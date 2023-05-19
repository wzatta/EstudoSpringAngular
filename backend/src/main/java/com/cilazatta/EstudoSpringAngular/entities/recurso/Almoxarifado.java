package com.cilazatta.EstudoSpringAngular.entities.recurso;

import java.time.LocalDate;

import com.cilazatta.EstudoSpringAngular.dto.AlmoxarifadoDTO;
import com.cilazatta.EstudoSpringAngular.entities.Filial;
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
public class Almoxarifado extends WareHouse implements Convertible<AlmoxarifadoDTO> {

	private static final long serialVersionUID = 1L;
	
	private TipoAlmox tipo;
	
	@OneToOne
	@JoinColumn(name = "id_filial",unique = true ,nullable = false, foreignKey = @ForeignKey(name="fk_AlmoxIdFilial" ))
	private Filial filial;
	
	public Almoxarifado(Long id, String title, Boolean isActive, LocalDate dataCriacao, TipoAlmox tipo, Filial filial) {
		super(id, title, isActive, dataCriacao);
		this.tipo = tipo;
		this.filial = filial;
	}
	
	public Almoxarifado(AlmoxarifadoDTO dto) {
		super(dto.getIdAlmoxdto(), dto.getTitulodto(), dto.getIsAtivodto(), LocalDate.parse(dto.getDataCriacaodto()));
		this.tipo = dto.getTipodto();
		this.filial = new Filial(dto.getFilialDto());
	}

	@Override
	public String toString() {
		return "Almoxarifado [tipo=" + tipo + ", filial=" + filial + "]";
	}

	@Override
	public AlmoxarifadoDTO convert() {
		return new AlmoxarifadoDTO(this);
	}

	


}
