package com.cilazatta.EstudoSpringAngular.dto;

import java.time.LocalDateTime;

import com.cilazatta.EstudoSpringAngular.entities.Almox;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlmoxDTO implements Convertible<Almox> {

	private Long idAlmoxdto;
	private String titulodto;
	private Boolean isAtivodto;
	private LocalDateTime dataCriacaodto;
	private FilialDTO filialDto;
	
	public AlmoxDTO(Long idAlmoxdto, String titulodto, Boolean isAtivodto, LocalDateTime dataCriacaodto, FilialDTO filialdto) {
		this.idAlmoxdto = idAlmoxdto;
		this.titulodto = titulodto;
		this.isAtivodto = isAtivodto;
		this.dataCriacaodto = dataCriacaodto;
		this.filialDto = filialdto;
	}
	
	
	public AlmoxDTO(Almox almox) {
		
		this.idAlmoxdto = almox.getIdAlmox();
		this.titulodto = almox.getTitulo();
		this.isAtivodto = almox.getIsAtivo();
		this.dataCriacaodto = almox.getDataCriacao();
		this.filialDto = new FilialDTO(almox.getFilial());
	}
	
	@Override
	public String toString() {
		return "AlmoxDTO [idAlmoxdto=" + idAlmoxdto + ", titulodto=" + titulodto + ", isAtivodto=" + isAtivodto
				+ ", dataCriacaodto=" + dataCriacaodto + ", filialdto=" + filialDto + "]";
	}
	
	
	@Override
	public Almox convert() {
		return new Almox(this);
	}

	 
}
