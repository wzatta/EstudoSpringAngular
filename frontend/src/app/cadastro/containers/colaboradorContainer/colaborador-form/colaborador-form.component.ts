import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { FilialInterface } from '../../../model/filial-interface';
import { ColaboradorInterface } from '../../../model/colaboradorInterface';
import { ActivatedRoute } from '@angular/router';
import { FilialService } from '../../../services/filial.service';
import { Observable } from 'rxjs';
import { ColaboradorService } from '../../../services/colaborador.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Location } from '@angular/common';

@Component({
  selector: 'app-colaborador-form',
  templateUrl: './colaborador-form.component.html',
  styleUrls: ['./colaborador-form.component.scss']
})
export class ColaboradorFormComponent implements OnInit {

    private filial: FilialInterface | any = {};
    filiais: Observable<FilialInterface[]> | any = [];
    telaDe : string = "Inclusão";
    exibirCampo : boolean = false;

    formColaborador = this.formBuilder.group({
      id: [''],
      matricula: ['',[Validators.required,
                      Validators.maxLength(20)]],
      cpf: ['',[Validators.required]],
      name: ['',[Validators.required,
                 Validators.minLength(10),
                 Validators.maxLength(49)]],
      funcao: ['',[Validators.required,
                   Validators.minLength(10),
                   Validators.maxLength(35)]],
      dateAdm: ['',[Validators.required]],
      dateDem: [''],
      filialDto: [this.filial,[Validators.required]],
    });

    constructor(
      private formBuilder: NonNullableFormBuilder,
      private route: ActivatedRoute,
      private filialServ: FilialService,
      private colabServ: ColaboradorService,
      private snackBar: MatSnackBar,
      private location: Location
    ){}

    ngOnInit(): void {

      const colabConst: ColaboradorInterface = this.route.snapshot.data['colabresolver'];

      this.formColaborador.patchValue({

        id:colabConst.id,
        matricula:colabConst.matricula,
        cpf:colabConst.cpf,
        name:colabConst.name,
        funcao:colabConst.funcao,
        dateAdm:colabConst.dateAdm,
        dateDem:colabConst.dateDem,
        filialDto:colabConst.filialDto
      })

      if(colabConst.id){
        this.telaDe = "Edição"; // Alterar o titulo do formulario para "Edição" o Padrão é "Inclusão"
        this.exibirCampo = true;
      }

      this.filiais = this.filialServ.listAll(); // popular o campo select do formulario.

    } // fecha ngOnInit

    onCancel(){
      this.location.back();
    }

    onSubmit(){
      this.colabServ.saveColab(this.formColaborador.value)
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


    compareObj(o1:FilialInterface, o2:FilialInterface){
      return o1.idFilial === o2.idFilial;
    }

    //------- Validação dos Dados do formulario-----

    getErrorMessage(fieldName: string){

      const field = this.formColaborador.get(fieldName);

      if(field?.hasError('required')){
        return 'Campo Obrigatório';
      }

      if(field?.hasError('minLength')){
        const requiredLength: number = field.errors ? field.errors['minLength'] ['requiredLength']:10;
        return  'Tamanho minimo ${requiredLength} caracteres.';
      }
      if(field?.hasError('maxlength')){
        const requiredLength: number = field.errors ? field.errors['maxlength']['requiredLength']:49;
        return  'Tamanho Maximo ' + requiredLength +' caracteres.';

      }



        return 'Campo Invalido';
    }


}
