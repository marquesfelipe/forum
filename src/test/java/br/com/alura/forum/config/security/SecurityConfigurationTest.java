package br.com.alura.forum.config.security;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityConfigurationTest {
	
	@Test
	public void deveGerarSenhaEncriptada() {
		String hash = new BCryptPasswordEncoder().encode("123789");
		System.out.println(hash);
	}
	

}
