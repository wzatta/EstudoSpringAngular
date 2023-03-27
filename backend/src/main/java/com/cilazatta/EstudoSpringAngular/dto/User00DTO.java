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
	private ColaboradorDTO colabDto;
	private String user00Name;
	private String password;
	private Boolean userAtivo;
	private Boolean userBloqueado;
	
	private Role role;
	
	public User00DTO(Long id, String name, String cpf, ColaboradorDTO colabDto, String user00Name, String password,
			Boolean userAtivo, Boolean userBloqueado, Role role) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.colabDto = colabDto;
		this.user00Name = user00Name;
		this.password = password;
		this.userAtivo = userAtivo;
		this.userBloqueado = userBloqueado;
		this.role = role;
	}
	
	

	public User00DTO(User00 user) {
		this.id = user.getId();
		this.name = user.getName();
		this.cpf = user.getCpf();
		this.colabDto = new ColaboradorDTO(user.getColab());
		this.user00Name = user.getUsername();
		this.password = "********";
		this.userAtivo = user.getUserAtivo();
		this.userBloqueado = user.getUserBloqueado();
		this.role = user.getRole();
	}

	@Override
	public String toString() {
		return "User00DTO [id=" + id + ", name=" + name + ", cpf=" + cpf + ", user00Name=" + user00Name + ", password="
				+ password + ", userAtivo=" + userAtivo + ", userBloqueado=" + userBloqueado + ", role=" + role + "]";
	}

	

	
}