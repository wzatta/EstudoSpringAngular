import { FilialInterface } from "../filial-interface";
import { AlmoxInterface } from "./almox-interface";

export interface Almoxsubinterface {
  idSubdto : string;
	tituloSubdto: string;
	isAtivodto : string;
	isOnLine : string;
	dataCriacaodto : string;
  filialDto: FilialInterface;

}
