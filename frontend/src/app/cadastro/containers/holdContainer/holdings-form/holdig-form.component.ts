import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { HoldingService } from '../../../services/Holding.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { HoldInterface } from '../../../model/HoldInterface';
import { UserloginService } from '../../../../servicesapp/userlogin.service';
import { UsuarioInterface } from '../../../model/UsuarioInterface';

@Component({
  selector: 'app-holdig-form',
  templateUrl: './holdig-form.component.html',
  styleUrls: ['./holdig-form.component.scss']
})
export class HoldigFormComponent implements OnInit {

  private userlogado1: UsuarioInterface = {id:'', cpf:'', name:'', password:'',user00Name:'',userAtivo:'',userBloqueado:'',role:''};

  formHold = this.formBuilder.group({
    idHold:[''],
    rsocial:['', [Validators.required,
                  Validators.maxLength(49)]],
    dsocial:['',[Validators.required]],
    cnpj:['', [Validators.required]],
    municipio:['',[Validators.required]],
    uf:['',[Validators.required]],
    user00Dto: [this.userlogado1]
  });

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private location: Location,
    private holdingService: HoldingService,
    private snackBar: MatSnackBar,
    private route: ActivatedRoute,
    private logService: UserloginService
    ){}

  ngOnInit(): void {

    const user$ = this.logService.obterUsuario?.subscribe(
      user => {
        this.formHold.patchValue({
          user00Dto: user
        });
      }
    );

    const holdingConst: HoldInterface = this.route.snapshot.data['holdingresolver'];

      this.formHold.patchValue({
        idHold: holdingConst.idHold,
        rsocial: holdingConst.rsocial,
        dsocial: holdingConst.dsocial,
        cnpj: holdingConst.cnpj,
        municipio:holdingConst.municipio,
        uf:holdingConst.uf,
        user00Dto:holdingConst.user00Dto
      }
      );
  }

  onSubmit(){
      this.holdingService.save(this.formHold.value)
      .subscribe({
        complete:()=> {this.onSucess()},
        error:()=>{this.onError()}
      }
      );
  }

  onCancel(){
    this.location.back();
  }

  onSucess(){
    this.snackBar.open('Registro Salvo com Sucesso','',{duration:5000});
    this.onCancel();
  };

  onError(){
    this.snackBar.open('Erro ao Salvar o Registro','',{duration:5000})
  };

  //------- Validação dos Dados do formulario-----

  getErrorMessage(fieldName:string){
    const field = this.formHold.get(fieldName);

    if(field?.hasError('required')){
      return 'Campo Obrigatório';
    }

    if(field?.hasError('maxleght')){
      const requiredLength: number = field.errors ? field.errors['maxlength']['requiredLength']:49;
      return 'Tamanho Maximo ${requiredLength} caracteres.'
    }

    return 'Campo Invalido';
  }




}
