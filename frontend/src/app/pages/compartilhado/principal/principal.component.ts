import { Component, OnInit } from '@angular/core';
import { UserloginService } from '../../../servicesapp/userlogin.service';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.scss']
})
export class PrincipalComponent implements OnInit {

  constructor(
    private usuarioLoginService: UserloginService
  ){}

  ngOnInit(): void {

  }

  deslogar(){
    this.usuarioLoginService.deslogar();
  }

}
