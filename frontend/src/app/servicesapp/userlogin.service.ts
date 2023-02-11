import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, tap } from 'rxjs';
import { LoginInterface } from '../cadastro/model/LoginInterface';

@Injectable({
  providedIn: 'root'
})
export class UserloginService {

  private readonly APILOGIN = 'api/v1/auth/authenticate';

  constructor(
    private httpClient: HttpClient,
    private router: Router
  ) { }

  logar(usuario: LoginInterface) : Observable<any>{
    return this.httpClient.post<any>(this.APILOGIN, usuario)
    .pipe(
      tap((resposta) =>
       {
        if(!resposta) return;
        localStorage.setItem('token' , JSON.stringify(resposta['token']));
        this.router.navigate(['']);
      })
    );
  }

  deslogar(){
    localStorage.clear();
    this.router.navigate(['login']);
  }



  get obterTokenUsuario(): string {
    return localStorage.getItem('token') ? "localStorage.getItem('token')" : "fraco";
  }

  get logado(): boolean {
    return localStorage.getItem('token') ? true : false;
  }




}
