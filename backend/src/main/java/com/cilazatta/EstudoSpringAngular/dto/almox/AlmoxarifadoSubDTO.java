package com.cilazatta.EstudoSpringAngular.dto.almox;


import com.cilazatta.EstudoSpringAngular.dto.FilialDTO;
import com.cilazatta.EstudoSpringAngular.entities.almox.AlmoxarifadoSub;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AlmoxarifadoSubDTO implements Convertible<AlmoxarifadoSub> {
	
	
	private Long idSubdto;
	private String tituloSubdto;
	private Boolean isAtivodto;
	private Boolean isOnLine;
	private String dataCriacaodto;
	private AlmoxarifadoDTO almoxarifadodto;
	
	public AlmoxarifadoSubDTO(Long idSubdto, String tituloSubdto, Boolean isAtivodto, Boolean isOnLine,
			String dataCriacaodto, AlmoxarifadoDTO almoxarifadodto) {
		this.idSubdto = idSubdto;
		this.tituloSubdto = tituloSubdto;
		this.isAtivodto = isAtivodto;
		this.isOnLine = isOnLine;
		this.dataCriacaodto = dataCriacaodto;
		this.almoxarifadodto = almoxarifadodto;
	}

	
	public AlmoxarifadoSubDTO(AlmoxarifadoSub sub) {
		
		this.idSubdto = sub.getId();
		this.isAtivodto = sub.getIsAtivo();
		this.tituloSubdto = sub.getTitulo();
		this.dataCriacaodto = sub.getDataCriacao().toString();
		this.isOnLine = sub.getIsOnLine();
		this.almoxarifadodto = new AlmoxarifadoDTO(sub.getAlmoxarifado());
	}


	@Override
	public AlmoxarifadoSub convert() {
		return new AlmoxarifadoSub(this);
	}

	

}
