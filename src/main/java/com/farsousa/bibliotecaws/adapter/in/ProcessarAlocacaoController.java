package com.farsousa.bibliotecaws.adapter.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farsousa.bibliotecaws.adapter.in.dtos.RespostaDto;
import com.farsousa.bibliotecaws.core.ports.in.ProcessarAlocacaoPortIn;

@RestController
@RequestMapping("/alocacoes")
public class ProcessarAlocacaoController {
	
	private ProcessarAlocacaoPortIn processarAlocacaoPortIn;
	
	public ProcessarAlocacaoController(ProcessarAlocacaoPortIn processarAlocacaoPortIn) {
		this.processarAlocacaoPortIn = processarAlocacaoPortIn;
	}
	
	@PutMapping("/{id}/calcular-multas-juros")
	public ResponseEntity<RespostaDto<String>> calcularMultasJurosPorId(
		@PathVariable Long id
	) {	
		processarAlocacaoPortIn.verificarPendenciasPorId(id);
		
		RespostaDto<String> resposta = new RespostaDto<>();
		resposta.setMensagem("Pendências verificadas com sucesso!");
		
		return ResponseEntity.status(200).body(resposta);
	}
	
	@PutMapping("/{id}/registrar-devolucao")
	public ResponseEntity<RespostaDto<String>> registrarDevolucao(
		@PathVariable Long id
	) {	
		processarAlocacaoPortIn.registrarDevolucaoPorId(id);
		
		RespostaDto<String> resposta = new RespostaDto<>();
		resposta.setMensagem("Devolução registrada com sucesso!");
		
		return ResponseEntity.status(200).body(resposta);
	}
	
	@PutMapping("/calcular-multas-juros")
	public ResponseEntity<RespostaDto<String>> verificarPendenciasTodos() 
	{	
		processarAlocacaoPortIn.verificarPendenciasTodos();
		
		RespostaDto<String> resposta = new RespostaDto<>();
		resposta.setMensagem("Pendências verificadas com sucesso!");
		
		return ResponseEntity.status(200).body(resposta);
	}
	
}
