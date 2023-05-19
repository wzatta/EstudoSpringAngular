package com.cilazatta.EstudoSpringAngular.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cilazatta.EstudoSpringAngular.dto.AlmoxDTO;
import com.cilazatta.EstudoSpringAngular.dto.FilialDTO;
import com.cilazatta.EstudoSpringAngular.dto.HoldingDTO;
import com.cilazatta.EstudoSpringAngular.entities.Almox;
import com.cilazatta.EstudoSpringAngular.entities.Filial;
import com.cilazatta.EstudoSpringAngular.entities.Holding;
import com.cilazatta.EstudoSpringAngular.repositories.AlmoxRepository;
import com.cilazatta.EstudoSpringAngular.services.util.GenericsAbstractService;

@Service
public class AlmoxService extends GenericsAbstractService<Almox, AlmoxDTO, Long> {

	@Autowired
	private AlmoxRepository almoxRepo;
	
	public List<AlmoxDTO> findByFilial(FilialDTO dto) {
		Filial filial = new Filial(dto);
		List<Almox> almox = almoxRepo.findByFilial(filial);
		List<AlmoxDTO> listDto = almox.stream().sorted(Comparator.comparing(Almox::getTitulo))
				.map(result -> new AlmoxDTO(result)).collect(Collectors.toList());
		return listDto;
	}

	public List<AlmoxDTO> findAllByHolding(HoldingDTO dto) {
		Holding hold = new Holding(dto);
		List<Almox> almox = almoxRepo.findByHolding(hold);
		List<AlmoxDTO> listDto = almox.stream().sorted(Comparator.comparing(Almox::getTitulo))
				.map(result -> new AlmoxDTO(result)).collect(Collectors.toList());
		return listDto;
	}
	
	
}
