package com.cilazatta.EstudoSpringAngular.dto.almox;

import com.cilazatta.EstudoSpringAngular.dto.FilialDTO;
import com.cilazatta.EstudoSpringAngular.entities.almox.AlmoxarifadoCliente;
import com.cilazatta.EstudoSpringAngular.entities.almox.TipoAlmox;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlmoxarifadoClienteDTO implements Convertible<AlmoxarifadoCliente> {
	
	private Long idAlmoxdto;
	private String titulodto;
	private Boolean isAtivodto;
	private String dataCriacaodto; 
	private TipoAlmox tipodto;
	private FilialDTO filialDto;
	
	public AlmoxarifadoClienteDTO(Long idAlmoxdto, String titulodto, Boolean isAtivodto, String dataCriacaodto,
			TipoAlmox tipodto, FilialDTO filialDto) {
		super();
		this.idAlmoxdto = idAlmoxdto;
		this.titulodto = titulodto;
		this.isAtivodto = isAtivodto;
		this.dataCriacaodto = dataCriacaodto;
		this.tipodto = tipodto;
		this.filialDto = filialDto;
	}

	public AlmoxarifadoClienteDTO(AlmoxarifadoCliente almox) {
		
		this.idAlmoxdto = almox.getId();
		this.titulodto = almox.getTitulo();
		this.isAtivodto =almox.getIsAtivo();
		this.dataCriacaodto = almox.getDataCriacao().toString();
		this.tipodto = almox.getTipo();
		this.filialDto = new FilialDTO(almox.getFilial()); 
	}

	@Override
	public AlmoxarifadoCliente convert() {
		return new AlmoxarifadoCliente(this);
	}
	
	

}
