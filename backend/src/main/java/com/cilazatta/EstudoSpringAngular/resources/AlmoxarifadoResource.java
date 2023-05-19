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

import com.cilazatta.EstudoSpringAngular.dto.AlmoxarifadoDTO;
import com.cilazatta.EstudoSpringAngular.dto.FilialDTO;
import com.cilazatta.EstudoSpringAngular.dto.HoldingDTO;
import com.cilazatta.EstudoSpringAngular.services.AlmoxarifadoService;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping(value="api/v1/almoxarifado")
public class AlmoxarifadoResource {


	@Autowired
	private AlmoxarifadoService service;
	
	
	@PostMapping
	public ResponseEntity<AlmoxarifadoDTO> insertHold(@RequestBody AlmoxarifadoDTO dto){
		AlmoxarifadoDTO almoxDto = service.insertObj(dto);
		return ResponseEntity.created(null).body(almoxDto);
	}

	@GetMapping
	public ResponseEntity<List<AlmoxarifadoDTO>> findAll(){
		List<AlmoxarifadoDTO> listDto = service.findAll();
		return ResponseEntity.ok().body(listDto);
	} 
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AlmoxarifadoDTO> findById(@PathVariable @NotNull @Positive Long id){
		AlmoxarifadoDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping(value = "/almox")
	public ResponseEntity<AlmoxarifadoDTO> findByFilial(@RequestBody FilialDTO filial){
		AlmoxarifadoDTO dto = service.findByFilial(filial);
		return ResponseEntity.ok().body(dto);
	}
	
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AlmoxarifadoDTO> update(@PathVariable @NotNull @Positive Long id, @RequestBody AlmoxarifadoDTO obj){
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
	
	@PostMapping(value="/hold")
	public ResponseEntity<List<AlmoxarifadoDTO>> findAllByHolding(@RequestBody HoldingDTO dto){
		List<AlmoxarifadoDTO> listDto = service.findAllByHolding(dto);
		return ResponseEntity.ok().body(listDto);
	}

	@PostMapping(value="/filial")
	public ResponseEntity<List<AlmoxarifadoDTO>> findAllByFilial(@RequestBody FilialDTO dto){
		List<AlmoxarifadoDTO> listDto = service.findAllByFilial(dto);
		return ResponseEntity.ok().body(listDto);
	}
	
	
	
}
