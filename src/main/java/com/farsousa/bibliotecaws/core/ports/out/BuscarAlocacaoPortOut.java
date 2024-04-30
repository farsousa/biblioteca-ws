package com.farsousa.bibliotecaws.core.ports.out;

public interface BuscarAlocacaoPortOut {
	
	public int quantidadeAlocacoesPendentesParaUsuario(Long idUsuario);
	
	public int quantidadeAlocacoesAtivasDeLivro(Long idLivro);
	
	public int quantidadeAlocacaoAtivasDeLivrosParaUsuario(Long idUsuario, Long idLivro);

}
