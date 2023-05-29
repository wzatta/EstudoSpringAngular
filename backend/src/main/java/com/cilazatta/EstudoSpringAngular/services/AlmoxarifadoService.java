package com.cilazatta.EstudoSpringAngular.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cilazatta.EstudoSpringAngular.dto.FilialDTO;
import com.cilazatta.EstudoSpringAngular.dto.HoldingDTO;
import com.cilazatta.EstudoSpringAngular.dto.almox.AlmoxarifadoDTO;
import com.cilazatta.EstudoSpringAngular.entities.almox.Almoxarifado;
import com.cilazatta.EstudoSpringAngular.entities.basic.Filial;
import com.cilazatta.EstudoSpringAngular.entities.basic.Holding;
import com.cilazatta.EstudoSpringAngular.repositories.AlmoxarifadoRepository;
import com.cilazatta.EstudoSpringAngular.services.util.GenericsAbstractService;

@Service
public class AlmoxarifadoService extends GenericsAbstractService<Almoxarifado, AlmoxarifadoDTO, Long> {

	@Autowired
	private AlmoxarifadoRepository repo;
	
	public List<AlmoxarifadoDTO> findAllByHolding(HoldingDTO dto) {
		Holding hold = new Holding(dto);
		List<Almoxarifado> listHold = repo.findAllByHolding(hold);
		List<AlmoxarifadoDTO> listDto = listHold.stream()
				.map(w-> new AlmoxarifadoDTO(w))
				.collect(Collectors.toList());
		return listDto;
	}

	public List<AlmoxarifadoDTO> findAllByFilial(FilialDTO dto) {
		Filial filial = new Filial(dto);
		List<Almoxarifado> listFilial = repo.findAllByFilial(filial);
		List<AlmoxarifadoDTO> listdto = listFilial.stream()
				.map(w-> new AlmoxarifadoDTO(w))
				.collect(Collectors.toList());
		return listdto;
	}
	
	public AlmoxarifadoDTO findByFilial(FilialDTO dto) {
		Filial filial = new Filial(dto);
		Almoxarifado almox = repo.findByFilial(filial);
		AlmoxarifadoDTO almoxDto = new AlmoxarifadoDTO(almox);
		return almoxDto;
	}

}
