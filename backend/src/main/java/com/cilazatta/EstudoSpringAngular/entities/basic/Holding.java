package com.cilazatta.EstudoSpringAngular.entities.basic;

import java.io.Serializable;

import com.cilazatta.EstudoSpringAngular.dto.HoldingDTO;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Table(name = "holding")
public class Holding implements Serializable, Convertible<HoldingDTO> {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long idHold;
	
	@Column(name = "rsocial", length = 50, nullable = false)
	private String rSocial;

	@Column(name = "dsocial", length = 50, nullable = false)
	private String dSocial;
	
	@Column(name = "cnpj", length = 16, nullable = false, unique = true)
	private String cnpj;
	
	@Column(name = "municipio", length = 30, nullable = false)
	private String municipio;
	
	@Column(name = "uf", length = 2, nullable = false)
	private String uf;
	
	public Holding(Long idHold, String rSocial, String dSocial, String cnpj, String municipio, String uf
			) {
		super();
		this.idHold = idHold;
		this.rSocial = rSocial;
		this.dSocial = dSocial;
		this.cnpj = cnpj;
		this.municipio = municipio;
		this.uf = uf;
		
	}
	
	
	public Holding(HoldingDTO holdDto) {
		this.idHold = holdDto.getIdHold();
		this.rSocial = holdDto.getRSocial();
		this.dSocial = holdDto.getDSocial();
		this.cnpj = holdDto.getCnpj();
		this.municipio = holdDto.getMunicipio();
		this.uf = holdDto.getUf();
			
		
	}


	
	
	
	@Override
	public HoldingDTO convert() {
		return new HoldingDTO(this);
	}


	@Override
	public String toString() {
		return "Holding [idHold=" + idHold + ", rSocial=" + rSocial + ", dSocial=" + dSocial + ", cnpj=" + cnpj
				+ ", municipio=" + municipio + ", uf=" + uf + "]";
	}


	

	
}

