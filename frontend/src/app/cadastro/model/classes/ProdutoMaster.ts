import { CertAprov } from '../CertAprovInterface';
import { HoldInterface } from '../HoldInterface';
import { ProdutoMasterInteface } from '../ProdutoMasterInteface';
import { SubGrupoInterface } from '../grupo/SubGrupoInterface';
export class ProdutoMaster implements ProdutoMasterInteface {
  iddto!: string;
  descProddto!: string;
  modelodto!: string;
  marcadto!: string;
  capacidadedto!: string;
  subGrupodto!: SubGrupoInterface;
  certAprovdto!: CertAprov;
  holddto!: HoldInterface;
  qtdedto!: number;
  vMediodto!: number;
  VTotaldto!: number;

}
