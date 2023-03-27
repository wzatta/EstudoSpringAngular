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
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
public class SubAlmox implements Serializable{

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long idSub;
	
	@Column(name = "titulosub")
	private String tituloSub;

	@Column(name = "subisativa")
	private Boolean isAtiva;
	
	@Column(name = "subisonline")
	private Boolean isOnLine;
	
	@Column(name = "datacriacao")
	private LocalDateTime dataCriacao;
	
	@ManyToOne
	@JoinColumn(name="id_Almox", nullable = false, foreignKey = @ForeignKey(name="fk_idAlmox"))
	private AlmoxPrincipal almoxCentral;
}
