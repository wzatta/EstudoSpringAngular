package com.cilazatta.EstudoSpringAngular.entities.produtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.cilazatta.EstudoSpringAngular.dto.SubGrupoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Table(name = "subgrupo", uniqueConstraints = { @UniqueConstraint( name = "uniqueGrupoeSub" , columnNames = {"idgrupo","codigoSubGr"})})
public class SubGrupo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "idsubgr")
	private Long idSubGr;
	
	@ManyToOne
	@JoinColumn(name = "idgrupo", nullable = false, foreignKey = @ForeignKey(name="fk_idgrupo"))
	private Grupo grupo;
	
	@NotNull
	@Positive
	@Max(value = 99)
	@Column(name = "codigosubgr", nullable = false)
	private Integer codigoSubGr;
	
	@NotNull
	@Length(min = 10, max = 50)
	@Column(name= "descsubgr", length = 50, nullable = false)
	private String descSubGr;

	public SubGrupo(Long idSubGr, Grupo grupo, @NotNull @Positive @Max(99) Integer codigoSubGr,
			@NotNull @Length(min = 10, max = 50) String descSubGr) {
		super();
		this.idSubGr = idSubGr;
		this.grupo = grupo;
		this.codigoSubGr = codigoSubGr;
		this.descSubGr = descSubGr;
	}
	
	public SubGrupo(SubGrupoDTO sbGrDto) {
		this.idSubGr = sbGrDto.getIdSubGr();
		this.codigoSubGr = sbGrDto.getCodigoSubGr();
		this.descSubGr = sbGrDto.getDescSubGr();
		this.grupo = new Grupo(sbGrDto.getGrupoDto());
	}
	
	
	
}
