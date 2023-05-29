package com.cilazatta.EstudoSpringAngular.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cilazatta.EstudoSpringAngular.entities.almox.AlmoxarifadoCliente;

@Repository
public interface AlmoxarifadoClienteRepository 
extends JpaRepository<AlmoxarifadoCliente, Long> {

}
