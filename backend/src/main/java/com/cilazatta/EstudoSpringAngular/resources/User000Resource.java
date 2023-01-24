package com.cilazatta.EstudoSpringAngular.resources;

import java.util.List;

import org.hibernate.PropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cilazatta.EstudoSpringAngular.dto.User000DTO;
import com.cilazatta.EstudoSpringAngular.services.User000Service;
import com.cilazatta.EstudoSpringAngular.services.exception.FieldNotNullException;

@RestController
@RequestMapping(value="/users")
public class User000Resource {
	
	@Autowired
	private User000Service userServ;
	
	@PostMapping
	public ResponseEntity<User000DTO> insertUser(@RequestBody User000DTO user){
		User000DTO userDto = userServ.insertUser(user);
		return ResponseEntity.created(null).body(userDto);
	}
	
	@GetMapping
	public ResponseEntity<List<User000DTO>> findAll(){
		List<User000DTO> users = userServ.findAll();
		return ResponseEntity.ok().body(users);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User000DTO> findById(@PathVariable Long id){
		User000DTO userdto = userServ.findById(id);
		return ResponseEntity.ok().body(userdto);
	}
	
	
}
