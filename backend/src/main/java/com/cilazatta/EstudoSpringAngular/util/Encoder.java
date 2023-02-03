
package com.cilazatta.EstudoSpringAngular.util;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Encoder {
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
		return encode;
	}
}
