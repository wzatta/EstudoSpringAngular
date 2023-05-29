package com.cilazatta.EstudoSpringAngular.entities.almox;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.cilazatta.EstudoSpringAngular.dto.almox.AlmoxarifadoSubDTO;
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
public class AlmoxarifadoSub extends WareHouse implements Convertible<AlmoxarifadoSubDTO>{
	

	private static final long serialVersionUID = 1L;

	private Boolean isOnLine;
	
	@ManyToOne
	@JoinColumn(name = "idalmoxarifadox")
	private Almoxarifado almoxarifado;
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public AlmoxarifadoSub(Long id, String title, Boolean isActive, LocalDate dataCriacao, Boolean isOnLine,
			Almoxarifado almoxarifado) {
		super(id, title, isActive, dataCriacao);
		this.isOnLine = isOnLine;
		this.almoxarifado = almoxarifado;
		
	}
	
	public AlmoxarifadoSub(AlmoxarifadoSubDTO dto) {
		//super(dto.getIdSubdto(), dto.getTituloSubdto(), dto.getIsAtivodto(),LocalDate.parse(dto.getDataCriacaodto(),dtf));
		this.setId(dto.getIdSubdto());
		this.setTitulo(dto.getTituloSubdto());
	    this.setIsAtivo(dto.getIsAtivodto());
	    this.setDataCriacao(LocalDate.parse(dto.getDataCriacaodto(),dtf));
		this.isOnLine = dto.getIsOnLine();
		this.almoxarifado = new Almoxarifado(dto.getAlmoxarifadodto());
	}
	

	@Override
	public AlmoxarifadoSubDTO convert() {
		return new AlmoxarifadoSubDTO(this);
	}
	
}
