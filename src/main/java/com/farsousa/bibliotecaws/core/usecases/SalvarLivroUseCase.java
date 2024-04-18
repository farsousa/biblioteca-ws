package com.farsousa.bibliotecaws.core.usecases;

import com.farsousa.bibliotecaws.core.exceptions.ValidacaoException;
import com.farsousa.bibliotecaws.core.models.Livro;
import com.farsousa.bibliotecaws.core.ports.in.SalvarLivroPortIn;
import com.farsousa.bibliotecaws.core.ports.out.SalvarLivroPortOut;

public class SalvarLivroUseCase implements SalvarLivroPortIn {
	
	private final SalvarLivroPortOut salvarLivroPortOut;
	
	public SalvarLivroUseCase(SalvarLivroPortOut salvarLivroPortOut) {
		this.salvarLivroPortOut = salvarLivroPortOut;
	}

	@Override
	public Livro execute(Livro livroASalvar) {		
		if(livroASalvar.getDescricao() == null) {
			throw new ValidacaoException("Descrição do livro é obrigatório!");
		}
		
		if(livroASalvar.getAutor() == null) {
			throw new ValidacaoException("Autor do livro é obrigatório!");
		}
		
		return salvarLivroPortOut.execute(livroASalvar);
	}
	
}
