import { Component, OnInit } from '@angular/core';
import { Route, Router, ActivatedRoute } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

@Component({
  selector: 'app-colaborador',
  templateUrl: './colaborador.component.html',
  styleUrls: ['./colaborador.component.scss']
})
export class ColaboradorComponent implements OnInit{

  public listar: boolean = false;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private dialog: MatDialog

  ){}

  ngOnInit(): void {

  }

  onAddColab(){
    this.router.navigate(['newColab'],{ relativeTo: this.route });
  }

  onListColab(){
    this.listar = !this.listar;
  }

  onError(errorMSG : string){
    this.dialog.open(ErrorDialogComponent, {
      data : errorMSG
    });

  }

}
