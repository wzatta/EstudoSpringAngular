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
import { GrupoComponent } from './containers/GrupoContainer/grupo/grupo.component';
import { GrupoFormComponent } from './containers/GrupoContainer/grupo-form/grupo-form.component';
import { GrupoListComponent } from './containers/GrupoContainer/grupo-list/grupo-list.component';
import { SubgrupoComponent } from './containers/SubGrupoContainer/subgrupo/subgrupo.component';
import { SubgrupoFormComponent } from './containers/SubGrupoContainer/subgrupo-form/subgrupo-form.component';
import { SubgrupoListComponent } from './containers/SubGrupoContainer/subgrupo-list/subgrupo-list.component';
import { AlmoxarifadoComponent } from './containers/almoxContainer/almoxarifado/almoxarifado.component';
import { AlmoxarifadoFormComponent } from './containers/almoxContainer/almoxarifado-form/almoxarifado-form.component';
import { AlmoxarifadoListComponent } from './containers/almoxContainer/almoxarifado-list/almoxarifado-list.component';
import { AlmoxarifadoSubComponent } from './containers/almoxsubContainer/almoxarifado-sub/almoxarifado-sub.component';
import { AlmoxarifadoSubFormComponent } from './containers/almoxsubContainer/almoxarifado-sub-form/almoxarifado-sub-form.component';
import { AlmoxarifadoSubListComponent } from './containers/almoxsubContainer/almoxarifado-sub-list/almoxarifado-sub-list.component';



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
    ColaboradorFormComponent,
    GrupoComponent,
    GrupoFormComponent,
    GrupoListComponent,
    SubgrupoComponent,
    SubgrupoFormComponent,
    SubgrupoListComponent,
    AlmoxarifadoComponent,
    AlmoxarifadoFormComponent,
    AlmoxarifadoListComponent,
    AlmoxarifadoSubComponent,
    AlmoxarifadoSubFormComponent,
    AlmoxarifadoSubListComponent,
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
