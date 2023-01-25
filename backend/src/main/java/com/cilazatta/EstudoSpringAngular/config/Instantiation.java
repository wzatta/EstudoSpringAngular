package com.cilazatta.EstudoSpringAngular.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cilazatta.EstudoSpringAngular.dto.User000DTO;
import com.cilazatta.EstudoSpringAngular.repositories.User000Repository;
import com.cilazatta.EstudoSpringAngular.services.User000Service;
/*
@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private User000Repository userRepo;
	
	@Autowired
	private User000Service userServ;
	
	@Override
	public void run(String... args) throws Exception {
		
	
		List<User000DTO> listDTO = new ArrayList<>();
		userRepo.deleteAll();
		
		User000DTO wal = new User000DTO(null,"zatta","1234","00000000153","Waldyr Zatta Junior",true);
		User000DTO edi = new User000DTO(null,"cila","1234","00000000253","Edisilene Santos Zatta",true);
		User000DTO mat = new User000DTO(null,"santos","1234","00000000353","Matheus Santos Zatta",true);
		
		
		List<User000DTO> listUser = new ArrayList<>(Arrays.asList(wal,edi,mat));
		listUser.stream()
			.forEach(w-> {listDTO.add(userServ.insertUser(w));});
		
		
	
	}

}
*/