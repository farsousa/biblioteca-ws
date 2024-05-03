package com.farsousa.bibliotecaws.core.usecases;

import java.util.List;
import java.util.Optional;
import com.farsousa.bibliotecaws.core.enums.MensagemAplicacao;
import com.farsousa.bibliotecaws.core.exceptions.NaoEncontradoException;
import com.farsousa.bibliotecaws.core.models.Alocacao;
import com.farsousa.bibliotecaws.core.ports.in.ProcessarAlocacaoPortIn;
import com.farsousa.bibliotecaws.core.ports.in.BuscarAlocacaoPortIn;
import com.farsousa.bibliotecaws.core.ports.out.BuscarAlocacaoPortOut;

public class BuscarAlocacaoUseCase implements BuscarAlocacaoPortIn {
	
	private final BuscarAlocacaoPortOut buscarAlocacaoPortOut;
	private final ProcessarAlocacaoPortIn processarAlocacaoPortIn;
	
	public BuscarAlocacaoUseCase(BuscarAlocacaoPortOut buscarAlocacaoPortOut, ProcessarAlocacaoPortIn processarAlocacaoPortIn) {
		this.buscarAlocacaoPortOut = buscarAlocacaoPortOut;
		this.processarAlocacaoPortIn = processarAlocacaoPortIn;
	}

	@Override
	public List<Alocacao> todos() {
		List<Alocacao> alocacoes = buscarAlocacaoPortOut.todos().stream().map(obj -> {
			processarAlocacaoPortIn.calcularAtrasoMultaJuros(obj);
			return obj;
		}).toList();
		
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
		
		processarAlocacaoPortIn.calcularAtrasoMultaJuros(alocacao.get());
		
		return alocacao.get();
	}

	
}
