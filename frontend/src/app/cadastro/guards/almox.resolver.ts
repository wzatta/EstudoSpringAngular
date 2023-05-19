import { Injectable } from '@angular/core';
import {
  Router, Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable, of } from 'rxjs';
import { AlmoxService } from '../services/almox/almox.service';
import { FilialInterface } from '../model/filial-interface';
import { AlmoxInterface } from '../model/almox/almox-interface';

@Injectable({
  providedIn: 'root'
})
export class AlmoxResolver implements Resolve<AlmoxInterface> {

  constructor(
    private almoxService: AlmoxService
  ){

  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<AlmoxInterface> {

    let filial: FilialInterface | any = {};

    if(route.params && route.params['id']){
      return this.almoxService.findById(route.params['id']);
    }

    return of({idAlmoxdto:'', titulodto:'',tipodto:'' ,isAtivodto:'', dataCriacaodto:'', filialDto:filial});
  }
}
