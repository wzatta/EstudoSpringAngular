package com.cilazatta.EstudoSpringAngular.entities;

import java.io.Serializable;

import com.cilazatta.EstudoSpringAngular.dto.User000DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class User000 implements Serializable {

	/**
	 * Definição do usuário de Implantação
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column(name="userName", length = 30, unique = true, nullable = false)
	private String userName;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name = "cpf", length = 11, nullable = false)
	private String cpf;
	
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@Column(name="status", nullable = false)
	private Boolean userAtivo;

	public User000(Long id, String userName, String password, String cpf, String name, Boolean userAtivo) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.cpf = cpf;
		this.name = name;
		this.userAtivo = userAtivo;
	}
	
	public User000(User000DTO userDto) {
		id = userDto.getId();
		userName = userDto.getUserName();
		password = userDto.getPassword();
		cpf = userDto.getCpf();
		name = userDto.getName();
		userAtivo = userDto.getUserAtivo();
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User000 [id=");
		builder.append(id);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", name=");
		builder.append(name);
		builder.append(", userAtivo=");
		builder.append(userAtivo);
		builder.append("]");
		return builder.toString();
	}
	


	
	
	
	
	
	
	
}
