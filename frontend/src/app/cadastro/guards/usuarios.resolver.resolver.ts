import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable, of } from 'rxjs';
import { UsuarioInterface } from '../model/UsuarioInterface';

import { UsuariosService } from '../services/usuarios.service';

@Injectable({
  providedIn: 'root'
})
export class UsuariosResolverResolver implements Resolve<UsuarioInterface> {

  constructor(private service: UsuariosService){

  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<UsuarioInterface> {

       if(route.params && route.params['id']){
          return this.service.loadById(route.params['id']);
       }
    return of( {id : '', name: '', cpf : '', user00Name : '', password : '', userAtivo : '',userBloqueado : '',
    role : ''}
    );
  }
}
