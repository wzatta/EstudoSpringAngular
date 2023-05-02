import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UsuariosService } from '../../../services/usuarios.service';
import { ActivatedRoute } from '@angular/router';
import { UsuarioInterface } from '../../../model/UsuarioInterface';
import { OptionBoolean } from 'src/app/cadastro/model/option-boolean';
import { ColaboradorInterface } from '../../../model/colaboradorInterface';
import { ColaboradorService } from '../../../services/colaborador.service';
import { filter, map, Observable, distinctUntilChanged, switchMap } from 'rxjs';

//export interface OptionBoolean {
//  value: string;
// viewValue: string;
//}

@Component({
  selector: 'app-usuarios-form',
  templateUrl: './usuarios-form.component.html',
  styleUrls: ['./usuarios-form.component.scss']
})
export class UsuariosFormComponent implements OnInit {

  public is_Edit1: boolean = true;

  colab: ColaboradorInterface | any = {};

  public optionsBoolean: OptionBoolean[] = [
    { value: 'true', viewValue: 'SIM' },
    { value: 'false', viewValue: 'NÃO' },
  ];

  listColab$: Observable<ColaboradorInterface[]> | null = null;
  queryField = new FormControl();

  form = this.formBuilder.group({

    id: [''],
    name: ['', [Validators.required,
    Validators.minLength(10),
    Validators.maxLength(49)]],
    cpf: ['', [Validators.required]],
    user00Name: ['', [Validators.required]],
    password: ['', [Validators.required]],
    userAtivo: ['', [Validators.required]],
    userBloqueado: ['', [Validators.required]],
    role: ['', [Validators.required]],
    colabDto: [this.colab, [Validators.required]],
  });

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private userService: UsuariosService,
    private snackBar: MatSnackBar,
    private location: Location,
    private colabServ: ColaboradorService,
    private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    const usuarioConst: UsuarioInterface = this.route.snapshot.data['usuarioresolve'];

    if (usuarioConst.id != "") {
      this.form.controls.user00Name.disable();
      this.form.controls.password.disable();
    }

    this.form.setValue({
      id: usuarioConst.id,
      name: usuarioConst.name,
      cpf: usuarioConst.cpf,
      user00Name: usuarioConst.user00Name,
      userAtivo: usuarioConst.userAtivo.toString(),
      userBloqueado: usuarioConst.userBloqueado.toString(),
      role: usuarioConst.role,
      password: usuarioConst.password,
      colabDto: usuarioConst.colabDto,
    });


    this.listColab$ = this.colabServ.listAll();

  }

  onSubmit() {
    this.userService.save(this.form.value)
      .subscribe({
        complete: () => { this.onSucess() },
        error: () => { this.onError() }
      })
  }

  onCancel() {
    this.location.back();
  }

  private onSucess() {
    this.snackBar.open('Registro Salvo com Sucesso', '', { duration: 5000 });
    this.onCancel();
  }

  private onError() {
    this.snackBar.open('Erro ao Salvar o Registro', '', { duration: 5000 });
  }

  compareObj(o1: ColaboradorInterface, o2: ColaboradorInterface) {
    return o1.id === o2.id;
  }

  getErrorMessage(fieldName: string) {
    const field = this.form.get(fieldName);

    if (field?.hasError('required')) {
      return 'Campo Obrigatório';

    }
    if (field?.hasError('minlength')) {
      const requiredLength: number = field.errors ? field.errors['minlength']['requiredLength'] : 5;
      return 'Tamanho minimo ${requiredLength} caracteres.';
    }

    if (field?.hasError('maxlength')) {
      const requiredLength: number = field.errors ? field.errors['maxlength']['requiredLength'] : 49;
      return 'Tamanho Maximo ${requiredLength} caracteres.';
    }

    return 'Campo Invalido';
  }


}
