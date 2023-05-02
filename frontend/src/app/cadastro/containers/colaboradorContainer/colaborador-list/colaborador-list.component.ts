import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Observable } from 'rxjs';
import { ColaboradorInterface } from '../../../model/colaboradorInterface';
import { ColaboradorService } from '../../../services/colaborador.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ConfirmationDialogComponent } from 'src/app/shared/components/confirmation-dialog/confirmation-dialog.component';
import { UserloginService } from 'src/app/servicesapp/userlogin.service';
import { Colaborador } from 'src/app/cadastro/model/classes/Colaborador';

@Component({
  selector: 'app-colaborador-list',
  templateUrl: './colaborador-list.component.html',
  styleUrls: ['./colaborador-list.component.scss']
})
export class ColaboradorListComponent implements OnInit{

  //@Input() colabDb: ColaboradorInterface[] = [];
 // @Output() editColab = new EventEmitter(false);
 // @Output() delColab = new EventEmitter(false);

 roleString: String = "USER";
  //colabDb$ : Observable<ColaboradorInterface[]> | null = null;
  colabDb$ : Observable<ColaboradorInterface[]> = new Observable<Colaborador[]>;
  readonly displayedColumns = ['matricula','name','funcao','dateAdm','dateDem','actions'];

  constructor(
    private colabServ: ColaboradorService,
    private logUser: UserloginService,
    private router: Router,
    private route: ActivatedRoute,
    private dialog: MatDialog,
    private snackBar: MatSnackBar
  ){}

  ngOnInit(): void {
    this.refresh()
  }


  refresh(){
    //this.colabDb$ = this.colabServ.listAll();
    this.logUser.obterUsuario.subscribe(
      res=>{
        this.roleString = res.role;
        if(this.roleString==="ADMIN"){
          this.colabDb$ = this.colabServ.findAllByHolding(res.colabDto.filialDto.holdingDto);
        }
        if(this.roleString==="USER"){
         this.colabDb$ = this.colabServ.findAllByFilial(res.colabDto.filialDto);
        }
      }
    )
  }

  onEdit(colab: ColaboradorInterface){
    this.router.navigate(['editColab', colab.id],{relativeTo: this.route});
  }

  onDelete(colab: ColaboradorInterface){

    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: 'Tem Certeza que Deseja Remover o Registro ?',
    });

    dialogRef.afterClosed().subscribe((result:boolean) => {

      if(result){

        this.colabServ.deleteColab(colab.id).subscribe(
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
