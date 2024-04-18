package com.farsousa.bibliotecaws.adapter.out;

import com.farsousa.bibliotecaws.adapter.out.entities.LivroEntity;
import com.farsousa.bibliotecaws.adapter.out.repositories.LivroRepository;
import com.farsousa.bibliotecaws.core.models.Livro;
import com.farsousa.bibliotecaws.core.ports.out.SalvarLivroPortOut;

public class SalvarLivroPersistence implements SalvarLivroPortOut {
	
	private LivroRepository livroRepository;
	
	public SalvarLivroPersistence(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@Override
	public Livro execute(Livro livro) {		
		LivroEntity livroEntity = LivroEntity.fromModel(livro);	
		
		return livroRepository.save(livroEntity).toModel();
	}

}
