import { Component, OnInit } from '@angular/core';
import { Usuario } from '../model/Usuario';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.scss']
})
export class UsuariosComponent implements OnInit {

  usuariosdb: Usuario[] = ["1234","Waldyr","zatta","a","12345","12345"];
  displayedColumns = ['id' , 'name', 'username','status','cpf' ,'password'];

  constructor(){
   // this.usuariosdb = [];
  }
 ngOnInit():void{

 }

}
