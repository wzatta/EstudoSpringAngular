package com.cilazatta.EstudoSpringAngular.dto;

import com.cilazatta.EstudoSpringAngular.entities.User00;
import com.cilazatta.EstudoSpringAngular.enums.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User00DTO {

	private Long id;
	private String name;
	private String cpf;
	private String userName;
	private String password;
	private Boolean userAtivo;
	private Boolean userNaoBloqueado;
	
	private Role role;
	
	public User00DTO(Long id, String name, String cpf, String userName, String password, Boolean userAtivo,Boolean userNaoBloqueado, Role role) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.userName = userName;
		this.password = password;
		this.userAtivo = userAtivo;
		this.userNaoBloqueado = userNaoBloqueado;
		this.role = role;
	}

	public User00DTO(User00 user) {
		id = user.getId();
		name = user.getName();
		cpf = user.getCpf();
		userName = user.getUserName();
		password = "********";
		userAtivo = user.getUserAtivo();
		userNaoBloqueado = user.getUserNaoBloqueado();
		role = user.getRole();
	}
	
}
