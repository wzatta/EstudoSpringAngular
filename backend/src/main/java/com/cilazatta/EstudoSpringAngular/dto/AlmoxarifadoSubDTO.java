package com.cilazatta.EstudoSpringAngular.dto;

import java.time.LocalDate;

import com.cilazatta.EstudoSpringAngular.entities.recurso.AlmoxarifadoSub;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlmoxarifadoSubDTO implements Convertible<AlmoxarifadoSub> {
	
	
	private Long idSubdto;
	private String tituloSubdto;
	private Boolean isAtivodto;
	private Boolean isOnLine;
	private String dataCriacaodto;
	private FilialDTO filialDto;
	
	public AlmoxarifadoSubDTO(Long idSubdto, String tituloSubdto, Boolean isAtivodto, Boolean isOnLine,
			String dataCriacaodto,  FilialDTO filialDto) {
		this.idSubdto = idSubdto;
		this.tituloSubdto = tituloSubdto;
		this.isAtivodto = isAtivodto;
		this.isOnLine = isOnLine;
		this.dataCriacaodto = dataCriacaodto;
		this.filialDto = filialDto;
	}

	
	public AlmoxarifadoSubDTO(AlmoxarifadoSub sub) {
		
		this.idSubdto = sub.getId();
		this.isAtivodto = sub.getIsActive();
		this.tituloSubdto = sub.getTitle();
		this.dataCriacaodto = sub.getDataCriacao().toString();
		this.isOnLine = sub.getIsOnLine();
		this.filialDto = new FilialDTO(sub.getFilial());
	}

	@Override
	public String toString() {
		return "AlmoxarifadoSubDTO [idSubdto=" + idSubdto + ", tituloSubdto=" + tituloSubdto + ", isAtivadto="
				+ isAtivodto + ", isOnLine=" + isOnLine + ", dataCriacaodto=" + dataCriacaodto + ", filialdto="
				+ filialDto + "]";
	}

	@Override
	public AlmoxarifadoSub convert() {
		return new AlmoxarifadoSub(this);
	}

	

}
