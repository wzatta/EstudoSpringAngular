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

import com.cilazatta.EstudoSpringAngular.dto.AlmoxSubDTO;
import com.cilazatta.EstudoSpringAngular.services.AlmoxSubService;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping(value="api/v1/almoxsub")
public class AlmoxSubResource {

	@Autowired
	private AlmoxSubService service;
	
	
	@PostMapping
	public ResponseEntity<AlmoxSubDTO> insertObj(@RequestBody AlmoxSubDTO dto){
		dto = service.insertObj(dto);
		return ResponseEntity.created(null).body(dto);
	}

	@GetMapping
	public ResponseEntity<List<AlmoxSubDTO>> findAll(){
		List<AlmoxSubDTO> listDto = service.findAll();
		return ResponseEntity.ok().body(listDto);
	} 
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AlmoxSubDTO> findById(@PathVariable @NotNull @Positive Long id){
		AlmoxSubDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AlmoxSubDTO> update(@PathVariable @NotNull @Positive Long id, @RequestBody AlmoxSubDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
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
