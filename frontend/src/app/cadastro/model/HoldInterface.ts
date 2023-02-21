import { UsuarioInterface } from "./UsuarioInterface";

export interface HoldInterface {
  idHold: string;
  rsocial: string;
  dsocial: string;
  cnpj: string;
  municipio: string;
  uf: string;
  user00Dto: UsuarioInterface;
}
