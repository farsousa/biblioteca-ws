package com.farsousa.bibliotecaws.core.ports.out;

import java.util.List;
import java.util.Optional;

import com.farsousa.bibliotecaws.core.models.Livro;

public interface BuscarLivroPortOut {
	
	Optional<Livro> porId(Long id);
	
	List<Livro> todos();

}
