package com.farsousa.bibliotecaws.core.usecases;

import java.util.List;
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
		return buscarLivroPortOut.porId(id);
	}

	@Override
	public List<Livro> todos() {
		return buscarLivroPortOut.todos();
	}

	
}
