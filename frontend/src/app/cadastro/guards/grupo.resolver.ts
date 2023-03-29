import { Injectable } from '@angular/core';
import {
  Router, Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable, of } from 'rxjs';
import { GrupoInterface } from '../model/GrupoInterface';
import { GrupoService } from '../services/grupo.service';

@Injectable({
  providedIn: 'root'
})
export class GrupoResolver implements Resolve<GrupoInterface> {

  constructor(
    private gruposerv: GrupoService
    ){}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<GrupoInterface> {

    if(route.params && route.params['id']){
        return this.gruposerv.findById(route.params['id']);
    }
      return of({idGr:'', codigoGr:'', descGr:''});

  }
}
