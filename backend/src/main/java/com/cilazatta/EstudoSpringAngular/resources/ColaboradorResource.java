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

import com.cilazatta.EstudoSpringAngular.dto.ColaboradorDTO;
import com.cilazatta.EstudoSpringAngular.services.ColaboradorService;

@RestController
@RequestMapping(value = "api/v1/colab")
public class ColaboradorResource {
	
	@Autowired
	private ColaboradorService colabService;
	
	@PostMapping
	public ResponseEntity<ColaboradorDTO> insertColab(@RequestBody ColaboradorDTO colabDto){
		colabDto = colabService.saveColab(colabDto);
		return ResponseEntity.created(null).body(colabDto);
	}
	
	@GetMapping
	public ResponseEntity<List<ColaboradorDTO>> findAll(){
		List<ColaboradorDTO> listDto = colabService.findAll();
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ColaboradorDTO> findById(@PathVariable Long id){
		ColaboradorDTO colabDto = colabService.findById(id);
		return ResponseEntity.ok().body(colabDto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ColaboradorDTO> updateColab(@PathVariable Long Id, @RequestBody ColaboradorDTO obj){
		obj = colabService.updateColab(Id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		Boolean isDeletado = colabService.deleteById(id);
		if(isDeletado) {
			return ResponseEntity.noContent().<Void>build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping(value = "/name/{name}")
	public ResponseEntity<List<ColaboradorDTO>> findByName(@PathVariable String name){
		List<ColaboradorDTO> listDto = colabService.findByName(name);
		return ResponseEntity.ok().body(listDto);
	}

}
