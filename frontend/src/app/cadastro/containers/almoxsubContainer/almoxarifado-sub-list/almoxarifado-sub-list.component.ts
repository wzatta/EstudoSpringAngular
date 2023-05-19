import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Almoxsubinterface } from '../../../model/almox/almoxsubinterface';
import { AlmoxSub } from 'src/app/cadastro/model/classes/AlmoxSub';
import { AlmoxsubService } from 'src/app/cadastro/services/almox/almoxsub.service';
import { UserloginService } from 'src/app/servicesapp/userlogin.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmationDialogComponent } from 'src/app/shared/components/confirmation-dialog/confirmation-dialog.component';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

@Component({
  selector: 'app-almoxarifado-sub-list',
  templateUrl: './almoxarifado-sub-list.component.html',
  styleUrls: ['./almoxarifado-sub-list.component.scss']
})
export class AlmoxarifadoSubListComponent implements OnInit {

  roleString: string = "USER";
  almoxSubDb$: Observable<Almoxsubinterface[]> = new Observable<AlmoxSub[]>;

  readonly displayedColumns = ['titulodto','isAtivodto','filialDto','actions'];


  constructor(
    private subservice: AlmoxsubService,
    private logUser: UserloginService,
    private router: Router,
    private route: ActivatedRoute,
    private dialog:MatDialog,
    private snackBar: MatSnackBar
  ){}

  ngOnInit(): void {
    this.refresh;
  }

  refresh(){
    this.logUser.obterUsuario.subscribe(
      res=>{
        this.roleString = res.role;
        if(this.roleString==="ADMIN"){
         this.almoxSubDb$ = this.subservice.findAllByFilial(res.colabDto.filialDto);
        }
        if(this.roleString === "USER"){
          this.almoxSubDb$ = this.subservice.findAllByFilial(res.colabDto.filialDto)
        }
      }
    )
  }
onEdit(sub:Almoxsubinterface){
  this.router.navigate(['editAlmoxSub', sub.idSubdto],{relativeTo: this.route});
}

  onDelete(sub: Almoxsubinterface) {

    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: 'Tem Certeza que Deseja Remover o Registro ?',
    });

    dialogRef.afterClosed().subscribe((result: boolean) => {

      if (result) {

        this.subservice.deleteAlmoxSub(sub.idSubdto).subscribe({
          complete: () => {
            this.refresh();
            this.snackBar.open('Registro Removido com Sucesso!', 'X', {
              duration: 5000,
              verticalPosition: 'top',
              horizontalPosition: 'center'
            });
          },
          error: () => { this.onError }
        });
      }
    });
  }

onError(errorMSG: string) {
  this.dialog.open(ErrorDialogComponent, {
    data: errorMSG
  });
}







}
