package com.cilazatta.EstudoSpringAngular.dto;

import java.io.Serializable;
import java.time.LocalDate;


import com.cilazatta.EstudoSpringAngular.entities.produtos.CertAprov;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CertAprovDTO implements Convertible<CertAprov>, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idCadto;
	private String numeroCadto;
	private String validadedto;
	private Boolean isValidodto = true;
	
	public CertAprovDTO(Long idCadto,String numeroCadto, LocalDate validadedto,
			Boolean isValidodto) {
		super();
		this.idCadto = idCadto;
		this.numeroCadto = numeroCadto;
		this.validadedto = validadedto.toString();
		this.isValidodto = isValidodto;
	}

	public CertAprovDTO(CertAprov ca) {
		this.idCadto = ca.getIdCa();
		this.numeroCadto = ca.getNumeroCa();
		this.validadedto = ca.getValidade().toString();
		this.isValidodto = ca.getIsValido();
	}

	@Override
	public CertAprov convert() {
		return new CertAprov(this);
	}
	
	
}
