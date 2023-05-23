package com.cilazatta.EstudoSpringAngular.entities.recurso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.cilazatta.EstudoSpringAngular.dto.AlmoxarifadoSubDTO_v1a;
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
public class AlmoxarifadoSub_v1a extends WareHouse implements Convertible<AlmoxarifadoSubDTO_v1a>{
	

	private static final long serialVersionUID = 1L;

	private Boolean isOnLine;
	
	@ManyToOne
	@JoinColumn(name = "id_almoxarifado",nullable = false, foreignKey = @ForeignKey(name="fk_AlmoxSubIdAlmox" ))
	private Almoxarifado almoxarifado;
	
	@ManyToOne
	@JoinColumn(name = "id_filial",nullable = false, foreignKey = @ForeignKey(name="fk_AlmoxSubIdFilial" ))
	private Filial filial;
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public AlmoxarifadoSub_v1a(Long id, String title, Boolean isActive, LocalDate dataCriacao, Boolean isOnLine,
			Almoxarifado almoxarifado, Filial filial) {
		super(id, title, isActive, dataCriacao);
		this.isOnLine = isOnLine;
		this.almoxarifado = almoxarifado;
		this.filial = filial;
	}
	
	public AlmoxarifadoSub_v1a(AlmoxarifadoSubDTO_v1a dto) {
		super(dto.getIdSubdto(), dto.getTituloSubdto(), dto.getIsAtivodto(),LocalDate.parse(dto.getDataCriacaodto(),dtf));
		this.isOnLine = dto.getIsOnLine();
		this.filial = new Filial(dto.getFilialDto());
	}
	

	@Override
	public String toString() {
		return "AlmoxarifadoSub [isOnLine=" + isOnLine + ", Filial=" + filial + "]";
	}

	@Override
	public AlmoxarifadoSubDTO_v1a convert() {
		return new AlmoxarifadoSubDTO_v1a(this);
	}
	
}
