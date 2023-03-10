import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { FilialFormComponent } from './containers/filialContainer/filial-form/filial-form.component';
import { HoldigFormComponent } from './containers/holdContainer/holdings-form/holdig-form.component';
import { OsfilialComponent } from './containers/osContainer/osfilial/osfilial.component';
import { UsuariosFormComponent } from './containers/userContainer/usuarios-form/usuarios-form.component';
import { FilialResolver } from './guards/filial.resolver';
import { HoldingResolver } from './guards/holding.resolver';
import { UsuariosResolverResolver } from './guards/usuarios.resolver.resolver';

import { OsfilialResolver } from './guards/osfilial.resolver';
import { OsfilialFormComponent } from './containers/osContainer/osfilial-form/osfilial-form.component';
const routes: Routes = [

  {path:'telaUsuario/new', component: UsuariosFormComponent, resolve: {usuarioresolve: UsuariosResolverResolver}},
  {path:'telaUsuario/edit/:id', component: UsuariosFormComponent, resolve: {usuarioresolve: UsuariosResolverResolver}},

  {path:'telaHolding/newHold', component: HoldigFormComponent, resolve: {holdingresolver: HoldingResolver}},
  {path:'telaHolding/editHold/:id', component: HoldigFormComponent, resolve: {holdingresolver: HoldingResolver}},

  {path:'telaFilial/newFilial', component: FilialFormComponent, resolve: {filialresolver: FilialResolver}},
  {path:'telaFilial/editFilial/:id', component: FilialFormComponent, resolve: {filialresolver: FilialResolver}},

  { path: 'telaOsFilial/newOsFilial', component: OsfilialFormComponent, resolve: {osfilialresolver: OsfilialResolver}},
  { path: 'telaOsFilial/editOsFilial/:id', component: OsfilialFormComponent, resolve: {osfilialresolver: OsfilialResolver}},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CadastroRoutingModule { }
