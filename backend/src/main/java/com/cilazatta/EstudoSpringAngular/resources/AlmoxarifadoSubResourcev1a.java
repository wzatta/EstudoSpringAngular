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
import com.cilazatta.EstudoSpringAngular.dto.AlmoxarifadoSubDTO_v1a;
import com.cilazatta.EstudoSpringAngular.dto.FilialDTO;
import com.cilazatta.EstudoSpringAngular.services.AlmoxarifadoSubService_v1a;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping(value="api/v1/almoxarifadosub")
public class AlmoxarifadoSubResourcev1a {

	@Autowired
	private AlmoxarifadoSubService_v1a service;
	
	@PostMapping(value="/sub")
	public ResponseEntity<AlmoxarifadoSubDTO_v1a> insertObj(@RequestBody AlmoxarifadoSubDTO_v1a dto){
		System.out.println(dto.toString());
		dto = service.insertObj(dto);
		return ResponseEntity.created(null).body(dto);
	}
	
	@PostMapping(value = "/filial")
	public ResponseEntity<List<AlmoxarifadoSubDTO_v1a>> findAllByFilial(@RequestBody FilialDTO fdto){
		List<AlmoxarifadoSubDTO_v1a> ldto = service.findAllByFilial(fdto);
		return ResponseEntity.ok().body(ldto);
	}

	@GetMapping
	public ResponseEntity<List<AlmoxarifadoSubDTO_v1a>> findAll(){
		List<AlmoxarifadoSubDTO_v1a> listDto = service.findAll();
		return ResponseEntity.ok().body(listDto);
	} 
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AlmoxarifadoSubDTO_v1a> findById(@PathVariable @NotNull @Positive Long id){
		AlmoxarifadoSubDTO_v1a dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AlmoxarifadoSubDTO_v1a> update(@PathVariable @NotNull @Positive Long id, @RequestBody AlmoxarifadoSubDTO_v1a dto){
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
