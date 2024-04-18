package com.farsousa.bibliotecaws.core.ports.in;

import java.util.List;

import com.farsousa.bibliotecaws.core.models.Livro;

public interface BuscarLivroPortIn {
	
	public Livro porId(Long id);
	
	public List<Livro> todos();

}
