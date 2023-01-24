package com.cilazatta.EstudoSpringAngular.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cilazatta.EstudoSpringAngular.dto.User000DTO;
import com.cilazatta.EstudoSpringAngular.services.User000Service;

@RestController
@RequestMapping(value="/users")
public class User000Resource {
	
	@Autowired
	private User000Service userServ;
	
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
