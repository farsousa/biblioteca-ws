package com.farsousa.bibliotecaws.core.ports.out;

import com.farsousa.bibliotecaws.core.models.Usuario;

public interface SalvarUsuarioPortOut {
	
	Usuario execute(Usuario usuarioASalvar);

}
