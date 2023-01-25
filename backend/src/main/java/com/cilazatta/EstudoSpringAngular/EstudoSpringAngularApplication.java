package com.cilazatta.EstudoSpringAngular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EstudoSpringAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstudoSpringAngularApplication.class, args);
	}

}
