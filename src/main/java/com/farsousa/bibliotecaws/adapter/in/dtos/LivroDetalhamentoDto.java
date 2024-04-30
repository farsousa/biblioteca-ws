package com.farsousa.bibliotecaws.adapter.in.dtos;

import com.farsousa.bibliotecaws.core.models.Livro;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LivroDetalhamentoDto {
	
	private Long id;
	private String titulo;
	private String descricao;
	private String autor;
	private Integer quantidade;

	public static LivroDetalhamentoDto fromModel(Livro model) {
		if(model == null) {
			return null;
		}
		
		return LivroDetalhamentoDto.builder()
				.autor(model.getAutor())
				.descricao(model.getDescricao())
				.id(model.getId())
				.titulo(model.getTitulo())
				.quantidade(model.getQuantidade())
				.build();
	}

}
