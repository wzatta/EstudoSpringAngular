/*
package com.cilazatta.EstudoSpringAngular.config;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
		
	    //List<User00DTO> listDto = new ArrayList<>();
		
		
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
//===================================================
//Quinto - Criando a Holding Tenenge / Montreal / Ultratec
	    HoldingDTO hold2 = new HoldingDTO(null, "Tenenge-Tecnica Nacional de Engenharia S/A", "matriz", "22222222000201","São Paulo","SP");
		HoldingDTO hold3 = new HoldingDTO(null, "Montreal Engenharia e Construções Ltda", "Matriz", "33333333000301", "Rio de Janeiro", "RJ");
		HoldingDTO hold4 = new HoldingDTO(null, "UltraTec Montagem Industrial Ltda", "Matriz", "44444444000401", "Belo Horizonte", "MG");
		HoldingDTO hold5 = new HoldingDTO(null, "Engeman Manutenções Industriais Ltda", "Matriz", "55555555000501", "Vitoria", "ES");
		List<HoldingDTO> listdto = Arrays.asList(hold2, hold3, hold4, hold5);
		listdto = listdto.stream().map(w -> w = holdService.insertHolding(w)
										).collect(Collectors.toList());
				
//Sexto - Criando a Filial 	
		FilialDTO f2 = new FilialDTO(null, "TENENGE - FILIAL 01","FILIAL 01","22222222000202","SALVADOR","BA",listdto.get(0));
		FilialDTO f3 = new FilialDTO(null, "MONTREAL - FILIAL 01","FILIAL 01","33333333000302","SALVADOR","BA",listdto.get(1));
		FilialDTO f4 = new FilialDTO(null, "ULTRATEC - FILIAL 01","FILIAL 01","44444444000402","SALVADOR","BA",listdto.get(2));
		FilialDTO f5 = new FilialDTO(null, "ENGEMAN - FILIAL 01","FILIAL 01","55555555000502","SALVADOR","BA",listdto.get(3));
	    List<FilialDTO> listFilial = new ArrayList<>(Arrays.asList(f2,f3,f4,f5));
	    listFilial = listFilial.stream().map(x-> x = filialServ.insertFilial(x))
	    		.collect(Collectors.toList());
	    
//Setimo
	    ColaboradorDTO c1 = new ColaboradorDTO(null, "TNE0001","22222222201","Antonio Jose dos Santos","analista","2023-01-31",null,listFilial.get(0));
	    ColaboradorDTO c2 = new ColaboradorDTO(null, "TNE0002","22222222202","Marcos Geraldo Lima","Montador de Andaime","2023-01-31",null,listFilial.get(0));
	    ColaboradorDTO c3 = new ColaboradorDTO(null, "TNE0003","22222222203","Rodrigo Martins Andrade","Soldador Tig","2023-01-31",null,listFilial.get(0));
	    ColaboradorDTO c4 = new ColaboradorDTO(null, "TNE0004","22222222204","Maria Aparecida Silva","Gerente Adm Financeiro","2023-01-31",null,listFilial.get(0));
	    ColaboradorDTO c5 = new ColaboradorDTO(null, "TNE0005","22222222205","Maria Jose Pereira","Contadora","2023-01-31",null,listFilial.get(0));
	
	    ColaboradorDTO c6 = new ColaboradorDTO(null, "M0001","33333333301","Jose Marcos Rodrigues","analista","2023-01-31",null,listFilial.get(1));
	    ColaboradorDTO c7 = new ColaboradorDTO(null, "M0002","33333333302","Marcos Geraldo Lima","Montador de Andaime","2023-01-31",null,listFilial.get(1));
	    ColaboradorDTO c8 = new ColaboradorDTO(null, "M0003","33333333303","Rodrigo Martins Andrade","Soldador Tig","2023-01-31",null,listFilial.get(1));
	    ColaboradorDTO c9 = new ColaboradorDTO(null, "M0004","33333333304","Maria Aparecida Silva","Gerente Adm Financeiro","2023-01-31",null,listFilial.get(1));
	    ColaboradorDTO c10 = new ColaboradorDTO(null, "M0005","33333333305","Maria Jose Pereira","Contadora","2023-01-31",null,listFilial.get(1));

	    ColaboradorDTO c11 = new ColaboradorDTO(null, "U0001","44444444401","Roberto Carlos Miranda","analista","2023-01-31",null,listFilial.get(2));
	    ColaboradorDTO c12 = new ColaboradorDTO(null, "U0002","44444444402","Marcos Geraldo Lima","Montador de Andaime","2023-01-31",null,listFilial.get(2));
	    ColaboradorDTO c13 = new ColaboradorDTO(null, "U0003","44444444403","Rodrigo Martins Andrade","Soldador Tig","2023-01-31",null,listFilial.get(2));
	    ColaboradorDTO c14 = new ColaboradorDTO(null, "U0004","44444444404","Maria Aparecida Silva","Gerente Adm Financeiro","2023-01-31",null,listFilial.get(2));
	    ColaboradorDTO c15 = new ColaboradorDTO(null, "U0005","44444444405","Maria Jose Pereira","Contadora","2023-01-31",null,listFilial.get(2));

	    ColaboradorDTO c16 = new ColaboradorDTO(null, "E0001","55555555501","Carlos Andre Nascimento","analista","2023-01-31",null,listFilial.get(3));
	    ColaboradorDTO c17 = new ColaboradorDTO(null, "E0002","55555555502","Marcos Geraldo Lima","Montador de Andaime","2023-01-31",null,listFilial.get(3));
	    ColaboradorDTO c18 = new ColaboradorDTO(null, "E0003","55555555503","Rodrigo Martins Andrade","Soldador Tig","2023-01-31",null,listFilial.get(3));
	    ColaboradorDTO c19 = new ColaboradorDTO(null, "E0004","55555555504","Maria Aparecida Silva","Gerente Adm Financeiro","2023-01-31",null,listFilial.get(3));
	    ColaboradorDTO c20 = new ColaboradorDTO(null, "E0005","55555555505","Maria Jose Pereira","Contadora","2023-01-31",null,listFilial.get(3));

	    List<ColaboradorDTO> listDto = new ArrayList<>(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20));
	     listDto = listDto.stream().map(w-> w = colabServ.saveColab(w)).collect(Collectors.toList());
	    
//Oitavo Inserindo o Primeiro Colaborador para ser Usuário - TI
	    User00DTO u1 = new User00DTO(null, c1.getName(),c1.getCpf(),listDto.get(0),"santos","1234",true,true,Role.ADMIN);
	    User00DTO u2 = new User00DTO(null, c6.getName(),c6.getCpf(),listDto.get(5),"rodrigues","1234",true,true,Role.ADMIN);
	    User00DTO u3 = new User00DTO(null, c11.getName(),c11.getCpf(),listDto.get(10),"miranda","1234",true,true,Role.ADMIN);
	    User00DTO u4 = new User00DTO(null, c16.getName(),c16.getCpf(),listDto.get(15),"nascimento","1234",true,true,Role.ADMIN);
	    List<User00DTO> listUser = new ArrayList<>(Arrays.asList(u1, u2,u3,u4));
	    listUser.stream().forEach(w -> {w = user00Serv.insertUser(w);
	    							 System.out.println(w);});
	
	}
	
}
*/

