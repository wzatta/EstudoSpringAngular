import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

@Component({
  selector: 'app-almoxarifado',
  templateUrl: './almoxarifado.component.html',
  styleUrls: ['./almoxarifado.component.scss']
})
export class AlmoxarifadoComponent implements OnInit{

  listar : Boolean = false;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private dialog: MatDialog
  ){}

  ngOnInit(): void {}

  onListAlmox(){
    this.listar = !this.listar;
  }

  onAddAlmox(){
    this.router.navigate(['newAlmox'],{ relativeTo: this.route });
  }

  onError(errorMSG : string){
    this.dialog.open(ErrorDialogComponent, {
      data : errorMSG
    });

  }


}
