package com.cilazatta.EstudoSpringAngular.services.util;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cilazatta.EstudoSpringAngular.services.exception.FieldDataIntegrityViolationException;
import com.cilazatta.EstudoSpringAngular.services.exception.FieldNotNullException;
import com.cilazatta.EstudoSpringAngular.services.exception.GenericsExceptionError;
import com.cilazatta.EstudoSpringAngular.services.exception.ObjectNotFoundException;


public abstract class GenericsAbstractService<T extends Convertible<DTO>, DTO extends Convertible<T>, ID> {
	
	@Autowired(required=false)
	private JpaRepository<T, ID> repository;
	
	public DTO insertObj(DTO objDto) {
		try {
			T obj = objDto.convert();
			obj = repository.save(obj);
			return obj.convert();
		} catch (NullPointerException n) {
			throw new FieldNotNullException("Usuário não Identificado.");
		} catch (DataIntegrityViolationException e) {
			throw new FieldDataIntegrityViolationException("Registro ja Cadastrado!");
		} catch (Exception e) {
			throw new GenericsExceptionError(e.toString());
	}

	}
	
	public List<DTO> findAll(){
		List<T> listObj = repository.findAll();
		List<DTO> listObjDto = listObj.stream()
				.map(w-> w.convert()).collect(Collectors.toList());
		return listObjDto;		
	}

	public DTO findById(ID id) {
		Optional<T> optionalObj = repository.findById(id);
		T obj = optionalObj.orElseThrow(()-> new ObjectNotFoundException("Registro não Encontrado") );
		return obj.convert();
	}
	
	public DTO update(ID id, DTO dto) {
		T obj = repository.getReferenceById(id);
		obj = updateData(obj, dto);
		System.out.println(obj);
		obj = repository.save(obj);
		return obj.convert();
	}
	
	private T updateData(T obj, DTO dto) {
		obj = dto.convert();
		return obj;
	}

	public Boolean deleteById(ID id) {
		return repository.findById(id).map(recordFound -> {
			repository.deleteById(id);
			return true;
		}).orElse(false);
	}
	
}
