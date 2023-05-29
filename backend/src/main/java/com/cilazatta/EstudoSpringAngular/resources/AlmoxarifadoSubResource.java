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

import com.cilazatta.EstudoSpringAngular.dto.FilialDTO;
import com.cilazatta.EstudoSpringAngular.dto.almox.AlmoxarifadoSubDTO;
import com.cilazatta.EstudoSpringAngular.services.AlmoxarifadoSubService;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping(value="api/v1/almoxarifadosub")
public class AlmoxarifadoSubResource {

	@Autowired
	private AlmoxarifadoSubService service;
	
	@PostMapping(value="/sub")
	public ResponseEntity<AlmoxarifadoSubDTO> insertObj(@RequestBody AlmoxarifadoSubDTO dto){
		dto = service.insertObj(dto);
		return ResponseEntity.created(null).body(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<AlmoxarifadoSubDTO>> findAll(){
		List<AlmoxarifadoSubDTO> listDto = service.findAll();
		return ResponseEntity.ok().body(listDto);
	} 

	@PostMapping(value = "/filial" )
	public ResponseEntity<List<AlmoxarifadoSubDTO>> findAllByFilial(@RequestBody FilialDTO filial){
		List<AlmoxarifadoSubDTO> listDto = service.findAllByFilial(filial);
		return ResponseEntity.ok().body(listDto);
	} 
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AlmoxarifadoSubDTO> findById(@PathVariable @NotNull @Positive Long id){
		AlmoxarifadoSubDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AlmoxarifadoSubDTO> update(@PathVariable @NotNull @Positive Long id, @RequestBody AlmoxarifadoSubDTO dto){
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
