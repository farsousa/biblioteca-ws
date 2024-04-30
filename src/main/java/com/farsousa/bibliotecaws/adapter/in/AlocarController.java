package com.farsousa.bibliotecaws.adapter.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farsousa.bibliotecaws.adapter.in.dtos.AlocacaoDetalhamentoDto;
import com.farsousa.bibliotecaws.adapter.in.dtos.RespostaDto;
import com.farsousa.bibliotecaws.adapter.in.forms.AlocacaoCadastroForm;
import com.farsousa.bibliotecaws.core.models.Alocacao;
import com.farsousa.bibliotecaws.core.ports.in.SalvarAlocacaoPortIn;

@RestController
@RequestMapping("/alocacoes")
public class AlocarController {
	
	private SalvarAlocacaoPortIn salvarAlocacaoPortIn;
	
	public AlocarController(SalvarAlocacaoPortIn salvarAlocacaoPortIn) {
		this.salvarAlocacaoPortIn = salvarAlocacaoPortIn;
	}
	
	@PostMapping
	public ResponseEntity<RespostaDto<AlocacaoDetalhamentoDto>> execute(
		@RequestBody AlocacaoCadastroForm alocacaoASalvar
	) {	
		Alocacao alocacao = salvarAlocacaoPortIn.execute(alocacaoASalvar.toModel());
		
		RespostaDto<AlocacaoDetalhamentoDto> resposta = new RespostaDto<>();
		resposta.setObjeto(AlocacaoDetalhamentoDto.fromModel(alocacao));
		resposta.setMensagem("Alocacão cadastrada com sucesso!");
		
		return ResponseEntity.status(201).body(resposta);
	}
	
}
