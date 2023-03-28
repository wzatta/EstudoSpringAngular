package com.cilazatta.EstudoSpringAngular.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cilazatta.EstudoSpringAngular.services.exception.FieldDataIntegrityViolationException;
import com.cilazatta.EstudoSpringAngular.services.exception.FieldNotNullException;
import com.cilazatta.EstudoSpringAngular.services.exception.GenericsExceptionError;
import com.cilazatta.EstudoSpringAngular.services.exception.ObjectNotFoundException;
import com.cilazatta.EstudoSpringAngular.services.exception.UserNameNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class ResourceExceptionHandler  {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(
				System.currentTimeMillis(),
				status.value(),
				"Registro não Encontrado",
				e.getMessage(),
				request.getRequestURI()
				);
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(FieldNotNullException.class)
	public ResponseEntity<StandardError> fieldNotNull(FieldNotNullException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(
				System.currentTimeMillis(),
				status.value(),
				"Campo Não Pode ser Nulo",
				e.getMessage(),
				request.getRequestURI()
				);
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(FieldDataIntegrityViolationException.class)
	public ResponseEntity<StandardError> fieldNotNull(FieldDataIntegrityViolationException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(
				System.currentTimeMillis(),
				status.value(),
				"Violação de Integridade - Dados Duplicado",
				e.getMessage(),
				request.getRequestURI()
				);
		return ResponseEntity.status(status).body(err);
	}
	
	
	@ExceptionHandler(UserNameNotFoundException.class)
	public ResponseEntity<StandardError> fieldNotNull(UserNameNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(
				System.currentTimeMillis(),
				status.value(),
				"Waldyr Zatta Junior",
				e.getMessage(),
				request.getRequestURI()
				);
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(GenericsExceptionError.class)
	public ResponseEntity<StandardError> genericsException(GenericsExceptionError e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(
				System.currentTimeMillis(),
				status.value(),
				"Error",
				e.getMessage(),
				request.getRequestURI()
				);
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<StandardError> genericsException(ConstraintViolationException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(
				System.currentTimeMillis(),
				status.value(),
				"Error",
				e.getMessage(),
				request.getRequestURI()
				);
		return ResponseEntity.status(status).body(err);
	}
	
	
	
	
	
	
	
}
