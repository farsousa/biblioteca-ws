package com.farsousa.bibliotecaws.core.ports.out;

import com.farsousa.bibliotecaws.core.models.Alocacao;

public interface SalvarAlocacaoPortOut {
	
	Alocacao execute(Alocacao alocacaoASerSalva);

}
