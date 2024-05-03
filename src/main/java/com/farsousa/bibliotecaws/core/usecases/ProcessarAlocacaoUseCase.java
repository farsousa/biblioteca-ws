package com.farsousa.bibliotecaws.core.usecases;

import java.time.LocalDateTime;

import com.farsousa.bibliotecaws.core.enums.SituacaoAlocacao;
import com.farsousa.bibliotecaws.core.exceptions.ValidacaoException;
import com.farsousa.bibliotecaws.core.models.Alocacao;
import com.farsousa.bibliotecaws.core.ports.in.ProcessarAlocacaoPortIn;
import com.farsousa.bibliotecaws.core.ports.out.AtualizarAlocacaoPortOut;

public class ProcessarAlocacaoUseCase implements ProcessarAlocacaoPortIn {
	
	private final AtualizarAlocacaoPortOut atualizarAlocacaoPortOut;
	
	public ProcessarAlocacaoUseCase(AtualizarAlocacaoPortOut atualizarAlocacaoPortOut) {
		this.atualizarAlocacaoPortOut = atualizarAlocacaoPortOut;
	}

	@Override
	public void registrarDevolucao(Alocacao alocacao) {		
		if(alocacao.getDataDevolucao() != null) {
			throw new ValidacaoException("Alocação já devolvida!");
		}
		
		alocacao.setDataDevolucao(LocalDateTime.now());
		calcularAtrasoMultaJuros(alocacao);
		
		atualizarAlocacaoPortOut.execute(alocacao);
	}

	@Override
	public void calcularAtrasoMultaJuros(Alocacao alocacao) {		
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
		
		atualizarAlocacaoPortOut.execute(alocacao);
	}
	
}
