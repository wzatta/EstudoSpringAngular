import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';


import { CadastroRoutingModule } from './cadastro-routing.module';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { AppMaterialModule } from '../shared/app-material/app-material.module';


@NgModule({
  declarations: [
    UsuariosComponent
  ],
  imports: [
    CommonModule,
    CadastroRoutingModule,
    AppMaterialModule

  ]
})
export class CadastroModule { }
