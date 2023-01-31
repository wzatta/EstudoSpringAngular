import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';


import { CadastroRoutingModule } from './cadastro-routing.module';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { UsuariosFormComponent } from './usuarios-form/usuarios-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { UsuariosListComponent } from './usuarios-list/usuarios-list.component';


@NgModule({
  declarations: [
    UsuariosComponent,
    UsuariosFormComponent,
    UsuariosListComponent
  ],
  imports: [
    CommonModule,
    CadastroRoutingModule,
    AppMaterialModule,
    SharedModule,
    ReactiveFormsModule


  ]
})
export class CadastroModule { }
