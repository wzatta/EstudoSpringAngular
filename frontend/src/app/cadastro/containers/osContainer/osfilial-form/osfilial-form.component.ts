import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { UsuarioInterface } from 'src/app/cadastro/model/UsuarioInterface';
import { UserloginService } from 'src/app/servicesapp/userlogin.service';
import { FilialInterface } from '../../../model/filial-interface';
import { OsFilialInterface } from '../../../model/OsfilialInteface';
import { FilialService } from '../../../services/filial.service';
import { OsfilialService } from '../../../services/osfilial.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { OptionBoolean } from 'src/app/cadastro/model/option-boolean';
import { Observable } from 'rxjs';
import { Usuario } from 'src/app/cadastro/model/classes/usuario';

@Component({
  selector: 'app-osfilial-form',
  templateUrl: './osfilial-form.component.html',
  styleUrls: ['./osfilial-form.component.scss']
})
export class OsfilialFormComponent implements OnInit {

  private userLogado:UsuarioInterface = new Usuario();
  //private userlogado1: UsuarioInterface = {id:'', cpf:'', name:'', password:'',user00Name:'',userAtivo:'',userBloqueado:'',role:''};
  private userlogado1: UsuarioInterface | any = {};
  private filial: FilialInterface | any = {};

  telaDe : string = "Inclusão";

  //filiais: FilialInterface[] = [];
  filiais: Observable<FilialInterface[]> | any = [];

   optionsBoolean:OptionBoolean[] = [
    {value: 'true', viewValue: 'SIM'},
    {value: 'false', viewValue: 'NÃO'},
  ];

  formOsFilial = this.formBuilder.group({
    idOs: [''],
    codigoOs: ['', Validators.required],
    descricaoOs: ['',Validators.required],
    dataInicial: ['',Validators.required],
    dataFinal: [''],
    osIsAtiva: ['',Validators.required],
    filialDto: [this.filial, Validators.required],
    user00Dto: [this.userlogado1]
  })

  //formFilial = new FormControl<FilialInterface[] | null>(null, Validators.required);

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private logService: UserloginService,
    private osService: OsfilialService,
    private filialServ: FilialService,
    private location: Location,
    private route: ActivatedRoute,
    private snackBar: MatSnackBar
  ){}

  ngOnInit(): void {

    this.logService.obterUsuario.subscribe(
      res=>{this.userLogado = res}
    );


        this.formOsFilial.patchValue({
          user00Dto: this.userLogado
        });



   const osFilialConst: OsFilialInterface = this.route.snapshot.data['osfilialresolver'];

   this.formOsFilial.patchValue({
    idOs:osFilialConst.idOs,
    codigoOs:osFilialConst.codigoOs,
    descricaoOs:osFilialConst.descricaoOs,
    dataInicial:osFilialConst.dataInicial,
    dataFinal:osFilialConst.dataFinal,
    osIsAtiva:osFilialConst.osIsAtiva.toString(),
    filialDto:osFilialConst.filialDto,
    user00Dto:osFilialConst.user00Dto
   });

   if(osFilialConst.idOs){
    this.telaDe = "Edição";   // Alterar o titulo do formulario para "Edição" o Padrão é "Inclusão"
   }

   this.filiais = this.filialServ.listAll(); //Popular o Select do formulario

  }//fim onInit

  onSubmit(){
    this.osService.save(this.formOsFilial.value)
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

compareObj(o1:FilialInterface, o2:FilialInterface){
  return o1.idFilial === o2.idFilial;
}


//------- Validação dos Dados do formulario-----

getErrorMessage(fieldName:string){
  const field = this.formOsFilial.get(fieldName);

  if(field?.hasError('required')){
    return 'Campo Obrigatório';
  }

   return 'Campo Invalido';
}



}
