package com.farsousa.bibliotecaws.core.enums;

public enum SituacaoAlocacao {
	
	ALOCACAO_REGULAR(0, "Alocação Regular"),
	ALOCACAO_COM_ATRASO(1, "Alocação com atrado"),
	DEVOLUCAO_REGULAR(2, "Devolução Regular"),
	DEVOLUCAO_COM_ATRASO(3, "Devolução com atraso");
	
	private int codigo;
	private String descricao;
	
	private SituacaoAlocacao(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}
