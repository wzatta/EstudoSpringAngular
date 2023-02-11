import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UserloginService } from 'src/app/servicesapp/userlogin.service';

@Injectable({
  providedIn: 'root'
})
export class UsuarioNaoAutenticadoGuard implements CanActivate {


  constructor(
    private usuarioLoginService: UserloginService,
    private router: Router
  ){}


  canActivate(){
    if(this.usuarioLoginService.logado){
      this.router.navigate(['']);
      return false;
    }
    return true;
  }

}
