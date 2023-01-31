import { Injectable } from '@angular/core';
import { Usuariointerface } from '../model/usuariointerface';
import { HttpClient } from '@angular/common/http';
import { delay, first, tap } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  private readonly API = 'api/v1/user00';

  constructor(private httpClient: HttpClient) { }

  list()  {
    return this.httpClient.get<Usuariointerface[]>(this.API)
    .pipe(
          first(),
          tap(usuarios=>console.log(usuarios))
    );
  }

  save(record: Partial<Usuariointerface>){
   console.log(record);
   return this.httpClient.post<Usuariointerface>(this.API, record);
  }

}
