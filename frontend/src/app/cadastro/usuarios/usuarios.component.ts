import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { catchError, Observable, of } from 'rxjs';

import { ErrorDialogComponent } from '../../shared/components/error-dialog/error-dialog.component';
import { Usuariointerface } from '../model/usuariointerface';
import { UsuariosService } from '../services/usuarios.service';


@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.scss']
})
export class UsuariosComponent implements OnInit {

  usuariosdb$: Observable<Usuariointerface[]>;
  displayedColumns = ['id' , 'name', 'cpf','username','userativo','usernaobloq'];

  //usuariosService: UsuariosService;

  constructor(
    private usuariosService: UsuariosService,
    public dialog: MatDialog
    ){
   // this.usuariosdb = [];
   //this.usuariosService = new UsuariosService;
   this.usuariosdb$ = usuariosService.list()
   .pipe(
      catchError(errorteste =>{
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



 ngOnInit():void{

 }

}
