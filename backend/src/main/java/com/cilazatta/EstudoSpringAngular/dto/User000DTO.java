package com.cilazatta.EstudoSpringAngular.dto;

import com.cilazatta.EstudoSpringAngular.entities.User000;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPassWord(String passWord) {
		this.password = passWord;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getUserAtivo() {
		return userAtivo;
	}

	public void setUserAtivo(Boolean userAtivo) {
		this.userAtivo = userAtivo;
	}
	
	
}
