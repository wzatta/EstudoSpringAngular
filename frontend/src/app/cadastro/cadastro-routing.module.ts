import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UsuariosFormComponent } from './usuarios-form/usuarios-form.component';
import { UsuariosComponent } from './usuarios/usuarios.component';


const routes: Routes = [
  {path:'', component:UsuariosComponent},
  {path:'new', component: UsuariosFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CadastroRoutingModule { }
