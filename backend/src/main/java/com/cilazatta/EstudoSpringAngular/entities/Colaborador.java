package com.cilazatta.EstudoSpringAngular.entities;

import java.io.Serializable;
import java.time.LocalDate;
import com.cilazatta.EstudoSpringAngular.dto.ColaboradorDTO;
import com.cilazatta.EstudoSpringAngular.entities.basic.Filial;
import com.cilazatta.EstudoSpringAngular.services.util.Convertible;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "colaborador")
public class Colaborador implements Convertible<ColaboradorDTO>, Serializable {

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
	
	@Column(name = "dateadm", nullable = false)
	private LocalDate dateAdm;
	
	@Column(name = "datedem", nullable = true)
	private LocalDate dateDem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "filial_id", nullable = false, foreignKey = @ForeignKey(name = "fk_Colab_idFilial"))
	private Filial filial;

	public Colaborador(Long id, String matricula, String cpf, String name, String funcao, LocalDate dateAdm,
			LocalDate dateDem,  Filial filial) {
		this.id = id;
		this.matricula = matricula;
		this.cpf = cpf;
		this.name = name;
		this.funcao = funcao;
		this.dateAdm = dateAdm;
		this.dateDem = dateDem;
		this.filial = filial;
	}
	
	/*public Colaborador(Long id, String matricula, String cpf, String name, String funcao, LocalDate dateAdm,
			 Filial filial) {
		this.id = id;
		this.matricula = matricula;
		this.cpf = cpf;
		this.name = name;
		this.funcao = funcao;
		this.dateAdm = dateAdm;
		this.filial = filial;
	}*/
	
	public Colaborador(ColaboradorDTO colabDto) {
		
		this.id = colabDto.getId();
		this.matricula = colabDto.getMatricula();
		this.name = colabDto.getName();
		this.cpf = colabDto.getCpf();
		this.funcao = colabDto.getFuncao();
		this.dateAdm = LocalDate.parse(colabDto.getDateAdm().subSequence(0, 10));
		if(colabDto.getDateDem()!="" && colabDto.getDateDem()!=null) {
			
		this.dateDem =  LocalDate.parse(colabDto.getDateDem());}
		this.filial = new Filial(colabDto.getFilialDto());
	}

	@Override
	public String toString() {
		return "Colaborador [id=" + id + ", matricula=" + matricula + ", cpf=" + cpf + ", name=" + name + ", funcao="
				+ funcao + ", dateAdm=" + dateAdm + ", dateDem=" + dateDem + ", filial=" + filial + "]";
	}

	@Override
	public ColaboradorDTO convert() {
		return new ColaboradorDTO(this);
	}

	

	
	
}