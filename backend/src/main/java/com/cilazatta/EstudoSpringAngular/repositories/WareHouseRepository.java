package com.cilazatta.EstudoSpringAngular.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cilazatta.EstudoSpringAngular.entities.recurso.WareHouse;

public interface WareHouseRepository extends JpaRepository<WareHouse, Long> {

}
