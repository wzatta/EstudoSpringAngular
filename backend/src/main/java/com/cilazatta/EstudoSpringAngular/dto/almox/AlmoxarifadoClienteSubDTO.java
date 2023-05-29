package com.cilazatta.EstudoSpringAngular.dto.almox;

import com.cilazatta.EstudoSpringAngular.entities.almox.AlmoxarifadoClienteSub;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlmoxarifadoClienteSubDTO implements Convertible<AlmoxarifadoClienteSub> {
	
	private Long idSubdto;
	private String tituloSubdto;
	private Boolean isAtivodto;
	private Boolean isOnLine;
	private String dataCriacaodto;
	private AlmoxarifadoDTO almoxarifadodto;
	
	public AlmoxarifadoClienteSubDTO(Long idSubdto, String tituloSubdto, Boolean isAtivodto, Boolean isOnLine,
			String dataCriacaodto, AlmoxarifadoDTO almoxarifadodto) {
		this.idSubdto = idSubdto;
		this.tituloSubdto = tituloSubdto;
		this.isAtivodto = isAtivodto;
		this.isOnLine = isOnLine;
		this.dataCriacaodto = dataCriacaodto;
		this.almoxarifadodto = almoxarifadodto;
	}
	
	public AlmoxarifadoClienteSubDTO(AlmoxarifadoClienteSub sub) {
		
		this.idSubdto = sub.getId();
		this.isAtivodto = sub.getIsAtivo();
		this.tituloSubdto = sub.getTitulo();
		this.dataCriacaodto = sub.getDataCriacao().toString();
		this.isOnLine = sub.getIsOnLine();
		this.almoxarifadodto = new AlmoxarifadoDTO(sub.getAlmoxarifado());
	}

	@Override
	public AlmoxarifadoClienteSub convert() {
		return new AlmoxarifadoClienteSub(this);
	}

}
