package com.cilazatta.EstudoSpringAngular.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cilazatta.EstudoSpringAngular.dto.AlmoxSubDTO;
import com.cilazatta.EstudoSpringAngular.dto.FilialDTO;
import com.cilazatta.EstudoSpringAngular.entities.AlmoxSub;
import com.cilazatta.EstudoSpringAngular.entities.Filial;
import com.cilazatta.EstudoSpringAngular.repositories.AlmoxSubRepository;
import com.cilazatta.EstudoSpringAngular.services.util.GenericsAbstractService;

@Service
public class AlmoxSubService extends GenericsAbstractService<AlmoxSub, AlmoxSubDTO, Long> {

	@Autowired
	private AlmoxSubRepository repo;
	
	public List<AlmoxSubDTO> findAllByAlmox(FilialDTO fdto) {
		Filial filial = new Filial(fdto);
		List<AlmoxSub> listAlmoxSub = repo.findAllByAlmox(filial);
		List<AlmoxSubDTO> listDto = listAlmoxSub.stream()
				.map(w-> new AlmoxSubDTO(w))
				.collect(Collectors.toList());
		return listDto;
	}

}
