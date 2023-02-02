import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { CadastroRoutingModule } from './cadastro-routing.module';
import { UsuariosListComponent } from './components/usuarios-list/usuarios-list.component';
import { UsuariosFormComponent } from './containers/usuarios-form/usuarios-form.component';
import { UsuariosComponent } from './containers/usuarios/usuarios.component';



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
