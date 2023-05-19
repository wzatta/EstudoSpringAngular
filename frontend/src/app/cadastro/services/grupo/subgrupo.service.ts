import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SubGrupoInterface } from '../../model/grupo/SubGrupoInterface';

@Injectable({
  providedIn: 'root'
})
export class SubgrupoService {

  private readonly APISBGRUPO = "api/v1/sbgrupo";

  constructor(
    private httpcliente: HttpClient
  ) { }

listAll(){
  return this.httpcliente.get<SubGrupoInterface[]>(this.APISBGRUPO);
}

findById(id:string){
  return this.httpcliente.get<SubGrupoInterface>(this.APISBGRUPO+"/"+id);
}

save(record: Partial<SubGrupoInterface>){
  if(record.idSubGr){
    return this.update(record);
  }
    return this.create(record);
}

private create(record: Partial<SubGrupoInterface>){
  return this.httpcliente.post<SubGrupoInterface>(this.APISBGRUPO, record);
}

private update(record: Partial<SubGrupoInterface>){
  return this.httpcliente.put<SubGrupoInterface>(this.APISBGRUPO+"/"+record.codigoSubGr, record);
}


}
