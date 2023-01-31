import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UsuariosService } from '../services/usuarios.service';

@Component({
  selector: 'app-usuarios-form',
  templateUrl: './usuarios-form.component.html',
  styleUrls: ['./usuarios-form.component.scss']
})
export class UsuariosFormComponent implements OnInit {

  form= this.formBuilder.group({

    id : [''],
    name: [''],
    cpf : [''],
    userName : [''],
    password : [''],
    userAtivo : [''],
    userNaoBloqueado : [''],
    role : ['']
  });

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private userService: UsuariosService,
    private snackBar: MatSnackBar,
    private location: Location){


  }

    ngOnInit(): void{

    }

    onSubmit(){
      console.log(this.form.value);
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



}
