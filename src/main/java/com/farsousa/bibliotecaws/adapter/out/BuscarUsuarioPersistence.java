package com.farsousa.bibliotecaws.adapter.out;

import java.util.List;
import java.util.Optional;

import com.farsousa.bibliotecaws.adapter.out.entities.UsuarioEntity;
import com.farsousa.bibliotecaws.adapter.out.repositories.UsuarioRepository;
import com.farsousa.bibliotecaws.core.exceptions.NaoEncontradoException;
import com.farsousa.bibliotecaws.core.models.Usuario;
import com.farsousa.bibliotecaws.core.ports.out.BuscarUsuarioPortOut;

public class BuscarUsuarioPersistence implements BuscarUsuarioPortOut {
	
	private UsuarioRepository usuarioRepository;
	
	public BuscarUsuarioPersistence(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario porId(Long id) {
		Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
		if(usuario.isEmpty()) {
			throw new NaoEncontradoException("Usuário não encontrado!");
		}
		
		return usuario.get().toModel();
	}

	@Override
	public List<Usuario> todos() {
		List<UsuarioEntity> usuarios = usuarioRepository.findAll();
		if(usuarios.isEmpty()) {
			throw new NaoEncontradoException("Não há usuários cadastrados!");
		}
		
		return usuarios.stream().map(UsuarioEntity::toModel).toList();
	}




}
