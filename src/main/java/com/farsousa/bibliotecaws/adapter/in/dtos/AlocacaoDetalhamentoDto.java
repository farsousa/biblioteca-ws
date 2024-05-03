package com.farsousa.bibliotecaws.adapter.in.dtos;

import java.time.LocalDateTime;

import com.farsousa.bibliotecaws.core.enums.SituacaoAlocacao;
import com.farsousa.bibliotecaws.core.models.Alocacao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlocacaoDetalhamentoDto {
	
	private Long id;
	private LivroDetalhamentoDto livro;
	private UsuarioDetalhamentoDto usuario;
	private LocalDateTime dataAlocacao;
	private LocalDateTime dataPrevistaDevolucao;
	private LocalDateTime dataDevolucao;
	private SituacaoAlocacao situacao;

	public static AlocacaoDetalhamentoDto fromModel(Alocacao model) {
		if(model == null) {
			return null;
		}
		
		return AlocacaoDetalhamentoDto.builder()
				.livro(LivroDetalhamentoDto.fromModel(model.getLivro()))
				.usuario(UsuarioDetalhamentoDto.fromModel(model.getUsuario()))
				.id(model.getId())
				.dataAlocacao(model.getDataAlocacao())
				.dataPrevistaDevolucao(model.getDataPrevistaDevolucao())
				.dataDevolucao(model.getDataDevolucao())
				.situacao(model.getSituacao())
				.build();
	}

}
