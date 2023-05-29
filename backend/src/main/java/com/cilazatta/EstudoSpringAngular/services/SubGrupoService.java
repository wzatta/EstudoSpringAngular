package com.cilazatta.EstudoSpringAngular.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cilazatta.EstudoSpringAngular.dto.SubGrupoDTO;
import com.cilazatta.EstudoSpringAngular.entities.produtos.SubGrupo;
import com.cilazatta.EstudoSpringAngular.repositories.SubGrupoRepository;
import com.cilazatta.EstudoSpringAngular.services.exception.FieldDataIntegrityViolationException;
import com.cilazatta.EstudoSpringAngular.services.exception.ObjectNotFoundException;

@Service
public class SubGrupoService {

	@Autowired
	private SubGrupoRepository subGrupoRepo;
	
	
	public SubGrupoDTO insertSub(SubGrupoDTO sbGrDto) {
		try {
			SubGrupo sbGr = new SubGrupo(sbGrDto);
			sbGr = subGrupoRepo.save(sbGr);
			return new SubGrupoDTO(sbGr);			
		} catch (Exception e) {
			throw new FieldDataIntegrityViolationException("Campo Duplicado");
		}

		
	}
	
	public List<SubGrupoDTO> findAll(){
		
		return subGrupoRepo.findAll(Sort.by(Sort.Direction.ASC, "grupo.codigoGr")).stream().map(w-> new SubGrupoDTO(w)).collect(Collectors.toList());
				
	}
	
	public SubGrupoDTO findById(Long id) {
		SubGrupo sbGr = subGrupoRepo.findById(id)
				.orElseThrow(()->new ObjectNotFoundException("Registro Não Encontrado"));
		return new SubGrupoDTO(sbGr);
	}
	
	public SubGrupoDTO upDate(Long id, SubGrupoDTO sbGrDTO) {
		SubGrupo subGr = subGrupoRepo.getReferenceById(id);
		upDateData(subGr, sbGrDTO);
		subGr = subGrupoRepo.save(subGr);
		return new SubGrupoDTO(subGr);
	}

	private void upDateData(SubGrupo subGr, SubGrupoDTO sbGrDTO) {
		subGr.setDescSubGr(sbGrDTO.getDescSubGr());
	}
	
	public Boolean deleteById(Long id) {
		return subGrupoRepo.findById(id).map(recordFound -> {
			subGrupoRepo.deleteById(id);
			return true;
		}).orElse(false);
	}
	
	
}
