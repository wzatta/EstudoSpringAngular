package com.cilazatta.EstudoSpringAngular.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cilazatta.EstudoSpringAngular.dto.AlmoxarifadoSubDTO_v1a;
import com.cilazatta.EstudoSpringAngular.dto.FilialDTO;
import com.cilazatta.EstudoSpringAngular.entities.Filial;
import com.cilazatta.EstudoSpringAngular.entities.recurso.AlmoxarifadoSub_v1a;
import com.cilazatta.EstudoSpringAngular.entities.recurso.WareHouse;
import com.cilazatta.EstudoSpringAngular.repositories.AlmoxarifadoSubRepository;
import com.cilazatta.EstudoSpringAngular.repositories.WareHouseRepository;
import com.cilazatta.EstudoSpringAngular.services.util.GenericsAbstractService;

@Service
public class AlmoxarifadoSubService_v1a extends GenericsAbstractService<AlmoxarifadoSub_v1a, AlmoxarifadoSubDTO_v1a, Long>{

	@Autowired
	private AlmoxarifadoSubRepository repo;
	
	@Autowired
	private WareHouseRepository whrepo;
	
	public List<AlmoxarifadoSubDTO_v1a> findAllByFilial(FilialDTO fdto) {
		Filial filial = new Filial(fdto);
		List<AlmoxarifadoSub_v1a> listAlmoxSub = repo.findAllByFilial(filial);
		List<AlmoxarifadoSubDTO_v1a> listDto = listAlmoxSub.stream()
				.map(w-> new AlmoxarifadoSubDTO_v1a(w))
				.collect(Collectors.toList());
		return listDto;
	}
	
	@Override
	public AlmoxarifadoSubDTO_v1a insertObj(AlmoxarifadoSubDTO_v1a objDto) {
		
		WareHouse wh = new AlmoxarifadoSub_v1a(objDto);
		AlmoxarifadoSub_v1a sub = (AlmoxarifadoSub_v1a) whrepo.save(wh);
		AlmoxarifadoSubDTO_v1a subDto = new AlmoxarifadoSubDTO_v1a(sub);
		return subDto;
	}
	
}
