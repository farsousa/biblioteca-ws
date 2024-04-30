CREATE TABLE tb_alocacao (
	tal_id INT AUTO_INCREMENT,
	tal_tus_id INT NOT NULL,
	tal_tli_id INT NOT NULL,
	tal_dt_alocacao DATE DEFAULT CURRENT_DATE,
	tal_dt_prevista_devolucao DATE NOT NULL,
	tal_dt_devolucao DATE,
	tal_situacao INT NOT NULL,
	CONSTRAINT pk_tb_alocacao PRIMARY KEY(tal_id),
	CONSTRAINT fk_tal_tus_id FOREIGN KEY(tal_tus_id) REFERENCES tb_usuario(tus_id),
	CONSTRAINT fk_tal_tli_id FOREIGN KEY(tal_tli_id) REFERENCES tb_livro(tli_id)
);

COMMENT ON COLUMN tb_alocacao.tal_situacao IS '0 - Regular, 1 - Pendência';

