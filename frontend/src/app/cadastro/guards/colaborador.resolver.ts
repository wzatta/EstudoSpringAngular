import { Injectable } from '@angular/core';
import {
  Router, Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable, of } from 'rxjs';
import { ColaboradorInterface } from '../model/colaboradorInterface';
import { ColaboradorService } from '../services/colaborador.service';
import { FilialInterface } from '../model/filial-interface';

@Injectable({
  providedIn: 'root'
})
export class ColaboradorResolver implements Resolve<ColaboradorInterface> {


  constructor(
    private colabService: ColaboradorService
  ){}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ColaboradorInterface> {

    let filial: FilialInterface | any = {};

    if(route.params && route.params['id']){
      return this.colabService.findById(route.params['id']);
    }
    return of({id:'', matricula:'', cpf: '', name: '', funcao: '', dateAdm:'', dateDem:'', filialDto: filial });
  }
}
