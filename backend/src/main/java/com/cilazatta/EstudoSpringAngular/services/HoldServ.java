package com.cilazatta.EstudoSpringAngular.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cilazatta.EstudoSpringAngular.dto.HoldingDTO;
import com.cilazatta.EstudoSpringAngular.entities.basic.Holding;
import com.cilazatta.EstudoSpringAngular.services.util.GenericsAbstractService;

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
