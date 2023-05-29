package com.cilazatta.EstudoSpringAngular.entities.produtos;

import java.io.Serializable;

import com.cilazatta.EstudoSpringAngular.dto.ProdutoMasterDTO;
import com.cilazatta.EstudoSpringAngular.entities.basic.Holding;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class ProdutoMaster extends Produto implements Convertible<ProdutoMasterDTO>, Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "subgrupoid", foreignKey = @ForeignKey(name="fk_subgrupo_prod"))
	private SubGrupo subGrupo;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "certaprovid",  foreignKey = @ForeignKey(name="fk_certaprov_prod"))
	private CertAprov certAprov;
	
	@ManyToOne
	@JoinColumn(name = "hold_id", foreignKey = @ForeignKey(name="fk_hold_prod"))
	private Holding hold;
	
	public ProdutoMaster(String descProd, String modelo, String marca, String capacidade, Long id, SubGrupo subGrupo,
			CertAprov certAprov, Holding hold) {
		super(descProd, modelo, marca, capacidade);
		this.id = id;
		this.subGrupo = subGrupo;
		this.certAprov = certAprov;
		this.hold = hold;
	}

	public ProdutoMaster(String descProd, String modelo, String marca, String capacidade, Double qtde, Double vMedio,
			Double VTotal, Long id, SubGrupo subGrupo, CertAprov certAprov, Holding hold) {
		super(descProd, modelo, marca, capacidade, qtde, vMedio, VTotal);
		this.id = id;
		this.subGrupo = subGrupo;
		this.certAprov = certAprov;
		this.hold = hold;
	}
	
	public ProdutoMaster(ProdutoMasterDTO dto) {
		this.id = dto.getIddto();
		this.setDescProd(dto.getDescProddto());
		this.setModelo(dto.getModelodto());
		this.setMarca(dto.getMarcadto());
		this.setCapacidade(dto.getCapacidadedto());
		this.subGrupo = new SubGrupo(dto.getSubGrupodto());
		this.certAprov = new CertAprov(dto.getCertAprovdto());
		this.hold = new Holding(dto.getHolddto());
	}

	
	



	@Override
	public ProdutoMasterDTO convert() {
		return new ProdutoMasterDTO(this) ;
	}

	
}
