package com.cilazatta.EstudoSpringAngular.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cilazatta.EstudoSpringAngular.dto.FilialDTO;
import com.cilazatta.EstudoSpringAngular.dto.almox.AlmoxarifadoDTO;
import com.cilazatta.EstudoSpringAngular.dto.almox.AlmoxarifadoSubDTO;
import com.cilazatta.EstudoSpringAngular.entities.almox.Almoxarifado;
import com.cilazatta.EstudoSpringAngular.entities.almox.AlmoxarifadoSub;
import com.cilazatta.EstudoSpringAngular.repositories.AlmoxarifadoSubRepository;
import com.cilazatta.EstudoSpringAngular.repositories.WareHouseRepository;
import com.cilazatta.EstudoSpringAngular.services.util.GenericsAbstractService;

@Service
public class AlmoxarifadoSubService extends GenericsAbstractService<AlmoxarifadoSub, AlmoxarifadoSubDTO, Long>{

	@Autowired
	private WareHouseRepository whrepo;
	
	@Autowired
	private AlmoxarifadoService almoxServ;
	
	@Autowired
	private AlmoxarifadoSubRepository almoxSubRepo;

	/*
	@Override
	public AlmoxarifadoSubDTO insertObj(AlmoxarifadoSubDTO objDto) {
		WareHouse almox = new AlmoxarifadoSub(objDto);
		almox = whrepo.save(almox);
		return new AlmoxarifadoSubDTO((AlmoxarifadoSub)almox);
		
	}
	*/
	public List<AlmoxarifadoSubDTO> findAllByFilial(FilialDTO filial){
		
		AlmoxarifadoDTO almox = almoxServ.findByFilial(filial);
		List<AlmoxarifadoSub> listSub = almoxSubRepo.findAllByAlmoxarifado(new Almoxarifado(almox));
		List<AlmoxarifadoSubDTO> listDto = listSub.stream()
				.map(w-> new AlmoxarifadoSubDTO(w))
				.collect(Collectors.toList());
		
		return listDto;
	}
	
}
