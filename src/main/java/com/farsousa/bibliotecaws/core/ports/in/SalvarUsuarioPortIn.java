package com.farsousa.bibliotecaws.core.ports.in;

import com.farsousa.bibliotecaws.core.models.Usuario;

public interface SalvarUsuarioPortIn {
	
	public Usuario execute(Usuario usuarioASalvar);

}
