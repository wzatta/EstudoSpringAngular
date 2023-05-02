import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from '../../../../shared/components/error-dialog/error-dialog.component';

@Component({
  selector: 'app-subgrupo',
  templateUrl: './subgrupo.component.html',
  styleUrls: ['./subgrupo.component.scss']
})
export class SubgrupoComponent  implements OnInit{

  public listar: boolean = false;

  constructor(
    private router:Router,
    private route: ActivatedRoute,
    private dialog: MatDialog
  ){}

  ngOnInit(): void {

  }

  onAddSbGrupo(){
    this.router.navigate(['newSbGrupo'],{relativeTo:this.route});
  }

  onListSbGrupo(){
    this.listar = !this.listar;
  }

  onError(errorMSG : string){
    this.dialog.open(ErrorDialogComponent,{
      data : errorMSG
    });
  }


}
