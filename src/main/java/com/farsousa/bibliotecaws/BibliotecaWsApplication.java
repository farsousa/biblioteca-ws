package com.farsousa.bibliotecaws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BibliotecaWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaWsApplication.class, args);
	}

}
