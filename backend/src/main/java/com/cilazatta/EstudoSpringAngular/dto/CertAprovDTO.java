package com.cilazatta.EstudoSpringAngular.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.cilazatta.EstudoSpringAngular.entities.CertAprov;
import com.cilazatta.EstudoSpringAngular.entities.Produto;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CertAprovDTO implements Convertible<CertAprov>, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idCadto;
	private Produto produtodto;
	private String numeroCadto;
	private LocalDate validadedto;
	private Boolean isValidodto = true;
	
	public CertAprovDTO(Long idCadto, Produto produtodto, String numeroCadto, LocalDate validadedto,
			Boolean isValidodto) {
		super();
		this.idCadto = idCadto;
		this.produtodto = produtodto;
		this.numeroCadto = numeroCadto;
		this.validadedto = validadedto;
		this.isValidodto = isValidodto;
	}

	public CertAprovDTO(CertAprov ca) {

		this.idCadto = ca.getIdCa();
		this.produtodto = ca.getProduto();
		this.numeroCadto = ca.getNumeroCa();
		this.validadedto = ca.getValidade();
		this.isValidodto = ca.getIsValido();
	}

	@Override
	public CertAprov convert() {
		return new CertAprov(this);
	}
	
	
	
}
