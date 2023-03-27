import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ColaboradorInterface } from '../model/colaboradorInterface';

@Injectable({
  providedIn: 'root'
})
export class ColaboradorService {

  private readonly APICOLAB = "api/v1/colab";
  private readonly APICOLABNAME = "api/v1/colab/name"

  constructor(
    private httpClient: HttpClient
  ) { }

  listAll(){
    return this.httpClient.get<ColaboradorInterface[]>(this.APICOLAB);
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
