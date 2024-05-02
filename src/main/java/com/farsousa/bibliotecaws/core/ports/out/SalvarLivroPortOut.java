package com.farsousa.bibliotecaws.core.ports.out;

import com.farsousa.bibliotecaws.core.models.Livro;

public interface SalvarLivroPortOut {
	
	Livro execute(Livro livroASalvar);

}
