package com.farsousa.bibliotecaws.adapter.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farsousa.bibliotecaws.adapter.in.dtos.RespostaDto;
import com.farsousa.bibliotecaws.adapter.in.dtos.UsuarioDetalhamentoDto;
import com.farsousa.bibliotecaws.adapter.in.forms.UsuarioCadastroForm;
import com.farsousa.bibliotecaws.core.models.Usuario;
import com.farsousa.bibliotecaws.core.ports.in.SalvarUsuarioPortIn;

@RestController
@RequestMapping("/usuarios")
public class SalvarUsuarioController {
	
	private SalvarUsuarioPortIn salvarUsuarioPortIn;
	
	public SalvarUsuarioController(SalvarUsuarioPortIn salvarUsuarioPortIn) {
		this.salvarUsuarioPortIn = salvarUsuarioPortIn;
	}
	
	@PostMapping
	public ResponseEntity<RespostaDto<UsuarioDetalhamentoDto>> execute(
		@RequestBody UsuarioCadastroForm usuarioASalvar
	) {	
		Usuario usuario = salvarUsuarioPortIn.execute(usuarioASalvar.toModel());
		
		RespostaDto<UsuarioDetalhamentoDto> resposta = new RespostaDto<>();
		resposta.setObjeto(UsuarioDetalhamentoDto.fromModel(usuario));
		resposta.setMensagem("Usuário cadastrado com sucesso!");
		
		return ResponseEntity.status(201).body(resposta);
	}
	
}
