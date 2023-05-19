import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Almoxsubinterface } from '../../model/almox/almoxsubinterface';
import { FilialInterface } from '../../model/filial-interface';

@Injectable({
  providedIn: 'root'
})
export class AlmoxsubService {

  private readonly API = "api/v1/almoxarifadosub"
  private readonly APIF = "api/v1/almoxarifadosub/filial"
  private readonly APIT = "api/v1/almoxarifadosub/sub"


  constructor(
    private httpClient: HttpClient
  ) { }

  findAllByFilial(filial: Partial<FilialInterface>){
   return this.httpClient.post<Almoxsubinterface[]>(this.APIF, filial);
  }

  findById(id: string) {
    return this.httpClient.get<Almoxsubinterface>(this.API + "/" + id);
  }

  saveAlmoxSub(record: Partial<Almoxsubinterface>) {
    if (record.idSubdto) {
      return this.update(record);
    }
    return this.create(record);
  }

  private update(record: Partial<Almoxsubinterface>) {
   return this.httpClient.put<Almoxsubinterface>(this.API + "/" + record.idSubdto, record);
  }

  private create(record: Partial<Almoxsubinterface>) {
    return this.httpClient.post<Almoxsubinterface>(this.APIT, record);
  }

  deleteAlmoxSub(id:string) {
    return this.httpClient.delete(this.API+"/"+id);

  }

}




