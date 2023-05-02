package com.cilazatta.EstudoSpringAngular.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cilazatta.EstudoSpringAngular.dto.AlmoxDTO;
import com.cilazatta.EstudoSpringAngular.services.AlmoxService;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping(value="api/v1/almox")
public class AlmoxResource {

	@Autowired
	private AlmoxService service;
	
	
	@PostMapping
	public ResponseEntity<AlmoxDTO> insertHold(@RequestBody AlmoxDTO dto){
		AlmoxDTO almoxDto = service.insertObj(dto);
		return ResponseEntity.created(null).body(almoxDto);
	}

	@GetMapping
	public ResponseEntity<List<AlmoxDTO>> findAll(){
		List<AlmoxDTO> listDto = service.findAll();
		return ResponseEntity.ok().body(listDto);
	} 
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AlmoxDTO> findById(@PathVariable @NotNull @Positive Long id){
		AlmoxDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AlmoxDTO> update(@PathVariable @NotNull @Positive Long id, @RequestBody AlmoxDTO obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable @NotNull @Positive Long id){
		Boolean isDeletado = service.deleteById(id);
		if(isDeletado) {
			return ResponseEntity.noContent().<Void>build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
