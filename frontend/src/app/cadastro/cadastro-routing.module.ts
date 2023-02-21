import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsuariosFormComponent } from './containers/userContainer/usuarios-form/usuarios-form.component';

//import { UsuariosComponent } from './containers/usuarios/usuarios.component';
import { UsuariosResolverResolver } from './guards/usuarios.resolver.resolver';
import { HoldigFormComponent } from './containers/holdContainer/holdings-form/holdig-form.component';
import { HoldingResolver } from './guards/holding.resolver';


const routes: Routes = [
  //{path:'telaUsuario', component:UsuariosComponent},

  {path:'telaUsuario/new', component: UsuariosFormComponent, resolve: {usuarioresolve: UsuariosResolverResolver}},
  {path:'telaUsuario/edit/:id', component: UsuariosFormComponent, resolve: {usuarioresolve: UsuariosResolverResolver}},
  {path:'telaHolding/newHold', component: HoldigFormComponent, resolve: {holdingresolver: HoldingResolver}},
  {path:'telaHolding/editHold/:id', component: HoldigFormComponent, resolve: {holdingresolver: HoldingResolver}}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CadastroRoutingModule { }
