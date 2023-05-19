package com.cilazatta.EstudoSpringAngular.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cilazatta.EstudoSpringAngular.entities.Almox;
import com.cilazatta.EstudoSpringAngular.entities.Filial;
import com.cilazatta.EstudoSpringAngular.entities.Holding;
import com.cilazatta.EstudoSpringAngular.entities.recurso.Almoxarifado;

@Repository
public interface AlmoxarifadoRepository extends JpaRepository<Almoxarifado, Long> {

	Almoxarifado findByFilial(Filial filial);
	
	List<Almoxarifado> findAllByFilial(Filial filial);
	
	@Query("SELECT c FROM Almoxarifado c WHERE c.filial.holding=:holdK")
	List<Almoxarifado> findAllByHolding(@Param("holdK")Holding hold);
	
	
}
