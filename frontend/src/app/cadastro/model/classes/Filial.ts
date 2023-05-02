import { HoldInterface } from "../HoldInterface";
import { FilialInterface } from '../filial-interface';

export class Filial implements FilialInterface {
  idFilial!: string;
  rsocial!: string;
  dsocial!: string;
  cnpj!: string;
  municipio!: string;
  uf!: string;
  holdingDto!: HoldInterface;

  constructor(){

  }




}
