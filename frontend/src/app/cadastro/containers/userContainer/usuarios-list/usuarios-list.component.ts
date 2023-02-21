import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { UsuarioInterface } from '../../../model/UsuarioInterface';

@Component({
  selector: 'app-usuarios-list',
  templateUrl: './usuarios-list.component.html',
  styleUrls: ['./usuarios-list.component.scss']
})
export class UsuariosListComponent implements OnInit {

@Input() usuariosdb: UsuarioInterface[] = [];
@Output() add = new EventEmitter(false);
@Output() edit = new EventEmitter(false);
@Output() deluser = new EventEmitter(false);

readonly displayedColumns = ['id' , 'name', 'cpf','username','userativo','usernaobloq','role','actions'];

constructor() {}

ngOnInit():void{}

onAdd(){
    this.add.emit(true);
 }

 onEdit(usuario: UsuarioInterface){
  this.edit.emit(usuario);
  }

 onDelete(usuario: UsuarioInterface){
    this.deluser.emit(usuario);
 }

}
