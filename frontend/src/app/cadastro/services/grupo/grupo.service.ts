import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GrupoInterface } from '../../model/grupo/GrupoInterface';

@Injectable({
  providedIn: 'root'
})
export class GrupoService {

  private readonly APIGRUPO = "api/v1/grupo";

  constructor(
    private httpCliente : HttpClient
  ) { }


  listAll(){
    return this.httpCliente.get<GrupoInterface[]>(this.APIGRUPO);
  }

  findById(id:string){
    return this.httpCliente.get<GrupoInterface>(this.APIGRUPO+"/"+id);
  }

  save(record:Partial<GrupoInterface>){
    if(record.idGr){
      return this.update(record);
    }
      return this.create(record);
  }

  private create(record: Partial<GrupoInterface>){
    return this.httpCliente.post<GrupoInterface>(this.APIGRUPO, record);
  }

  private update(record: Partial<GrupoInterface>){
    return this.httpCliente.put<GrupoInterface>(this.APIGRUPO+"/"+record.idGr, record);
  }


}
