package com.cilazatta.EstudoSpringAngular.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "colborador")
public class Colaborador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column(name = "matricula",length = 20,nullable = false, unique = true)
	private String matricula;

	@Column(name = "cpf",length = 11, nullable = false)
	private String cpf;
	
	@Column(name = "name",length = 50, nullable = false)
	private String name;
	
	@Column(name = "funcao",length = 35, nullable = false)
	private String funcao;
	
	@Column(name = "dateadm")
	private LocalDate dateAdm;
	
	@Column(name = "datedem")
	private LocalDate dateDem;

	public Colaborador(Long id, String matricula, String cpf, String name, String funcao, LocalDate dateAdm,
			LocalDate dateDem) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.cpf = cpf;
		this.name = name;
		this.funcao = funcao;
		this.dateAdm = dateAdm;
		this.dateDem = dateDem;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Colaborador [id=");
		builder.append(id);
		builder.append(", matricula=");
		builder.append(matricula);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", name=");
		builder.append(name);
		builder.append(", funcao=");
		builder.append(funcao);
		builder.append(", dateAdm=");
		builder.append(dateAdm);
		builder.append(", dateDem=");
		builder.append(dateDem);
		builder.append("]");
		return builder.toString();
	}
	
}
