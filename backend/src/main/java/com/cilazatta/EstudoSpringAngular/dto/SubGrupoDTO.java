package com.cilazatta.EstudoSpringAngular.dto;

import org.hibernate.validator.constraints.Length;

import com.cilazatta.EstudoSpringAngular.entities.SubGrupo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SubGrupoDTO {

	private Long idSubGr;
	
	private GrupoDTO grupoDto;
	
	@NotNull(message = "{field.not.null}")
	@Positive(message = "{field.not.negative}")
	@Max(value = 99, message = "{codigo.grupo.min.max}")
	private Integer codigoSubGr;
	
	@NotNull(message = "{field.not.null}")
	@Length(min = 10, max = 50)
	private String descSubGr;

	public SubGrupoDTO(Long idSubGr, GrupoDTO grupoDto, @NotNull @Positive @Min(1) @Max(99) Integer codigoSubGr,
			@NotNull @Length(min = 10, max = 50) String descSubGr) {
		this.idSubGr = idSubGr;
		this.grupoDto = grupoDto;
		this.codigoSubGr = codigoSubGr;
		this.descSubGr = descSubGr;
	}
	
	public SubGrupoDTO(SubGrupo sbGr) {
		this.idSubGr = sbGr.getIdSubGr();
		this.codigoSubGr = sbGr.getCodigoSubGr();
		this.descSubGr = sbGr.getDescSubGr();
		this.grupoDto = new GrupoDTO(sbGr.getGrupo());
	}
	
	
	
	
}
