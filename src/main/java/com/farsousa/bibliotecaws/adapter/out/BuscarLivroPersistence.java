package com.farsousa.bibliotecaws.adapter.out;

import java.util.List;
import java.util.Optional;

import com.farsousa.bibliotecaws.adapter.out.entities.LivroEntity;
import com.farsousa.bibliotecaws.adapter.out.repositories.LivroRepository;
import com.farsousa.bibliotecaws.core.exceptions.NaoEncontradoException;
import com.farsousa.bibliotecaws.core.models.Livro;
import com.farsousa.bibliotecaws.core.ports.out.BuscarLivroPortOut;

public class BuscarLivroPersistence implements BuscarLivroPortOut {
	
	private LivroRepository livroRepository;
	
	public BuscarLivroPersistence(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@Override
	public Livro porId(Long id) {
		Optional<LivroEntity> livro = livroRepository.findById(id);
		if(livro.isEmpty()) {
			throw new NaoEncontradoException("Livro não encontrado!");
		}
		
		return livro.get().toModel();
	}

	@Override
	public List<Livro> todos() {
		List<LivroEntity> livros = livroRepository.findAll();
		if(livros.isEmpty()) {
			throw new NaoEncontradoException("Não há livros cadastrados!");
		}
		
		return livros.stream().map(LivroEntity::toModel).toList();
	}




}
