import { Injectable } from '@angular/core';
import { Usuariointerface } from '../model/usuariointerface';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  constructor(private httpClient: HttpClient) { }

  list(): Usuariointerface[] {
    return [
    {id:"1", name:"Waldyr Zatta",username:"zatta",cpf:"123",password:"1234", userativo:"true",usernaobloq:"falso",role:"ADMIN"},
    {id:"1", name:"Waldyr Zatta",username:"zatta",cpf:"123",password:"1234", userativo:"true",usernaobloq:"falso",role:"USER"}
  ];
  }

}
