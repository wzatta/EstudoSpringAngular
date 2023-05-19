import { AlmoxInterface } from '../almox/almox-interface';
import { FilialInterface } from '../filial-interface';
export class Almox implements AlmoxInterface {
  idAlmoxdto!: string;
  titulodto!: string;
  tipodto!: string;
  isAtivodto!: string;
  dataCriacaodto!: string;
  filialDto!: FilialInterface;

    constructor(){

    }


}
