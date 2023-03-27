import { Injectable } from '@angular/core';
import {
  Router, Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable, of } from 'rxjs';
import { FilialInterface } from '../model/filial-interface';
import { UsuarioInterface } from '../model/UsuarioInterface';
import { FilialService } from '../services/filial.service';
import { HoldInterface } from '../model/HoldInterface';

@Injectable({
  providedIn: 'root'
})
export class FilialResolver implements Resolve<FilialInterface> {

  constructor(private filialServ: FilialService){}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<FilialInterface> {

    let hold2: HoldInterface | any = '';

    if(route.params && route.params['id']){
      return this.filialServ.findById(route.params['id']);
    }

    return of({idFilial:'', rsocial: '', dsocial:'', cnpj:'', municipio: '', uf:'', holdingDto:hold2});
  }
}
