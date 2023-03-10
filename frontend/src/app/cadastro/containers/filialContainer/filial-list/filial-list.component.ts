import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { debounceTime, distinctUntilChanged, filter, map, Observable, switchMap } from 'rxjs';
import { FilialService } from 'src/app/cadastro/services/filial.service';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

import { FilialInterface } from './../../../model/filial-interface';

@Component({
  selector: 'app-filial-list',
  templateUrl: './filial-list.component.html',
  styleUrls: ['./filial-list.component.scss']
})
export class FilialListComponent implements OnInit {

  @Input() filialdb: FilialInterface[] = [];
  @Output() editFilial = new EventEmitter(false);
  @Output() delFilial = new EventEmitter(false);

  filialdb$: Observable<FilialInterface[]> | null = null;

  queryField = new FormControl();

  readonly displayedColumns = ['rsocial', 'dsocial', 'cnpj', 'municipio', 'uf', 'actions'];

  constructor(
    private filialServ: FilialService,
    private dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {

    this.filialdb$ = this.queryField.valueChanges
    .pipe(
      map( value => value.trim()),
      filter(value => value.length > 5),
      debounceTime(200),
      distinctUntilChanged(),
      switchMap(value => this.filialServ.findByRsocial(value))
    );
  }


  onSearch() {
    let value = this.queryField.value;
    if(value && value.trim() !== ''){
      value = value.trim();
      this.filialdb$ = this.filialServ.findByRsocial(value);
    }
  }


  onEdit(filial: FilialInterface){
    this.router.navigate(['editFilial', filial.idFilial],{relativeTo: this.route});
  }

  onDelete(filial: FilialInterface){}

  onError(errorMSG: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMSG
    });
  }


}


