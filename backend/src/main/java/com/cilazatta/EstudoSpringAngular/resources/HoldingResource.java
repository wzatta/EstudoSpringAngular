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

import com.cilazatta.EstudoSpringAngular.dto.HoldingDTO;
import com.cilazatta.EstudoSpringAngular.services.HoldingService;

@RestController
@RequestMapping(value="api/v1/holding")
public class HoldingResource {

	@Autowired
	private HoldingService holdService;
	
	
	@PostMapping
	public ResponseEntity<HoldingDTO> insertHold(@RequestBody HoldingDTO holdDto){
		HoldingDTO hold = holdService.insertHolding(holdDto);
		return ResponseEntity.created(null).body(hold);
	}

	@GetMapping
	public ResponseEntity<List<HoldingDTO>> findAll(){
		List<HoldingDTO> listHoldDto = holdService.findAll();
		return ResponseEntity.ok().body(listHoldDto);
	} 
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<HoldingDTO> findById(@PathVariable Long id){
		HoldingDTO holdDto = holdService.findById(id);
		return ResponseEntity.ok().body(holdDto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<HoldingDTO> update(@PathVariable Long id, @RequestBody HoldingDTO obj){
		obj = holdService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		Boolean isDeletado = holdService.deleteById(id);
		if(isDeletado) {
			return ResponseEntity.noContent().<Void>build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
