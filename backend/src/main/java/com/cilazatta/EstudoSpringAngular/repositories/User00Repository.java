package com.cilazatta.EstudoSpringAngular.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cilazatta.EstudoSpringAngular.entities.User00;

@Repository
public interface User00Repository extends JpaRepository<User00, Long> {

	Optional<User00> findByUser00Name(String username);
	
}
