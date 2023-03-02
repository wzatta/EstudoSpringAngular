package com.cilazatta.EstudoSpringAngular.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cilazatta.EstudoSpringAngular.dto.User00DTO;
import com.cilazatta.EstudoSpringAngular.entities.User00;
import com.cilazatta.EstudoSpringAngular.repositories.User00Repository;
import com.cilazatta.EstudoSpringAngular.services.exception.FieldDataIntegrityViolationException;
import com.cilazatta.EstudoSpringAngular.services.exception.FieldNotNullException;
import com.cilazatta.EstudoSpringAngular.services.exception.ObjectNotFoundException;
import com.cilazatta.EstudoSpringAngular.util.Encoder;

@Service
public class User00Service {

	@Autowired
	private User00Repository userRepo;

	@Autowired
	private Encoder encoder;

	public void save(User00 user) {
		user.setPassword(encoder.getPasswordEncoder().encode(user.getPassword()));
		userRepo.save(user);
	}

	public User00DTO insertUser(User00DTO userDto) {
		User00 user = new User00(userDto);
		this.findByUsername(user.getUsername()).map(w->{ throw new FieldDataIntegrityViolationException("UserName ja Existente");});
		try {
			user.setPassword(encoder.getPasswordEncoder().encode(user.getPassword()));
			user = userRepo.save(user);
			return new User00DTO(user);
		}
		catch (Exception e) {
			throw new FieldNotNullException(e.getMessage());
		}
	}

	public List<User00DTO> findAll() {
		List<User00> users = userRepo.findAll(Sort.by(Sort.Direction.ASC, "name"));
		List<User00DTO> usersDto = users.stream().map(w -> new User00DTO(w)).collect(Collectors.toList());
		return usersDto;
	}

	public User00DTO findById(Long id) {
		Optional<User00> user = userRepo.findById(id);
		User00 user0 = user.orElseThrow(() -> new ObjectNotFoundException("Registro não Encontrado"));
		return new User00DTO(user0);
	}

	public Optional<User00> findByUsername(String username) {
		return userRepo.findByUser00Name(username);
	}

	public User00DTO update(Long id, User00DTO obj) {
		User00 entity = userRepo.getReferenceById(id);
		updateData(entity, obj);
		entity = userRepo.save(entity);
		return new User00DTO(entity);
	}

	private void updateData(User00 entity, User00DTO obj) {
		entity.setName(obj.getName());
		entity.setUserAtivo(obj.getUserAtivo());
		entity.setUserBloqueado(obj.getUserBloqueado());
		entity.setRole(obj.getRole());

	}

	public Boolean delete(Long id) {
		return userRepo.findById(id).map(recordFound -> {
			userRepo.deleteById(id);
			return true;
		}).orElse(false);
	}

}
