package com.cilazatta.EstudoSpringAngular.dto;

import com.cilazatta.EstudoSpringAngular.entities.Filial;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FilialDTO {
	private Long idFilial;
	private String rSocial;
	private String dSocial;
	private String cnpj;
	private String municipio;
	private String uf;
	//@JsonProperty(access = Access.WRITE_ONLY)
	private HoldingDTO holdingDto;
	
	public FilialDTO(Long idFilial, String rSocial, String dSocial, String cnpj, String municipio, String uf,
			HoldingDTO holdingDto) {
		super();
		this.idFilial = idFilial;
		this.rSocial = rSocial;
		this.dSocial = dSocial;
		this.cnpj = cnpj;
		this.municipio = municipio;
		this.uf = uf;
		this.holdingDto = holdingDto;
		
	}
		
		public FilialDTO(Filial filial) {
			this.idFilial = filial.getIdFilial();
			this.rSocial = filial.getRSocial();
			this.dSocial = filial.getDSocial();
			this.cnpj = filial.getCnpj();
			this.municipio = filial.getMunicipio();
			this.uf = filial.getUf();
			this.holdingDto = new HoldingDTO(filial.getHolding());
			
			
		}

		@Override
		public String toString() {
			return "FilialDTO [idFilial=" + idFilial + ", rSocial=" + rSocial + ", dSocial=" + dSocial + ", cnpj="
					+ cnpj + ", municipio=" + municipio + ", uf=" + uf + ", holdingDto=" + holdingDto + "]";
		}

		
		
		
		
	}