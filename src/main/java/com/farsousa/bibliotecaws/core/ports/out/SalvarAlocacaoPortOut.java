package com.farsousa.bibliotecaws.core.ports.out;

import com.farsousa.bibliotecaws.core.models.Alocacao;

public interface SalvarAlocacaoPortOut {
	
	public Alocacao execute(Alocacao alocacaoASerSalva);

}
