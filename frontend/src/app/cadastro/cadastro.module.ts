import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { CadastroRoutingModule } from './cadastro-routing.module';
import { FilialFormComponent } from './containers/filialContainer/filial-form/filial-form.component';
import { FilialListComponent } from './containers/filialContainer/filial-list/filial-list.component';
import { FilialComponent } from './containers/filialContainer/filial/filial.component';
import { HoldigFormComponent } from './containers/holdContainer/holdings-form/holdig-form.component';
import { HoldingsListComponent } from './containers/holdContainer/holdings-list/holdings-list.component';
import { HoldingsComponent } from './containers/holdContainer/holdings/holdings.component';
import { OsfilialFormComponent } from './containers/osContainer/osfilial-form/osfilial-form.component';
import { OsfilialListComponent } from './containers/osContainer/osfilial-list/osfilial-list.component';
import { OsfilialComponent } from './containers/osContainer/osfilial/osfilial.component';
import { UsuariosFormComponent } from './containers/userContainer/usuarios-form/usuarios-form.component';
import { UsuariosListComponent } from './containers/userContainer/usuarios-list/usuarios-list.component';
import { UsuariosComponent } from './containers/userContainer/usuarios/usuarios.component';
import { ColaboradorComponent } from './containers/colaboradorContainer/colaborador/colaborador.component';
import { ColaboradorListComponent } from './containers/colaboradorContainer/colaborador-list/colaborador-list.component';
import { ColaboradorFormComponent } from './containers/colaboradorContainer/colaborador-form/colaborador-form.component';



@NgModule({
  declarations: [
    UsuariosComponent,
    UsuariosFormComponent,
    UsuariosListComponent,
    HoldingsComponent,
    HoldigFormComponent,
    HoldingsListComponent,
    FilialComponent,
    FilialListComponent,
    FilialFormComponent,
    OsfilialComponent,
    OsfilialFormComponent,
    OsfilialListComponent,
    ColaboradorComponent,
    ColaboradorListComponent,
    ColaboradorFormComponent
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
