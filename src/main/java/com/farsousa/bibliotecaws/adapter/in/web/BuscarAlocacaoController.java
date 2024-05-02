package com.farsousa.bibliotecaws.adapter.in.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farsousa.bibliotecaws.adapter.in.web.dtos.AlocacaoDetalhamentoDto;
import com.farsousa.bibliotecaws.adapter.in.web.dtos.AlocacaoListagemDto;
import com.farsousa.bibliotecaws.adapter.in.web.dtos.RespostaDto;
import com.farsousa.bibliotecaws.core.models.Alocacao;
import com.farsousa.bibliotecaws.core.ports.in.BuscarAlocacaoPortIn;

@RestController
@RequestMapping("/alocacoes")
public class BuscarAlocacaoController {

	private BuscarAlocacaoPortIn buscarAlocacaoPortIn;
	
	public BuscarAlocacaoController(BuscarAlocacaoPortIn buscarAlocacaoPortIn) {
		this.buscarAlocacaoPortIn = buscarAlocacaoPortIn;
	}
	
	@GetMapping
	public ResponseEntity<RespostaDto<AlocacaoListagemDto>> todos() {	
		List<Alocacao> alocacoes = buscarAlocacaoPortIn.todos();
		
		RespostaDto<AlocacaoListagemDto> resposta = new RespostaDto<>();
		resposta.setLista(alocacoes.stream().map(AlocacaoListagemDto::fromModel).toList());
		
		return ResponseEntity.status(200).body(resposta);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RespostaDto<AlocacaoDetalhamentoDto>> buscarPorId(
		@PathVariable Long id
	) {	
		Alocacao alocacao = buscarAlocacaoPortIn.porId(id);
		
		RespostaDto<AlocacaoDetalhamentoDto> resposta = new RespostaDto<>();
		resposta.setObjeto(AlocacaoDetalhamentoDto.fromModel(alocacao));
		
		return ResponseEntity.status(200).body(resposta);
	}
	
}
