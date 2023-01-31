import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
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
  displayedColumns = ['id' , 'name', 'cpf','username','userativo','usernaobloq','role','actions'];

  //usuariosService: UsuariosService;

  constructor(
    private usuariosService: UsuariosService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute
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

 onAdd(){
    this.router.navigate(['new'],{relativeTo: this.route});
 }

 onEdit(){
    console.log('onEdit');

  }
 onDelete(){
    console.log('onDelete');
 }




}
