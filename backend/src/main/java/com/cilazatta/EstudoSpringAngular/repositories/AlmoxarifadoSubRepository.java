package com.cilazatta.EstudoSpringAngular.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cilazatta.EstudoSpringAngular.entities.Filial;
import com.cilazatta.EstudoSpringAngular.entities.recurso.AlmoxarifadoSub;

@Repository
public interface AlmoxarifadoSubRepository
	extends JpaRepository<AlmoxarifadoSub, Long>{
	
	List<AlmoxarifadoSub> findAllByFilial(Filial filial);

}
