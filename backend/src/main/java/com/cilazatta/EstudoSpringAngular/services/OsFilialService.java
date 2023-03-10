package com.cilazatta.EstudoSpringAngular.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cilazatta.EstudoSpringAngular.dto.OsFilialDTO;
import com.cilazatta.EstudoSpringAngular.dto.OsFilialDTOget;
import com.cilazatta.EstudoSpringAngular.entities.OsFilial;
import com.cilazatta.EstudoSpringAngular.repositories.OsRepository;
import com.cilazatta.EstudoSpringAngular.services.exception.FieldNotNullException;
import com.cilazatta.EstudoSpringAngular.services.exception.GenericsExceptionError;
import com.cilazatta.EstudoSpringAngular.services.exception.ObjectNotFoundException;

@Service
public class OsFilialService {

	@Autowired
	private OsRepository osRepo;

	public OsFilialDTO insertOsFilial(OsFilialDTO osDto) {
		try {
			OsFilial os = new OsFilial(osDto);
			os = osRepo.save(os);
			return new OsFilialDTO(os);
		} catch (NullPointerException n) {
			throw new FieldNotNullException("Usuário não Identificado.");
		} catch (Exception e) {
			throw new GenericsExceptionError(e.toString());
		}
	}

	public List<OsFilialDTOget> findAll() {
		List<OsFilial> listOs = osRepo.findAll(Sort.by(Sort.Direction.ASC, "descricaoOs"));
		List<OsFilialDTOget> listDto = listOs.stream().map(w -> new OsFilialDTOget(w)).collect(Collectors.toList());
		return listDto;
	}

	public OsFilialDTO findById(Long Id) {
		Optional<OsFilial> osFilial = osRepo.findById(Id);
		OsFilial os = osFilial.orElseThrow(() -> new ObjectNotFoundException("Registro não Encontrado"));
		return new OsFilialDTO(os);
	}

	public OsFilialDTO update(Long id, OsFilialDTO osDto) {
		OsFilial osFilial = osRepo.getReferenceById(id);
		updateData(osFilial, osDto);
		osFilial = osRepo.save(osFilial);
		return new OsFilialDTO(osFilial);
	}

	private void updateData(OsFilial osFilial, OsFilialDTO osDto) {
		osFilial.setCodigoOs(osDto.getCodigoOs());
		osFilial.setDescricaoOs(osDto.getDescricaoOs());
		osFilial.setDataInicial(osDto.getDataInicial());
		osFilial.setDataFinal(osDto.getDataFinal());
		osFilial.setOsIsAtiva(osDto.getOsIsAtiva());
	}

	public Boolean deleteById(Long id) {
		return osRepo.findById(id).map(recordFound -> {
			osRepo.deleteById(id);
			return true;
		}).orElse(false);
	}

}
