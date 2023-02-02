import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsuariosFormComponent } from './containers/usuarios-form/usuarios-form.component';

import { UsuariosComponent } from './containers/usuarios/usuarios.component';
import { UsuariosResolverResolver } from './guards/usuarios.resolver.resolver';


const routes: Routes = [
  {path:'', component:UsuariosComponent},
  {path:'new', component: UsuariosFormComponent, resolve: {usuarioresolve: UsuariosResolverResolver}},
  {path:'edit/:id', component: UsuariosFormComponent, resolve: {usuarioresolve: UsuariosResolverResolver}}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CadastroRoutingModule { }
