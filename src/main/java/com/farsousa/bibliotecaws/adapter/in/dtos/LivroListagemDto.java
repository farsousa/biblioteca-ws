package com.farsousa.bibliotecaws.adapter.in.dtos;

import com.farsousa.bibliotecaws.core.models.Livro;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LivroListagemDto {
	
	private Long id;
	private String titulo;
	private String autor;
	
	public static LivroListagemDto fromModel(Livro model) {
		if(model == null) {
			return null;
		}
		
		return LivroListagemDto.builder()
				.titulo(model.getTitulo())
				.autor(model.getAutor())
				.id(model.getId())
				.build();
	}

}
