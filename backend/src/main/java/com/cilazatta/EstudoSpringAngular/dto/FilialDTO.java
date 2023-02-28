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
	private HoldingDTO holdingDto;
	private User00DTO user00Dto;
	
	public FilialDTO(Long idFilial, String rSocial, String dSocial, String cnpj, String municipio, String uf,
			HoldingDTO holdingDto, User00DTO user00Dto) {
		super();
		this.idFilial = idFilial;
		this.rSocial = rSocial;
		this.dSocial = dSocial;
		this.cnpj = cnpj;
		this.municipio = municipio;
		this.uf = uf;
		this.holdingDto = holdingDto;
		this.user00Dto = user00Dto;
	}
		
		public FilialDTO(Filial filial) {
			this.idFilial = filial.getIdFilial();
			this.rSocial = filial.getRSocial();
			this.dSocial = filial.getDSocial();
			this.cnpj = filial.getCnpj();
			this.municipio = filial.getMunicipio();
			this.uf = filial.getUf();
			this.holdingDto = new HoldingDTO(filial.getHolding());
			this.user00Dto = new User00DTO(filial.getUser00());
			
		}
		
		
		
	}
	
	



	