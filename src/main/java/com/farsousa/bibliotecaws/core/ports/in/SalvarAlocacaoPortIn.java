package com.farsousa.bibliotecaws.core.ports.in;

import com.farsousa.bibliotecaws.core.models.Alocacao;

public interface SalvarAlocacaoPortIn {
	
	public Alocacao execute(Alocacao alocacaoASerSalva);

}
