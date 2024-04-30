package com.farsousa.bibliotecaws.adapter.out.entities;

import com.farsousa.bibliotecaws.core.models.Usuario;

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

@Table(name = "tb_usuario")
@Entity(name = "Usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "tus_id")
	private Long id;
	@Column(name = "tus_nome")
	private String nome;
	
	public static UsuarioEntity fromModel(Usuario model) {
		return new UsuarioEntityBuilder()
				.nome(model.getNome())
				.id(model.getId())
				.build();
	}
	
	public Usuario toModel() {
		Usuario model = new Usuario();
		model.setNome(this.nome);
		model.setId(this.id);
		
		return model;
	}
}
