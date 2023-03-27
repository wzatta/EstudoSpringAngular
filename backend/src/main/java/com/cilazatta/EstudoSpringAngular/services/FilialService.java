package com.cilazatta.EstudoSpringAngular.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cilazatta.EstudoSpringAngular.dto.FilialDTO;
import com.cilazatta.EstudoSpringAngular.entities.Filial;
import com.cilazatta.EstudoSpringAngular.repositories.FilialRepository;
import com.cilazatta.EstudoSpringAngular.services.exception.FieldNotNullException;
import com.cilazatta.EstudoSpringAngular.services.exception.GenericsExceptionError;
import com.cilazatta.EstudoSpringAngular.services.exception.ObjectNotFoundException;

@Service
public class FilialService {

	@Autowired
	private FilialRepository filialRepo;

	public FilialDTO insertFilial(FilialDTO filialDto) {
		try {
			Filial filial = new Filial(filialDto);
			filial = filialRepo.save(filial);
			return new FilialDTO(filial);
		} catch (NullPointerException n) {
			throw new FieldNotNullException("Usuário não Identificado.");
		} catch (Exception e) {
			throw new GenericsExceptionError(e.toString());
		}

	}

	public FilialDTO update(Long id, FilialDTO filialDto) {
		Filial filial = filialRepo.getReferenceById(id);
		updateData(filial, filialDto);
		filial = filialRepo.save(filial);
		return new FilialDTO(filial);
	}

	private void updateData(Filial filial, FilialDTO filialDto) {
		filial.setRSocial(filialDto.getRSocial());
		filial.setDSocial(filialDto.getDSocial());
		filial.setMunicipio(filialDto.getMunicipio());
		filial.setUf(filialDto.getUf());
	}

	public List<FilialDTO> findAll() {
		return filialRepo.findAll().stream().map(w -> new FilialDTO(w)).collect(Collectors.toList());
	}

	public FilialDTO findById(Long id) {
		Filial filial = filialRepo.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Registro não Encontrado"));
		return new FilialDTO(filial);
	}

	public Boolean deleteById(Long id) {
		return filialRepo.findById(id).map(recordFound -> {
			filialRepo.deleteById(id);
			return true;
		}).orElse(false);
	}

	public Page<FilialDTO> searchByRsocialDSocial(String searchTerm, int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name");
		return filialRepo.searchP(searchTerm.toLowerCase(), pageRequest).map(w -> new FilialDTO(w));
	}

	public Page<FilialDTO> findAllPage() {
		int page = 0;
		int size = 10;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name");
		List<FilialDTO> listDto = filialRepo.findAll().stream().map(w -> new FilialDTO(w)).collect(Collectors.toList());
		return new PageImpl<FilialDTO>(listDto, pageRequest, size);
	}

	public List<FilialDTO> findByRsocial(String rsocial) {
		return filialRepo.findByrSocialContainingIgnoreCase(rsocial).stream().map(w -> new FilialDTO(w))
				.collect(Collectors.toList());

	}

}