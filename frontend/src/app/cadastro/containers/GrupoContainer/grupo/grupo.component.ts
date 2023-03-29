import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

@Component({
  selector: 'app-grupo',
  templateUrl: './grupo.component.html',
  styleUrls: ['./grupo.component.scss']
})
export class GrupoComponent implements OnInit {


  public listar: boolean = false;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private dialog: MatDialog
  ){}


  ngOnInit(): void {

  }


  onAddGrupo(){
    this.router.navigate(['newGrupo'],{relativeTo: this.route});
  }

  onListGrupo(){
    this.listar = !this.listar;
  }

  onError(errorMSG : string){
    this.dialog.open(ErrorDialogComponent, {
      data : errorMSG
    });

  }




}
