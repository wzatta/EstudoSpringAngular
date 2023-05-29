package com.cilazatta.EstudoSpringAngular.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.cilazatta.EstudoSpringAngular.dto.CertAprovDTO;
import com.cilazatta.EstudoSpringAngular.services.CertAprovService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping(value = "api/v1/certaprov")
public class CertAprovResource {
	
	@Autowired
	private CertAprovService service;
	
	@PostMapping
	public ResponseEntity<CertAprovDTO> insertObj(@RequestBody CertAprovDTO dto ){
		dto = service.insertObj(dto);
		return ResponseEntity.created(null).body(dto);
	}
	
	public ResponseEntity<List<CertAprovDTO>> findAll(){
		List<CertAprovDTO> listDto = service.findAll();
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CertAprovDTO> findById(@PathVariable Long id){
		CertAprovDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CertAprovDTO> update(@PathVariable Long id, @RequestBody CertAprovDTO dto){
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
