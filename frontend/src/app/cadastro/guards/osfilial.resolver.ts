import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable, of } from 'rxjs';

import { FilialInterface } from '../model/filial-interface';
import { OsFilialInterface } from '../model/OsfilialInteface';
import { UsuarioInterface } from '../model/UsuarioInterface';
import { OsfilialService } from '../services/osfilial.service';

@Injectable({
  providedIn: 'root'
})
export class OsfilialResolver implements Resolve<OsFilialInterface> {

  constructor(private osfilialService: OsfilialService){}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<OsFilialInterface> {

    let userlogado2: UsuarioInterface | any = {};
    let filial1: FilialInterface | any = '';

    if(route.params && route.params['id']){
      return this.osfilialService.findById(route.params['id']);
    }

    return of({idOs:'', codigoOs: '', descricaoOs:'', dataInicial:'', dataFinal: '',osIsAtiva:'', filialDto:filial1, user00Dto:userlogado2});
  }

  }

