package com.farsousa.bibliotecaws.adapter.in.web.dtos;

import com.farsousa.bibliotecaws.core.models.Usuario;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioListagemDto {
	
	private Long id;
	private String nome;
	
	public static UsuarioListagemDto fromModel(Usuario model) {
		if(model == null) {
			return null;
		}
		
		return UsuarioListagemDto.builder()
				.nome(model.getNome())
				.id(model.getId())
				.build();
	}

}
