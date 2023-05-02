package com.cilazatta.EstudoSpringAngular.services;

import org.springframework.stereotype.Service;

import com.cilazatta.EstudoSpringAngular.dto.ProdutoDTO;
import com.cilazatta.EstudoSpringAngular.entities.Produto;
import com.cilazatta.EstudoSpringAngular.services.util.GenericsAbstractService;

@Service
public class ProdutoService extends GenericsAbstractService<Produto, ProdutoDTO, Long>  {

}
