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

import com.cilazatta.EstudoSpringAngular.dto.ProdutoMasterDTO;
import com.cilazatta.EstudoSpringAngular.services.ProdutoMasterService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "api/v1/produtomaster")
public class ProdutoMasterResource {
	
	@Autowired
	private ProdutoMasterService prodService;
	
	@PostMapping
	public ResponseEntity<ProdutoMasterDTO> insertObj(@RequestBody ProdutoMasterDTO dto){
		dto = prodService.insertObj(dto);
		return ResponseEntity.created(null).body(dto);
	}

	@GetMapping
	public ResponseEntity<List<ProdutoMasterDTO>> findAll(){
		List<ProdutoMasterDTO> listDto = prodService.findAll();
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProdutoMasterDTO> findById(@PathVariable Long id){
		ProdutoMasterDTO dto = prodService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProdutoMasterDTO> update(@PathVariable Long id, @RequestBody ProdutoMasterDTO dto){
		dto = prodService.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		Boolean isDeletado = prodService.deleteById(id);
		if(isDeletado) {
			return ResponseEntity.noContent().<Void>build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	

}
