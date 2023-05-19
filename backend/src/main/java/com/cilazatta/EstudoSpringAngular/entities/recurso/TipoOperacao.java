package com.cilazatta.EstudoSpringAngular.entities.recurso;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class TipoOperacao implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long idTpOp;
	private TipoMovimento tipo;
	private String siglaOp;
	private String titulo;
	
	@Override
	public String toString() {
		return "TipoOperacao [idTpOp=" + idTpOp + ", tipo=" + tipo + ", siglaOp=" + siglaOp + ", titulo=" + titulo
				+ "]";
	}
	
	

}
