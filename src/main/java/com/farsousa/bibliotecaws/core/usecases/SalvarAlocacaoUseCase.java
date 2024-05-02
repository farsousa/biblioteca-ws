package com.farsousa.bibliotecaws.core.usecases;

import java.time.LocalDateTime;

import com.farsousa.bibliotecaws.core.enums.MensagemAplicacao;
import com.farsousa.bibliotecaws.core.enums.QuantitativoAplicacao;
import com.farsousa.bibliotecaws.core.enums.SituacaoAlocacao;
import com.farsousa.bibliotecaws.core.exceptions.ValidacaoException;
import com.farsousa.bibliotecaws.core.models.Alocacao;
import com.farsousa.bibliotecaws.core.models.Livro;
import com.farsousa.bibliotecaws.core.models.Usuario;
import com.farsousa.bibliotecaws.core.ports.in.BuscarAlocacaoPortIn;
import com.farsousa.bibliotecaws.core.ports.in.BuscarLivroPortIn;
import com.farsousa.bibliotecaws.core.ports.in.BuscarUsuarioPortIn;
import com.farsousa.bibliotecaws.core.ports.in.SalvarAlocacaoPortIn;
import com.farsousa.bibliotecaws.core.ports.out.SalvarAlocacaoPortOut;

public class SalvarAlocacaoUseCase implements SalvarAlocacaoPortIn {
	
	private final SalvarAlocacaoPortOut portOut;
	private final BuscarAlocacaoPortIn buscarAlocacaoPortIn;
	private final BuscarUsuarioPortIn buscarUsuarioPortIn;
	private final BuscarLivroPortIn buscarLivroPortIn;
	
	public SalvarAlocacaoUseCase(SalvarAlocacaoPortOut portOut, BuscarAlocacaoPortIn buscarAlocacaoPortIn, BuscarUsuarioPortIn buscarUsuarioPortIn, BuscarLivroPortIn buscarLivroPortIn) {
		this.portOut = portOut;
		this.buscarAlocacaoPortIn = buscarAlocacaoPortIn;
		this.buscarUsuarioPortIn = buscarUsuarioPortIn;
		this.buscarLivroPortIn = buscarLivroPortIn;
	}

	@Override
	public Alocacao execute(Alocacao alocacaoASerSalva) {		
		Usuario usuario = buscarUsuarioPortIn.porId(alocacaoASerSalva.getUsuario().getId());
		alocacaoASerSalva.setUsuario(usuario);		
		
		Livro livro = buscarLivroPortIn.porId(alocacaoASerSalva.getLivro().getId());
		alocacaoASerSalva.setLivro(livro);
		
		int quantidadeAlocacoesPendentesParaUsuario = buscarAlocacaoPortIn.quantidadeAlocacoesPendentesParaUsuario(alocacaoASerSalva.getUsuario().getId());
		if(quantidadeAlocacoesPendentesParaUsuario > 0) {
			throw new ValidacaoException(MensagemAplicacao.ALOCACAO_USUARIO_PENDENTE.getMensagem());
		}
		
		int quantidadeAlocacaoAtivasDeLivrosParaUsuario = buscarAlocacaoPortIn.quantidadeAlocacaoAtivasDeLivrosParaUsuario(alocacaoASerSalva.getUsuario().getId(), alocacaoASerSalva.getLivro().getId());
		if(quantidadeAlocacaoAtivasDeLivrosParaUsuario > 0) {
			throw new ValidacaoException(MensagemAplicacao.ALOCACAO_LIVRO_ALOCADO.getMensagem());
		}
		
		int quantidadeAlocacoesAtivasDeLivro = buscarAlocacaoPortIn.quantidadeAlocacoesAtivasDeLivro(alocacaoASerSalva.getLivro().getId());
		if(quantidadeAlocacoesAtivasDeLivro + QuantitativoAplicacao.QUANTIDADE_DE_LIVRO_QUE_DEVE_FICAR_NA_BIBLIOTECA.getQuantidade() >= livro.getQuantidade()) {
			throw new ValidacaoException(MensagemAplicacao.ALOCACAO_LIVRO_INDISPONIVEL_QUANTIDADE_ESGOTADA.getMensagem());
		}
		
		alocacaoASerSalva.setDataAlocacao(LocalDateTime.now());
		alocacaoASerSalva.setDataPrevistaDevolucao(LocalDateTime.now().plusDays(5));
		alocacaoASerSalva.setSituacao(SituacaoAlocacao.ALOCACAO_REGULAR);
		
		return portOut.execute(alocacaoASerSalva);
	}
	
}
