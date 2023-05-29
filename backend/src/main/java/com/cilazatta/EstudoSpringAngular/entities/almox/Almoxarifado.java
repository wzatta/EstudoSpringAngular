package com.cilazatta.EstudoSpringAngular.entities.almox;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.cilazatta.EstudoSpringAngular.dto.almox.AlmoxarifadoDTO;
import com.cilazatta.EstudoSpringAngular.entities.basic.Filial;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
public class Almoxarifado extends WareHouse implements Convertible<AlmoxarifadoDTO> {

	private static final long serialVersionUID = 1L;
	
	private TipoAlmox tipo;
	
	@OneToOne
	@JoinColumn(name = "id_filial",unique = true ,nullable = false, foreignKey = @ForeignKey(name="fk_AlmoxIdFilial" ))
	private Filial filial;
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Almoxarifado(Long id, String titulo, Boolean isAtivo, LocalDate dataCriacao, TipoAlmox tipo, Filial filial) {
		super(id, titulo, isAtivo, dataCriacao);
		this.tipo = tipo;
		this.filial = filial;
	}
	
	public Almoxarifado(AlmoxarifadoDTO dto) {
		this.setId(dto.getIdAlmoxdto());
		this.setTitulo(dto.getTitulodto());
		this.setIsAtivo(dto.getIsAtivodto());
		if(dto.getIdAlmoxdto()==null) {
		this.setDataCriacao(LocalDate.parse(dto.getDataCriacaodto(),dtf));
		} else {
		this.setDataCriacao(LocalDate.parse(dto.getDataCriacaodto()));	
		}
		this.tipo = dto.getTipodto();
		this.filial = new Filial(dto.getFilialDto());
	}

	@Override
	public AlmoxarifadoDTO convert() {
		return new AlmoxarifadoDTO(this);
	}

}
