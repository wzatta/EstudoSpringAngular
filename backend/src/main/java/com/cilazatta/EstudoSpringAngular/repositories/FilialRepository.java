package com.cilazatta.EstudoSpringAngular.repositories;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cilazatta.EstudoSpringAngular.entities.basic.Filial;
import com.cilazatta.EstudoSpringAngular.entities.basic.Holding;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Long> {

	//List<Filial> findByRsocialContainingIgnoreCase(String rsocial);
	List<Filial> findByrSocialContainingIgnoreCase(String rSocial);
	List<Filial> findAllByHolding(Holding hold);
	
		@Query("FROM Filial c "+
			   "WHERE LOWER(c.rSocial) like %:searchTerm% " +
			   "OR LOWER(c.dSocial) like %:searchTerm%")
		Page<Filial> searchP(
				@Param("searchTerm") String searchTerm, 
				Pageable pageable);
	 
	
}