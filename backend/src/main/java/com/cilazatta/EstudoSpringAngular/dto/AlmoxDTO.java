package com.cilazatta.EstudoSpringAngular.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.cilazatta.EstudoSpringAngular.entities.Almox;
import com.cilazatta.EstudoSpringAngular.entities.Filial;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlmoxDTO implements Convertible<Almox> {

	private Long idAlmoxdto;
	private String titulodto;
	private Boolean isAtivodto;
	private LocalDateTime dataCriacaodto;
	private FilialDTO filialdto;
	
	public AlmoxDTO(Long idAlmoxdto, String titulodto, Boolean isAtivodto, LocalDateTime dataCriacaodto, FilialDTO filialdto) {
		super();
		this.idAlmoxdto = idAlmoxdto;
		this.titulodto = titulodto;
		this.isAtivodto = isAtivodto;
		this.dataCriacaodto = dataCriacaodto;
		this.filialdto = filialdto;
	}
	
	
	public AlmoxDTO(Almox almox) {
		
		this.idAlmoxdto = almox.getIdAlmox();
		this.titulodto = almox.getTitulo();
		this.isAtivodto = almox.getIsAtivo();
		this.dataCriacaodto = almox.getDataCriacao();
		this.filialdto = new FilialDTO(almox.getFilial());
	}
	
	
	@Override
	public Almox convert() {
		return new Almox(this);
	}

	 
}
