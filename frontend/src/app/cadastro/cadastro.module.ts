import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatTableModule } from '@angular/material/table';

import { CadastroRoutingModule } from './cadastro-routing.module';
import { UsuariosComponent } from './usuarios/usuarios.component';

@NgModule({
  declarations: [
    UsuariosComponent
  ],
  imports: [
    CommonModule,
    CadastroRoutingModule,
    MatTableModule
  ]
})
export class CadastroModule { }
