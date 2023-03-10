package com.cilazatta.EstudoSpringAngular.dto;

import java.time.LocalDate;

import com.cilazatta.EstudoSpringAngular.entities.OsFilial;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OsFilialDTO {

	private Long idOs;
	private String codigoOs;
	private String descricaoOs;
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	private Boolean osIsAtiva;
	private FilialDTO filialDto;
	private User00DTO user00Dto;
	
	public OsFilialDTO(Long idOs, String codigoOs, String descricaoOs, LocalDate dataInicial, LocalDate dataFinal,
			Boolean osIsAtiva, FilialDTO filial, User00DTO user) {
		this.idOs = idOs;
		this.codigoOs = codigoOs;
		this.descricaoOs = descricaoOs;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.osIsAtiva = osIsAtiva;
		this.filialDto = filial;
		this.user00Dto = user;
	}
	
	public OsFilialDTO(OsFilial osfilial) {
		
		this.idOs = osfilial.getIdOs();
		this.codigoOs = osfilial.getCodigoOs();
		this.descricaoOs = osfilial.getDescricaoOs();
		this.dataInicial = osfilial.getDataInicial();
		this.dataFinal = osfilial.getDataFinal();
		this.osIsAtiva = osfilial.getOsIsAtiva();
		this.filialDto = new FilialDTO(osfilial.getFilial());
		this.user00Dto = new User00DTO(osfilial.getUser());
	}

	@Override
	public String toString() {
		return "OsFilialDTO [idOs=" + idOs + ", codigoOs=" + codigoOs + ", descricaoOs=" + descricaoOs
				+ ", dataInicial=" + dataInicial + ", dataFinal=" + dataFinal + ", osIsAtiva=" + osIsAtiva
				+ ", filialDto=" + filialDto + ", user00Dto=" + user00Dto + "]";
	} 
	
	
	
	
}
