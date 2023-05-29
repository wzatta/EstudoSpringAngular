package com.cilazatta.EstudoSpringAngular.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cilazatta.EstudoSpringAngular.entities.Colaborador;
import com.cilazatta.EstudoSpringAngular.entities.basic.Filial;
import com.cilazatta.EstudoSpringAngular.entities.basic.Holding;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

	List<Colaborador> findByNameContainingIgnoreCase(String name);
	List<Colaborador> findByFilial(Filial filial);
	
	@Query("SELECT c FROM Colaborador c WHERE c.filial.holding=:holdK")
	List<Colaborador> findByHolding(@Param("holdK")Holding hold);
	
	
	
}
