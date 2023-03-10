package com.cilazatta.EstudoSpringAngular.dto;

import java.time.LocalDate;

import com.cilazatta.EstudoSpringAngular.entities.OsFilial;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OsFilialDTOget {

	private Long idOs;
	private String codigoOs;
	private String descricaoOs;
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	private Boolean osIsAtiva;
	
	public OsFilialDTOget(Long idOs, String codigoOs, String descricaoOs, LocalDate dataInicial, LocalDate dataFinal,
			Boolean osIsAtiva) {
		this.idOs = idOs;
		this.codigoOs = codigoOs;
		this.descricaoOs = descricaoOs;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.osIsAtiva = osIsAtiva;
	}
	
	public OsFilialDTOget(OsFilial osfilial) {
		
		this.idOs = osfilial.getIdOs();
		this.codigoOs = osfilial.getCodigoOs();
		this.descricaoOs = osfilial.getDescricaoOs();
		this.dataInicial = osfilial.getDataInicial();
		this.dataFinal = osfilial.getDataFinal();
		this.osIsAtiva = osfilial.getOsIsAtiva();
	}

	@Override
	public String toString() {
		return "OsFilialDTOget [idOs=" + idOs + ", codigoOs=" + codigoOs + ", descricaoOs=" + descricaoOs
				+ ", dataInicial=" + dataInicial + ", dataFinal=" + dataFinal + ", osIsAtiva=" + osIsAtiva + "]";
	}

	
}
