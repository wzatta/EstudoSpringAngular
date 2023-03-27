import { Injectable } from '@angular/core';
import {
  Router, Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { map, Observable, of, tap } from 'rxjs';
import { HoldInterface } from '../model/HoldInterface';
import { UsuarioInterface } from '../model/UsuarioInterface';
import { HoldingService } from '../services/Holding.service';

@Injectable({
  providedIn: 'root'
})
export class HoldingResolver implements Resolve<HoldInterface> {

  constructor(private holdService: HoldingService){

  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<HoldInterface> {

  //  let userlogado2: UsuarioInterface = {id:'', cpf:'', name:'', password:'',user00Name:'',userAtivo:'',userBloqueado:'',role:''};

      if(route.params && route.params['id']){
        return this.holdService.loadById(route.params['id']);
      }
    return of({idHold:'', rsocial: '', dsocial:'', cnpj:'', municipio: '', uf:''});
  }
}
