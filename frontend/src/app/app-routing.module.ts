import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { FilialComponent } from './cadastro/containers/filialContainer/filial/filial.component';
import { HoldingsComponent } from './cadastro/containers/holdContainer/holdings/holdings.component';
import { UsuariosComponent } from './cadastro/containers/userContainer/usuarios/usuarios.component';
import { PrincipalComponent } from './pages/compartilhado/principal/principal.component';
import { UsuarioAutenticadoGuard } from './pages/guards/usuario-autenticado.guard';
import { UsuarioNaoAutenticadoGuard } from './pages/guards/usuario-nao-autenticado.guard';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { OsfilialComponent } from './cadastro/containers/osContainer/osfilial/osfilial.component';
import { ColaboradorComponent } from './cadastro/containers/colaboradorContainer/colaborador/colaborador.component';
import { GrupoComponent } from './cadastro/containers/GrupoContainer/grupo/grupo.component';

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
  { path:'userTela', pathMatch: 'full', redirectTo: 'telaUsuario' },
  { path:'holdTela', pathMatch: 'full', redirectTo: 'telaHolding'},
  { path: 'filialTela', pathMatch: 'full', redirectTo: 'telaFilial'},
  { path: 'osfilialTela', pathMatch: 'full', redirectTo: 'telaOsFilial'},
  { path: 'colabTela', pathMatch: 'full', redirectTo: 'telaColab'},
  { path: 'grupoTela', pathMatch: 'full', redirectTo: 'telaGrupo'},

  { path:'', component: HomeComponent},




    { path: 'principal', component: PrincipalComponent, canActivate: [UsuarioAutenticadoGuard]},
    { path: 'home', component: HomeComponent  },
    {
        path: 'telaUsuario',
        loadChildren: () => import('./cadastro/cadastro.module').then(m => m.CadastroModule),
        component: UsuariosComponent, canActivate: [UsuarioAutenticadoGuard]
      },
      {
        path: 'telaHolding',
        loadChildren: () => import('./cadastro/cadastro.module').then(m => m.CadastroModule),
        component: HoldingsComponent, canActivate: [UsuarioAutenticadoGuard]
      },

      {
        path: 'telaFilial',
        loadChildren: () => import('./cadastro/cadastro.module').then(m => m.CadastroModule),
        component: FilialComponent, canActivate: [UsuarioAutenticadoGuard]
      },

      {
        path: 'telaOsFilial',
        loadChildren: () => import('./cadastro/cadastro.module').then(m => m.CadastroModule),
        component: OsfilialComponent, canActivate: [UsuarioAutenticadoGuard]
      },

      {
        path: 'telaColab',
        loadChildren: () => import('./cadastro/cadastro.module').then(m => m.CadastroModule),
        component: ColaboradorComponent, canActivate: [UsuarioAutenticadoGuard]
      },

      {
        path: 'telaGrupo',
        loadChildren: () => import('./cadastro/cadastro.module').then(m => m.CadastroModule),
        component: GrupoComponent, canActivate: [UsuarioAutenticadoGuard]
      },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
