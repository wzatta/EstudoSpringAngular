package com.cilazatta.EstudoSpringAngular.entities.produtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import com.cilazatta.EstudoSpringAngular.dto.CertAprovDTO;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class CertAprov implements Convertible<CertAprovDTO>, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long idCa;
	
	@OneToMany(mappedBy = "certAprov")
	private Set<ProdutoMaster> produtos;
	
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

	public CertAprov(CertAprovDTO dto) {
		this.idCa = dto.getIdCadto();
		this.numeroCa = dto.getNumeroCadto();
		this.isValido = dto.getIsValidodto();
		this.validade = LocalDate.parse(dto.getValidadedto());
	}
	
	
	@Override
	public CertAprovDTO convert() {
		return new CertAprovDTO(this);
	}

	
}
