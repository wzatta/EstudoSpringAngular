package com.cilazatta.EstudoSpringAngular.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cilazatta.EstudoSpringAngular.dto.FilialDTO;
import com.cilazatta.EstudoSpringAngular.services.FilialService;

@RestController
@RequestMapping(value = "api/v1/filial")
public class FilialResource {

	@Autowired
	private FilialService filialServ;
	
	@PostMapping
	public ResponseEntity<FilialDTO> insertFilial(@RequestBody FilialDTO filialDto){
		filialDto = filialServ.insertFilial(filialDto);
		return ResponseEntity.created(null).body(filialDto);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<FilialDTO> updateFilial(@PathVariable Long id, @RequestBody FilialDTO filialDto){
		filialDto = filialServ.update(id, filialDto);
		return ResponseEntity.ok().body(filialDto);
	}
	
	@GetMapping
	public ResponseEntity<List<FilialDTO>> findAll(){
		List<FilialDTO> listFilialDto = filialServ.findAll();
		return ResponseEntity.ok().body(listFilialDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FilialDTO> findById(@PathVariable Long id){
		FilialDTO filialDto = filialServ.findById(id);
		return ResponseEntity.ok().body(filialDto);
	}
	
	@GetMapping("/pagesearch0")
	public Page<FilialDTO> search(
			@RequestParam("searchTerm") String searchTerm,
			@RequestParam(value = "page", required=false, defaultValue="0") int page,
			@RequestParam(value = "size", required=false, defaultValue="10") int size
			){
		
		return filialServ.searchByRsocialDSocial(searchTerm, page, size);
	}

	@GetMapping("/pagesearch")
	public Page<FilialDTO> getAll(){
		return filialServ.findAllPage();
	}
	
	@GetMapping("/search/{rsocial}")
	public ResponseEntity<List<FilialDTO>> findByRsocial(@PathVariable String rsocial){
		List<FilialDTO> list = filialServ.findByRsocial(rsocial);
		return ResponseEntity.ok().body(list);
	}
	
}
