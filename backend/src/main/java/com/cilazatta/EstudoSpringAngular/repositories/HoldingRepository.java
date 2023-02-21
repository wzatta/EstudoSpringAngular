package com.cilazatta.EstudoSpringAngular.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cilazatta.EstudoSpringAngular.entities.Holding;

@Repository
public interface HoldingRepository extends JpaRepository<Holding, Long>{

}
