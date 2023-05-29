package com.cilazatta.EstudoSpringAngular.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cilazatta.EstudoSpringAngular.dto.almox.AlmoxarifadoSubDTO;
import com.cilazatta.EstudoSpringAngular.entities.almox.AlmoxarifadoSub;
import com.cilazatta.EstudoSpringAngular.entities.almox.WareHouse;

public interface WareHouseRepository extends JpaRepository<WareHouse, Long> {

	AlmoxarifadoSub save(AlmoxarifadoSubDTO dto);
	
}
