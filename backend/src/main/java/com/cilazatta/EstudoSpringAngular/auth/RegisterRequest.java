package com.cilazatta.EstudoSpringAngular.auth;

import com.cilazatta.EstudoSpringAngular.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

	private String name;
	private String cpf;
	private String userName;
	private String password;
	private Boolean userAtivo;
	private Boolean userBloqueado;
	
	private Role role;

	
}
