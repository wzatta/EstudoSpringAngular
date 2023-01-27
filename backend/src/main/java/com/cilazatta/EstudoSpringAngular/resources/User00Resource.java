package com.cilazatta.EstudoSpringAngular.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cilazatta.EstudoSpringAngular.dto.User000DTO;
import com.cilazatta.EstudoSpringAngular.dto.User00DTO;
import com.cilazatta.EstudoSpringAngular.services.User00Service;

@RestController
@RequestMapping(value="api/v1/user00")
public class User00Resource {
	
	@Autowired
	private User00Service userServ;
	
	@PostMapping
	public ResponseEntity<User00DTO> insertUser(@RequestBody User00DTO user){
		User00DTO userDto = userServ.insertUser(user);
		return ResponseEntity.created(null).body(userDto);
	}
	
	@GetMapping
	public ResponseEntity<List<User00DTO>> findAll(){
		List<User00DTO> users = userServ.findAll();
		return ResponseEntity.ok().body(users);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User00DTO> findById(@PathVariable Long id){
		User00DTO userdto = userServ.findById(id);
		return ResponseEntity.ok().body(userdto);
	}
	
	
	
}
