import { UsuarioInterface } from "../UsuarioInterface";
import { ColaboradorInterface } from "../colaboradorInterface";

export class Usuario implements UsuarioInterface {
  id!: string;
  name!: string;
  cpf!: string;
  user00Name!: string;
  password!: string;
  userAtivo!: string;
  userBloqueado!: string;
  role!: string;
  colabDto!: ColaboradorInterface;

  constructor(){

  }

}
