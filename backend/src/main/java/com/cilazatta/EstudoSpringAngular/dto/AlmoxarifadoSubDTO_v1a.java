package com.cilazatta.EstudoSpringAngular.dto;

import java.time.LocalDate;

import com.cilazatta.EstudoSpringAngular.entities.recurso.AlmoxarifadoSub_v1a;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlmoxarifadoSubDTO_v1a implements Convertible<AlmoxarifadoSub_v1a> {
	
	
	private Long idSubdto;
	private String tituloSubdto;
	private Boolean isAtivodto;
	private Boolean isOnLine;
	private String dataCriacaodto;
	private AlmoxarifadoDTO almoxarifadodto;
	private FilialDTO filialDto;
	
	public AlmoxarifadoSubDTO_v1a(Long idSubdto, String tituloSubdto, Boolean isAtivodto, Boolean isOnLine,
			String dataCriacaodto, AlmoxarifadoDTO almoxarifadodto,  FilialDTO filialDto) {
		this.idSubdto = idSubdto;
		this.tituloSubdto = tituloSubdto;
		this.isAtivodto = isAtivodto;
		this.isOnLine = isOnLine;
		this.dataCriacaodto = dataCriacaodto;
		this.almoxarifadodto = almoxarifadodto;
		this.filialDto = filialDto;
	}

	
	public AlmoxarifadoSubDTO_v1a(AlmoxarifadoSub_v1a sub) {
		
		this.idSubdto = sub.getId();
		this.isAtivodto = sub.getIsActive();
		this.tituloSubdto = sub.getTitle();
		this.dataCriacaodto = sub.getDataCriacao().toString();
		this.isOnLine = sub.getIsOnLine();
		this.almoxarifadodto = new AlmoxarifadoDTO(sub.getAlmoxarifado());
		this.filialDto = new FilialDTO(sub.getFilial());
	}

	@Override
	public String toString() {
		return "AlmoxarifadoSubDTO [idSubdto=" + idSubdto + ", tituloSubdto=" + tituloSubdto + ", isAtivadto="
				+ isAtivodto + ", isOnLine=" + isOnLine + ", dataCriacaodto=" + dataCriacaodto + ", filialdto="
				+ filialDto + "]";
	}

	@Override
	public AlmoxarifadoSub_v1a convert() {
		return new AlmoxarifadoSub_v1a(this);
	}

	

}
