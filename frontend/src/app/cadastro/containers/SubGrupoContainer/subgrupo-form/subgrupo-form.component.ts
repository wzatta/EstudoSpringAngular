import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { SubgrupoService } from '../../../services/subgrupo.service';
import { ActivatedRoute } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Location } from '@angular/common';
import { GrupoComponent } from '../../GrupoContainer/grupo/grupo.component';
import { SubGrupoInterface } from '../../../model/SubGrupoInterface';
import { Observable } from 'rxjs';
import { GrupoInterface } from '../../../model/GrupoInterface';
import { GrupoService } from '../../../services/grupo.service';

@Component({
  selector: 'app-subgrupo-form',
  templateUrl: './subgrupo-form.component.html',
  styleUrls: ['./subgrupo-form.component.scss']
})
export class SubgrupoFormComponent  implements OnInit{

  telaDe: String= "Inclusão"
  grupos$: Observable<GrupoInterface[]> | null = null;
  grupo:GrupoInterface | any = {};

  formSbGrupo = this.formBuilder.group({
    idSubGr: [''],
    grupoDto: [this.grupo,[Validators.required]],
    codigoSubGr: ['',[Validators.required,
                      Validators.min(1),
                      Validators.max(99)]],
    descSubGr: ['',  [Validators.required,
                      Validators.minLength(10),
                      Validators.maxLength(50)]]
  });

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private grupoService: GrupoService,
    private sbgrService: SubgrupoService,
    private route: ActivatedRoute,
    private snackBar: MatSnackBar,
    private location: Location
  ){}


  ngOnInit(): void {

    const sbgrConst : SubGrupoInterface = this.route.snapshot.data['sbgruporesolver'] ;

    this.formSbGrupo.patchValue({
      idSubGr:sbgrConst.idSubGr,
      codigoSubGr:sbgrConst.codigoSubGr,
      descSubGr:sbgrConst.descSubGr,
      grupoDto:sbgrConst.grupoDto
    });

    if(sbgrConst.idSubGr){
      this.telaDe = "Edição";
    }

    this.grupos$ = this.grupoService.listAll(); // popular o Select

  } // fecha OnInit

  onSubmit(){

    this.sbgrService.save(this.formSbGrupo.value)
      .subscribe({
        complete:() =>{this.onSucess()},
        error:() => {this.onError()}
      });
  }

  private onSucess(){
    this.snackBar.open('Registro Salvo com Sucesso','',{duration:5000});
    this.onCancel();

  }

  private onError(){
    this.snackBar.open('Erro ao Salvar o Registro','',{duration:5000})
  }


  onCancel(){
    this.location.back();
  }

  compareObj(o1:GrupoInterface, o2:GrupoInterface){
    return o1.idGr === o2.idGr;
  }


  //------- Validação dos Dados do formulario-----

  getErrorMessage(fieldName: string){

    const field = this.formSbGrupo.get(fieldName);

    if(field?.hasError('required')){
      return "Campo obrigatório";
    }

    if(field?.hasError('min') || field?.hasError('max')){
      return "Codigo do Grupo deve ser de 1 a 99!";
    }

    if(field?.hasError('minLength') || field?.hasError('maxLength')){
        return "Texto entre 10 a 50 Caracteres."
    }

    return "Campo Invalido";

}



}
