package com.cilazatta.EstudoSpringAngular.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.cilazatta.EstudoSpringAngular.dto.OsFilialDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Table(name = "osfilial")
public class OsFilial implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name="idos")
	private Long idOs;
	
	@Column(name="codigoos", nullable = false, unique = true, length = 15)
	private String codigoOs;
	
	@Column(name="descricaoos", nullable = false, length = 50)
	private String descricaoOs;
	
	@Column(name="datainicial", nullable = false)
	private LocalDate dataInicial;
	
	@Column(name="datainfinal", nullable = true)
	private LocalDate dataFinal;
	
	@Column(name="osisativa")
	private Boolean osIsAtiva;
	
	@ManyToOne()
	@JoinColumn(name="osid", nullable = false, foreignKey = @ForeignKey(name="fkidos"))
	private Filial filial;
	
	@ManyToOne()
	@JoinColumn(name="user00id", nullable = false, foreignKey = @ForeignKey(name = "fkiduser00"))
	private User00 user;

	//==== Construtor com todos os campos
	public OsFilial(Long idOs, String codigoOs, String descricaoOs, LocalDate dataInicial, LocalDate dataFinal,
			Boolean osIsAtiva, Filial filial, User00 user) {
		this.idOs = idOs;
		this.codigoOs = codigoOs;
		this.descricaoOs = descricaoOs;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.osIsAtiva = osIsAtiva;
		this.filial = filial;
		this.user = user;
	}
	
	//======= Construtor de conversão DTO para Entidade;

	public OsFilial(OsFilialDTO osDto) {
		this.idOs = osDto.getIdOs();
		this.codigoOs = osDto.getCodigoOs();
		this.descricaoOs = osDto.getDescricaoOs();
		this.dataInicial = osDto.getDataInicial();
		this.dataFinal = osDto.getDataFinal();
		this.osIsAtiva = osDto.getOsIsAtiva();
		this.filial = new Filial(osDto.getFilialDto());
		this.user = new User00(osDto.getUser00Dto());
	}
	
	
	
	
}
