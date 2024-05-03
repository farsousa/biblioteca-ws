package com.farsousa.bibliotecaws.core.ports.in;

import java.util.List;

import com.farsousa.bibliotecaws.core.models.Alocacao;

public interface BuscarAlocacaoPortIn {
	
	List<Alocacao> todos();
	
	Alocacao porId(Long id);

}
