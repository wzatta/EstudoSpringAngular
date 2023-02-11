import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UserloginService } from '../../servicesapp/userlogin.service';

@Injectable({
  providedIn: 'root'
})
export class UsuarioAutenticadoGuard implements CanActivate {

  constructor(
    private usuarioLoginService: UserloginService,
    private router: Router
  ){}

  canActivate(){

    if(this.usuarioLoginService.logado){
      return true;
    }

    this.router.navigate(['login']);
    return false;

  }

}
