package com.cilazatta.EstudoSpringAngular.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cilazatta.EstudoSpringAngular.dto.User00DTO;
import com.cilazatta.EstudoSpringAngular.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "user00")
public class User00 implements UserDetails, Serializable {

	/**
	 * Definição do usuário de Implantação
	 */
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column(name="user00name", length = 30, unique = true, nullable = false)
	private String user00Name;
	
	@Column(name="password", length = 200, nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@Column(name="name", length = 50, nullable = false)
	private String name;
	
	@Column(name="cpf", length = 11, nullable=false)
	private String cpf;
	
	//==========================================
	
	
	@OneToOne(optional = false)
	@JoinColumn(name="idcolab", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name="fkcolabid"))
	private Colaborador colab;
	
	
	//===========================================

	
	@Column(name="ativo", nullable = false)
	private Boolean userAtivo;
	
	@Column(name="bloq", nullable = false)
	private Boolean userBloqueado;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	//=========================================================
	
	public User00(Long id, String user00Name, String password, String name, String cpf, Colaborador colab,
			Boolean userAtivo, Boolean userBloqueado, Role role) {
		this.id = id;
		this.user00Name = user00Name;
		this.password = password;
		this.name = name;
		this.cpf = cpf;
		this.colab = colab;
		this.userAtivo = userAtivo;
		this.userBloqueado = userBloqueado;
		this.role = role;
	}
	
	
	public User00(User00DTO userDto) {
		this.id = userDto.getId();
		this.user00Name = userDto.getUser00Name();
		this.password = userDto.getPassword();
		this.name = userDto.getName();
		this.cpf = userDto.getCpf();
		this.colab = new Colaborador(userDto.getColabDto());
		this.userAtivo = userDto.getUserAtivo();
		this.userBloqueado = userDto.getUserBloqueado();
		this.role = userDto.getRole();
	}

	//Implementação USERDETAILS =====================================

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public String getUsername() {
		return this.user00Name;
	}
	
	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.userBloqueado;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.userAtivo;
	}



}