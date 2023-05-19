import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  imgPrincipal: string = "assets/painel02.png"

    constructor(){}


    ngOnInit(): void {
      this.imgPrincipal = "assets/painel02.png";
    }
}
