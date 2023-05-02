import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, pipe, tap } from 'rxjs';
import { LoginInterface } from '../cadastro/model/LoginInterface';
import { UsuarioInterface } from '../cadastro/model/UsuarioInterface';
import  jwt_decode from 'jwt-decode';
import { UsuariosService } from '../cadastro/services/usuarios.service';
import { Usuario } from '../cadastro/model/classes/usuario';

@Injectable({
  providedIn: 'root'
})
export class UserloginService {

  private readonly APILOGIN = 'api/v1/auth/authenticate';


  private storage: Storage;

  constructor(
    private httpClient: HttpClient,
    private router: Router,
    private userservice: UsuariosService
  ) {
    this.storage = window.sessionStorage;
  }

  logar(usuario: LoginInterface) : Observable<any>{
    return this.httpClient.post<any>(this.APILOGIN, usuario)
    .pipe(
      tap((resposta) =>
       {
        if(!resposta) return;
        this.storage.clear();
        this.storage.setItem('token', JSON.stringify(resposta['token']));
       // localStorage.setItem('token' , JSON.stringify(resposta['token']));
        this.router.navigate(['']);
      })
    );
  }

  deslogar(){
    this.storage.clear();
    //localStorage.clear();
    window.location.reload();
    this.router.navigate(['login'])
  }



  get obterTokenUsuario(): string | null {
    return this.storage.getItem('token') ? this.storage.getItem('token') : null;
  }

  get obterUsuario(): Observable<UsuarioInterface>  {
    let tokenprovisorio: string | null  = this.obterTokenUsuario;
    if(tokenprovisorio != null){
      type dados = {
      'sub': '';
      'iat': 0;
      'exp': 0;
    }
    var teste:dados = jwt_decode(tokenprovisorio);
    return this.userservice.loadByUsername(teste.sub);
    }
    return new Observable<Usuario>;
  }


  get logado(): boolean {
      return this.storage.getItem('token') ? true : false;
    //return localStorage.getItem('token') ? true : false;
  }




}
