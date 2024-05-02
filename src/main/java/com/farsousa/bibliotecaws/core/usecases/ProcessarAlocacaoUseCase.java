package com.farsousa.bibliotecaws.core.usecases;

import java.time.LocalDateTime;
import java.util.List;

import com.farsousa.bibliotecaws.core.enums.SituacaoAlocacao;
import com.farsousa.bibliotecaws.core.models.Alocacao;
import com.farsousa.bibliotecaws.core.ports.in.BuscarAlocacaoPortIn;
import com.farsousa.bibliotecaws.core.ports.in.ProcessarAlocacaoPortIn;
import com.farsousa.bibliotecaws.core.ports.out.AtualizarAlocacaoPortOut;

public class ProcessarAlocacaoUseCase implements ProcessarAlocacaoPortIn {
	
	private final BuscarAlocacaoPortIn buscarAlocacaoPortIn;
	private final AtualizarAlocacaoPortOut atualizarAlocacaoPortOut;
	
	public ProcessarAlocacaoUseCase(BuscarAlocacaoPortIn buscarAlocacaoPortIn, AtualizarAlocacaoPortOut atualizarAlocacaoPortOut) {
		this.buscarAlocacaoPortIn = buscarAlocacaoPortIn;
		this.atualizarAlocacaoPortOut = atualizarAlocacaoPortOut;
	}

	@Override
	public void verificarPendenciasTodos() {
		List<Alocacao> alocacoes = buscarAlocacaoPortIn.todos();		
		alocacoes.stream().forEach(alocacao -> {
			alocacao = verificarPendencias(alocacao);
			atualizarAlocacaoPortOut.execute(alocacao);
		});			
	}

	@Override
	public void verificarPendenciasPorId(Long id) {
		Alocacao alocacao = buscarAlocacaoPortIn.porId(id);
		alocacao = verificarPendencias(alocacao);	
		atualizarAlocacaoPortOut.execute(alocacao);
	}

	@Override
	public void registrarDevolucaoPorId(Long id) {
		Alocacao alocacao = buscarAlocacaoPortIn.porId(id);
		alocacao.setDataDevolucao(LocalDateTime.now());		
		atualizarAlocacaoPortOut.execute(alocacao);
		verificarPendenciasPorId(id);
	}
	
	private Alocacao verificarPendencias(Alocacao alocacao) {
		boolean foiDevolvido = alocacao.getDataDevolucao() != null;						
		if(foiDevolvido) {
			boolean temAtrasoNaDevolucao = alocacao.getDataDevolucao().isAfter(alocacao.getDataPrevistaDevolucao());
			if(temAtrasoNaDevolucao) {
				alocacao.setSituacao(SituacaoAlocacao.DEVOLUCAO_COM_ATRASO);
			}else {
				alocacao.setSituacao(SituacaoAlocacao.DEVOLUCAO_REGULAR);
			}				
		}else {
			boolean temAtrasoNaDevolucaoPrevista = LocalDateTime.now().isAfter(alocacao.getDataPrevistaDevolucao());
			if(temAtrasoNaDevolucaoPrevista) {
				alocacao.setSituacao(SituacaoAlocacao.ALOCACAO_COM_ATRASO);
			}else {
				alocacao.setSituacao(SituacaoAlocacao.ALOCACAO_REGULAR);
			}
		}	
		return alocacao;
	}
		
}
