package com.farsousa.bibliotecaws.core.usecases;

import com.farsousa.bibliotecaws.core.exceptions.ValidacaoException;
import com.farsousa.bibliotecaws.core.models.Usuario;
import com.farsousa.bibliotecaws.core.ports.in.SalvarUsuarioPortIn;
import com.farsousa.bibliotecaws.core.ports.out.SalvarUsuarioPortOut;

public class SalvarUsuarioUseCase implements SalvarUsuarioPortIn {
	
	private final SalvarUsuarioPortOut salvarUsuarioPortOut;
	
	public SalvarUsuarioUseCase(SalvarUsuarioPortOut salvarUsuarioPortOut) {
		this.salvarUsuarioPortOut = salvarUsuarioPortOut;
	}

	@Override
	public Usuario execute(Usuario usuarioASalvar) {		
		if(usuarioASalvar.getNome() == null) {
			throw new ValidacaoException("Nome do usuário é obrigatório!");
		}
		
		return salvarUsuarioPortOut.execute(usuarioASalvar);
	}
	
}
