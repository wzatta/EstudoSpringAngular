import { Injectable } from '@angular/core';
import {
  Router, Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable, of } from 'rxjs';
import { SubGrupoInterface } from '../model/grupo/SubGrupoInterface';
import { SubgrupoService } from '../services/grupo/subgrupo.service';
import { GrupoInterface } from '../model/grupo/GrupoInterface';

@Injectable({
  providedIn: 'root'
})

export class SbgrupoResolver implements Resolve<SubGrupoInterface> {

    constructor(
      private sbgrServ: SubgrupoService
    ){}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<SubGrupoInterface> {

    let grupo: GrupoInterface | any = {};

    if(route.params && route.params['id']){
        return this.sbgrServ.findById(route.params['id']);
    }

    return of({idSubGr:'', codigoSubGr:'', descSubGr:'', grupoDto:grupo});
  }
}
