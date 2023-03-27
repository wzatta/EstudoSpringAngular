import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { first, Observable, pipe, tap } from 'rxjs';
import { HoldInterface } from '../model/HoldInterface';
import { UserloginService } from '../../servicesapp/userlogin.service';
import { UsuarioInterface } from '../model/UsuarioInterface';
import { ParseTreeResult } from '@angular/compiler';
import { Resolve } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class HoldingService {

  private readonly API = 'api/v1/holding';

constructor(private httpClient: HttpClient
            //private userLoginService: UserloginService
            ) { }

list(){
  return this.httpClient.get<HoldInterface[]>(this.API);
}

save(record: Partial<HoldInterface>){

  if(record.idHold){
    return this.update(record);
  }
    return this.create(record);
}

loadById(id: string){
  return this.httpClient.get<HoldInterface>(this.API+'/'+id);
}

delHold(id: string){
  return this.httpClient.delete(this.API+'/'+id).pipe(first());
}

private create(record: Partial<HoldInterface>){
  return this.httpClient.post<HoldInterface>(this.API, record);
}

private update(record: Partial<HoldInterface>){
  return this.httpClient.put<HoldInterface>(this.API+'/'+record.idHold, record);
}


}
