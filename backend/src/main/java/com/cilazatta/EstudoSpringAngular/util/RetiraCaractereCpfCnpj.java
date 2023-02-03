package com.cilazatta.EstudoSpringAngular.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetiraCaractereCpfCnpj {

	    private String cpf;
	    private String cnpj;

	    public static String retiraCaractCpf(String cpf) {

	        if (!cpf.isEmpty() && cpf != null) {

	            String cpfA = cpf.replace(".", "");
	            String cpfB = cpfA.replace("-", "");
	            cpf = cpfB.trim();

	            return cpf;

	        } else {

	            return cpf;
	        }
	    }

	    public static String retiraCaractCnpj(String cnpj) {

	        if (!cnpj.isEmpty() && cnpj != null) {

	            String cnpjA = cnpj.replace(".", "");
	            String cnpjB = cnpjA.replace("-", "");
	            cnpjA = cnpjB.replace("/", "");
	            cnpj = cnpjA.trim();

	            return cnpj;

	        } else {

	            return cnpj;
	        }

	    }

	

	
	
	
	
	
}
