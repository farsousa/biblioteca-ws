package com.farsousa.bibliotecaws.core.ports.in;

import java.util.List;

import com.farsousa.bibliotecaws.core.models.Alocacao;

public interface BuscarAlocacaoPortIn {
	
	int quantidadeAlocacoesPendentesParaUsuario(Long idUsuario);
	
	int quantidadeAlocacoesAtivasDeLivro(Long idLivro);
	
	int quantidadeAlocacaoAtivasDeLivrosParaUsuario(Long idUsuario, Long idLivro);
	
	List<Alocacao> todos();
	
	Alocacao porId(Long id);

}
