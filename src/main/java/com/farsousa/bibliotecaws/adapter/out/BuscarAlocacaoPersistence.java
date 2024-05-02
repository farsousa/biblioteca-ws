package com.farsousa.bibliotecaws.adapter.out;

import java.util.List;
import java.util.Optional;

import com.farsousa.bibliotecaws.adapter.out.entities.AlocacaoEntity;
import com.farsousa.bibliotecaws.adapter.out.repositories.AlocacaoRepository;
import com.farsousa.bibliotecaws.core.enums.SituacaoAlocacao;
import com.farsousa.bibliotecaws.core.models.Alocacao;
import com.farsousa.bibliotecaws.core.ports.out.BuscarAlocacaoPortOut;

public class BuscarAlocacaoPersistence implements BuscarAlocacaoPortOut {
	
	private AlocacaoRepository alocacaoRepository;
	
	public BuscarAlocacaoPersistence(AlocacaoRepository alocacaoRepository) {
		this.alocacaoRepository = alocacaoRepository;
	}

	@Override
	public int quantidadeAlocacoesPendentesParaUsuario(Long idUsuario) {
		return alocacaoRepository.countByUsuarioIdAndSituacao(idUsuario, SituacaoAlocacao.ALOCACAO_COM_ATRASO)
				+ alocacaoRepository.countByUsuarioIdAndSituacao(idUsuario, SituacaoAlocacao.DEVOLUCAO_COM_ATRASO);
	}

	@Override
	public int quantidadeAlocacoesAtivasDeLivro(Long idLivro) {
		return alocacaoRepository.countByLivroIdAndSituacao(idLivro, SituacaoAlocacao.ALOCACAO_REGULAR)
				+ alocacaoRepository.countByLivroIdAndSituacao(idLivro, SituacaoAlocacao.ALOCACAO_COM_ATRASO);
	}

	@Override
	public int quantidadeAlocacaoAtivasDeLivrosParaUsuario(Long idUsuario, Long idLivro) {
		return alocacaoRepository.countByLivroIdAndUsuarioIdAndSituacao(idLivro, idUsuario, SituacaoAlocacao.ALOCACAO_REGULAR)
				+ alocacaoRepository.countByLivroIdAndUsuarioIdAndSituacao(idLivro, idUsuario, SituacaoAlocacao.ALOCACAO_COM_ATRASO);
	}

	@Override
	public List<Alocacao> todos() {
		return alocacaoRepository.findAll().stream().map(AlocacaoEntity::toModel).toList();
	}

	@Override
	public Optional<Alocacao> porId(Long id) {
		Optional<AlocacaoEntity> alocacaoEntity = alocacaoRepository.findById(id);
		
		if(alocacaoEntity.isEmpty()) {
			return Optional.empty();
		}
		
		return Optional.of(alocacaoEntity.get().toModel());
	}



	

}
