package com.cilazatta.EstudoSpringAngular.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cilazatta.EstudoSpringAngular.dto.GrupoDTO;
import com.cilazatta.EstudoSpringAngular.entities.Grupo;
import com.cilazatta.EstudoSpringAngular.repositories.GrupoRepository;
import com.cilazatta.EstudoSpringAngular.services.exception.FieldDataIntegrityViolationException;
import com.cilazatta.EstudoSpringAngular.services.exception.ObjectNotFoundException;

@Service
public class GrupoService {

	@Autowired
	private GrupoRepository grRepo;

	public GrupoDTO insertGr(GrupoDTO grDto) {
		Grupo grupo = new Grupo(grDto);

		if(grRepo.findByCodigoGr(grupo.getCodigoGr()).isPresent()) {
			throw new FieldDataIntegrityViolationException("Grupo Cadastrado");
		}
		grupo = grRepo.save(grupo);
		return new GrupoDTO(grupo);
	}

	public List<GrupoDTO> findAll() {
		return grRepo.findAll(Sort.by(Sort.Direction.ASC, "codigoGr")).stream().map(w -> new GrupoDTO(w)).collect(Collectors.toList());
	}

	public GrupoDTO findById(Long id) {
		Grupo grupo = grRepo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Registro não Encontrado"));
		return new GrupoDTO(grupo);
	}

	public GrupoDTO update(Long id, GrupoDTO grDto) {
		Grupo grupo = grRepo.getReferenceById(id);
		updateData(grupo, grDto);
		grupo = grRepo.save(grupo);
		return new GrupoDTO(grupo);
	}

	private void updateData(Grupo grupo, GrupoDTO grDto) {
		grupo.setDescGr(grDto.getDescGr());
	}

	public Boolean deleteById(Long id) {
		return grRepo.findById(id).map(recordFound -> {
			grRepo.deleteById(id);
			return true;
		}).orElse(false);
	}

}
