import { HoldInterface } from './HoldInterface';
import { UsuarioInterface } from './UsuarioInterface';

export interface FilialInterface {
  idFilial: string,
	rsocial: string,
  dsocial: string,
	cnpj:    string,
	municipio: string,
	uf: string,
	holdingDto: HoldInterface,
	user00Dto: UsuarioInterface
}
