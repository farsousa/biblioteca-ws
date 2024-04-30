package com.farsousa.bibliotecaws.adapter.out;

import com.farsousa.bibliotecaws.adapter.out.entities.AlocacaoEntity;
import com.farsousa.bibliotecaws.adapter.out.repositories.AlocacaoRepository;
import com.farsousa.bibliotecaws.core.models.Alocacao;
import com.farsousa.bibliotecaws.core.ports.out.SalvarAlocacaoPortOut;

public class SalvarAlocacaoPersistence implements SalvarAlocacaoPortOut {
	
	private AlocacaoRepository alocacaoRepository;
	
	public SalvarAlocacaoPersistence(AlocacaoRepository alocacaoRepository) {
		this.alocacaoRepository = alocacaoRepository;
	}

	@Override
	public Alocacao execute(Alocacao alocacaoASerSalva) {		
		AlocacaoEntity alocacaoEntity = AlocacaoEntity.fromModel(alocacaoASerSalva);	
		
		return alocacaoRepository.save(alocacaoEntity).toModel();
	}

}
