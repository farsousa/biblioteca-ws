package com.farsousa.bibliotecaws.adapter.in.web.forms;

import com.farsousa.bibliotecaws.core.models.Usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCadastroForm {
	
	private String nome;
	
	public Usuario toModel() {
		Usuario model = new Usuario();
		model.setNome(this.nome);
		
		return model;
	}

}
