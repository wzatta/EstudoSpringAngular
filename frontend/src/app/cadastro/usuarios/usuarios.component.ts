import { Component, OnInit } from '@angular/core';
import { Usuariointerface } from '../model/usuariointerface';
import { UsuariosService } from '../services/usuarios.service';


@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.scss']
})
export class UsuariosComponent implements OnInit {

  usuariosdb: Usuariointerface[] = [];
  displayedColumns = ['id' , 'name', 'cpf','username','userativo','usernaobloq'];

  //usuariosService: UsuariosService;

  constructor(usuariosService: UsuariosService){
   // this.usuariosdb = [];
   //this.usuariosService = new UsuariosService;
   this.usuariosdb = usuariosService.list();

  }
 ngOnInit():void{

 }

}
