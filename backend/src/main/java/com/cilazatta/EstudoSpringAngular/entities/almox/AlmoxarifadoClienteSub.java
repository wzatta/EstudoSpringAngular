package com.cilazatta.EstudoSpringAngular.entities.almox;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.cilazatta.EstudoSpringAngular.dto.almox.AlmoxarifadoClienteSubDTO;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class AlmoxarifadoClienteSub extends WareHouse implements Convertible<AlmoxarifadoClienteSubDTO>{
	

	private static final long serialVersionUID = 1L;

	private Boolean isOnLine;
	
	@ManyToOne
	@JoinColumn(name = "id_almoxarifado",nullable = false, foreignKey = @ForeignKey(name="fk_AlmoxSubIdAlmox" ))
	private Almoxarifado almoxarifado;
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public AlmoxarifadoClienteSub(Long id, String title, Boolean isActive, LocalDate dataCriacao, Boolean isOnLine,
			Almoxarifado almoxarifado) {
		super(id, title, isActive, dataCriacao);
		this.isOnLine = isOnLine;
		this.almoxarifado = almoxarifado;
		
	}
	
	public AlmoxarifadoClienteSub(AlmoxarifadoClienteSubDTO dto) {
		super(dto.getIdSubdto(), dto.getTituloSubdto(), dto.getIsAtivodto(),LocalDate.parse(dto.getDataCriacaodto(),dtf));
		this.isOnLine = dto.getIsOnLine();
	}
	

	@Override
	public AlmoxarifadoClienteSubDTO convert() {
		return new AlmoxarifadoClienteSubDTO(this);
	}
	
}
