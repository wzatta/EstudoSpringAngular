package com.cilazatta.EstudoSpringAngular.entities.produtos;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Produto {

	private String descProd;
	private String modelo;
	private String marca;
	private String capacidade;

	private Double qtde = 0d;
	private Double vMedio = 0d;
	private Double VTotal = 0d;

	public Produto(String descProd, String modelo, String marca, String capacidade) {
		super();
		this.descProd = descProd;
		this.modelo = modelo;
		this.marca = marca;
		this.capacidade = capacidade;
	}

}
