package com.cilazatta.EstudoSpringAngular.dto;

import com.cilazatta.EstudoSpringAngular.entities.Produto;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProdutoDTO implements Convertible<Produto> {

	private Long idProddto;
	private GrupoDTO grupodto;
	private String namedto;
	private String modeldto;
	private String marcadto;
	private CertAprovDTO certAprovdto;
	private String medidadto;

	public ProdutoDTO(Long idProddto, GrupoDTO grupodto, String namedto, String modeldto, String marcadto,
			CertAprovDTO certAprovdto, String medidadto) {
		super();
		this.idProddto = idProddto;
		this.grupodto = grupodto;
		this.namedto = namedto;
		this.modeldto = modeldto;
		this.marcadto = marcadto;
		this.certAprovdto = certAprovdto;
		this.medidadto = medidadto;
	}

	
	public ProdutoDTO(Produto product) {
		
		this.idProddto = product.getIdProd();
		this.certAprovdto = new CertAprovDTO(product.getCertAprov());
		this.grupodto = new GrupoDTO(product.getGrupo());
		this.marcadto = product.getMarca();
		this.modeldto = product.getModel();
		this.medidadto = product.getMedida();
		this.namedto = product.getName();
	}


	@Override
	public Produto convert() {
		return new Produto(this);
	}
	
	
}
