package com.cilazatta.EstudoSpringAngular.services.util;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cilazatta.EstudoSpringAngular.dto.HoldingDTO;
import com.cilazatta.EstudoSpringAngular.entities.Holding;

@Service
public class HoldServ extends GenericsAbstractService<Holding, HoldingDTO, Long> {

	@Override
	public List<HoldingDTO> findAll() {
		return super.findAll()
				.stream()
				.sorted(Comparator.comparing(HoldingDTO::getRSocial))
				.collect(Collectors.toList());
	}
	
	
	
}
