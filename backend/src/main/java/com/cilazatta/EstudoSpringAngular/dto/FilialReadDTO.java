package com.cilazatta.EstudoSpringAngular.dto;

import com.cilazatta.EstudoSpringAngular.entities.basic.Filial;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FilialReadDTO {
	private Long idFilial;
	private String rSocial;
	private String dSocial;
	private String cnpj;
	private String municipio;
	private String uf;
	@JsonProperty(access = Access.WRITE_ONLY)
	private HoldingDTO holdingDto;
	
	public FilialReadDTO(Long idFilial, String rSocial, String dSocial, String cnpj, String municipio, String uf,
			HoldingDTO holdingDto) {
		this.idFilial = idFilial;
		this.rSocial = rSocial;
		this.dSocial = dSocial;
		this.cnpj = cnpj;
		this.municipio = municipio;
		this.uf = uf;
		this.holdingDto = holdingDto;
	}
		
		public FilialReadDTO(Filial filial) {
			this.idFilial = filial.getIdFilial();
			this.rSocial = filial.getRSocial();
			this.dSocial = filial.getDSocial();
			this.cnpj = filial.getCnpj();
			this.municipio = filial.getMunicipio();
			this.uf = filial.getUf();
			this.holdingDto = new HoldingDTO(filial.getHolding());
			
			
		}
		
		
		
	}