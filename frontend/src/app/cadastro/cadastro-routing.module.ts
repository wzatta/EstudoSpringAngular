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
import { ColaboradorFormComponent } from './containers/colaboradorContainer/colaborador-form/colaborador-form.component';
import { ColaboradorResolver } from './guards/colaborador.resolver';
import { GrupoFormComponent } from './containers/GrupoContainer/grupo-form/grupo-form.component';
import { GrupoResolver } from './guards/grupo.resolver';
import { SbgrupoResolver } from './guards/sbgrupo.resolver';
import { SubgrupoFormComponent } from './containers/SubGrupoContainer/subgrupo-form/subgrupo-form.component';
import { AlmoxarifadoComponent } from './containers/almoxContainer/almoxarifado/almoxarifado.component';
import { AlmoxResolver } from './guards/almox.resolver';
import { AlmoxarifadoFormComponent } from './containers/almoxContainer/almoxarifado-form/almoxarifado-form.component';
import { AlmoxarifadoSubFormComponent } from './containers/almoxsubContainer/almoxarifado-sub-form/almoxarifado-sub-form.component';
import { AlmoxSubResolver } from './guards/almox-sub.resolver';
import { CertaprovaFormComponent } from './containers/CertaprovContainer/certaprova-form/certaprova-form.component';
import { ProdutoMasterFormComponent } from './containers/produtomasterContainer/produto-master-form/produto-master-form.component';
import { ProdMasterResolver } from './guards/prod-master.resolver';
import { CertAprovResolver } from './guards/cert-aprov.resolver';
const routes: Routes = [

  {path:'telaUsuario/new', component: UsuariosFormComponent, resolve: {usuarioresolve: UsuariosResolverResolver}},
  {path:'telaUsuario/edit/:id', component: UsuariosFormComponent, resolve: {usuarioresolve: UsuariosResolverResolver}},

  {path:'telaHolding/newHold', component: HoldigFormComponent, resolve: {holdingresolver: HoldingResolver}},
  {path:'telaHolding/editHold/:id', component: HoldigFormComponent, resolve: {holdingresolver: HoldingResolver}},

  {path:'telaFilial/newFilial', component: FilialFormComponent, resolve: {filialresolver: FilialResolver}},
  {path:'telaFilial/editFilial/:id', component: FilialFormComponent, resolve: {filialresolver: FilialResolver}},

  { path: 'telaOsFilial/newOsFilial', component: OsfilialFormComponent, resolve: {osfilialresolver: OsfilialResolver}},
  { path: 'telaOsFilial/editOsFilial/:id', component: OsfilialFormComponent, resolve: {osfilialresolver: OsfilialResolver}},

  { path: 'telaColab/newColab', component: ColaboradorFormComponent, resolve: {colabresolver: ColaboradorResolver}},
  { path: 'telaColab/editColab/:id', component: ColaboradorFormComponent, resolve: {colabresolver: ColaboradorResolver}},

  { path: 'telaGrupo/newGrupo', component: GrupoFormComponent, resolve: {gruporesolver: GrupoResolver}},
  { path: 'telaGrupo/editGrupo/:id', component: GrupoFormComponent, resolve: {gruporesolver: GrupoResolver}},

  { path: 'telaSubGrupo/newSbGrupo', component: SubgrupoFormComponent , resolve: {sbgruporesolver: SbgrupoResolver}},
  { path: 'telaSubGrupo/editSbGrupo/:id', component: SubgrupoFormComponent  , resolve: {sbgruporesolver: SbgrupoResolver}},

  { path: 'telaAlmox/newAlmox', component: AlmoxarifadoFormComponent , resolve: {almoxresolver: AlmoxResolver}},
  { path: 'telaAlmox/editAlmox/:id', component: AlmoxarifadoFormComponent , resolve: {almoxresolver: AlmoxResolver}},

  { path: 'telaAlmoxSub/newAlmoxSub', component: AlmoxarifadoSubFormComponent , resolve: {almoxsubresolver: AlmoxSubResolver}},
  { path: 'telaAlmoxSub/editAlmoxSub/:id', component: AlmoxarifadoSubFormComponent , resolve: {almoxsubresolver: AlmoxSubResolver}},

  { path: 'telaCertAprov/newCertAprov', component: CertaprovaFormComponent , resolve: {certAprovresolver: CertAprovResolver}},
  { path: 'telaCertAprov/editCertAprov/:id', component: CertaprovaFormComponent , resolve: {certAprovresolver: CertAprovResolver}},

  { path: 'telaProdMaster/newProdMaster', component: ProdutoMasterFormComponent , resolve: {prodMasterresolver: ProdMasterResolver}},
  { path: 'telaProdMaster/editProdMaster/:id', component: ProdutoMasterFormComponent , resolve: {prodMasterresolver: ProdMasterResolver}},



];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CadastroRoutingModule { }
