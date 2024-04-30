package com.farsousa.bibliotecaws.adapter.out;

import com.farsousa.bibliotecaws.adapter.out.entities.UsuarioEntity;
import com.farsousa.bibliotecaws.adapter.out.repositories.UsuarioRepository;
import com.farsousa.bibliotecaws.core.models.Usuario;
import com.farsousa.bibliotecaws.core.ports.out.SalvarUsuarioPortOut;

public class SalvarUsuarioPersistence implements SalvarUsuarioPortOut {
	
	private UsuarioRepository usuarioRepository;
	
	public SalvarUsuarioPersistence(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario execute(Usuario usuario) {		
		UsuarioEntity usuarioEntity = UsuarioEntity.fromModel(usuario);	
		
		return usuarioRepository.save(usuarioEntity).toModel();
	}

}
