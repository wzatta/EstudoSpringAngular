package com.cilazatta.EstudoSpringAngular.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cilazatta.EstudoSpringAngular.entities.OsFilial;

@Repository
public interface OsRepository extends JpaRepository<OsFilial, Long> {

}
