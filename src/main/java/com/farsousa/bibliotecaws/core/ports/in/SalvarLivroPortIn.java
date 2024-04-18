package com.farsousa.bibliotecaws.core.ports.in;

import com.farsousa.bibliotecaws.core.models.Livro;

public interface SalvarLivroPortIn {
	
	public Livro execute(Livro livroASalvar);

}
