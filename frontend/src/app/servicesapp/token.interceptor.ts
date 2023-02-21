import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserloginService } from './userlogin.service';

const TOKEN_HEADER_KEY = 'Authorization';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor(
    private userlog: UserloginService
    ) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

     let authReq = request;
     let retirarAspa = this.userlog.obterTokenUsuario;
     const token = retirarAspa?.replace(/"/g,'');
     //const token = this.userlog.obterTokenUsuario;
     if(token != null){
      authReq = request.clone({
        headers:request.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + token)
      });
     }

    return next.handle(authReq);
  }
}

