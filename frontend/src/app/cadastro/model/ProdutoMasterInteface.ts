import { CertAprovInterface } from "./CertAprovInterface";
import { HoldInterface } from "./HoldInterface";
import { SubGrupoInterface } from "./grupo/SubGrupoInterface";

export interface ProdutoMasterInteface {
  iddto : string;
	descProddto : string;
	modelodto : string;
	marcadto : string;
	capacidadedto : string;
	subGrupodto : SubGrupoInterface;
	certAprovdto : CertAprovInterface;
	holddto : HoldInterface;

	qtdedto : number;
	vMediodto : number;
	VTotaldto : number;
}
