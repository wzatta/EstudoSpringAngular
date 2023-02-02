import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Usuariointerface } from '../../model/usuariointerface';

@Component({
  selector: 'app-usuarios-list',
  templateUrl: './usuarios-list.component.html',
  styleUrls: ['./usuarios-list.component.scss']
})
export class UsuariosListComponent implements OnInit {

@Input() usuariosdb: Usuariointerface[] = [];
@Output() add = new EventEmitter(false);
@Output() edit = new EventEmitter(false);
@Output() deluser = new EventEmitter(false);

readonly displayedColumns = ['id' , 'name', 'cpf','username','userativo','usernaobloq','role','actions'];

constructor() {}

ngOnInit():void{}

onAdd(){
    this.add.emit(true);
 }

 onEdit(usuario: Usuariointerface){
  this.edit.emit(usuario);
  }

 onDelete(usuario: Usuariointerface){
    this.deluser.emit(usuario);
 }

}
