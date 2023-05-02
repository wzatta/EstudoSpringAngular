import { UsuarioInterface } from './../../../cadastro/model/UsuarioInterface';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from 'src/app/cadastro/model/classes/usuario';
import { UserloginService } from 'src/app/servicesapp/userlogin.service';

@Component({
  selector: 'app-meu-menu',
  templateUrl: './meu-menu.component.html',
  styleUrls: ['./meu-menu.component.scss']
})
export class MeuMenuComponent implements OnInit  {

userAdm:boolean = true;
userlog: UsuarioInterface = new Usuario;
roleString: string | any = "";

constructor(
  private logService: UserloginService
){
  this.logService.obterUsuario.subscribe(
    res=> {this.userlog = res,
           this.roleString = res.role}
  );
      this.roleString = this.userlog.role;
  }

ngOnInit(): void {


}







}
