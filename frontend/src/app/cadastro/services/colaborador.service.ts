import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ColaboradorInterface } from '../model/colaboradorInterface';
import { FilialInterface } from '../model/filial-interface';
import { HoldInterface } from '../model/HoldInterface';

@Injectable({
  providedIn: 'root'
})
export class ColaboradorService {

  private readonly APICOLAB = "api/v1/colab";
  private readonly APICOLABNAME = "api/v1/colab/name"
  private readonly APICOLABOBJ = "api/v1/colab/filial"
  private readonly APICOLABOBJH = "api/v1/colab/hold"

  constructor(
    private httpClient: HttpClient
  ) { }

  listAll(){
    return this.httpClient.get<ColaboradorInterface[]>(this.APICOLAB);
  }

  findAllByHolding(hold:Partial<HoldInterface>){
    return this.httpClient.post<ColaboradorInterface[]>(this.APICOLABOBJH, hold);
  }

  findAllByFilial(filial:Partial<FilialInterface>){
    return this.httpClient.post<ColaboradorInterface[]>(this.APICOLABOBJ ,filial);
  }

  listName(name: string){
    return this.httpClient.get<ColaboradorInterface[]>(this.APICOLABNAME+"/"+ name);
  }

  findById(id: string){
    return this.httpClient.get<ColaboradorInterface>(this.APICOLAB+"/"+id);
  }

  saveColab(record: Partial<ColaboradorInterface>){
    if(record.id){
      return this.update(record);
    }
      return this.create(record);
  }

  private create(record: Partial<ColaboradorInterface>){
    return this.httpClient.post<ColaboradorInterface>(this.APICOLAB, record);
  }

  private update(record: Partial<ColaboradorInterface>){
    return this.httpClient.put<ColaboradorInterface>(this.APICOLAB+"/"+record.id, record);
  }

  deleteColab(id: string){
    return this.httpClient.delete<ColaboradorInterface>(this.APICOLAB+"/"+id);
  }


}
