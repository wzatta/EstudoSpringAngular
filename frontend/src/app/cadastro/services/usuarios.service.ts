import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { first, tap } from 'rxjs';
import { Usuariointerface } from '../model/usuariointerface';

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
      if(record.id){
        return this.update(record);
      }
    return this.create(record);
  }

  loadById(id: string){
   return this.httpClient.get<Usuariointerface>(this.API+'/'+id);
  }

  deluser(id:String){
    return this.httpClient.delete(this.API+'/'+id).pipe(first());
  }


  private create(record: Partial<Usuariointerface>){
    return this.httpClient.post<Usuariointerface>(this.API, record);
  }

  private update(record: Partial<Usuariointerface>){
    return this.httpClient.put<Usuariointerface>(this.API+'/'+record.id, record);
  }




}
