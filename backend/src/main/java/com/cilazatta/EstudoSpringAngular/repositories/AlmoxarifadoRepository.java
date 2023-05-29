package com.cilazatta.EstudoSpringAngular.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cilazatta.EstudoSpringAngular.entities.almox.Almoxarifado;
import com.cilazatta.EstudoSpringAngular.entities.almox.AlmoxarifadoSub;
import com.cilazatta.EstudoSpringAngular.entities.basic.Filial;
import com.cilazatta.EstudoSpringAngular.entities.basic.Holding;

@Repository
public interface AlmoxarifadoRepository extends JpaRepository<Almoxarifado, Long> {

	Almoxarifado findByFilial(Filial filial);
	
	List<Almoxarifado> findAllByFilial(Filial filial);
	
	@Query("SELECT c FROM Almoxarifado c WHERE c.filial.holding=:holdK")
	List<Almoxarifado> findAllByHolding(@Param("holdK")Holding hold);

	Almoxarifado save(AlmoxarifadoSub almox);
	
	
}
