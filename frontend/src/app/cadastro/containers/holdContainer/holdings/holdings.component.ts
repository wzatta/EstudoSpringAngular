import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, of } from 'rxjs';
import { HoldingService } from 'src/app/cadastro/services/Holding.service';

import {
  ConfirmationDialogComponent,
} from '../../../../shared/components/confirmation-dialog/confirmation-dialog.component';
import { ErrorDialogComponent } from '../../../../shared/components/error-dialog/error-dialog.component';
import { HoldInterface } from '../../../model/HoldInterface';

@Component({
  selector: 'app-holdings',
  templateUrl: './holdings.component.html',
  styleUrls: ['./holdings.component.scss']
})
export class HoldingsComponent implements OnInit {

  holdingdb$: Observable<HoldInterface[]> | null = null;
  displayedColumns = ['idHold','rsocial', 'dsocial', 'cnpj', 'municipio', 'uf', 'actions' ];

  constructor(
    private holdService: HoldingService,
    private router: Router,
    private route: ActivatedRoute,
    public dialog: MatDialog,
    private snackBar: MatSnackBar
  ){
    this.refresh();
    }

    refresh(){
      this.holdingdb$ = this.holdService.list()
      .pipe(
        catchError(errorteste => {
          this.onError('Erro ao Carregar os Registros!');
          return of([]);
        })
      );
    }

    onError(errorMSG : string){
      this.dialog.open(ErrorDialogComponent, {
        data : errorMSG
      });

    }

  ngOnInit(): void {}

  onAdd(){
    this.router.navigate(['newHold'],{relativeTo: this.route});
  }


  onEdit(holding: HoldInterface){
    this.router.navigate(['editHold', holding.idHold],{relativeTo: this.route});

  }

  onDelete(holding: HoldInterface){

    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: 'Tem Certeza que Deseja Remover o Registro ?',
    });

    dialogRef.afterClosed().subscribe((result:boolean) => {

      if(result){

        this.holdService.delHold(holding.idHold).subscribe(
          () => {
            this.refresh();
            this.snackBar.open('Registro Removido com Sucesso!','X',{
              duration: 5000,
              verticalPosition: 'top',
              horizontalPosition: 'center'
            });
          },
          () => this.onError('Erro ao tentar remover Registro.')
        );

      }
    });
   }

}
