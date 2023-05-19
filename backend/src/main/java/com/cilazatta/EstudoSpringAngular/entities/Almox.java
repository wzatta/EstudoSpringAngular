package com.cilazatta.EstudoSpringAngular.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.cilazatta.EstudoSpringAngular.dto.AlmoxDTO;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

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
public class Almox implements Serializable, Convertible<AlmoxDTO> {

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
	@JoinColumn(name = "id_filial",unique = true ,nullable = false, foreignKey = @ForeignKey(name="fk_idfilial" ))
	private Filial filial;

	public Almox(Long idAlmox, String titulo, Boolean isAtivo, LocalDateTime dataCriacao, Filial filial) {
		this.idAlmox = idAlmox;
		this.titulo = titulo;
		this.isAtivo = isAtivo;
		this.dataCriacao = dataCriacao;
		this.filial = filial;
	}

	public Almox(AlmoxDTO dto) {
		this.idAlmox = dto.getIdAlmoxdto();
		this.titulo = dto.getTitulodto();
		this.isAtivo = dto.getIsAtivodto();
		this.dataCriacao = dto.getDataCriacaodto();
		this.filial = new Filial(dto.getFilialDto());
	}

	@Override
	public AlmoxDTO convert() {
		return new AlmoxDTO(this);
	}
	
	
}
