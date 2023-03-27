package com.cilazatta.EstudoSpringAngular.entities;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.cilazatta.EstudoSpringAngular.dto.GrupoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
public class Grupo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long idGr;
	
	@NotNull
	@Positive
	@Max(value = 99)
	@Column(name = "codigogr", nullable = false)
	private Integer codigoGr;
	
	@NotNull
	@Length(min=10, max = 50)
	@Column(name= "descgr", length = 50, nullable = false)
	private String descGr;

	public Grupo(Long idGr, Integer codigoGr, String descGr) {
		this.idGr = idGr;
		this.codigoGr = codigoGr;
		this.descGr = descGr;
	}
	
	
	public Grupo(GrupoDTO grDto) {
		this.idGr = grDto.getIdGr();
		this.codigoGr = grDto.getCodigoGr();
		this.descGr = grDto.getDescGr();
	}




	
	
	
	
	
}
