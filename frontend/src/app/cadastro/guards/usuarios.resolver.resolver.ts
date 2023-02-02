import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable, of } from 'rxjs';
import { Usuariointerface } from '../model/usuariointerface';

import { UsuariosService } from '../services/usuarios.service';

@Injectable({
  providedIn: 'root'
})
export class UsuariosResolverResolver implements Resolve<Usuariointerface> {

  constructor(private service: UsuariosService){

  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Usuariointerface> {

       if(route.params && route.params['id']){
          return this.service.loadById(route.params['id']);
       }
    return of( {id : '', name: '', cpf : '', userName : '', password : '', userAtivo : '',userNaoBloqueado : '',
    role : ''}
    );
  }
}
