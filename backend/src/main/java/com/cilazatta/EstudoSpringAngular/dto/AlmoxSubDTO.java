package com.cilazatta.EstudoSpringAngular.dto;

import java.time.LocalDateTime;

import com.cilazatta.EstudoSpringAngular.entities.AlmoxSub;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlmoxSubDTO implements Convertible<AlmoxSub> {

	private Long idSubdto;
	private String tituloSubdto;
	private Boolean isAtivadto;
	private Boolean isOnLine;
	private LocalDateTime dataCriacaodto;
	private AlmoxDTO almoxdto;
	
	public AlmoxSubDTO(Long idSubdto, String tituloSubdto, Boolean isAtivadto, Boolean isOnLine,
			LocalDateTime dataCriacaodto, AlmoxDTO almoxdto) {
		this.idSubdto = idSubdto;
		this.tituloSubdto = tituloSubdto;
		this.isAtivadto = isAtivadto;
		this.isOnLine = isOnLine;
		this.dataCriacaodto = dataCriacaodto;
		this.almoxdto = almoxdto;
	}
	
	public AlmoxSubDTO(AlmoxSub sub) {
		this.idSubdto = sub.getIdSub();
		this.tituloSubdto = sub.getTituloSub();
		this.isAtivadto = sub.getIsAtiva();
		this.isOnLine = sub.getIsOnLine();
		this.almoxdto = new AlmoxDTO(sub.getAlmox());
	}

	@Override
	public AlmoxSub convert() {
		return new AlmoxSub(this);
	}
	
	
}
