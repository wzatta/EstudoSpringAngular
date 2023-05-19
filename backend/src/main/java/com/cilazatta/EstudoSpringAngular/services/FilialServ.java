package com.cilazatta.EstudoSpringAngular.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cilazatta.EstudoSpringAngular.dto.FilialDTO;
import com.cilazatta.EstudoSpringAngular.dto.HoldingDTO;
import com.cilazatta.EstudoSpringAngular.entities.Filial;
import com.cilazatta.EstudoSpringAngular.entities.Holding;
import com.cilazatta.EstudoSpringAngular.repositories.FilialRepository;
import com.cilazatta.EstudoSpringAngular.services.util.GenericsAbstractService;

@Service
public class FilialServ extends GenericsAbstractService<Filial, FilialDTO, Long> {

	@Autowired
	private FilialRepository filialRepo;

	@Override
	public List<FilialDTO> findAll() {
		return super.findAll()
				.stream()
				.sorted(Comparator.comparing(FilialDTO::getRSocial))
				.collect(Collectors.toList());
	}

/*=========================================================
	@Override
	public FilialDTO update(Long id, FilialDTO dto) {
		Filial filial = filialRepo.getReferenceById(id);
		updateData(filial, dto);
		filial = filialRepo.save(filial);
		return new FilialDTO(filial);
	}

	private void updateData(Filial filial, FilialDTO filialDto) {
		filial.setRSocial(filialDto.getRSocial());
		filial.setDSocial(filialDto.getDSocial());
		filial.setMunicipio(filialDto.getMunicipio());
		filial.setUf(filialDto.getUf());
	}
*/
//===================================================================

	public List<FilialDTO> findAllByHolding(HoldingDTO dto){
		Holding hold = new Holding(dto);
		List<Filial> listFilial = filialRepo.findAllByHolding(hold);
		List<FilialDTO> listDto = listFilial.stream()
				.map(w -> new FilialDTO(w))
				.collect(Collectors.toList());
		return listDto;
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

	public List<FilialDTO> findAllByFilial(FilialDTO filial) {
		List<FilialDTO> listdto = new ArrayList();
		listdto.add(filial);
		return listdto;
	}

}
