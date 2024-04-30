package com.farsousa.bibliotecaws.adapter.in.forms;

import com.farsousa.bibliotecaws.core.models.Livro;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LivroCadastroForm {
	
	private String titulo;
	private String descricao;
	private String autor;	
	private Integer quantidade;
	
	public Livro toModel() {
		Livro model = new Livro();
		model.setAutor(this.autor);
		model.setTitulo(this.titulo);
		model.setDescricao(this.descricao);
		model.setQuantidade(this.quantidade);
		
		return model;
	}

}
