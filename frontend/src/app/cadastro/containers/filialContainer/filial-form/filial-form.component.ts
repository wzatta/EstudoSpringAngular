import { HoldingService } from 'src/app/cadastro/services/Holding.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, NonNullableFormBuilder, Validators } from '@angular/forms';
import { UsuarioInterface } from 'src/app/cadastro/model/UsuarioInterface';
import { UserloginService } from '../../../../servicesapp/userlogin.service';
import { FilialInterface } from '../../../model/filial-interface';
import { ActivatedRoute } from '@angular/router';
import { HoldInterface } from '../../../model/HoldInterface';
import { FilialService } from '../../../services/filial.service';
import { Location } from '@angular/common';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-filial-form',
  templateUrl: './filial-form.component.html',
  styleUrls: ['./filial-form.component.scss']
})
export class FilialFormComponent implements OnInit {

  //private userlogado1: UsuarioInterface = {id:'', cpf:'', name:'', password:'',user00Name:'',userAtivo:'',userBloqueado:'',role:''};

  private hold1: HoldInterface | any = {};
  roleString: String = "USER";

  holds: Observable<HoldInterface[]> | any = [];

  formFilial = this.formBuilder.group({
    idFilial:[''],
    rsocial:['', [Validators.required,
                  Validators.maxLength(49)]],
    dsocial:['',[Validators.required]],
    cnpj:['', [Validators.required]],
    municipio:['',[Validators.required]],
    uf:['',[Validators.required]],
    holdingDto: [this.hold1,[Validators.required]],
  });

  //formHold = new FormControl<HoldInterface[] | null >(null, Validators.required);



  constructor(
    private formBuilder: NonNullableFormBuilder,
    private logService: UserloginService,
    private snackBar: MatSnackBar,
    private route: ActivatedRoute,
    private filialService: FilialService,
    private location: Location,
    private holdServ: HoldingService
  ){}

  ngOnInit(): void {

    const user = this.logService.obterUsuario;

        this.formFilial.patchValue({
          //user00Dto: user
        });



    const filialConst: FilialInterface = this.route.snapshot.data['filialresolver'];

      this.formFilial.patchValue({
        idFilial: filialConst.idFilial,
        rsocial: filialConst.rsocial,
        dsocial: filialConst.dsocial,
        cnpj: filialConst.cnpj,
        municipio: filialConst.municipio,
        uf: filialConst.uf,
        holdingDto: filialConst.holdingDto
             }
      );

        //this.holdServ.list().subscribe(dados => this.holds = dados);
        this.holds = this.holdServ.list(); //Popular o Select do formulario






  } //ngOnInit


compareObj(o1:HoldInterface, o2: HoldInterface){
  return o1.idHold === o2.idHold;
}

  onSubmit(){
    this.filialService.save(this.formFilial.value)
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
  const field = this.formFilial.get(fieldName);

  if(field?.hasError('required')){
    return 'Campo Obrigatório';
  }

  if(field?.hasError('maxlength')){
    const requiredLength: number = field.errors ? field.errors['maxlength']['requiredLength'] : 49;
    return 'Tamanho Maximo ' + requiredLength +' caracteres.';
  }

  return 'Campo Invalido';
}

}
