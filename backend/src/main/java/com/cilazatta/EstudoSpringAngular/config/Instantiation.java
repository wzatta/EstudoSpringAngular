/*package com.cilazatta.EstudoSpringAngular.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cilazatta.EstudoSpringAngular.dto.User000DTO;
import com.cilazatta.EstudoSpringAngular.dto.User00DTO;
import com.cilazatta.EstudoSpringAngular.enums.Role;
import com.cilazatta.EstudoSpringAngular.repositories.User000Repository;
import com.cilazatta.EstudoSpringAngular.repositories.User00Repository;
import com.cilazatta.EstudoSpringAngular.services.User000Service;
import com.cilazatta.EstudoSpringAngular.services.User00Service;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private User000Repository userRepo;
	
	@Autowired
	private User00Repository user00Repo;
	
	@Autowired
	private User000Service userServ;
	
	@Autowired
	private User00Service user00Serv;
	
	@Override
	public void run(String... args) throws Exception {
		
	
		List<User000DTO> listDTO = new ArrayList<>();
		List<User00DTO> listDto = new ArrayList<>();
		
		userRepo.deleteAll();
		user00Repo.deleteAll();
		
		User000DTO wal = new User000DTO(null,"zatta","1234","00000000153","Waldyr Zatta Junior",true);
		User000DTO edi = new User000DTO(null,"cila","1234","00000000253","Edisilene Santos Zatta",true);
		User000DTO mat = new User000DTO(null,"santos","1234","00000000353","Matheus Santos Zatta",true);

		User00DTO wal1 = new User00DTO(null,"Waldyr Zatta Junior","00000000153","zatta","1234",true, true, Role.ADMIN);
		User00DTO edi1 = new User00DTO(null,"Edisilene Santos Zatta","00000000253","cila","1234",true, true, Role.USER);
		User00DTO mat1 = new User00DTO(null,"Mateus Santos Zatta","00000000353","santos","1234",true, true, Role.USER);
		
		List<User000DTO> listUser = new ArrayList<>(Arrays.asList(wal,edi,mat));
		listUser.stream()
			.forEach(w-> {listDTO.add(userServ.insertUser(w));});

		List<User00DTO> list0User = new ArrayList<>(Arrays.asList(wal1,edi1,mat1));
		list0User.stream()
		.forEach(w-> {listDto.add(user00Serv.insertUser(w));});
		
		
	
	}

}
*/