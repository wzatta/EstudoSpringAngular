import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

import { OsFilialInterface } from '../../../model/OsfilialInteface';

@Component({
  selector: 'app-osfilial',
  templateUrl: './osfilial.component.html',
  styleUrls: ['./osfilial.component.scss']
})
export class OsfilialComponent implements OnInit {

  public listar: boolean = false;

  teste:boolean = true;

  constructor(
    private dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute
  ){}

  ngOnInit(): void {}

  addOsFilial(){
    console.log("cheguei aqui");
    this.router.navigate(['newOsFilial'],{relativeTo: this.route});
  }

  onEdit(osfilial: OsFilialInterface){
    this.router.navigate(['editOsFilial', osfilial.idOs],{relativeTo: this.route});

  }

  listOsFilial(){
    this.listar = !this.listar;
  }

  onError(errorMSG : string){
    this.dialog.open(ErrorDialogComponent, {
      data : errorMSG
    });
}


}
