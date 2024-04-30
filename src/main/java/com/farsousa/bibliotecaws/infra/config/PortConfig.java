package com.farsousa.bibliotecaws.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farsousa.bibliotecaws.adapter.out.BuscarLivroPersistence;
import com.farsousa.bibliotecaws.adapter.out.BuscarUsuarioPersistence;
import com.farsousa.bibliotecaws.adapter.out.SalvarLivroPersistence;
import com.farsousa.bibliotecaws.adapter.out.SalvarUsuarioPersistence;
import com.farsousa.bibliotecaws.adapter.out.repositories.LivroRepository;
import com.farsousa.bibliotecaws.adapter.out.repositories.UsuarioRepository;
import com.farsousa.bibliotecaws.core.ports.in.BuscarLivroPortIn;
import com.farsousa.bibliotecaws.core.ports.in.BuscarUsuarioPortIn;
import com.farsousa.bibliotecaws.core.ports.in.SalvarLivroPortIn;
import com.farsousa.bibliotecaws.core.ports.in.SalvarUsuarioPortIn;
import com.farsousa.bibliotecaws.core.ports.out.BuscarLivroPortOut;
import com.farsousa.bibliotecaws.core.ports.out.BuscarUsuarioPortOut;
import com.farsousa.bibliotecaws.core.ports.out.SalvarLivroPortOut;
import com.farsousa.bibliotecaws.core.ports.out.SalvarUsuarioPortOut;
import com.farsousa.bibliotecaws.core.usecases.BuscarLivroUseCase;
import com.farsousa.bibliotecaws.core.usecases.BuscarUsuarioUseCase;
import com.farsousa.bibliotecaws.core.usecases.SalvarLivroUseCase;
import com.farsousa.bibliotecaws.core.usecases.SalvarUsuarioUseCase;

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
	
	@Bean
	SalvarUsuarioPortIn salvarUsuarioPortIn(SalvarUsuarioPortOut salvarUsuarioPortIn) {
		return new SalvarUsuarioUseCase(salvarUsuarioPortIn);
	}
	
	@Bean
	SalvarUsuarioPortOut salvarUsuarioPortOut(UsuarioRepository usuarioRepository) {
		return new SalvarUsuarioPersistence(usuarioRepository);
	}
	
	@Bean
	BuscarUsuarioPortIn buscarUsuarioPortIn(BuscarUsuarioPortOut buscarUsuarioPortIn) {
		return new BuscarUsuarioUseCase(buscarUsuarioPortIn);
	}
	
	@Bean
	BuscarUsuarioPortOut buscarUsuarioPortOut(UsuarioRepository usuarioRepository) {
		return new BuscarUsuarioPersistence(usuarioRepository);
	}
	
}
