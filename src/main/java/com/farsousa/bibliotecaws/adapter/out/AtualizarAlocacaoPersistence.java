package com.farsousa.bibliotecaws.adapter.out;

import java.time.LocalDateTime;
import java.util.Optional;

import com.farsousa.bibliotecaws.adapter.out.entities.AlocacaoEntity;
import com.farsousa.bibliotecaws.adapter.out.repositories.AlocacaoRepository;
import com.farsousa.bibliotecaws.core.enums.SituacaoAlocacao;
import com.farsousa.bibliotecaws.core.models.Alocacao;
import com.farsousa.bibliotecaws.core.ports.out.AtualizarAlocacaoPortOut;

public class AtualizarAlocacaoPersistence implements AtualizarAlocacaoPortOut {
	
	private AlocacaoRepository alocacaoRepository;
	
	public AtualizarAlocacaoPersistence(AlocacaoRepository alocacaoRepository) {
		this.alocacaoRepository = alocacaoRepository;
	}

	@Override
	public Alocacao execute(Alocacao alocacaoASerAtualizada) {
		Optional<AlocacaoEntity> alocacaoEntity = alocacaoRepository.findById(alocacaoASerAtualizada.getId());
		
		if(alocacaoEntity.isEmpty()) {
			return null;
		}
		
		LocalDateTime dataDevolucacao = (LocalDateTime) obterValorParaAtualizacao(alocacaoASerAtualizada.getDataDevolucao(), alocacaoEntity.get().getDataDevolucao());
		SituacaoAlocacao situacao = (SituacaoAlocacao) obterValorParaAtualizacao(alocacaoASerAtualizada.getSituacao(), alocacaoEntity.get().getSituacao());
				
		alocacaoEntity.get().setDataDevolucao(dataDevolucacao);
		alocacaoEntity.get().setSituacao(situacao);
		
		return alocacaoRepository.save(alocacaoEntity.get()).toModel();
	}
	
	private Object obterValorParaAtualizacao(Object valorASerAtualizado, Object valorAtual) {
		return valorASerAtualizado != null ? valorASerAtualizado : valorAtual;
	}

	

}
