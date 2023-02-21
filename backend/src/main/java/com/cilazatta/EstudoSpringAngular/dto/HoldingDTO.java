package com.cilazatta.EstudoSpringAngular.dto;

import com.cilazatta.EstudoSpringAngular.entities.Holding;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HoldingDTO {
	
	private Long idHold;
	private String rSocial;
	private String dSocial;
	private String cnpj;
	private String municipio;
	private String uf;
	private User00DTO user00Dto;
	
	
	public HoldingDTO(Long idHold, String rSocial, String dSocial, String cnpj, String municipio, String uf,
			User00DTO user00) {
		this.idHold = idHold;
		this.rSocial = rSocial;
		this.dSocial = dSocial;
		this.cnpj = cnpj;
		this.municipio = municipio;
		this.uf = uf;
		this.user00Dto = user00;
	}

	public HoldingDTO(Holding hold) {
		
		this.idHold = hold.getIdHold();
		this.rSocial = hold.getRSocial();
		this.dSocial = hold.getDSocial();
		this.cnpj = hold.getCnpj();
		this.municipio = hold.getMunicipio();
		this.uf = hold.getUf();
		this.user00Dto = new User00DTO(hold.getUser00());
		
	}

	@Override
	public String toString() {
		return "HoldingDTO [idHold=" + idHold + ", rSocial=" + rSocial + ", dSocial=" + dSocial + ", cnpj=" + cnpj
				+ ", municipio=" + municipio + ", uf=" + uf + ", user00Dto=" + user00Dto + "]";
	}
	
	
}
