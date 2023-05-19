package com.cilazatta.EstudoSpringAngular.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cilazatta.EstudoSpringAngular.entities.AlmoxSub;
import com.cilazatta.EstudoSpringAngular.entities.Filial;

public interface AlmoxSubRepository extends JpaRepository<AlmoxSub, Long> {

	List<AlmoxSub> findAllByAlmox(Filial filial);
	
}
