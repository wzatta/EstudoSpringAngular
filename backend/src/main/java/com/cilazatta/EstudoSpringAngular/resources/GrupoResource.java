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

import com.cilazatta.EstudoSpringAngular.dto.GrupoDTO;
import com.cilazatta.EstudoSpringAngular.services.GrupoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping(value = "api/v1/grupo")
public class GrupoResource {

	@Autowired
	private GrupoService grServ;

	@PostMapping
	public ResponseEntity<GrupoDTO> insertFilial(@RequestBody @Valid GrupoDTO grDto) {
		grDto = grServ.insertGr(grDto);
		return ResponseEntity.created(null).body(grDto);
	}

	@GetMapping
	public ResponseEntity<List<GrupoDTO>> findAll() {
		List<GrupoDTO> listDto = grServ.findAll();
		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<GrupoDTO> findById(@PathVariable @NotNull @Positive Long id) {
		GrupoDTO grDto = grServ.findById(id);
		return ResponseEntity.ok().body(grDto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<GrupoDTO> updateGrupo(@PathVariable @NotNull @Positive Long id, @RequestBody GrupoDTO grDto) {
		grDto = grServ.update(id, grDto);
		return ResponseEntity.ok().body(grDto);
	}

}
