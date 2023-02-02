import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UsuariosService } from '../../services/usuarios.service';
import { ActivatedRoute } from '@angular/router';
import { Usuariointerface } from '../../model/usuariointerface';

export interface OptionBoolean {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-usuarios-form',
  templateUrl: './usuarios-form.component.html',
  styleUrls: ['./usuarios-form.component.scss']
})
export class UsuariosFormComponent implements OnInit {

  public is_Edit1: boolean = true;

  public optionsBoolean: OptionBoolean[] = [
    {value: 'true', viewValue: 'SIM'},
    {value: 'false', viewValue: 'NÃO'},
  ];


  form= this.formBuilder.group({

    id : [''],
    name: ['' , [Validators.required,
                Validators.minLength(10),
                Validators.maxLength(49)]],
    cpf : ['' , [Validators.required]],
    userName : ['' , [Validators.required]],
    password : ['' , [Validators.required]],
    userAtivo : ['' , [Validators.required]],
    userNaoBloqueado : ['' , [Validators.required]],
    role : ['' , [Validators.required]]
  });

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private userService: UsuariosService,
    private snackBar: MatSnackBar,
    private location: Location,
    private route: ActivatedRoute){
  }

    ngOnInit(): void{
      const usuarioConst: Usuariointerface = this.route.snapshot.data['usuarioresolve'];

      if(usuarioConst.id!=""){
        this.form.controls.userName.disable();
        this.form.controls.password.disable();
      }

      this.form.setValue({
        id: usuarioConst.id,
        name: usuarioConst.name,
        cpf: usuarioConst.cpf,
        userName:usuarioConst.userName,
        userAtivo:usuarioConst.userAtivo,
        userNaoBloqueado: usuarioConst.userNaoBloqueado,
        role: usuarioConst.role,
        password: usuarioConst.password
      });
    }

    onSubmit(){
      this.userService.save(this.form.value)
      .subscribe(result => this.onSucess(), error => this.onError());
    }

    onCancel(){
      this.location.back();
    }

    private onSucess(){
      this.snackBar.open('Registro Salvo com Sucesso','',{duration:5000});
      this.onCancel();
    }

    private onError(){
      this.snackBar.open('Erro ao Salvar o Registro','',{duration:5000});
    }


    getErrorMessage(fieldName: string){
      const field = this.form.get(fieldName);

      if(field?.hasError('required')){
        return 'Campo Obrigatório';

      }
      if(field?.hasError('minlenght')){
        const requiredLength: number = field.errors ? field.errors['minlength']['requiredLength']:5;
        return  'Tamanho minimo ${requiredLength} caracteres.'
      }

      if(field?.hasError('maxlenght')){
        const requiredLength: number = field.errors ? field.errors['maxlength']['requiredLength']:49;
        return  'Tamanho Maximo ${requiredLength} caracteres.'
      }




      return 'Campo Invalido';
    }


}
