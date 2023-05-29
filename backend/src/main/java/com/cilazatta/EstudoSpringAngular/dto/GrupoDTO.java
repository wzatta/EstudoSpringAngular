package com.cilazatta.EstudoSpringAngular.dto;

import org.hibernate.validator.constraints.Length;

import com.cilazatta.EstudoSpringAngular.entities.produtos.Grupo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

	@NotNull(message = "{field.not.null}")
	@Positive(message = "{field.not.negative}")
	@Max(value = 99, message = "{codigo.grupo.min.max}")
	private Integer codigoGr;

	@NotNull(message = "{field.not.null}")
	@Length(min = 10, max = 50)
	private String descGr;

	public GrupoDTO(Grupo gr) {
		this.idGr = gr.getIdGr();
		this.codigoGr = gr.getCodigoGr();
		this.descGr = gr.getDescGr();
	}

}
