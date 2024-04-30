package com.farsousa.bibliotecaws.core.usecases;

import java.util.List;

import com.farsousa.bibliotecaws.core.models.Usuario;
import com.farsousa.bibliotecaws.core.ports.in.BuscarUsuarioPortIn;
import com.farsousa.bibliotecaws.core.ports.out.BuscarUsuarioPortOut;

public class BuscarUsuarioUseCase implements BuscarUsuarioPortIn {
	
	private final BuscarUsuarioPortOut buscarUsuarioPortOut;
	
	public BuscarUsuarioUseCase(BuscarUsuarioPortOut buscarUsuarioPortOut) {
		this.buscarUsuarioPortOut = buscarUsuarioPortOut;
	}

	@Override
	public Usuario porId(Long id) {
		return buscarUsuarioPortOut.porId(id);
	}

	@Override
	public List<Usuario> todos() {
		return buscarUsuarioPortOut.todos();
	}

	
}
