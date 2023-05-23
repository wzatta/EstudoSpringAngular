package com.cilazatta.EstudoSpringAngular.dto;

import com.cilazatta.EstudoSpringAngular.entities.recurso.AlmoxarifadoSub;
import com.cilazatta.EstudoSpringAngular.entities.recurso.AlmoxarifadoSub_v1a;
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
	private AlmoxarifadoDTO almoxarifadodto;
	
	
	public AlmoxarifadoSubDTO(Long idSubdto, String tituloSubdto, Boolean isAtivodto, Boolean isOnLine,
			 AlmoxarifadoDTO almoxarifadodto) {
		this.idSubdto = idSubdto;
		this.tituloSubdto = tituloSubdto;
		this.isAtivodto = isAtivodto;
		this.isOnLine = isOnLine;
		this.almoxarifadodto = almoxarifadodto;
	}

	
	public AlmoxarifadoSubDTO(AlmoxarifadoSub sub) {
		this.idSubdto = sub.getId();
		this.isAtivodto = sub.getIsAtivo();
		this.tituloSubdto = sub.getTituloSub();
		this.isOnLine = sub.getIsOnLine();
		this.almoxarifadodto = new AlmoxarifadoDTO(sub.getAlmoxarifado());
	}

	@Override
	public String toString() {
		return "AlmoxarifadoSubDTO [idSubdto=" + idSubdto + ", tituloSubdto=" + tituloSubdto + ", isAtivodto="
				+ isAtivodto + ", isOnLine=" + isOnLine + ", almoxarifadodto=" + almoxarifadodto + "]";
	}

	@Override
	public AlmoxarifadoSub convert() {
		return new AlmoxarifadoSub(this);
	}




	

}
