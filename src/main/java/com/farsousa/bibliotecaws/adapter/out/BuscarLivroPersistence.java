package com.farsousa.bibliotecaws.adapter.out;

import java.util.List;
import java.util.Optional;

import com.farsousa.bibliotecaws.adapter.out.entities.LivroEntity;
import com.farsousa.bibliotecaws.adapter.out.repositories.LivroRepository;
import com.farsousa.bibliotecaws.core.models.Livro;
import com.farsousa.bibliotecaws.core.ports.out.BuscarLivroPortOut;

public class BuscarLivroPersistence implements BuscarLivroPortOut {
	
	private LivroRepository livroRepository;
	
	public BuscarLivroPersistence(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@Override
	public Optional<Livro> porId(Long id) {
		Optional<LivroEntity> livroEntity = livroRepository.findById(id);
		
		if(livroEntity.isEmpty()) {
			return Optional.empty();
		}
		
		return Optional.of(livroEntity.get().toModel());
	}

	@Override
	public List<Livro> todos() {		
		return livroRepository.findAll().stream().map(LivroEntity::toModel).toList();
	}




}
