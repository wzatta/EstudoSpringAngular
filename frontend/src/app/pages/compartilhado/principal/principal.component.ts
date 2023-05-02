import { Component, OnInit } from '@angular/core';
import { UserloginService } from '../../../servicesapp/userlogin.service';
import { UsuarioInterface } from 'src/app/cadastro/model/UsuarioInterface';
import { Usuario } from 'src/app/cadastro/model/classes/usuario';
import { Router } from '@angular/router';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.scss']
})
export class PrincipalComponent implements OnInit  {

  userlog: UsuarioInterface = new Usuario();
  displayUser: string = "";


  constructor(
    private usuarioLoginService: UserloginService,
    private router: Router
  ){
    this.usuarioLoginService.obterUsuario.subscribe(
      res=> {this.userlog = res,
            this.displayUser = res.colabDto.name}
    );
    // this.displayUser = this.userlog.colabDto.name;
  }

  ngOnInit(): void {


  }

  deslogar(){
    this.usuarioLoginService.deslogar();

  }

  refresh(){
    this.router.navigate(['']);
    window.location.reload;
  }


}
