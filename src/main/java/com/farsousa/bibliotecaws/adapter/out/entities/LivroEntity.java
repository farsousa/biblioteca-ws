package com.farsousa.bibliotecaws.adapter.out.entities;

import com.farsousa.bibliotecaws.core.models.Livro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tb_livro")
@Entity(name = "Livro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivroEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "tli_id")
	private Long id;
	@Column(name = "tli_descricao")
	private String descricao;
	@Column(name = "tli_autor")
	private String autor;
	@Column(name = "tli_titulo")
	private String titulo;
	@Column(name = "tli_quantidade")
	private Integer quantidade;
	
	public static LivroEntity fromModel(Livro model) {
		return new LivroEntityBuilder()
				.autor(model.getAutor())
				.descricao(model.getDescricao())
				.id(model.getId())
				.titulo(model.getTitulo())
				.quantidade(model.getQuantidade())
				.build();
	}
	
	public Livro toModel() {
		Livro model = new Livro();
		model.setAutor(this.autor);
		model.setDescricao(this.descricao);
		model.setId(this.id);
		model.setTitulo(this.titulo);
		model.setQuantidade(this.quantidade);
		
		return model;
	}
}
