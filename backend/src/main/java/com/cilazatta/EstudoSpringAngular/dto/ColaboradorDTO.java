package com.cilazatta.EstudoSpringAngular.dto;

import java.time.LocalDate;

import com.cilazatta.EstudoSpringAngular.entities.Colaborador;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ColaboradorDTO {
	
	private Long id;
	private String matricula;
	private String cpf;
	private String name;
	private String funcao;
	private LocalDate dateAdm;
	private LocalDate dateDem;
	
	public ColaboradorDTO(Long id, String matricula, String cpf, String name, String funcao, LocalDate dateAdm,
			LocalDate dateDem) {
		this.id = id;
		this.matricula = matricula;
		this.cpf = cpf;
		this.name = name;
		this.funcao = funcao;
		this.dateAdm = dateAdm;
		this.dateDem = dateDem;
	}
	
	public ColaboradorDTO(Colaborador colab) {
	
		this.id = colab.getId();
		this.matricula = colab.getMatricula();
		this.name = colab.getName();
		this.cpf = colab.getCpf();
		this.funcao = colab.getFuncao();
		this.dateAdm = colab.getDateAdm();
		this.dateDem = colab.getDateDem();
		
	}
	
	
	
	
	
	
}
