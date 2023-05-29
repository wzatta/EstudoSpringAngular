package com.cilazatta.EstudoSpringAngular.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cilazatta.EstudoSpringAngular.entities.almox.Almoxarifado;
import com.cilazatta.EstudoSpringAngular.entities.almox.AlmoxarifadoSub;

@Repository
public interface AlmoxarifadoSubRepository
	extends JpaRepository<AlmoxarifadoSub, Long>{
	
	List<AlmoxarifadoSub> findAllByAlmoxarifado(Almoxarifado almox);

}
