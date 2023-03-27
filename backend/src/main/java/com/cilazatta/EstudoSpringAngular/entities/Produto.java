package com.cilazatta.EstudoSpringAngular.entities;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long idProd;
	
	@ManyToOne
	private Grupo grupo;
	
	@NotNull
	@Length(min = 10, max = 100)
	@Column(name = "descricao", nullable = false, length = 100)
	private String descricao;
	
	@NotNull
	@Length(min = 10, max = 30)
	@Column(name = "modelo", nullable = false, length = 30)
	private String modelo;
	
	@NotNull
	@Length(min = 10, max = 30)
	@Column(name = "marca", nullable = false, length = 30)
	private String marca;
	
	public Produto(Long idProd, Grupo grupo, @NotNull @Length(min = 10, max = 100) String descricao,
			@NotNull @Length(min = 10, max = 30) String modelo, @NotNull @Length(min = 10, max = 30) String marca) {
		this.idProd = idProd;
		this.grupo = grupo;
		this.descricao = descricao;
		this.modelo = modelo;
		this.marca = marca;
	}

	
	
	

}
