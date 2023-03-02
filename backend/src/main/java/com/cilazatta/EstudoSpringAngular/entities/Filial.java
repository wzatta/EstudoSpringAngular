package com.cilazatta.EstudoSpringAngular.entities;

import java.io.Serializable;

import com.cilazatta.EstudoSpringAngular.dto.FilialDTO;

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
@Table(name = "filial")
public class Filial implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "idfilial")
	private Long idFilial;
	
	@Column(name = "rsocial", length = 50, nullable = false)
	private String rSocial;

	@Column(name = "dsocial", length = 50, nullable = false)
	private String dSocial;
	
	@Column(name = "cnpj", length = 16, nullable = false)
	private String cnpj;
	
	@Column(name = "municipio", length = 30, nullable = false)
	private String municipio;
	
	@Column(name = "uf", length = 2, nullable = false)
	private String uf;
	
	@ManyToOne
	@JoinColumn(name = "holding_id", nullable = false, foreignKey = @ForeignKey(name = "fk_idHolding"))
	private Holding holding;
	
	@ManyToOne
	@JoinColumn(name = "user00_id", nullable = false, foreignKey = @ForeignKey(name = "fk_Filial_idUser00"))
	private User00 user00;
	
	public Filial(FilialDTO filialDto) {
		this.idFilial = filialDto.getIdFilial();
		this.rSocial = filialDto.getRSocial();
		this.dSocial = filialDto.getDSocial();
		this.cnpj = filialDto.getCnpj();
		this.municipio = filialDto.getMunicipio();
		this.uf = filialDto.getUf();
		this.user00 = new User00(filialDto.getUser00Dto());
		this.holding = new Holding(filialDto.getHoldingDto());
	}

}