package com.farsousa.bibliotecaws.core.usecases;

import com.farsousa.bibliotecaws.core.enums.MensagemAplicacao;
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
		if(livroASalvar.getTitulo() == null) {
			throw new ValidacaoException(MensagemAplicacao.LIVRO_TITULO_OBRIGATORIO.getMensagem());
		}
		
		if(livroASalvar.getDescricao() == null) {
			throw new ValidacaoException(MensagemAplicacao.LIVRO_DESCRICAO_OBRIGATORIO.getMensagem());
		}
		
		if(livroASalvar.getAutor() == null) {
			throw new ValidacaoException(MensagemAplicacao.LIVRO_AUTOR_OBRIGATORIO.getMensagem());
		}
		
		if(livroASalvar.getQuantidade() == null) {
			throw new ValidacaoException(MensagemAplicacao.LIVRO_QUANTIDADE_OBRIGATORIO.getMensagem());
		}
		
		return salvarLivroPortOut.execute(livroASalvar);
	}
	
}
