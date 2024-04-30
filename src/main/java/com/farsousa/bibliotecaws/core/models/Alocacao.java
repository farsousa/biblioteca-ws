package com.farsousa.bibliotecaws.core.models;

import java.time.LocalDateTime;

import com.farsousa.bibliotecaws.core.enums.SituacaoAlocacao;

public class Alocacao {
	
	private Long id;
	private Livro livro;
	private Usuario usuario;
	private LocalDateTime dataAlocacao;
	private LocalDateTime dataDevolucao;
	private LocalDateTime dataPrevistaDevolucao;
	private SituacaoAlocacao situacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public LocalDateTime getDataAlocacao() {
		return dataAlocacao;
	}
	public void setDataAlocacao(LocalDateTime dataAlocacao) {
		this.dataAlocacao = dataAlocacao;
	}
	public LocalDateTime getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(LocalDateTime dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public LocalDateTime getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}
	public void setDataPrevistaDevolucao(LocalDateTime dataPrevistaDevolucao) {
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}
	public SituacaoAlocacao getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoAlocacao situacao) {
		this.situacao = situacao;
	}

}
