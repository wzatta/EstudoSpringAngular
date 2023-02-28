import { Component, OnInit } from '@angular/core';
import { FilialService } from '../../../services/filial.service';
import { Observable, catchError, of } from 'rxjs';
import { FilialInterface } from '../../../model/filial-interface';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-filial',
  templateUrl: './filial.component.html',
  styleUrls: ['./filial.component.scss']
})
export class FilialComponent implements OnInit {

  public listar: boolean = false;

  //filialdb$: Observable<FilialInterface[]> | null = null;
  displayedColumns = ['rsocial', 'dsocial', 'cnpj', 'municipio', 'uf' ];


  constructor(
    private filialServ: FilialService,
    private dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute
  ){
    this.refresh();
  }

  ngOnInit(): void {}

  refresh(){
    /*this.filialdb$ = this.filialServ.listAll()
    .pipe(
      catchError(erroteste => {
        this.onError('Erro ao Carregar os Registros');
        return of([]);
      })
    );*/
  }

  onAddFilial(){
    this.router.navigate(['newFilial'],{relativeTo: this.route});
  }

  onEdit(filial: FilialInterface){
    this.router.navigate(['editFilial', filial.idFilial],{relativeTo: this.route});

  }

  onListFilial(){
    this.listar = !this.listar;
  }

  onError(errorMSG : string){
    this.dialog.open(ErrorDialogComponent, {
      data : errorMSG
    });
}
}
