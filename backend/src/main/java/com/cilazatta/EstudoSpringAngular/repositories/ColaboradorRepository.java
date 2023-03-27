package com.cilazatta.EstudoSpringAngular.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cilazatta.EstudoSpringAngular.entities.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

	List<Colaborador> findByNameContainingIgnoreCase(String name);
}
