import { Injectable } from '@angular/core';
import {
  Router, Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable, of } from 'rxjs';
import { Almoxsubinterface } from '../model/almox/almoxsubinterface';
import { AlmoxsubService } from '../services/almox/almoxsub.service';
import { FilialInterface } from '../model/filial-interface';
import { AlmoxInterface } from '../model/almox/almox-interface';

@Injectable({
  providedIn: 'root'
})
export class AlmoxSubResolver implements Resolve<Almoxsubinterface> {

  constructor(
    private subservice: AlmoxsubService
  ){}



  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Almoxsubinterface> {

    let filial: FilialInterface | any = {};

    if(route.params && route.params['id']){
      return this.subservice.findById(route.params['id']);
    }

    return of({idSubdto:'', tituloSubdto:'', isAtivodto:'',isOnLine: '', dataCriacaodto:'', filialDto:filial});
  }
}
