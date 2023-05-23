package com.cilazatta.EstudoSpringAngular.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cilazatta.EstudoSpringAngular.entities.Filial;
import com.cilazatta.EstudoSpringAngular.entities.recurso.AlmoxarifadoSub_v1a;

@Repository
public interface AlmoxarifadoSubRepository
	extends JpaRepository<AlmoxarifadoSub_v1a, Long>{
	
	List<AlmoxarifadoSub_v1a> findAllByFilial(Filial filial);

}
