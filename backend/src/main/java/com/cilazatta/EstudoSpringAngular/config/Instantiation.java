package com.cilazatta.EstudoSpringAngular.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cilazatta.EstudoSpringAngular.entities.User000;
import com.cilazatta.EstudoSpringAngular.repositories.User000Repository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private User000Repository userRepo;
	
	@Override
	public void run(String... args) throws Exception {
    
	/*	
		userRepo.deleteAll();
		
		User000 wal = new User000(null,"zatta","1234","00000000153","Waldyr Zatta Junior",true);
		User000 edi = new User000(null,"cila","1234","00000000253","Edisilene Santos Zatta",true);
		User000 mat = new User000(null,"santos","1234","00000000353","Matheus Santos Zatta",true);
		
		userRepo.saveAll(Arrays.asList(wal,edi,mat));
	*/
	}

	
	
}
