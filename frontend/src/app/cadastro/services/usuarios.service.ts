import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { first, tap } from 'rxjs';
import { UsuarioInterface } from '../model/UsuarioInterface';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  private readonly API = 'api/v1/user00';

  constructor(private httpClient: HttpClient) { }

  list()  {
    return this.httpClient.get<UsuarioInterface[]>(this.API)
    .pipe(
          first(),
          tap(usuarios=>console.log(usuarios))
    );
  }

  save(record: Partial<UsuarioInterface>){

    if(record.id){
        return this.update(record);
      }
    return this.create(record);
  }

  loadById(id: string){
   return this.httpClient.get<UsuarioInterface>(this.API+'/id/'+id);
  }

  loadByUsername<UsuarioInterface>(username: string){
    return this.httpClient.get<UsuarioInterface>(this.API+'/'+username);
  }

  deluser(id:String){
    return this.httpClient.delete(this.API+'/'+id).pipe(first());
  }


  private create(record: Partial<UsuarioInterface>){
    return this.httpClient.post<UsuarioInterface>(this.API, record);
  }

  private update(record: Partial<UsuarioInterface>){
    return this.httpClient.put<UsuarioInterface>(this.API+'/'+record.id, record);
  }




}
