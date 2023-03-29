import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { GrupoInterface } from 'src/app/cadastro/model/GrupoInterface';
import { GrupoService } from '../../../services/grupo.service';
import { Router, ActivatedRoute } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-grupo-list',
  templateUrl: './grupo-list.component.html',
  styleUrls: ['./grupo-list.component.scss']
})
export class GrupoListComponent implements OnInit{

  grupodb$ : Observable<GrupoInterface[]> | null = null;
  readonly displayedColumns = ['codigoGr','descGr','actions'];

  constructor(
    private grupoService: GrupoService,
    private router: Router,
    private route: ActivatedRoute,
    private dialog: MatDialog,
    private snacBar: MatSnackBar
  ){}

  ngOnInit(): void {
    this.refresh();
  }


  refresh(){
   this.grupodb$ = this.grupoService.listAll();
  }

 onEdit(grupo: GrupoInterface){
  this.router.navigate(['editGrupo',grupo.idGr],{relativeTo: this.route});
 }

  onDelete(grupo: GrupoInterface): void{}


}

