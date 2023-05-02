package com.cilazatta.EstudoSpringAngular.entities;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.cilazatta.EstudoSpringAngular.dto.ProdutoDTO;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produto implements Convertible<ProdutoDTO>, Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long idProd;
	
	@ManyToOne
	private Grupo grupo;
	
	@NotNull
	@Length(min = 10, max = 100)
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@NotNull
	@Length(min = 10, max = 30)
	@Column(name = "model", nullable = false, length = 30)
	private String model;
	
	@NotNull
	@Length(min = 10, max = 30)
	@Column(name = "marca", nullable = false, length = 30)
	private String marca;
	
	@ManyToOne
	private CertAprov certAprov;
	
	@Column(name = "medida")
	private String medida;

	public Produto(ProdutoDTO dto) {
		this.idProd = dto.getIdProddto();
		this.name = dto.getNamedto();
		this.marca = dto.getMarcadto();
		this.model = dto.getModeldto();
		this.medida = dto.getMedidadto();
		this.certAprov = new CertAprov(dto.getCertAprovdto());
		this.grupo = new Grupo(dto.getGrupodto());
	}
	
	@Override
	public ProdutoDTO convert() {
		return new ProdutoDTO(this);
	}

}
