package com.farsousa.bibliotecaws.adapter.in.web.dtos;

import com.farsousa.bibliotecaws.core.models.Alocacao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlocacaoListagemDto {
	
	private Long id;
	private String nomeUsuario;
	private String tituloLivro;
	private String situacao;
	
	public static AlocacaoListagemDto fromModel(Alocacao model) {
		if(model == null) {
			return null;
		}
		
		return AlocacaoListagemDto.builder()
				.nomeUsuario(model.getUsuario().getNome())
				.tituloLivro(model.getLivro().getTitulo())
				.id(model.getId())
				.situacao(model.getSituacao().getDescricao())
				.build();
	}

}
