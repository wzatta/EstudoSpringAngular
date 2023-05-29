package com.cilazatta.EstudoSpringAngular.entities.produtos;

import java.io.Serializable;


import com.cilazatta.EstudoSpringAngular.dto.GrupoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@Column(name = "codigogr", nullable = false, unique = true)
	private Integer codigoGr;
	
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
