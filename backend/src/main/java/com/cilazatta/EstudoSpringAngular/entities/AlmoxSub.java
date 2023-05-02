package com.cilazatta.EstudoSpringAngular.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.cilazatta.EstudoSpringAngular.dto.AlmoxSubDTO;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

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
public class AlmoxSub implements Convertible<AlmoxSubDTO>, Serializable{

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
	@JoinColumn(name="fk_sub_almox", nullable = false, foreignKey = @ForeignKey(name="pk_idAlmox"))
	private Almox almox;

	public AlmoxSub(Long idSub, String tituloSub, Boolean isAtiva, Boolean isOnLine, LocalDateTime dataCriacao,
			Almox almox) {
		this.idSub = idSub;
		this.tituloSub = tituloSub;
		this.isAtiva = isAtiva;
		this.isOnLine = isOnLine;
		this.dataCriacao = dataCriacao;
		this.almox = almox;
	}

	public AlmoxSub(AlmoxSubDTO dto) {
		
		this.idSub = dto.getIdSubdto();
		this.tituloSub = dto.getTituloSubdto();
		this.isAtiva = dto.getIsAtivadto();
		this.isOnLine = dto.getIsOnLine();
		this.dataCriacao = dto.getDataCriacaodto();
		this.almox = new Almox(dto.getAlmoxdto());
		
	}

	@Override
	public AlmoxSubDTO convert() {
		return new AlmoxSubDTO(this);
	}
	
	
	
}
