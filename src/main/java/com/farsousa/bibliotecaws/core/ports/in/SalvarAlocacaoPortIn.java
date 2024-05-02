package com.farsousa.bibliotecaws.core.ports.in;

import com.farsousa.bibliotecaws.core.models.Alocacao;

public interface SalvarAlocacaoPortIn {
	
	Alocacao execute(Alocacao alocacaoASerSalva);

}
