package com.cilazatta.EstudoSpringAngular.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cilazatta.EstudoSpringAngular.dto.OsFilialDTO;
import com.cilazatta.EstudoSpringAngular.dto.OsFilialDTOget;
import com.cilazatta.EstudoSpringAngular.services.OsFilialService;

@RestController
@RequestMapping(value = "api/v1/osfilial")
public class OsFilialResource {

	@Autowired
	private OsFilialService osService;
	
	@PostMapping
	public ResponseEntity<OsFilialDTO> insertOsFilial(@RequestBody OsFilialDTO osDto){
		
		osDto = osService.insertOsFilial(osDto);
		return ResponseEntity.created(null).body(osDto);
	}
	
	@GetMapping
	public ResponseEntity<List<OsFilialDTOget>> findAll(){
		List<OsFilialDTOget> listDto = osService.findAll();
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OsFilialDTO> findById(@PathVariable Long id){
		OsFilialDTO osDto = osService.findById(id);
		return ResponseEntity.ok().body(osDto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<OsFilialDTO> update(@PathVariable Long id, @RequestBody OsFilialDTO osDto){
		osDto = osService.update(id, osDto);
		return ResponseEntity.ok().body(osDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteOs(@PathVariable Long id){
		Boolean isDeletado = osService.deleteById(id);
		if(isDeletado) {
			return ResponseEntity.noContent().<Void>build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
