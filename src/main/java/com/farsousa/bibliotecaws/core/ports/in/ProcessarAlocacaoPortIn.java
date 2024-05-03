package com.farsousa.bibliotecaws.core.ports.in;

import com.farsousa.bibliotecaws.core.models.Alocacao;

public interface ProcessarAlocacaoPortIn {
	
	void registrarDevolucao(Alocacao alocacao);
	
	void calcularAtrasoMultaJuros(Alocacao alocacao);

}
