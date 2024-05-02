package com.farsousa.bibliotecaws.core.ports.in;

import com.farsousa.bibliotecaws.core.models.Usuario;

public interface SalvarUsuarioPortIn {
	
	Usuario execute(Usuario usuarioASalvar);

}
