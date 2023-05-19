import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { GrupoService } from '../../../services/grupo/grupo.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Location } from '@angular/common';
import { GrupoInterface } from '../../../model/grupo/GrupoInterface';
import { GrupoResolver } from '../../../guards/grupo.resolver';
import { max, min } from 'rxjs';

@Component({
  selector: 'app-grupo-form',
  templateUrl: './grupo-form.component.html',
  styleUrls: ['./grupo-form.component.scss']
})
export class GrupoFormComponent implements OnInit{

  telaDe : string = "Inclusão";

  formGrupo = this.formBuilder.group({

    idGr:[''],
    codigoGr:['', [Validators.required,
                  Validators.min(1),
                  Validators.max(99)]],
    descGr:['',   [Validators.required,
                  Validators.minLength(10),
                  Validators.maxLength(50)]],
  });


  constructor(
    private formBuilder: NonNullableFormBuilder,
    private route: ActivatedRoute,
    private grupoService: GrupoService,
    private snackBar : MatSnackBar,
    private location: Location
  ){

  }

  ngOnInit(): void {

    const grupoConst: GrupoInterface = this.route.snapshot.data['gruporesolver'];

    this.formGrupo.patchValue({

      idGr:grupoConst.idGr,
      codigoGr:grupoConst.codigoGr,
      descGr:grupoConst.descGr

    });

    if(grupoConst.idGr){
      this.telaDe = "Edição";
    }

  } // fecha ngOnInit


  onCancel(){
    this.location.back();
  }

  onSubmit(){
    this.grupoService.save(this.formGrupo.value)
    .subscribe({
      complete:()=>{this.onSucess()},
      error:()=> {this.onError()}
  });
  }

  onSucess(){
    this.snackBar.open('Registro Salvo com Sucesso','',{duration:5000});
    this.onCancel();
  }

  onError(){
    this.snackBar.open('Erro ao Salvar o Registro','',{duration:5000})
  }

  //------- Validação dos Dados do formulario-----

  getErrorMessage(fieldName: string){

    const field = this.formGrupo.get(fieldName);

    if(field?.hasError('required')){
      return 'Campo Obrigatório';
    }

    if(field?.hasError('minLength')){
      const requiredLength: number = field.errors ? field.errors['minLength'] ['requiredLength']:10;
      return  'Tamanho minimo ${requiredLength} caracteres.';
    }
    if(field?.hasError('maxLength')){
      const requiredLength: number = field.errors ? field.errors['maxlength']['requiredLength']:49;
      return  'Tamanho Maximo ' + requiredLength +' caracteres.';
    }

    if(field?.hasError('min') || field?.hasError('max')){
      return 'Codigo do Grupo deve ser de 1 a 99 !';
    }


      return 'Campo Invalido';
  }



}
