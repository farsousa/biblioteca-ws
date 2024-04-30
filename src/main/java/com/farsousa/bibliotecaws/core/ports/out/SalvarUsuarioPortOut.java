package com.farsousa.bibliotecaws.core.ports.out;

import com.farsousa.bibliotecaws.core.models.Usuario;

public interface SalvarUsuarioPortOut {
	
	public Usuario execute(Usuario usuarioASalvar);

}
