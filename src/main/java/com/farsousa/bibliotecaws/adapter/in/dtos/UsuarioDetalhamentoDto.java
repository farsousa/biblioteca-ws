package com.farsousa.bibliotecaws.adapter.in.dtos;

import com.farsousa.bibliotecaws.core.models.Usuario;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDetalhamentoDto {
	
	private Long id;
	private String nome;

	public static UsuarioDetalhamentoDto fromModel(Usuario model) {
		if(model == null) {
			return null;
		}
		
		return UsuarioDetalhamentoDto.builder()
				.nome(model.getNome())
				.id(model.getId())
				.build();
	}

}
