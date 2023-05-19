package com.cilazatta.EstudoSpringAngular.entities.recurso;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public abstract class WareHouse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private Boolean isActive;
	private LocalDate dataCriacao;
	
	@Override
	public String toString() {
		return "WareHouse [id=" + id + ", title=" + title + ", isActive=" + isActive + ", dataCriacao=" + dataCriacao
				+ "]";
	}
	
	
	
	
}
