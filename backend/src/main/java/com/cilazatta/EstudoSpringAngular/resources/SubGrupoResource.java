package com.cilazatta.EstudoSpringAngular.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cilazatta.EstudoSpringAngular.dto.SubGrupoDTO;
import com.cilazatta.EstudoSpringAngular.services.SubGrupoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping(value = "api/v1/sbgrupo")
public class SubGrupoResource {

	@Autowired
	private SubGrupoService subGrServ;
	
	@PostMapping
	public ResponseEntity<SubGrupoDTO> insertSubGr(@RequestBody @Valid SubGrupoDTO subGrDto){
		
		subGrDto = subGrServ.insertSub(subGrDto);
		return ResponseEntity.created(null).body(subGrDto);
		
	}
	
	@GetMapping
	public ResponseEntity<List<SubGrupoDTO>> findAll(){
		List<SubGrupoDTO> list = subGrServ.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SubGrupoDTO> findById(@PathVariable @NotNull(message="{field.not.null}") @Positive(message="{field.not.negative}") Long id){
		SubGrupoDTO subgrDto = subGrServ.findById(id);
		return ResponseEntity.ok().body(subgrDto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<SubGrupoDTO> update(@PathVariable @NotNull(message="{field.not.null}") @Positive(message="{field.not.negative}") Long id, @RequestBody SubGrupoDTO sbGrDto){
		SubGrupoDTO subgrDto = subGrServ.upDate(id, sbGrDto);
		return ResponseEntity.ok().body(subgrDto);
	}
	
}
