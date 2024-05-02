package com.farsousa.bibliotecaws.core.usecases;

import java.util.List;
import java.util.Optional;

import com.farsousa.bibliotecaws.core.enums.MensagemAplicacao;
import com.farsousa.bibliotecaws.core.exceptions.NaoEncontradoException;
import com.farsousa.bibliotecaws.core.models.Alocacao;
import com.farsousa.bibliotecaws.core.ports.in.BuscarAlocacaoPortIn;
import com.farsousa.bibliotecaws.core.ports.out.BuscarAlocacaoPortOut;

public class BuscarAlocacaoUseCase implements BuscarAlocacaoPortIn {
	
	private final BuscarAlocacaoPortOut buscarAlocacaoPortOut;
	
	public BuscarAlocacaoUseCase(BuscarAlocacaoPortOut buscarAlocacaoPortOut) {
		this.buscarAlocacaoPortOut = buscarAlocacaoPortOut;
	}

	@Override
	public int quantidadeAlocacoesPendentesParaUsuario(Long idUsuario) {
		return buscarAlocacaoPortOut.quantidadeAlocacoesPendentesParaUsuario(idUsuario);
	}

	@Override
	public int quantidadeAlocacoesAtivasDeLivro(Long idLivro) {
		return buscarAlocacaoPortOut.quantidadeAlocacoesAtivasDeLivro(idLivro);
	}

	@Override
	public int quantidadeAlocacaoAtivasDeLivrosParaUsuario(Long idUsuario, Long idLivro) {
		return buscarAlocacaoPortOut.quantidadeAlocacaoAtivasDeLivrosParaUsuario(idUsuario, idLivro);
	}

	@Override
	public List<Alocacao> todos() {
		List<Alocacao> alocacoes = buscarAlocacaoPortOut.todos();
		
		if(alocacoes.isEmpty()) {
			throw new NaoEncontradoException(MensagemAplicacao.ALOCACAO_NENHUM_REGISTRO.getMensagem());
		}
		
		return alocacoes;
	}

	@Override
	public Alocacao porId(Long id) {
		Optional<Alocacao> alocacao = buscarAlocacaoPortOut.porId(id);
		
		if(alocacao.isEmpty()) {
			throw new NaoEncontradoException(MensagemAplicacao.ALOCACAO_NAO_ENCONTRADA.getMensagem());
		}
		
		return alocacao.get();
	}

	
}
