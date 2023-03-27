import { ColaboradorInterface } from './colaboradorInterface';
export interface UsuarioInterface {
  id: string;
  name: string;
  cpf: string;
  user00Name: string;
  password: string;
  userAtivo: string;
  userBloqueado: string;
  role:string;
  colabDto: ColaboradorInterface;
}
