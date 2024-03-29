package com.cilazatta.EstudoSpringAngular.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.cilazatta.EstudoSpringAngular.config.JwtService;
import com.cilazatta.EstudoSpringAngular.entities.User00;
import com.cilazatta.EstudoSpringAngular.repositories.User00Repository;
import com.cilazatta.EstudoSpringAngular.services.User00Service;
import com.cilazatta.EstudoSpringAngular.services.exception.UserNameNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final User00Repository repo;
	private final User00Service service;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public AuthenticationResponse authenticate(AuthenticationRequest request) {

		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
		var user = repo.findByUser00Name(request.getUserName()).orElseThrow(()-> new UserNameNotFoundException("Username Não Encontrado"));
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();

	}

	public AuthenticationResponse register(RegisterRequest request) {
		var user = User00.builder()
				.name(request.getName())
				.cpf(request.getCpf())
				.colab(request.getColab())
				.user00Name(request.getUserName())
				.password(request.getPassword())
				.userAtivo(request.getUserAtivo())
				.userBloqueado(request.getUserBloqueado())
				.role(request.getRole())
				.colab(request.getColab())
				.build();
		service.save(user);
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}
	


}