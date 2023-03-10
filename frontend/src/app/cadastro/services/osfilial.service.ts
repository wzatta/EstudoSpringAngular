import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OsFilialInterface } from '../model/OsfilialInteface';

@Injectable({
  providedIn: 'root'
})
export class OsfilialService {

  private readonly APIOS = "api/v1/osfilial";

  constructor(
    private httpcliente: HttpClient
  ) { }


  listAll(){
    return this.httpcliente.get<OsFilialInterface[]>(this.APIOS);
  }

  findById(id:string){
    return this.httpcliente.get<OsFilialInterface>(this.APIOS+'/'+id);
  }

  save(record: Partial<OsFilialInterface>){

    if(record.idOs){
      return this.update(record);
    }
      return this.create(record);
  }


private update(record: Partial<OsFilialInterface>){
  return this.httpcliente.put<OsFilialInterface>(this.APIOS+'/'+record.idOs, record);
}

private create(record: Partial<OsFilialInterface>){
  return this.httpcliente.post<OsFilialInterface>(this.APIOS, record);
}

delOsFilial(id:string){
  return this.httpcliente.delete<OsFilialInterface>(this.APIOS+'/'+id)
}




}
