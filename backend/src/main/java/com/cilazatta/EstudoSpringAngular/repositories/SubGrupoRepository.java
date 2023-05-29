package com.cilazatta.EstudoSpringAngular.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cilazatta.EstudoSpringAngular.entities.produtos.SubGrupo;

@Repository
public interface SubGrupoRepository extends JpaRepository<SubGrupo, Long> {

		Optional<List<SubGrupo>> findBydescSubGr(String titulo);
}
