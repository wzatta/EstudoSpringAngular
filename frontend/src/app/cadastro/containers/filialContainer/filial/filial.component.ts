import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

import { FilialInterface } from '../../../model/filial-interface';

@Component({
  selector: 'app-filial',
  templateUrl: './filial.component.html',
  styleUrls: ['./filial.component.scss']
})
export class FilialComponent implements OnInit {

  public listar: boolean = false;

  displayedColumns = ['rsocial', 'dsocial', 'cnpj', 'municipio', 'uf'];

  constructor(
    private dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute
  ){}

  ngOnInit(): void {}

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
