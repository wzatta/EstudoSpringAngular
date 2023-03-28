package com.cilazatta.EstudoSpringAngular.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cilazatta.EstudoSpringAngular.entities.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {
	

}