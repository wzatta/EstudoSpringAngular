/*package com.cilazatta.EstudoSpringAngular.config;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cilazatta.EstudoSpringAngular.dto.ColaboradorDTO;
import com.cilazatta.EstudoSpringAngular.dto.FilialDTO;
import com.cilazatta.EstudoSpringAngular.dto.HoldingDTO;
import com.cilazatta.EstudoSpringAngular.dto.User00DTO;
import com.cilazatta.EstudoSpringAngular.enums.Role;
import com.cilazatta.EstudoSpringAngular.repositories.HoldingRepository;
import com.cilazatta.EstudoSpringAngular.repositories.User00Repository;
import com.cilazatta.EstudoSpringAngular.services.ColaboradorService;
import com.cilazatta.EstudoSpringAngular.services.FilialService;
import com.cilazatta.EstudoSpringAngular.services.HoldingService;
import com.cilazatta.EstudoSpringAngular.services.User00Service;
@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private User00Repository user00Repo;
	
	@Autowired
	private HoldingRepository holdRepo;
	
	@Autowired
	private User00Service user00Serv;
	
	@Autowired
	private HoldingService holdService;
	
	@Autowired
	private ColaboradorService colabServ;
	
	@Autowired
	private FilialService filialServ;
	
	@Override
	public void run(String... args) throws Exception {
		
		List<User00DTO> listDto = new ArrayList<>();
		List<HoldingDTO> listHoldDto = new ArrayList<>();
		
		user00Repo.deleteAll();
		holdRepo.deleteAll();
		
//Primeiro - Criando a Holding de Desenvolvimento	
		HoldingDTO hold1 = new HoldingDTO(null, "Zatta Desenvolvimentos de Aplicativos", "matriz", "11111111000101","São Mateus","ES");
	    hold1 = holdService.insertHolding(hold1);
	    
//Segundo - Criando a Filial/Holding
		FilialDTO filia1 = new FilialDTO(null, "Zatta Desenvolvimentos","FILIAL 01","22333444000101","São Mateus","ES",hold1);
	    filia1 = filialServ.insertFilial(filia1);
	   
//Terceiro- Colaborado
	    ColaboradorDTO wal1 = new ColaboradorDTO(null, "zt0001","00100200344","waldyr zatta Junior","Analista","2023-01-01",null,filia1);
	    wal1 = colabServ.saveColab(wal1);
	    
	    
//Quarto - Usuario
	    User00DTO waldyr = new User00DTO(null, wal1.getName(),wal1.getCpf(),wal1,"zatta","1234",true,true,Role.ADMIN);
	    waldyr = user00Serv.insertUser(waldyr);
	    
//Quinto - Criando a Holding Tenenge
	    HoldingDTO hold2 = new HoldingDTO(null, "Tenenge-Tecnica Nacional de Engenharia S/A", "matriz", "22333444000100","São Paulo","SP");
		hold2 = holdService.insertHolding(hold2);
	    

//Sexto - Criando a Filial 01 - da Tenenge	
		FilialDTO filia1Hold2 = new FilialDTO(null, "TENENGE - FILIAL 01","FILIAL 01","22333444000101","SALVADOR","BA",hold2);
	    filia1Hold2 = filialServ.insertFilial(filia1Hold2);
	    
//Setimo
	    ColaboradorDTO colabDto = new ColaboradorDTO(null, "tne0001","00100200304","Antonio Santos TI","analista","2023-01-31",null,filia1Hold2);
	    colabDto = colabServ.saveColab(colabDto);
	    
//Oitavo Inserindo o Primeiro Colaborador para ser Usuário - TI
	    User00DTO antonioti = new User00DTO(null, colabDto.getName(),colabDto.getCpf(),colabDto,"santos","1234",true,true,Role.ADMIN);
	    antonioti = user00Serv.insertUser(antonioti);	    
	}
	
}
*/
