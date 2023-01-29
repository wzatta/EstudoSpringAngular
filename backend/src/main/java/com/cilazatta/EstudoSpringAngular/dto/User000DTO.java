package com.cilazatta.EstudoSpringAngular.dto;

import com.cilazatta.EstudoSpringAngular.entities.User000;
import com.cilazatta.EstudoSpringAngular.enums.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class User000DTO {

	private Long id;
	private String userName;
	private String password;
	private String cpf;
	private String name;
	private Boolean userAtivo;

	public User000DTO(Long id, String userName, String passWord, String cpf, String name, Boolean userAtivo) {
		this.id = id;
		this.userName = userName;
		this.password = passWord;
		this.cpf = cpf;
		this.name = name;
		this.userAtivo = userAtivo;
	}

	public User000DTO(User000 user) {
		id = user.getId();
		userName = user.getUserName();
		cpf = user.getCpf();
		name = user.getName();
		userAtivo = user.getUserAtivo();
	}

	
	
}
