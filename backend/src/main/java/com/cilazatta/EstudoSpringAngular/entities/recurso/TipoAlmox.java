package com.cilazatta.EstudoSpringAngular.entities.recurso;

import lombok.Getter;

@Getter
public enum TipoAlmox {
	
	
	CLIENTE(0,"Cliente"),
	PROPRIO(1,"Proprio");
	
	private final int codtipo;
	private final String descTipo;

	private TipoAlmox(int codtipo, String descTipo) {
		this.codtipo = codtipo;
		this.descTipo = descTipo;
	}
	
}