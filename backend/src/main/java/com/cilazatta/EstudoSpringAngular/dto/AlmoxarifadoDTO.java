package com.cilazatta.EstudoSpringAngular.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.cilazatta.EstudoSpringAngular.entities.recurso.Almoxarifado;
import com.cilazatta.EstudoSpringAngular.entities.recurso.TipoAlmox;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AlmoxarifadoDTO implements Convertible<Almoxarifado> {

	private Long idAlmoxdto;
	private String titulodto;
	private Boolean isAtivodto;
	private String dataCriacaodto; 
	private TipoAlmox tipodto;
	private FilialDTO filialDto;
	
	
	
	public AlmoxarifadoDTO(Almoxarifado almox) {
		this.idAlmoxdto = almox.getId();
		this.titulodto = almox.getTitle();
		this.isAtivodto = almox.getIsActive();
		this.dataCriacaodto = almox.getDataCriacao().toString();
		this.tipodto = almox.getTipo();
		this.filialDto = new FilialDTO(almox.getFilial());
	}


	@Override
	public Almoxarifado convert() {
		return new Almoxarifado(this);
	}


	public AlmoxarifadoDTO(Long idAlmoxdto, String titulodto, Boolean isAtivodto, String dataCriacaodto,
			TipoAlmox tipodto, FilialDTO filialDto) {
		super();
		this.idAlmoxdto = idAlmoxdto;
		this.titulodto = titulodto;
		this.isAtivodto = isAtivodto;
		this.dataCriacaodto = dataCriacaodto;
		this.tipodto = tipodto;
		this.filialDto = filialDto;
	}
	
	
	
}
