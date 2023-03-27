import { FilialInterface } from './filial-interface';
export interface ColaboradorInterface {
  id: string;
	matricula: string;
	cpf: string;
	name: string;
	funcao: string;
	dateAdm: string;
	dateDem: string;
	filialDto: FilialInterface;
}
