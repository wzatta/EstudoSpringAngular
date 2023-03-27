package com.cilazatta.EstudoSpringAngular.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
public class Fornecedor implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long idFor;
	
	@Column(name = "cnpjfor", unique = true)
	private String cnpjFor;
	
	@Column(name = "rsocialfor")
	private String rsocialFor;

	@Column(name = "dsocialfor")
	private String dsocialFor;
	
	@Column(name = "municipiofor")
	private String municipioFor;
	
	@Column(name = "uffor")
	private String ufFor;
	
	@ManyToOne
	@JoinColumn(name = "hold_id", nullable = false, foreignKey = @ForeignKey(name = "fk_idHold"))
	private Holding hold;

	public Fornecedor(Long idFor, String cnpjFor, String rsocialFor, String dsocialFor, String municipioFor,
			String ufFor, Holding hold) {
		this.idFor = idFor;
		this.cnpjFor = cnpjFor;
		this.rsocialFor = rsocialFor;
		this.dsocialFor = dsocialFor;
		this.municipioFor = municipioFor;
		this.ufFor = ufFor;
		this.hold = hold;
	}
	
	
	
	

}
