import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { AlmoxInterface } from '../../model/almox/almox-interface';
import { HoldInterface } from '../../model/HoldInterface';
import { FilialInterface } from '../../model/filial-interface';

@Injectable({
  providedIn: 'root'
})
export class AlmoxService implements OnInit {

   private readonly API = "api/v1/almoxarifado";
  private readonly APIALMOX = "api/v1/almoxarifado/hold";
  private readonly APIALMOXF = "api/v1/almoxarifado/filial";
  private readonly APIALMOXA = "api/v1/almoxarifado/almox";



  constructor(
    private httpClient: HttpClient,

  ) { }

  ngOnInit(): void {

  }

  findById(id: string){
    return this.httpClient.get<AlmoxInterface>(this.API+"/"+id);
  }

  findAllByHolding(hold:Partial<HoldInterface>){
    return this.httpClient.post<AlmoxInterface[]>(this.APIALMOX, hold);
  }

  findByFilial(filial:Partial<FilialInterface>){
    return this.httpClient.post<AlmoxInterface>(this.APIALMOXA, filial);
  }


  findAllByFilial(filial:Partial<FilialInterface>){
    return this.httpClient.post<AlmoxInterface[]>(this.APIALMOXF ,filial);
  }

  saveAlmox(record: Partial<AlmoxInterface>){
    if(record.idAlmoxdto){
      return this.update(record);
    }
      return this.create(record);
  }

  private create(record: Partial<AlmoxInterface>){
    return this.httpClient.post<AlmoxInterface>(this.API, record);
  }

  private update(record: Partial<AlmoxInterface>){
    return this.httpClient.put<AlmoxInterface>(this.API+"/"+record.idAlmoxdto, record);
  }

  deleteAlmox(id: string){
    return this.httpClient.delete<AlmoxInterface>(this.API+"/"+id);
  }






}
