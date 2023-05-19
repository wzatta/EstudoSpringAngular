package com.cilazatta.EstudoSpringAngular.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cilazatta.EstudoSpringAngular.entities.Almox;
import com.cilazatta.EstudoSpringAngular.entities.Filial;
import com.cilazatta.EstudoSpringAngular.entities.Holding;

@Repository
public interface AlmoxRepository extends JpaRepository<Almox, Long> {
	List<Almox> findByFilial(Filial filial);
	
	@Query("SELECT c FROM Almox c WHERE c.filial.holding=:holdK")
	List<Almox> findByHolding(@Param("holdK")Holding hold);
}
