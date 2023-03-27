package com.cilazatta.EstudoSpringAngular.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
public class AlmoxPrincipal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long idAlmox;
	
	@Column(name = "titulo")
	private String titulo;

	@Column(name = "statusativo")
	private Boolean isAtivo;
	
	@Column(name = "datacriacao")
	private LocalDateTime dataCriacao;
	
	@OneToOne
	@JoinColumn(name = "id_filial", nullable = false, foreignKey = @ForeignKey(name="fk_idfilial" ))
	private Filial filial;

	public AlmoxPrincipal(Long idAlmox, String titulo, Boolean isAtivo, LocalDateTime dataCriacao, Filial filial) {
		this.idAlmox = idAlmox;
		this.titulo = titulo;
		this.isAtivo = isAtivo;
		this.dataCriacao = dataCriacao;
		this.filial = filial;
	}

	
	
}
