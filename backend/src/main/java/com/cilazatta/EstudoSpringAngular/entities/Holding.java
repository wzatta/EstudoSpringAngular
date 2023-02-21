package com.cilazatta.EstudoSpringAngular.entities;

import java.io.Serializable;

import com.cilazatta.EstudoSpringAngular.dto.HoldingDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Table(name = "holding")
public class Holding implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long idHold;
	
	@Column(name = "rsocial", length = 50, nullable = false)
	private String rSocial;

	@Column(name = "dsocial", length = 50, nullable = false)
	private String dSocial;
	
	@Column(name = "cnpj", length = 16, nullable = false, unique = true)
	private String cnpj;
	
	@Column(name = "municipio", length = 30, nullable = false)
	private String municipio;
	
	@Column(name = "uf", length = 2, nullable = false)
	private String uf;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user00_id", nullable = false, foreignKey = @ForeignKey(name = "fk_idUser00"))
	private User00 user00;
	

	public Holding(Long idHold, String rSocial, String dSocial, String cnpj, String municipio, String uf,
			User00 user00) {
		super();
		this.idHold = idHold;
		this.rSocial = rSocial;
		this.dSocial = dSocial;
		this.cnpj = cnpj;
		this.municipio = municipio;
		this.uf = uf;
		this.user00 = user00;
	}
	
	
	public Holding(HoldingDTO holdDto) {
		this.idHold = holdDto.getIdHold();
		this.rSocial = holdDto.getRSocial();
		this.dSocial = holdDto.getDSocial();
		this.cnpj = holdDto.getCnpj();
		this.municipio = holdDto.getMunicipio();
		this.uf = holdDto.getUf();
			
		this.user00 = new User00(holdDto.getUser00Dto());
	}


}
