package com.farsousa.bibliotecaws.adapter.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farsousa.bibliotecaws.adapter.in.dtos.AlocacaoDetalhamentoDto;
import com.farsousa.bibliotecaws.adapter.in.dtos.RespostaDto;
import com.farsousa.bibliotecaws.core.models.Alocacao;
import com.farsousa.bibliotecaws.core.ports.in.BuscarAlocacaoPortIn;
import com.farsousa.bibliotecaws.core.ports.in.ProcessarAlocacaoPortIn;

@RestController
@RequestMapping("/alocacoes")
public class ProcessarAlocacaoController {

	private BuscarAlocacaoPortIn buscarAlocacaoPortIn;
	private ProcessarAlocacaoPortIn processarAlocacaoPortIn;
	
	public ProcessarAlocacaoController(BuscarAlocacaoPortIn buscarAlocacaoPortIn, ProcessarAlocacaoPortIn processarAlocacaoPortIn) {
		this.buscarAlocacaoPortIn = buscarAlocacaoPortIn;
		this.processarAlocacaoPortIn = processarAlocacaoPortIn;
	}
	
	@PutMapping("/{id}/registrar-devolucao")
	public ResponseEntity<RespostaDto<AlocacaoDetalhamentoDto>> registrarDevoolucaoPorId(
		@PathVariable Long id
	) {	
		Alocacao alocacao = buscarAlocacaoPortIn.porId(id);
		
		processarAlocacaoPortIn.registrarDevolucao(alocacao);
		
		RespostaDto<AlocacaoDetalhamentoDto> resposta = new RespostaDto<>();
		resposta.setObjeto(AlocacaoDetalhamentoDto.fromModel(alocacao));
		resposta.setMensagem("Data de devolução registrada com sucesso!");
		
		return ResponseEntity.status(200).body(resposta);
	}
	
	@PutMapping("/{id}/calcular-atrasos-multa-juros")
	public ResponseEntity<RespostaDto<AlocacaoDetalhamentoDto>> calcularAtrasoMultaJurosPorId(
		@PathVariable Long id
	) {	
		Alocacao alocacao = buscarAlocacaoPortIn.porId(id);
		
		processarAlocacaoPortIn.calcularAtrasoMultaJuros(alocacao);
		
		RespostaDto<AlocacaoDetalhamentoDto> resposta = new RespostaDto<>();
		resposta.setObjeto(AlocacaoDetalhamentoDto.fromModel(alocacao));
		resposta.setMensagem("Calculado o dias de atraso, multa e juros com sucesso!");
		
		return ResponseEntity.status(200).body(resposta);
	}
	
}
