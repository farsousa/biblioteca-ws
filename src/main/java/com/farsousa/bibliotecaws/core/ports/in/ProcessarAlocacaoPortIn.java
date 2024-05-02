package com.farsousa.bibliotecaws.core.ports.in;

public interface ProcessarAlocacaoPortIn {
	
	void verificarPendenciasTodos();
	
	void verificarPendenciasPorId(Long id);
	
	void registrarDevolucaoPorId(Long id);

}
