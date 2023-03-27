import { HoldInterface } from './HoldInterface';

export interface FilialInterface {
  idFilial: string,
	rsocial: string,
  dsocial: string,
	cnpj:    string,
	municipio: string,
	uf: string,
	holdingDto: HoldInterface,
}
