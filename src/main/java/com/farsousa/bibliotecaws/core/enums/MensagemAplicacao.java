package com.farsousa.bibliotecaws.core.enums;

public enum MensagemAplicacao {
	
	ALOCACAO_USUARIO_PENDENTE("Usuário possui alocações pendentes!"),
	ALOCACAO_LIVRO_ALOCADO("Usuário já possui alocações ativas deste livro!"),
	ALOCACAO_LIVRO_INDISPONIVEL_QUANTIDADE_ESGOTADA("Não há disponibilidade para este livro, pois a quantidade foi esgotada!"),
	ALOCACAO_NAO_ENCONTRADA("Alocação não encontrada!"),
	ALOCACAO_NENHUM_REGISTRO("Nenhum registro de alocação cadastrado!"),

	LIVRO_TITULO_OBRIGATORIO("Título do livro é obrigatório!"),
	LIVRO_DESCRICAO_OBRIGATORIO("Descrição do livro é obrigatório!"),
	LIVRO_AUTOR_OBRIGATORIO("Autor do livro é obrigatório!"),
	LIVRO_QUANTIDADE_OBRIGATORIO("Quantidade do livro é obrigatório!"),
	LIVRO_NAO_ENCONTRADO("Livro não encontrado!"),
	LIVRO_NENHUM_REGISTRO("Nenhum registro de livro cadastrado!"),
	
	USUARIO_NOME_OBRIGATORIO("Nome do usuário é obrigatório!")
	;
	
	private String mensagem;
	
	private MensagemAplicacao(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return mensagem;
	}

}
