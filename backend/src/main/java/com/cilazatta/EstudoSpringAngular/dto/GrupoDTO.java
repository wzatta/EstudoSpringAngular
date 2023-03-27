package com.cilazatta.EstudoSpringAngular.dto;

import com.cilazatta.EstudoSpringAngular.entities.Grupo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GrupoDTO {
	
	private Long idGr;
	private Integer codigoGr;
	private String descGr;
	
	public GrupoDTO(Grupo gr) {
		this.idGr = gr.getIdGr();
		this.codigoGr = gr.getCodigoGr();
		this.descGr = gr.getDescGr();
	}

}
