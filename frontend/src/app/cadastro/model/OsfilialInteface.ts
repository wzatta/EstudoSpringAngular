import { FilialInterface } from './filial-interface';
import { UsuarioInterface } from './UsuarioInterface';
export interface OsFilialInterface {
  idOs: string;
  codigoOs: string;
  descricaoOs: string;
  dataInicial: string;
  dataFinal: string;
  osIsAtiva: string;
  filialDto: FilialInterface;
  user00Dto: UsuarioInterface;
}
