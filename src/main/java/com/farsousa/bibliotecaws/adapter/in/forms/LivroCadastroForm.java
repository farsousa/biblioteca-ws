package com.farsousa.bibliotecaws.adapter.in.forms;

import com.farsousa.bibliotecaws.core.models.Livro;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LivroCadastroForm {
	
	private String descricao;
	private String autor;	
	
	public Livro toModel() {
		Livro model = new Livro();
		model.setAutor(this.autor);
		model.setDescricao(this.descricao);
		
		return model;
	}

}
