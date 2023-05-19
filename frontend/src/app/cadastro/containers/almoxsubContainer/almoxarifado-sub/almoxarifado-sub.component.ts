import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

@Component({
  selector: 'app-almoxarifado-sub',
  templateUrl: './almoxarifado-sub.component.html',
  styleUrls: ['./almoxarifado-sub.component.scss']
})
export class AlmoxarifadoSubComponent implements OnInit {

    listar : Boolean = false;

    constructor(
      private router: Router,
      private route: ActivatedRoute,
      private dialog: MatDialog
    ){}

    ngOnInit(): void {}

    onListAlmoxSub(){
      this.listar = !this.listar;
    }

    onAddAlmoxSub(){
      this.router.navigate(["newAlmoxSub"],{relativeTo : this.route});
    }

    onError(errorMSG : string){
      this.dialog.open(ErrorDialogComponent,{
        data: errorMSG
      });
    }

}
