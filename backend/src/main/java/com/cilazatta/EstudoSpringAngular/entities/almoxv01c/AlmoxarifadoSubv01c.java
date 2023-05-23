package com.cilazatta.EstudoSpringAngular.entities.almoxv01c;

import java.io.Serializable;

import com.cilazatta.EstudoSpringAngular.dto.AlmoxarifadoSubDTO;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "almoxarifadosub")
public class AlmoxarifadoSubv01c implements Serializable, Convertible<AlmoxarifadoSubDTO>{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	private String tituloSub;
	
	private Boolean isOnLine;
	
	private Boolean isAtivo;
	
	@ManyToOne
	@JoinColumn(name = "id_almox_v1b",nullable = false, foreignKey = @ForeignKey(name="fk_AlmoxSubIdAlmoxv1b" ))
	private Almoxarifadov01c almoxarifado;
	
	public AlmoxarifadoSubv01c(AlmoxarifadoSubDTO dto) {
		this.id = dto.getIdSubdto();
		this.tituloSub = dto.getTituloSubdto();
		this.isAtivo = dto.getIsAtivodto();
		this.isOnLine = dto.getIsOnLine();
		this.almoxarifado = new Almoxarifadov01c(dto.getAlmoxarifadodto());
	}
	
	
	@Override
	public String toString() {
		return "AlmoxarifadoSub [id=" + id + ", tituloSub=" + tituloSub + ", isOnLine=" + isOnLine + ", isAtivo="
				+ isAtivo + ", almoxarifado=" + almoxarifado + "]";
	}


	@Override
	public AlmoxarifadoSubDTO convert() {
		return new AlmoxarifadoSubDTO(this);
	}

	
}
