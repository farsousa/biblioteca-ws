package com.farsousa.bibliotecaws.infra.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.farsousa.bibliotecaws.adapter.in.dtos.RespostaDto;
import com.farsousa.bibliotecaws.core.exceptions.NaoEncontradoException;
import com.farsousa.bibliotecaws.core.exceptions.ValidacaoException;

@RestControllerAdvice
public class ExcecaoHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<RespostaDto<String>> exceptionHandler(Exception e) {
		RespostaDto<String> resposta = new RespostaDto<>();
		resposta.setMensagem(e.getMessage());
		
		return ResponseEntity.status(400).body(resposta);
	}
	
	@ExceptionHandler(value = NaoEncontradoException.class)
	public ResponseEntity<RespostaDto<String>> naoEncontradoExceptionHandler(NaoEncontradoException e) {
		RespostaDto<String> resposta = new RespostaDto<>();
		resposta.setMensagem(e.getMessage());
		
		return ResponseEntity.status(404).body(resposta);
	}
	
	@ExceptionHandler(value = ValidacaoException.class)
	public ResponseEntity<RespostaDto<String>> validacaoExceptionHandler(ValidacaoException e) {
		RespostaDto<String> resposta = new RespostaDto<>();
		resposta.setMensagem(e.getMessage());
		
		return ResponseEntity.status(422).body(resposta);
	}
	
	
}