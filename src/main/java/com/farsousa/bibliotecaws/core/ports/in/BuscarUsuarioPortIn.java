package com.farsousa.bibliotecaws.core.ports.in;

import java.util.List;

import com.farsousa.bibliotecaws.core.models.Usuario;

public interface BuscarUsuarioPortIn {
	
	public Usuario porId(Long id);
	
	public List<Usuario> todos();

}
