package com.farsousa.bibliotecaws.adapter.in.dtos;

import java.time.LocalDateTime;

import com.farsousa.bibliotecaws.core.models.Alocacao;
import com.farsousa.bibliotecaws.core.models.Livro;
import com.farsousa.bibliotecaws.core.models.Usuario;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlocacaoDetalhamentoDto {
	
	private Long id;
	private Livro livro;
	private Usuario usuario;
	private LocalDateTime dataAlocacao;
	private LocalDateTime dataPrevistaDevolucao;

	public static AlocacaoDetalhamentoDto fromModel(Alocacao model) {
		if(model == null) {
			return null;
		}
		
		return AlocacaoDetalhamentoDto.builder()
				.livro(model.getLivro())
				.usuario(model.getUsuario())
				.id(model.getId())
				.dataAlocacao(model.getDataAlocacao())
				.dataPrevistaDevolucao(model.getDataPrevistaDevolucao())
				.build();
	}

}
