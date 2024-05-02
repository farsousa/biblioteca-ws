package com.farsousa.bibliotecaws.core.usecases;

import java.util.List;
import java.util.Optional;

import com.farsousa.bibliotecaws.core.enums.MensagemAplicacao;
import com.farsousa.bibliotecaws.core.exceptions.NaoEncontradoException;
import com.farsousa.bibliotecaws.core.models.Livro;
import com.farsousa.bibliotecaws.core.ports.in.BuscarLivroPortIn;
import com.farsousa.bibliotecaws.core.ports.out.BuscarLivroPortOut;

public class BuscarLivroUseCase implements BuscarLivroPortIn {
	
	private final BuscarLivroPortOut buscarLivroPortOut;
	
	public BuscarLivroUseCase(BuscarLivroPortOut buscarLivroPortOut) {
		this.buscarLivroPortOut = buscarLivroPortOut;
	}

	@Override
	public Livro porId(Long id) {
		Optional<Livro> livro = buscarLivroPortOut.porId(id);
		
		if(livro.isEmpty()) {
			throw new NaoEncontradoException(MensagemAplicacao.LIVRO_NAO_ENCONTRADO.getMensagem());
		}
		
		return livro.get();
	}

	@Override
	public List<Livro> todos() {
		List<Livro> livros = buscarLivroPortOut.todos();
		
		if(livros.isEmpty()) {
			throw new NaoEncontradoException(MensagemAplicacao.LIVRO_NENHUM_REGISTRO.getMensagem());
		}
		
		return livros;
	}

	
}
