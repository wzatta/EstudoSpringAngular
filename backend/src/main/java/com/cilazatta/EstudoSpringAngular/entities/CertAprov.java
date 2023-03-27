package com.cilazatta.EstudoSpringAngular.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class CertAprov implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long idCa;
	
	@OneToOne
	@JoinColumn(name = "id_prod")
	private Produto produto;
	
	@NotNull
	@Column(name = "numeroca", nullable = false, unique = true)
	private String numeroCa;
	
	@Future
	@Column(name = "validade", nullable = false)
	private LocalDate validade;
	
	@Column(name = "isvalido")
	private Boolean isValido = true;
	
	public CertAprov(Long idCa, String numeroCa, LocalDate validade) {
		this.idCa = idCa;
		this.numeroCa = numeroCa;
		this.validade = validade;
		if(validade.isBefore(LocalDate.now())) {
		this.isValido = false;}
	}

	
}
