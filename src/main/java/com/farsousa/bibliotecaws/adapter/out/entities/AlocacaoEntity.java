package com.farsousa.bibliotecaws.adapter.out.entities;

import java.time.LocalDateTime;

import com.farsousa.bibliotecaws.core.enums.SituacaoAlocacao;
import com.farsousa.bibliotecaws.core.models.Alocacao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tb_alocacao")
@Entity(name = "Alocacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlocacaoEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "tal_id")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "tal_tli_id", referencedColumnName = "tli_id")
	private LivroEntity livro;
	@ManyToOne
	@JoinColumn(name = "tal_tus_id", referencedColumnName = "tus_id")
	private UsuarioEntity usuario;
	@Column(name = "tal_dt_alocacao")
	private LocalDateTime dataAlocacao;
	@Column(name = "tal_dt_devolucao")
	private LocalDateTime dataDevolucao;
	@Column(name = "tal_dt_prevista_devolucao")
	private LocalDateTime dataPrevistaDevolucao;
	@Column(name = "tal_situacao")
	private SituacaoAlocacao situacao;
	
	public static AlocacaoEntity fromModel(Alocacao model) {
		return new AlocacaoEntityBuilder()
				.livro(LivroEntity.fromModel(model.getLivro()))
				.usuario(UsuarioEntity.fromModel(model.getUsuario()))
				.id(model.getId())
				.dataAlocacao(model.getDataAlocacao())
				.dataDevolucao(model.getDataDevolucao())
				.dataPrevistaDevolucao(model.getDataPrevistaDevolucao())
				.situacao(model.getSituacao())
				.build();
	}
	
	public Alocacao toModel() {
		Alocacao model = new Alocacao();
		model.setLivro(this.livro.toModel());
		model.setUsuario(this.usuario.toModel());
		model.setId(this.id);
		model.setDataAlocacao(this.dataAlocacao);
		model.setDataDevolucao(this.dataDevolucao);
		model.setDataPrevistaDevolucao(this.dataPrevistaDevolucao);
		model.setSituacao(this.situacao);
		
		return model;
	}

}
