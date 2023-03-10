import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { OsfilialService } from '../../../services/osfilial.service';
import { Observable } from 'rxjs';
import { OsFilialInterface } from '../../../model/OsfilialInteface';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from '../../../../shared/components/error-dialog/error-dialog.component';
import { Router, ActivatedRoute } from '@angular/router';
import { ConfirmationDialogComponent } from 'src/app/shared/components/confirmation-dialog/confirmation-dialog.component';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-osfilial-list',
  templateUrl: './osfilial-list.component.html',
  styleUrls: ['./osfilial-list.component.scss']
})
export class OsfilialListComponent implements OnInit{

  @Input() osfilialdb: OsFilialInterface[] = [];
  @Output() editOsFilial = new EventEmitter(false);
  @Output() delOsFilial = new EventEmitter(false);

  osfilialdb$: Observable<OsFilialInterface[]> | null = null;
  readonly displayedColumns = ['codigoOs', 'descricaoOs','dataInicial', 'dataFinal', 'osIsAtiva','actions'];

constructor(
  private osservice: OsfilialService,
  private dialog: MatDialog,
  private router: Router,
  private route: ActivatedRoute,
  private snackBar: MatSnackBar

  ){}

ngOnInit(): void {
    this.refresh();
}

refresh(){
  this.osfilialdb$ = this.osservice.listAll();
}

onEdit(osfilial: OsFilialInterface){
this.router.navigate(['editOsFilial', osfilial.idOs],{relativeTo: this.route});
}


onDelete(osFilial: OsFilialInterface){

  const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
    data: 'Tem Certeza que Deseja Remover o Registro ?',
  });

  dialogRef.afterClosed().subscribe((result:boolean) => {

    if(result){

      this.osservice.delOsFilial(osFilial.idOs).subscribe(
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

onError(erroMSG: string){
this.dialog.open(ErrorDialogComponent, {
  data: erroMSG
});
}


}
