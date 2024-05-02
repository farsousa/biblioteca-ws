package com.farsousa.bibliotecaws.core.ports.out;

import java.util.List;

import com.farsousa.bibliotecaws.core.models.Usuario;

public interface BuscarUsuarioPortOut {
	
	Usuario porId(Long id);
	
	List<Usuario> todos();

}
