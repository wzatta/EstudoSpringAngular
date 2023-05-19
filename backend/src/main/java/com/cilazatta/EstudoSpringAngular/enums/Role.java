package com.cilazatta.EstudoSpringAngular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Role {
	
	USER(0,"Usuario"),
	ADMIN(1, "Administrador"),
	DEV(2,"Desenvolvimento");
	
	private int cod;
	private String desc;
	
	
}
