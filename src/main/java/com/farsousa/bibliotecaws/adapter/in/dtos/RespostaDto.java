package com.farsousa.bibliotecaws.adapter.in.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class RespostaDto<T> {
	
	private List<T> lista;
	private Integer tamanho;
	private Integer pagina;
	private Integer totalPaginas;
	private Integer totalElementos;
	private T objeto;
	private String mensagem;

}
