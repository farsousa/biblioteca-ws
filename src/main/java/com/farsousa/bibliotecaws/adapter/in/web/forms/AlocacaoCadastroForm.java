package com.farsousa.bibliotecaws.adapter.in.web.forms;

import com.farsousa.bibliotecaws.core.models.Alocacao;
import com.farsousa.bibliotecaws.core.models.Livro;
import com.farsousa.bibliotecaws.core.models.Usuario;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlocacaoCadastroForm {

	private Long idUsuario;
	private Long idLivro;
	
	public Alocacao toModel() {
		Usuario usuario = new Usuario();
		usuario.setId(idUsuario);
		
		Livro livro = new Livro();
		livro.setId(idLivro);
		
		Alocacao model = new Alocacao();
		model.setUsuario(usuario);
		model.setLivro(livro);
		
		return model;
	}

}
