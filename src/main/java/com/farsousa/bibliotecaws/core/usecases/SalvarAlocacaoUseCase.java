package com.farsousa.bibliotecaws.core.usecases;

import java.time.LocalDateTime;

import com.farsousa.bibliotecaws.core.enums.SituacaoAlocacao;
import com.farsousa.bibliotecaws.core.exceptions.ValidacaoException;
import com.farsousa.bibliotecaws.core.models.Alocacao;
import com.farsousa.bibliotecaws.core.models.Livro;
import com.farsousa.bibliotecaws.core.models.Usuario;
import com.farsousa.bibliotecaws.core.ports.in.SalvarAlocacaoPortIn;
import com.farsousa.bibliotecaws.core.ports.out.BuscarAlocacaoPortOut;
import com.farsousa.bibliotecaws.core.ports.out.BuscarLivroPortOut;
import com.farsousa.bibliotecaws.core.ports.out.BuscarUsuarioPortOut;
import com.farsousa.bibliotecaws.core.ports.out.SalvarAlocacaoPortOut;

public class SalvarAlocacaoUseCase implements SalvarAlocacaoPortIn {
	
	private final SalvarAlocacaoPortOut salvarAlocacaoPortOut;
	private final BuscarAlocacaoPortOut buscarAlocacaoPortOut;
	private final BuscarUsuarioPortOut buscarUsuarioPortOut;
	private final BuscarLivroPortOut buscarLivroPortOut;
	
	public SalvarAlocacaoUseCase(SalvarAlocacaoPortOut salvarAlocacaoPortOut, BuscarAlocacaoPortOut buscarAlocacaoPortOut, BuscarUsuarioPortOut buscarUsuarioPortOut, BuscarLivroPortOut buscarLivroPortOut) {
		this.salvarAlocacaoPortOut = salvarAlocacaoPortOut;
		this.buscarAlocacaoPortOut = buscarAlocacaoPortOut;
		this.buscarUsuarioPortOut = buscarUsuarioPortOut;
		this.buscarLivroPortOut = buscarLivroPortOut;
	}

	@Override
	public Alocacao execute(Alocacao alocacaoASerSalva) {
		Usuario usuario = buscarUsuarioPortOut.porId(alocacaoASerSalva.getUsuario().getId());
		alocacaoASerSalva.setUsuario(usuario);		
		
		Livro livro = buscarLivroPortOut.porId(alocacaoASerSalva.getLivro().getId());
		alocacaoASerSalva.setLivro(livro);
		
		int quantidadeAlocacoesPendentesParaUsuario = buscarAlocacaoPortOut.quantidadeAlocacoesPendentesParaUsuario(alocacaoASerSalva.getUsuario().getId());
		if(quantidadeAlocacoesPendentesParaUsuario > 0) {
			throw new ValidacaoException("Usuário possui alocações pendentes!");
		}
		
		int quantidadeAlocacaoAtivasDeLivrosParaUsuario = buscarAlocacaoPortOut.quantidadeAlocacaoAtivasDeLivrosParaUsuario(alocacaoASerSalva.getUsuario().getId(), alocacaoASerSalva.getLivro().getId());
		if(quantidadeAlocacaoAtivasDeLivrosParaUsuario > 0) {
			throw new ValidacaoException("Usuário já possui alocações ativas deste livro!");
		}
		
		int quantidadeAlocacoesAtivasDeLivro = buscarAlocacaoPortOut.quantidadeAlocacoesAtivasDeLivro(alocacaoASerSalva.getLivro().getId());
		if(quantidadeAlocacoesAtivasDeLivro >= livro.getQuantidade()) {
			throw new ValidacaoException("Não há disponibilidade para este livro, pois a quantidade foi esgotada!");
		}
		
		alocacaoASerSalva.setDataAlocacao(LocalDateTime.now());
		alocacaoASerSalva.setDataPrevistaDevolucao(LocalDateTime.now().plusDays(5));
		alocacaoASerSalva.setSituacao(SituacaoAlocacao.ALOCACAO_REGULAR);
		
		return salvarAlocacaoPortOut.execute(alocacaoASerSalva);
	}
	
}
