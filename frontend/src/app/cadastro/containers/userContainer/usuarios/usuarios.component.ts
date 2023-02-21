import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, of } from 'rxjs';

import { ErrorDialogComponent } from '../../../../shared/components/error-dialog/error-dialog.component';
import { UsuariosService } from '../../../services/usuarios.service';
import { ConfirmationDialogComponent } from '../../../../shared/components/confirmation-dialog/confirmation-dialog.component';
import { UsuarioInterface } from '../../../model/UsuarioInterface';



@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.scss']
})
export class UsuariosComponent implements OnInit {

  usuariosdb$: Observable<UsuarioInterface[]> | null  = null;

  displayedColumns = ['id' , 'name', 'cpf','username','userativo','usernaobloq','role','actions'];

  //usuariosService: UsuariosService;

  constructor(
    private usuariosService: UsuariosService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute,
    private snackBar: MatSnackBar
    ){
      this.refresh();
    }

    refresh(){
      this.usuariosdb$ = this.usuariosService.list()
   .pipe(
      catchError(errorteste => {
        this.onError('Erro ao carregar Usuarios');
        return of([])
      })
   );
    }


  onError(errorMSG : string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMSG
    });
  }

 ngOnInit():void{}




 onAdd(){
    this.router.navigate(['new'],{relativeTo: this.route});
 }

 onEdit(usuario:UsuarioInterface){
    this.router.navigate(['edit',usuario.id],{relativeTo: this.route});
  }

 onDelete(usuario: UsuarioInterface){

  const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
    data: 'Tem Certeza que Deseja Remover o Registro ?',
  });

  dialogRef.afterClosed().subscribe((result:boolean) => {

    if(result){

      this.usuariosService.deluser(usuario.id).subscribe(
        () => {
          this.refresh();
          this.snackBar.open('Registro Removido com Sucesso!','X',{
            duration: 5000,
            verticalPosition: 'top',
            horizontalPosition: 'center'
          });
        },
        () => this.onError('Erro ao tentar remover curso.')
      );

    }
  });
 }
}
