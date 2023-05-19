import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AlmoxInterface } from 'src/app/cadastro/model/almox/almox-interface';
import { AlmoxService } from 'src/app/cadastro/services/almox/almox.service';
import { UserloginService } from 'src/app/servicesapp/userlogin.service';
import { ConfirmationDialogComponent } from 'src/app/shared/components/confirmation-dialog/confirmation-dialog.component';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';
import { Almox } from '../../../model/classes/Almox';

@Component({
  selector: 'app-almoxarifado-list',
  templateUrl: './almoxarifado-list.component.html',
  styleUrls: ['./almoxarifado-list.component.scss']
})
export class AlmoxarifadoListComponent implements OnInit {


  roleString: string = "USER";
 // almoxDb$ : Observable<AlmoxInterface[]> | null = null;
 almoxDb$ : Observable<AlmoxInterface[]> = new Observable<Almox[]>;

 readonly displayedColumns = ['titulodto','isAtivodto','filialDto','actions'];

  constructor(
    private almoxServ: AlmoxService,
    private logUser: UserloginService,
    private router: Router,
    private route: ActivatedRoute,
    private dialog: MatDialog,
    private snackBar: MatSnackBar
  ){}

  ngOnInit(): void {
    this.refresh();
  }


  refresh(){
    this.logUser.obterUsuario.subscribe(
      res=>{
        this.roleString = res.role;
        if(this.roleString==="ADMIN"){
          this.almoxDb$ = this.almoxServ.findAllByHolding(res.colabDto.filialDto.holdingDto);
        }
        if(this.roleString==="USER"){
         this.almoxDb$ = this.almoxServ.findAllByFilial(res.colabDto.filialDto);
        }
      }
    )
  }

  onEdit(almox: AlmoxInterface){
    this.router.navigate(['editAlmox', almox.idAlmoxdto],{relativeTo: this.route});
  }

  onDelete(almox: AlmoxInterface){

    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: 'Tem Certeza que Deseja Remover o Registro ?',
    });

    dialogRef.afterClosed().subscribe((result:boolean) => {

      if(result){

        this.almoxServ.deleteAlmox(almox.idAlmoxdto).subscribe(
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

  onError(errorMSG: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMSG
    });
  }

}
