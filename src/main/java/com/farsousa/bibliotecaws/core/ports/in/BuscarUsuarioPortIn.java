package com.farsousa.bibliotecaws.core.ports.in;

import java.util.List;

import com.farsousa.bibliotecaws.core.models.Usuario;

public interface BuscarUsuarioPortIn {
	
	Usuario porId(Long id);
	
	List<Usuario> todos();

}
