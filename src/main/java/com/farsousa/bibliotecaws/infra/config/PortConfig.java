package com.farsousa.bibliotecaws.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farsousa.bibliotecaws.adapter.out.BuscarLivroPersistence;
import com.farsousa.bibliotecaws.adapter.out.SalvarLivroPersistence;
import com.farsousa.bibliotecaws.adapter.out.repositories.LivroRepository;
import com.farsousa.bibliotecaws.core.ports.in.BuscarLivroPortIn;
import com.farsousa.bibliotecaws.core.ports.in.SalvarLivroPortIn;
import com.farsousa.bibliotecaws.core.ports.out.BuscarLivroPortOut;
import com.farsousa.bibliotecaws.core.ports.out.SalvarLivroPortOut;
import com.farsousa.bibliotecaws.core.usecases.BuscarLivroUseCase;
import com.farsousa.bibliotecaws.core.usecases.SalvarLivroUseCase;

@Configuration
public class PortConfig {

	@Bean
	SalvarLivroPortIn salvarLivroPortIn(SalvarLivroPortOut salvarLivroPortIn) {
		return new SalvarLivroUseCase(salvarLivroPortIn);
	}
	
	@Bean
	SalvarLivroPortOut salvarLivroPortOut(LivroRepository livroRepository) {
		return new SalvarLivroPersistence(livroRepository);
	}
	
	@Bean
	BuscarLivroPortIn buscarLivroPortIn(BuscarLivroPortOut buscarLivroPortIn) {
		return new BuscarLivroUseCase(buscarLivroPortIn);
	}
	
	@Bean
	BuscarLivroPortOut buscarLivroPortOut(LivroRepository livroRepository) {
		return new BuscarLivroPersistence(livroRepository);
	}
	
}
