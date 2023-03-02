package com.cilazatta.EstudoSpringAngular.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cilazatta.EstudoSpringAngular.dto.HoldingDTO;
import com.cilazatta.EstudoSpringAngular.entities.Holding;
import com.cilazatta.EstudoSpringAngular.repositories.HoldingRepository;
import com.cilazatta.EstudoSpringAngular.services.exception.FieldNotNullException;
import com.cilazatta.EstudoSpringAngular.services.exception.GenericsExceptionError;
import com.cilazatta.EstudoSpringAngular.services.exception.ObjectNotFoundException;

@Service
public class HoldingService {
	
	@Autowired
	private HoldingRepository holdRepo;
	
	public HoldingDTO insertHolding(HoldingDTO holdDto) {
		try {
			Holding hold = new Holding(holdDto);
			hold = holdRepo.save(hold);
			return new HoldingDTO(hold);
		} catch (NullPointerException n) {
			throw new FieldNotNullException("Usuário não Identificado.");
		} catch (Exception e) {
			throw new GenericsExceptionError(e.toString());
		}

	}
	
	public List<HoldingDTO> findAll(){
		List<Holding> listHold = holdRepo.findAll(Sort.by(Sort.Direction.ASC,"rSocial"));
		List<HoldingDTO> listHoldDto = listHold.stream()
				.map(w-> new HoldingDTO(w)).collect(Collectors.toList());
		return listHoldDto;		
	}

	public HoldingDTO findById(Long id) {
		Optional<Holding> objOptional = holdRepo.findById(id);
		Holding hold = objOptional.orElseThrow(()-> new ObjectNotFoundException("Registro não Encontrado") );
		return new HoldingDTO(hold);
	}
	
	public HoldingDTO update(Long id, HoldingDTO holdDto) {
		
		Holding hold = holdRepo.getReferenceById(id);
		updateData(hold, holdDto);
		hold = holdRepo.save(hold);
		return new HoldingDTO(hold);
		
	}
	
	private void updateData(Holding hold, HoldingDTO holdDto) {
		hold.setRSocial(holdDto.getRSocial());
		hold.setDSocial(holdDto.getDSocial());
		hold.setMunicipio(holdDto.getMunicipio());
		hold.setUf(holdDto.getUf());
	}

	public Boolean deleteById(Long id) {
		return holdRepo.findById(id).map(recordFound -> {
			holdRepo.deleteById(id);
			return true;
		}).orElse(false);
	}
	
}
