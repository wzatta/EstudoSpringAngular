package com.cilazatta.EstudoSpringAngular.entities.almox;

import java.time.LocalDate;

import com.cilazatta.EstudoSpringAngular.dto.almox.AlmoxarifadoClienteDTO;
import com.cilazatta.EstudoSpringAngular.entities.basic.Filial;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor 
@Entity
public class AlmoxarifadoCliente extends WareHouse implements Convertible<AlmoxarifadoClienteDTO> {

	private static final long serialVersionUID = 1L;
	
	private TipoAlmox tipo;
	
	@OneToOne
	@JoinColumn(name = "idfilial",unique = true ,nullable = false, foreignKey = @ForeignKey(name="fk_AlmoxCliIdFilial" ))
	private Filial filial;

	public AlmoxarifadoCliente(Long id, String titulo, Boolean isAtivo, LocalDate dataCriacao, TipoAlmox tipo, Filial filial) {
		super(id, titulo, isAtivo, dataCriacao);
		this.tipo = tipo;
		this.filial = filial;
	}
	
	public AlmoxarifadoCliente(AlmoxarifadoClienteDTO dto) {
		this.setId(dto.getIdAlmoxdto());
		this.setTitulo(dto.getTitulodto());
		this.setIsAtivo(dto.getIsAtivodto());
		this.setDataCriacao(LocalDate.parse(dto.getDataCriacaodto()));
		this.tipo = dto.getTipodto();
		this.filial = new Filial(dto.getFilialDto());
	}

	@Override
	public AlmoxarifadoClienteDTO convert() {
		return new AlmoxarifadoClienteDTO(this);
	}

}
