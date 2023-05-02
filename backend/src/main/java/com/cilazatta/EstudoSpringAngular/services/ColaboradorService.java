package com.cilazatta.EstudoSpringAngular.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cilazatta.EstudoSpringAngular.dto.ColaboradorDTO;
import com.cilazatta.EstudoSpringAngular.entities.Colaborador;
import com.cilazatta.EstudoSpringAngular.repositories.ColaboradorRepository;
import com.cilazatta.EstudoSpringAngular.services.exception.FieldDataIntegrityViolationException;
import com.cilazatta.EstudoSpringAngular.services.exception.FieldNotNullException;
import com.cilazatta.EstudoSpringAngular.services.exception.GenericsExceptionError;
import com.cilazatta.EstudoSpringAngular.services.exception.ObjectNotFoundException;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colabRepo;

	public ColaboradorDTO saveColab(ColaboradorDTO colabDto) {
		
			Colaborador colab = new Colaborador(colabDto);
			try {
			colab = colabRepo.save(colab);
			return new ColaboradorDTO(colab);
		} catch (NullPointerException n) {
			throw new FieldNotNullException("Usuário não Identificado.");
		} catch (Exception e) {
			throw new GenericsExceptionError(e.toString());
		}

	}

	public List<ColaboradorDTO> findAll() {
		return colabRepo.findAll(Sort.by(Direction.ASC, "name")).stream().map(w -> new ColaboradorDTO(w))
				.collect(Collectors.toList());
	}

	public ColaboradorDTO findById(Long id) {
		Optional<Colaborador> obj = colabRepo.findById(id);
		Colaborador colab = obj.orElseThrow(() -> new ObjectNotFoundException("Colaborador não Identificado"));
		return new ColaboradorDTO(colab);
	}

	public List<ColaboradorDTO> findByName(String name) {
		return colabRepo.findByNameContainingIgnoreCase(name).stream().map(w -> new ColaboradorDTO(w))
				.collect(Collectors.toList());

	}

	public ColaboradorDTO updateColab(Long id, ColaboradorDTO colabDto) {

		Colaborador colab = colabRepo.getReferenceById(id);
		updateData(colab, colabDto);
		colab = colabRepo.save(colab);
		return new ColaboradorDTO(colab);

	}

	private void updateData(Colaborador colab, ColaboradorDTO colabDto) {

		colab.setName(colabDto.getName());
		colab.setCpf(colabDto.getCpf());
		colab.setDateAdm(LocalDate.parse(colabDto.getDateAdm()));
		colab.setDateDem(LocalDate.parse(colabDto.getDateDem()));

	}

	public Boolean deleteById(Long Id) {
		try {
			return colabRepo.findById(Id).map(recordFound -> {
				colabRepo.delete(recordFound);
				return true;
			}).orElse(false);
		} catch (Exception e) {
			throw new FieldDataIntegrityViolationException(e.getMessage());
		}

	}

}
