package com.cilazatta.EstudoSpringAngular.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cilazatta.EstudoSpringAngular.dto.User000DTO;
import com.cilazatta.EstudoSpringAngular.entities.User000;
import com.cilazatta.EstudoSpringAngular.repositories.User000Repository;
import com.cilazatta.EstudoSpringAngular.services.exception.FieldNotNullException;
import com.cilazatta.EstudoSpringAngular.services.exception.ObjectNotFoundException;
//import com.cilazatta.EstudoSpringAngular.util.Encoder;

@Service
public class User000Service {

	@Autowired
	private User000Repository userRepo;
	
//	@Autowired
//	private Encoder encoder;
	
	public User000DTO insertUser(User000DTO userDto) {
		User000 user = new User000(userDto);
		try {
//			user.setPassword(encoder.getPasswordEncoder().encode(user.getPassword()));
		user = userRepo.save(user);
		return new User000DTO(user);
		}
		catch (Exception e) {
			throw new FieldNotNullException(e.getMessage());
		}
	}
	
	public List<User000DTO> findAll() {
		List<User000> users = userRepo.findAll();
		List<User000DTO> usersDto = users.stream()
				.map(w -> new User000DTO(w)).collect(Collectors.toList());
		return usersDto;
	}
	
	public User000DTO findById(Long id) {
				Optional<User000> user = userRepo.findById(id);	
				User000 user000 = user.orElseThrow(()->new ObjectNotFoundException("Registro não Encontrado"));
				return new User000DTO(user000);
	}
	
	
	private Boolean findByUserName(String username) {
		Optional<List<User000>> user = userRepo.findByUserName(username);
		return user.isPresent();
	}
	
}
