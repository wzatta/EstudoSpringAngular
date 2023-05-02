package com.cilazatta.EstudoSpringAngular.dto;

import com.cilazatta.EstudoSpringAngular.entities.Holding;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HoldingDTO implements Convertible<Holding>{
	
	private Long idHold;
	private String rSocial;
	private String dSocial;
	private String cnpj;
	private String municipio;
	private String uf;
	
	
	public HoldingDTO(Long idHold, String rSocial, String dSocial, String cnpj, String municipio, String uf) {
		this.idHold = idHold;
		this.rSocial = rSocial;
		this.dSocial = dSocial;
		this.cnpj = cnpj;
		this.municipio = municipio;
		this.uf = uf;
	}

	public HoldingDTO(Holding hold) {
		
		this.idHold = hold.getIdHold();
		this.rSocial = hold.getRSocial();
		this.dSocial = hold.getDSocial();
		this.cnpj = hold.getCnpj();
		this.municipio = hold.getMunicipio();
		this.uf = hold.getUf();
		
	}

	@Override
	public String toString() {
		return "HoldingDTO [idHold=" + idHold + ", rSocial=" + rSocial + ", dSocial=" + dSocial + ", cnpj=" + cnpj
				+ ", municipio=" + municipio + ", uf=" + uf + "]";
	}

	@Override
	public Holding convert() {
		
		return new Holding(this);
	}

	
	
	
}
