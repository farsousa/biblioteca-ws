package com.farsousa.bibliotecaws.core.enums;

public enum QuantitativoAplicacao {
	
	QUANTIDADE_DE_LIVRO_QUE_DEVE_FICAR_NA_BIBLIOTECA(1);
	
	private int quantidade;
	
	QuantitativoAplicacao(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

}
