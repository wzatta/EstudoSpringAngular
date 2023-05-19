import { FilialInterface } from './../model/filial-interface';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HoldInterface } from '../model/HoldInterface';

@Injectable({
  providedIn: 'root'
})
export class FilialService {

  private readonly APIFilial = "api/v1/filial";
  private readonly APIFilialS = "api/v1/filial/search";
  private readonly APIFILIALH = "api/v1/filial/hold"
  private readonly APIFILIALF = "api/v1/filial/filial"

  constructor(
    private httpCliente: HttpClient
  ) { }

  listAll(){
    return this.httpCliente.get<FilialInterface[]>(this.APIFilial);
  }

  findAllByHolding(record: HoldInterface){
    return this.httpCliente.post<FilialInterface[]>(this.APIFILIALH, record);
  }

  findAllByFilial(record: FilialInterface){
    return this.httpCliente.post<FilialInterface[]>(this.APIFILIALF, record);
  }

  findByRsocial(rsocial:String){
    return this.httpCliente.get<FilialInterface[]>(this.APIFilialS+'/'+rsocial);
  }

  findById(id:String){
    return this.httpCliente.get<FilialInterface>(this.APIFilial+'/'+id);
  }

  save(record: Partial<FilialInterface>){

    if(record.idFilial){
      return this.update(record);
    }
      return this.create(record);
  }


  private create(record: Partial<FilialInterface>){
    return this.httpCliente.post<FilialInterface>(this.APIFilial, record);
  }

  private update(record: Partial<FilialInterface>){
    return this.httpCliente.put<FilialInterface>(this.APIFilial+'/'+record.idFilial, record);
  }





}
