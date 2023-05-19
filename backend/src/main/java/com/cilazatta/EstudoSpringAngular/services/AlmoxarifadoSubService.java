package com.cilazatta.EstudoSpringAngular.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cilazatta.EstudoSpringAngular.dto.AlmoxarifadoSubDTO;
import com.cilazatta.EstudoSpringAngular.dto.FilialDTO;
import com.cilazatta.EstudoSpringAngular.entities.Filial;
import com.cilazatta.EstudoSpringAngular.entities.recurso.AlmoxarifadoSub;
import com.cilazatta.EstudoSpringAngular.entities.recurso.WareHouse;
import com.cilazatta.EstudoSpringAngular.repositories.AlmoxarifadoSubRepository;
import com.cilazatta.EstudoSpringAngular.repositories.WareHouseRepository;
import com.cilazatta.EstudoSpringAngular.services.util.GenericsAbstractService;

@Service
public class AlmoxarifadoSubService extends GenericsAbstractService<AlmoxarifadoSub, AlmoxarifadoSubDTO, Long>{

	@Autowired
	private AlmoxarifadoSubRepository repo;
	
	@Autowired
	private WareHouseRepository whrepo;
	
	public List<AlmoxarifadoSubDTO> findAllByFilial(FilialDTO fdto) {
		Filial filial = new Filial(fdto);
		List<AlmoxarifadoSub> listAlmoxSub = repo.findAllByFilial(filial);
		List<AlmoxarifadoSubDTO> listDto = listAlmoxSub.stream()
				.map(w-> new AlmoxarifadoSubDTO(w))
				.collect(Collectors.toList());
		return listDto;
	}
	
	@Override
	public AlmoxarifadoSubDTO insertObj(AlmoxarifadoSubDTO objDto) {
		
		WareHouse wh = new AlmoxarifadoSub(objDto);
		AlmoxarifadoSub sub = (AlmoxarifadoSub) whrepo.save(wh);
		AlmoxarifadoSubDTO subDto = new AlmoxarifadoSubDTO(sub);
		return subDto;
	}
	
}
