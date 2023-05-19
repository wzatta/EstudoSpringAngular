import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { SubGrupoInterface } from '../../../model/grupo/SubGrupoInterface';
import { SubgrupoService } from '../../../services/grupo/subgrupo.service';
import { GrupoService } from '../../../services/grupo/grupo.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-subgrupo-list',
  templateUrl: './subgrupo-list.component.html',
  styleUrls: ['./subgrupo-list.component.scss']
})
export class SubgrupoListComponent implements OnInit {

  sbGrupodb$ : Observable<SubGrupoInterface[]> | null = null;
  readonly displayedColumns = ['grupoDtoA','grupoDtoB','codigoSbGr','descSbGr','actions'];

  constructor(
    private sbgrService: SubgrupoService,
    private grupoService: GrupoService,
    private router: Router,
    private route: ActivatedRoute
  ){

  }

  ngOnInit(): void {
    this.refresh();
  }


  refresh(){
    this.sbGrupodb$ = this.sbgrService.listAll();
   }


 onEdit(sbGrupo: SubGrupoInterface){
  this.router.navigate(['editSbGrupo',sbGrupo.idSubGr],{relativeTo: this.route});
 }

  onDelete(sbGrupo: SubGrupoInterface){


}

}
