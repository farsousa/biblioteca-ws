package com.farsousa.bibliotecaws.adapter.in;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.farsousa.bibliotecaws.adapter.in.dtos.LivroListagemDto;
import com.farsousa.bibliotecaws.adapter.in.dtos.RespostaDto;
import com.farsousa.bibliotecaws.core.models.Livro;
import com.farsousa.bibliotecaws.core.ports.in.BuscarLivroPortIn;

@RestController
@RequestMapping("/livros")
public class BuscarLivroController {

	private BuscarLivroPortIn buscarLivroPortIn;
	
	public BuscarLivroController(BuscarLivroPortIn buscarLivroPortIn) {
		this.buscarLivroPortIn = buscarLivroPortIn;
	}
	
	@GetMapping
	public ResponseEntity<RespostaDto<LivroListagemDto>> todos() {	
		List<Livro> livros = buscarLivroPortIn.todos();
		
		RespostaDto<LivroListagemDto> resposta = new RespostaDto<>();
		resposta.setLista(livros.stream().map(LivroListagemDto::fromModel).toList());
		
		return ResponseEntity.status(201).body(resposta);
	}
	
	
	
	
	
}
