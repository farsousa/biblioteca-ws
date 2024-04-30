package com.farsousa.bibliotecaws.adapter.out.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farsousa.bibliotecaws.adapter.out.entities.AlocacaoEntity;
import com.farsousa.bibliotecaws.core.enums.SituacaoAlocacao;

public interface AlocacaoRepository extends JpaRepository<AlocacaoEntity, Long> {

	int countByUsuarioIdAndSituacao(Long idUsuario, SituacaoAlocacao situacao);

	int countByLivroIdAndSituacao(Long idLivro, SituacaoAlocacao situacao);

	int countByLivroIdAndUsuarioIdAndSituacao(Long idLivro, Long idUsuario, SituacaoAlocacao situacao);

}
