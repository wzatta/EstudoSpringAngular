import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './pages/login/login.component';
import { PrincipalComponent } from './pages/compartilhado/principal/principal.component';
import { HomeComponent } from './pages/home/home.component';
import { UsuarioAutenticadoGuard } from './pages/guards/usuario-autenticado.guard';
import { UsuarioNaoAutenticadoGuard } from './pages/guards/usuario-nao-autenticado.guard';
import { UsuariosComponent } from './cadastro/containers/usuarios/usuarios.component';

const routes: Routes = [
  /*
  configuração inicial direto para lista de usuarios
  { path:'', pathMatch: 'full', redirectTo: 'telausuario'},
  {
    path: 'telausuario',
    loadChildren: () => import('./cadastro/cadastro.module').then(m => m.CadastroModule)
  }
  */
  { path: 'login', component: LoginComponent, canActivate: [UsuarioNaoAutenticadoGuard]},
  { path:'userTela', pathMatch: 'full', redirectTo: 'telausuario'},



   {
    path: '', component: PrincipalComponent, canActivate: [UsuarioAutenticadoGuard],
    children: [
      { path: 'home', component: HomeComponent },
      {
        path: 'telausuario',
        loadChildren: () => import('./cadastro/cadastro.module').then(m => m.CadastroModule),

      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
