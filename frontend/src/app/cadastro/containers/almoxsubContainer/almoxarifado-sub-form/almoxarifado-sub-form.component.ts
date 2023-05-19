import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { OptionTipoAlmox } from 'src/app/cadastro/model/OptionTipoAlmox';
import { Almoxsubinterface } from 'src/app/cadastro/model/almox/almoxsubinterface';
import { Filial } from 'src/app/cadastro/model/classes/Filial';
import { FilialInterface } from 'src/app/cadastro/model/filial-interface';
import { OptionBoolean } from 'src/app/cadastro/model/option-boolean';
import { AlmoxService } from 'src/app/cadastro/services/almox/almox.service';
import { AlmoxsubService } from 'src/app/cadastro/services/almox/almoxsub.service';
import { FilialService } from 'src/app/cadastro/services/filial.service';
import { UserloginService } from 'src/app/servicesapp/userlogin.service';


@Component({
  selector: 'app-almoxarifado-sub-form',
  templateUrl: './almoxarifado-sub-form.component.html',
  styleUrls: ['./almoxarifado-sub-form.component.scss']
})
export class AlmoxarifadoSubFormComponent implements OnInit {

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

  formAlmoxSub = this.formBuilder.group({
    idSubdto: [''],
    tituloSubdto: ['', [Validators.required]],
    isAtivodto: ['', Validators.required],
    isOnLine: ['', [Validators.required]],
    dataCriacaodto: [''],
    filialDto: [this.filial, [Validators.required]]

  });

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private route: ActivatedRoute,
    private logServ: UserloginService,
    private filialServ: FilialService,
    private subService: AlmoxsubService,
    private snackBar: MatSnackBar,
    private location: Location
  ) {}

  ngOnInit(): void {

    const subConst: Almoxsubinterface = this.route.snapshot.data['almoxsubresolver'];
    this.formAlmoxSub.patchValue({
      idSubdto: subConst.idSubdto,
      tituloSubdto: subConst.tituloSubdto,
      isAtivodto: subConst.isAtivodto,
      isOnLine: subConst.isOnLine,
      dataCriacaodto: subConst.dataCriacaodto,
      filialDto: subConst.filialDto
    })

    if (subConst.idSubdto) {
      this.telaDe = "Edição"; // Alterar o titulo do formulario para "Edição" o Padrão é "Inclusão"
    }

    this.logServ.obterUsuario.subscribe(
      res =>{
        this.roleString = res.role;
        if(this.roleString==="ADMIN"){
          this.filiais = this.filialServ.findAllByHolding(res.colabDto.filialDto.holdingDto); // popular o campo select do formulario.
        } else{
          this.formAlmoxSub.patchValue({
            filialDto: res.colabDto.filialDto,
          });
        }
});

      if (!subConst.idSubdto) {
        this.formAlmoxSub.patchValue({dataCriacaodto:new Date().toLocaleDateString()});
      }


  } //fim ngOnInit

  onCancel(){
    this.location.back();
  }

  onSubmit() {
    this.subService.saveAlmoxSub(this.formAlmoxSub.value)
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

  const field = this.formAlmoxSub.get(fieldName);

  if (field?.hasError('required')) {
    return 'Campo Obrigatório';
  }

  return 'Campo Invalido';
}


}
