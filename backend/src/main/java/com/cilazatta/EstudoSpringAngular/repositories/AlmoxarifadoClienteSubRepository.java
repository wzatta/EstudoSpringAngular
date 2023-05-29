package com.cilazatta.EstudoSpringAngular.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cilazatta.EstudoSpringAngular.entities.almox.AlmoxarifadoClienteSub;

@Repository
public interface AlmoxarifadoClienteSubRepository
extends JpaRepository<AlmoxarifadoClienteSub, Long>{

}
