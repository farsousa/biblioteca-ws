CREATE TABLE tb_livro (
	tli_id INT AUTO_INCREMENT,
	tli_titulo VARCHAR(50) NOT NULL,
	tli_descricao VARCHAR(150) NOT NULL,
	tli_autor VARCHAR(150) NOT NULL,
	tli_quantidade INT NOT NULL,
	CONSTRAINT PK_TB_LIVRO PRIMARY KEY(tli_id)
);