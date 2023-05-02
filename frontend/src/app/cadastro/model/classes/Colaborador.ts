import { ColaboradorInterface } from "../colaboradorInterface";
import { FilialInterface } from "../filial-interface";

export class Colaborador implements ColaboradorInterface {
  id!: string;
  matricula!: string;
  cpf!: string;
  name!: string;
  funcao!: string;
  dateAdm!: string;
  dateDem!: string;
  filialDto!: FilialInterface;

  constructor(){}


}
