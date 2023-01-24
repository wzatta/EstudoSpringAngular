package com.cilazatta.EstudoSpringAngular.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cilazatta.EstudoSpringAngular.entities.User000;

@Repository
public interface User000Repository extends JpaRepository<User000, Long> {

	public Optional<List<User000>> findByUserName(String username);
		
	
}
