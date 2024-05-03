package com.farsousa.bibliotecaws.adapter.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farsousa.bibliotecaws.adapter.in.dtos.LivroDetalhamentoDto;
import com.farsousa.bibliotecaws.adapter.in.dtos.RespostaDto;
import com.farsousa.bibliotecaws.adapter.in.forms.LivroCadastroForm;
import com.farsousa.bibliotecaws.core.models.Livro;
import com.farsousa.bibliotecaws.core.ports.in.SalvarLivroPortIn;

@RestController
@RequestMapping("/livros")
public class SalvarLivroController {
	
	private SalvarLivroPortIn salvarLivroPortIn;
	
	public SalvarLivroController(SalvarLivroPortIn salvarLivroPortIn) {
		this.salvarLivroPortIn = salvarLivroPortIn;
	}
	
	@PostMapping
	public ResponseEntity<RespostaDto<LivroDetalhamentoDto>> execute(
		@RequestBody LivroCadastroForm livroASalvar
	) {	
		Livro livro = salvarLivroPortIn.execute(livroASalvar.toModel());
		
		RespostaDto<LivroDetalhamentoDto> resposta = new RespostaDto<>();
		resposta.setObjeto(LivroDetalhamentoDto.fromModel(livro));
		resposta.setMensagem("Livro cadastrado com sucesso!");
		
		return ResponseEntity.status(201).body(resposta);
	}
	
}
