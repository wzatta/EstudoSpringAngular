package com.cilazatta.EstudoSpringAngular.dto;

import com.cilazatta.EstudoSpringAngular.entities.produtos.ProdutoMaster;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoMasterDTO implements Convertible<ProdutoMaster> {

	private Long iddto;
	private String descProddto;
	private String modelodto;
	private String marcadto;
	private String capacidadedto;
	private SubGrupoDTO subGrupodto;
	private CertAprovDTO certAprovdto;
	private HoldingDTO holddto;
	
	private Double qtdedto = 0d;
	private Double vMediodto = 0d;
	private Double VTotaldto = 0d;
	
	public ProdutoMasterDTO(Long iddto, String descProddto, String modelodto, String marcadto, String capacidadedto,
			SubGrupoDTO subGrupodto, CertAprovDTO certAprovdto, HoldingDTO holddto, Double qtdedto, Double vMediodto,
			Double vTotaldto) {
		this.iddto = iddto;
		this.descProddto = descProddto;
		this.modelodto = modelodto;
		this.marcadto = marcadto;
		this.capacidadedto = capacidadedto;
		this.subGrupodto = subGrupodto;
		this.certAprovdto = certAprovdto;
		this.holddto = holddto;
		this.qtdedto = qtdedto;
		this.vMediodto = vMediodto;
		VTotaldto = vTotaldto;
	}
	
	
	
	public ProdutoMasterDTO(ProdutoMaster pm) {
		this.iddto = pm.getId();
		this.descProddto = pm.getDescProd();
		this.modelodto = pm.getModelo();
		this.marcadto = pm.getMarca();
		this.capacidadedto = pm.getCapacidade();
		this.subGrupodto = new SubGrupoDTO(pm.getSubGrupo());
		this.certAprovdto =new CertAprovDTO(pm.getCertAprov());
		this.holddto = new HoldingDTO(pm.getHold());
		
		this.qtdedto = pm.getQtde();
		this.vMediodto = pm.getVMedio();
		this.VTotaldto= pm.getVTotal();
		
	}
	
	@Override
	public ProdutoMaster convert() {
		return new ProdutoMaster(this);
	}

	

	
}
