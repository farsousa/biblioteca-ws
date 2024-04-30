package com.farsousa.bibliotecaws.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farsousa.bibliotecaws.adapter.out.BuscarAlocacaoPersistence;
import com.farsousa.bibliotecaws.adapter.out.BuscarLivroPersistence;
import com.farsousa.bibliotecaws.adapter.out.BuscarUsuarioPersistence;
import com.farsousa.bibliotecaws.adapter.out.SalvarAlocacaoPersistence;
import com.farsousa.bibliotecaws.adapter.out.SalvarLivroPersistence;
import com.farsousa.bibliotecaws.adapter.out.SalvarUsuarioPersistence;
import com.farsousa.bibliotecaws.adapter.out.repositories.AlocacaoRepository;
import com.farsousa.bibliotecaws.adapter.out.repositories.LivroRepository;
import com.farsousa.bibliotecaws.adapter.out.repositories.UsuarioRepository;
import com.farsousa.bibliotecaws.core.ports.in.BuscarLivroPortIn;
import com.farsousa.bibliotecaws.core.ports.in.BuscarUsuarioPortIn;
import com.farsousa.bibliotecaws.core.ports.in.SalvarAlocacaoPortIn;
import com.farsousa.bibliotecaws.core.ports.in.SalvarLivroPortIn;
import com.farsousa.bibliotecaws.core.ports.in.SalvarUsuarioPortIn;
import com.farsousa.bibliotecaws.core.ports.out.BuscarAlocacaoPortOut;
import com.farsousa.bibliotecaws.core.ports.out.BuscarLivroPortOut;
import com.farsousa.bibliotecaws.core.ports.out.BuscarUsuarioPortOut;
import com.farsousa.bibliotecaws.core.ports.out.SalvarAlocacaoPortOut;
import com.farsousa.bibliotecaws.core.ports.out.SalvarLivroPortOut;
import com.farsousa.bibliotecaws.core.ports.out.SalvarUsuarioPortOut;
import com.farsousa.bibliotecaws.core.usecases.BuscarLivroUseCase;
import com.farsousa.bibliotecaws.core.usecases.BuscarUsuarioUseCase;
import com.farsousa.bibliotecaws.core.usecases.SalvarAlocacaoUseCase;
import com.farsousa.bibliotecaws.core.usecases.SalvarLivroUseCase;
import com.farsousa.bibliotecaws.core.usecases.SalvarUsuarioUseCase;

@Configuration
public class PortConfig {

	@Bean
	SalvarLivroPortIn salvarLivroPortIn(SalvarLivroPortOut salvarLivroPortOut) {
		return new SalvarLivroUseCase(salvarLivroPortOut);
	}
	
	@Bean
	SalvarLivroPortOut salvarLivroPortOut(LivroRepository livroRepository) {
		return new SalvarLivroPersistence(livroRepository);
	}
	
	@Bean
	BuscarLivroPortIn buscarLivroPortIn(BuscarLivroPortOut buscarLivroPortOut) {
		return new BuscarLivroUseCase(buscarLivroPortOut);
	}
	
	@Bean
	BuscarLivroPortOut buscarLivroPortOut(LivroRepository livroRepository) {
		return new BuscarLivroPersistence(livroRepository);
	}
	
	@Bean
	SalvarUsuarioPortIn salvarUsuarioPortIn(SalvarUsuarioPortOut salvarUsuarioPortOut) {
		return new SalvarUsuarioUseCase(salvarUsuarioPortOut);
	}
	
	@Bean
	SalvarUsuarioPortOut salvarUsuarioPortOut(UsuarioRepository usuarioRepository) {
		return new SalvarUsuarioPersistence(usuarioRepository);
	}
	
	@Bean
	BuscarUsuarioPortIn buscarUsuarioPortIn(BuscarUsuarioPortOut buscarUsuarioPortOut) {
		return new BuscarUsuarioUseCase(buscarUsuarioPortOut);
	}
	
	@Bean
	BuscarUsuarioPortOut buscarUsuarioPortOut(UsuarioRepository usuarioRepository) {
		return new BuscarUsuarioPersistence(usuarioRepository);
	}
	
	@Bean
	SalvarAlocacaoPortIn salvarAlocacaoPortIn(SalvarAlocacaoPortOut salvarAlocacaoPortOut, BuscarAlocacaoPortOut buscarAlocacaoPortOut, BuscarUsuarioPortOut buscarUsuarioPortOut, BuscarLivroPortOut buscarLivroPortOut) {
		return new SalvarAlocacaoUseCase(salvarAlocacaoPortOut, buscarAlocacaoPortOut, buscarUsuarioPortOut, buscarLivroPortOut);
	}
	
	@Bean
	SalvarAlocacaoPortOut salvarAlocacaoPortOut(AlocacaoRepository alocacaoRepository) {
		return new SalvarAlocacaoPersistence(alocacaoRepository);
	}
	
	@Bean
	BuscarAlocacaoPortOut buscarAlocacaoPortOut(AlocacaoRepository alocacaoRepository) {
		return new BuscarAlocacaoPersistence(alocacaoRepository);
	}
	
}
