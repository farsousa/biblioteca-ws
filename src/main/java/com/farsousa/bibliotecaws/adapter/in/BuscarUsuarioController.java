package com.farsousa.bibliotecaws.adapter.in;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farsousa.bibliotecaws.adapter.in.dtos.RespostaDto;
import com.farsousa.bibliotecaws.adapter.in.dtos.UsuarioDetalhamentoDto;
import com.farsousa.bibliotecaws.adapter.in.dtos.UsuarioListagemDto;
import com.farsousa.bibliotecaws.core.models.Usuario;
import com.farsousa.bibliotecaws.core.ports.in.BuscarUsuarioPortIn;

@RestController
@RequestMapping("/usuarios")
public class BuscarUsuarioController {

	private BuscarUsuarioPortIn buscarUsuarioPortIn;
	
	public BuscarUsuarioController(BuscarUsuarioPortIn buscarUsuarioPortIn) {
		this.buscarUsuarioPortIn = buscarUsuarioPortIn;
	}
	
	@GetMapping
	public ResponseEntity<RespostaDto<UsuarioListagemDto>> todos() {	
		List<Usuario> usuarios = buscarUsuarioPortIn.todos();
		
		RespostaDto<UsuarioListagemDto> resposta = new RespostaDto<>();
		resposta.setLista(usuarios.stream().map(UsuarioListagemDto::fromModel).toList());
		
		return ResponseEntity.status(200).body(resposta);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RespostaDto<UsuarioDetalhamentoDto>> buscarPorId(
		@PathVariable Long id
	) {	
		Usuario usuario = buscarUsuarioPortIn.porId(id);
		
		RespostaDto<UsuarioDetalhamentoDto> resposta = new RespostaDto<>();
		resposta.setObjeto(UsuarioDetalhamentoDto.fromModel(usuario));
		
		return ResponseEntity.status(200).body(resposta);
	}
	
	
	
	
	
}
