import { Injectable } from '@angular/core';
import { Usuariointerface } from '../model/usuariointerface';
import { HttpClient } from '@angular/common/http';
import { delay, first, tap } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  private readonly API = '/assets/usuariojason.json';

  constructor(private httpClient: HttpClient) { }

  list()  {
    return this.httpClient.get<Usuariointerface[]>(this.API)
    .pipe(
          first(),
          delay(10000),
          tap(usuarios=>console.log(usuarios))
    );
  }

}
