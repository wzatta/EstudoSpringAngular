package com.cilazatta.EstudoSpringAngular.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cilazatta.EstudoSpringAngular.dto.ColaboradorDTO;
import com.cilazatta.EstudoSpringAngular.dto.FilialDTO;
import com.cilazatta.EstudoSpringAngular.dto.HoldingDTO;
import com.cilazatta.EstudoSpringAngular.entities.Colaborador;
import com.cilazatta.EstudoSpringAngular.entities.Filial;
import com.cilazatta.EstudoSpringAngular.entities.Holding;
import com.cilazatta.EstudoSpringAngular.repositories.ColaboradorRepository;
import com.cilazatta.EstudoSpringAngular.services.util.GenericsAbstractService;

@Service
public class ColabService extends GenericsAbstractService<Colaborador, ColaboradorDTO, Long> {

	@Autowired
	private ColaboradorRepository colabRepo;

	public List<ColaboradorDTO> findByName(String name) {
		return colabRepo.findByNameContainingIgnoreCase(name).stream().map(w -> new ColaboradorDTO(w))
				.collect(Collectors.toList());

	}

	public List<ColaboradorDTO> findByFilial(FilialDTO dto) {
		Filial filial = new Filial(dto);
		List<Colaborador> colab = colabRepo.findByFilial(filial);
		List<ColaboradorDTO> listDto = colab.stream().sorted(Comparator.comparing(Colaborador::getName))
				.map(result -> new ColaboradorDTO(result)).collect(Collectors.toList());
		return listDto;
	}

	public List<ColaboradorDTO> findAllByHolding(HoldingDTO dto) {
		Holding hold = new Holding(dto);
		List<Colaborador> colab = colabRepo.findByHolding(hold);
		List<ColaboradorDTO> listDto = colab.stream().sorted(Comparator.comparing(Colaborador::getName))
				.map(result -> new ColaboradorDTO(result)).collect(Collectors.toList());
		return listDto;
	}

}
