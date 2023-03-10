package com.cilazatta.EstudoSpringAngular.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cilazatta.EstudoSpringAngular.auth.AuthenticationRequest;
import com.cilazatta.EstudoSpringAngular.auth.AuthenticationResponse;
import com.cilazatta.EstudoSpringAngular.auth.AuthenticationService;
//import com.cilazatta.EstudoSpringAngular.auth.RegisterRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value="/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationResource {
	
	@Autowired
	private final AuthenticationService service;

	@PostMapping(value="/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(
			@RequestBody AuthenticationRequest request
			){
		return ResponseEntity.ok(service.authenticate(request));
	}
	
/*	@PostMapping(value="/register")
	public ResponseEntity<AuthenticationResponse> register(
			@RequestBody RegisterRequest request
			){
		return ResponseEntity.ok(service.register(request));
	}*/
	
	
}
