package com.cilazatta.EstudoSpringAngular.entities.recurso;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.cilazatta.EstudoSpringAngular.dto.AlmoxarifadoSubDTO;
import com.cilazatta.EstudoSpringAngular.entities.Filial;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AlmoxarifadoSub extends WareHouse implements Convertible<AlmoxarifadoSubDTO>{
	

	private static final long serialVersionUID = 1L;

	private Boolean isOnLine;
	
	@ManyToOne
	@JoinColumn(name = "id_filial",nullable = false, foreignKey = @ForeignKey(name="fk_AlmoxSubIdFilial" ))
	private Filial filial;
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public AlmoxarifadoSub(Long id, String title, Boolean isActive, LocalDate dataCriacao, Boolean isOnLine,
			Filial filial) {
		super(id, title, isActive, dataCriacao);
		this.isOnLine = isOnLine;
		this.filial = filial;
	}
	
	public AlmoxarifadoSub(AlmoxarifadoSubDTO dto) {
		super(dto.getIdSubdto(), dto.getTituloSubdto(), dto.getIsAtivodto(),LocalDate.parse(dto.getDataCriacaodto(),dtf));
		this.isOnLine = dto.getIsOnLine();
		this.filial = new Filial(dto.getFilialDto());
	}
	

	@Override
	public String toString() {
		return "AlmoxarifadoSub [isOnLine=" + isOnLine + ", Filial=" + filial + "]";
	}

	@Override
	public AlmoxarifadoSubDTO convert() {
		return new AlmoxarifadoSubDTO(this);
	}
	
}
