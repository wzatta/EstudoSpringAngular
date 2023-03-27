package com.cilazatta.EstudoSpringAngular.dto;


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
	private String dateAdm;
	private String dateDem;
	private FilialDTO filialDto;
	
	public ColaboradorDTO(Long id, String matricula, String cpf, String name, String funcao, String dateAdm,
			String dateDem, FilialDTO filialDto) {
		this.id = id;
		this.matricula = matricula;
		this.cpf = cpf;
		this.name = name;
		this.funcao = funcao;
		this.dateAdm = dateAdm;
		this.dateDem = dateDem;
		this.filialDto = filialDto;
	}

/*	public ColaboradorDTO(Long id, String matricula, String cpf, String name, String funcao, String dateAdm,
			 FilialDTO filialDto) {
		this.id = id;
		this.matricula = matricula;
		this.cpf = cpf;
		this.name = name;
		this.funcao = funcao;
		this.dateAdm = dateAdm;
		this.filialDto = filialDto;
	}
	*/
	public ColaboradorDTO(Colaborador colab) {
		this.id = colab.getId();
		this.matricula = colab.getMatricula();
		this.name = colab.getName();
		this.cpf = colab.getCpf();
		this.funcao = colab.getFuncao();
		this.dateAdm = colab.getDateAdm().toString();
		if(colab.getDateDem()!=null) {
		this.dateDem = colab.getDateDem().toString();}
		this.filialDto = new FilialDTO(colab.getFilial());
		
	}
	
	
	
	
}
