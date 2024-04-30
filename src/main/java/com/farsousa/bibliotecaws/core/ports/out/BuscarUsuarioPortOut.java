package com.farsousa.bibliotecaws.core.ports.out;

import java.util.List;

import com.farsousa.bibliotecaws.core.models.Usuario;

public interface BuscarUsuarioPortOut {
	
	public Usuario porId(Long id);
	
	public List<Usuario> todos();

}
