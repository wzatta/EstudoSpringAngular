import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { HoldInterface } from '../../../model/HoldInterface';

@Component({
  selector: 'app-holdings-list',
  templateUrl: './holdings-list.component.html',
  styleUrls: ['./holdings-list.component.scss']
})
export class HoldingsListComponent implements OnInit {

 @Input() holdingdb: HoldInterface[] = [];
 @Output() add = new EventEmitter(false);
 @Output() editHold = new EventEmitter(false);
 @Output() delHold = new EventEmitter(false);

 readonly displayedColumns = ['idHold','rsocial', 'dsocial', 'cnpj', 'municipio', 'uf', 'actions' ];


  constructor(){}

  ngOnInit(): void {}

  onAdd(){
    this.add.emit(true);
 }

 onEdit(holding: HoldInterface){
  this.editHold.emit(holding);
  }

 onDelete(holding: HoldInterface){
    this.delHold.emit(holding);
 }

}
