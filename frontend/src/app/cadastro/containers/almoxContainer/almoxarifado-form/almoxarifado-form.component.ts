import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { OptionTipoAlmox } from '../../../model/OptionTipoAlmox';
import { AlmoxInterface } from 'src/app/cadastro/model/almox/almox-interface';
import { Filial } from 'src/app/cadastro/model/classes/Filial';
import { FilialInterface } from 'src/app/cadastro/model/filial-interface';
import { OptionBoolean } from 'src/app/cadastro/model/option-boolean';
import { AlmoxService } from 'src/app/cadastro/services/almox/almox.service';

import { FilialService } from 'src/app/cadastro/services/filial.service';
import { UserloginService } from 'src/app/servicesapp/userlogin.service';


@Component({
  selector: 'app-almoxarifado-form',
  templateUrl: './almoxarifado-form.component.html',
  styleUrls: ['./almoxarifado-form.component.scss']
})
export class AlmoxarifadoFormComponent implements OnInit {

  private filial: FilialInterface = new Filial();

  public optionsBoolean: OptionBoolean[] = [
    { value: 'true', viewValue: 'SIM' },
    { value: 'false', viewValue: 'NÃO' },
  ];

  public optionsTipoAlmox: OptionTipoAlmox[]=[
    { value: 'CLIENTE', viewValue: 'Cliente'},
    { value: 'PROPRIO', viewValue: 'Proprio'}
  ]

  roleString: String = "USER";
  filiais: Observable<FilialInterface[]> | any = [];
  telaDe: string = "Inclusão";

  formAlmoxarifado = this.formBuilder.group({
    idAlmoxdto: [''],
  	titulodto:  ['', [Validators.required,
                      Validators.maxLength(35)]],
	  isAtivodto: [''],
  	dataCriacaodto: [''],
    tipodto:[''],
	  filialDto: [this.filial,[Validators.required]]
  });

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private route: ActivatedRoute,
    private logServ: UserloginService,
    private filialServ: FilialService,
    private almoxService: AlmoxService,
    private snackBar: MatSnackBar,
    private location: Location
  ){ }

  ngOnInit(): void {

    const almoxConst: AlmoxInterface = this.route.snapshot.data['almoxresolver'];
    this.formAlmoxarifado.patchValue({
      idAlmoxdto: almoxConst.idAlmoxdto,
      titulodto: almoxConst.titulodto,
      isAtivodto: almoxConst.isAtivodto.toString(),
      tipodto:almoxConst.tipodto,
      dataCriacaodto: almoxConst.dataCriacaodto,
      filialDto: almoxConst.filialDto
    })

    if (almoxConst.idAlmoxdto) {
      this.telaDe = "Edição"; // Alterar o titulo do formulario para "Edição" o Padrão é "Inclusão"
    }

    this.logServ.obterUsuario.subscribe(
      res => {
        this.roleString = res.role;
        if (this.roleString === 'ADMIN') {
          this.filiais = this.filialServ.findAllByHolding(res.colabDto.filialDto.holdingDto); // popular o campo select do formulario.
        } else {
          this.formAlmoxarifado.patchValue({
            filialDto: res.colabDto.filialDto
          });
        }
      });

      if (!almoxConst.idAlmoxdto) {
        this.formAlmoxarifado.patchValue({
          dataCriacaodto:new Date().toLocaleDateString()});
      }

  } // fecha ng-onInit

  onCancel() {
    this.location.back();
  }

  onSubmit() {
    this.almoxService.saveAlmox(this.formAlmoxarifado.value)
      .subscribe({
        complete: () => { this.onSucess('Registro Salvo com Sucesso') },
        error: () => { this.onError('Erro ao Salvar o Registro') }
      });
  }

  onSucess(msg:string) {
    this.snackBar.open(msg, '', { duration: 5000 });
    this.onCancel();
  }

  onError(msg:string) {
    this.snackBar.open(msg, '', { duration: 5000 })
  }

  compareObj(o1: FilialInterface, o2: FilialInterface) {
    return o1.idFilial === o2.idFilial;
  }

  compareStatus(o1:string, o2:string){
    return o1 === o2;
  }

 //------- Validação dos Dados do formulario-----

 getErrorMessage(fieldName: string) {

  const field = this.formAlmoxarifado.get(fieldName);

  if (field?.hasError('required')) {
    return 'Campo Obrigatório';
  }
  if (field?.hasError('minLength')) {
    const requiredLength: number = field.errors ? field.errors['minLength']['requiredLength'] : 5;
    return 'Tamanho minimo ${requiredLength} caracteres.';
  }
  if (field?.hasError('maxlength')) {
    const requiredLength: number = field.errors ? field.errors['maxlength']['requiredLength'] : 49;
    return 'Tamanho Maximo ' + requiredLength + ' caracteres.';

  }
  return 'Campo Invalido';
}




}
