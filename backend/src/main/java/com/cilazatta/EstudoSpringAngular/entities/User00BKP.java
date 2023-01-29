/*
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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "user00")
public class User00BKP implements UserDetails, Serializable {

	
	   public interface CreateUser {
	    }

	    public interface UpdateUser {
	    }
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column(name="name", length = 50, nullable = false)
	private String name;
	
	@Column(name="cpf", length = 11, nullable=false)
	private String cpf;
	
	@Column(name="username", length = 30, unique = true, nullable = false)
    @NotNull(groups = CreateUser.class)
    @NotEmpty(groups = CreateUser.class)
    @Size(groups = CreateUser.class, min = 2, max = 30)
	private String userName;
	
	@Column(name="password", length = 200, nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull(groups = { CreateUser.class, UpdateUser.class })
    @NotEmpty(groups = { CreateUser.class, UpdateUser.class })
    @Size(groups = { CreateUser.class, UpdateUser.class }, min = 8, max = 200)
	private String password;
	
	@Column(name="ativo", nullable = false)
	private Boolean userAtivo;
	
	@Column(name="bloq", nullable = false)
	private Boolean userNaoBloqueado;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	//=========================================================
	
	public User00BKP(Long id, String name, String cpf,
			@NotNull(groups = CreateUser.class) @NotEmpty(groups = CreateUser.class) @Size(groups = CreateUser.class, min = 2, max = 30) String userName,
			@NotNull(groups = { CreateUser.class, UpdateUser.class }) @NotEmpty(groups = { CreateUser.class,
					UpdateUser.class }) @Size(groups = { CreateUser.class,
							UpdateUser.class }, min = 8, max = 200) String password,
			Boolean userAtivo, Boolean userNaoBloqueado, Role role) {
	
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.userName = userName;
		this.password = password;
		this.userAtivo = userAtivo;
		this.userNaoBloqueado = userNaoBloqueado;
		this.role = role;
	}

	public User00BKP(User00DTO userDto) {
		this.id = userDto.getId();
		this.name = userDto.getName();
		this.cpf = userDto.getCpf();
		this.userName = userDto.getUserName();
		this.password = userDto.getPassword();
		this.userAtivo = userDto.getUserAtivo();
		this.userNaoBloqueado = userDto.getUserNaoBloqueado();
		this.role = userDto.getRole();
	}

	//Implementação USERDETAILS =====================================
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public String getUsername() {
		return this.userName;
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
		return this.userNaoBloqueado;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.userAtivo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User00 [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", password=");
		builder.append(password);
		builder.append(", userAtivo=");
		builder.append(userAtivo);
		builder.append(", userNaoBloqueado=");
		builder.append(userNaoBloqueado);
		builder.append(", role=");
		builder.append(role);
		builder.append("]");
		return builder.toString();
	}

	


}
*/