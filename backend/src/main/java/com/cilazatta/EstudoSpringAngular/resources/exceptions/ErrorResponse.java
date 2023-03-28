package com.cilazatta.EstudoSpringAngular.resources.exceptions;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

	private  String message;
	private   int code;
	private  String status;
	private  String objectName;
	private  List<ErrorObject> errors;
 	
}
