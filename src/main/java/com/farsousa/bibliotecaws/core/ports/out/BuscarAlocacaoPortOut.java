package com.farsousa.bibliotecaws.core.ports.out;

import java.util.List;
import java.util.Optional;

import com.farsousa.bibliotecaws.core.models.Alocacao;

public interface BuscarAlocacaoPortOut {
	
	int quantidadeAlocacoesPendentesParaUsuario(Long idUsuario);
	
	int quantidadeAlocacoesAtivasDeLivro(Long idLivro);
	
	int quantidadeAlocacaoAtivasDeLivrosParaUsuario(Long idUsuario, Long idLivro);
	
	List<Alocacao> todos();
	
	Optional<Alocacao> porId(Long id);

}
