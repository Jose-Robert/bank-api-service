CREATE TABLE cliente (
	cdcliente BIGINT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(255) NOT NULL,
	cpfcnpj VARCHAR(14) NOT NULL,
	telefone VARCHAR(11),
	cep VARCHAR(8) NOT NULL,
	tipologradouro_id BIGINT DEFAULT NULL,
	rua VARCHAR(255) NOT NULL,
	numero VARCHAR(50),
	complemento VARCHAR(50),
	bairro VARCHAR(50) NOT NULL,
	municipio_id BIGINT DEFAULT NULL,
	uf_id BIGINT DEFAULT NULL,
	pais_id BIGINT DEFAULT NULL,
	status bit(1),
  	dtcriacao DATETIME,
  	dtatual DATETIME,
  	cdusrcre bigint,
  	cdusratua bigint,
  	version int(11) NOT NULL DEFAULT '0',
	PRIMARY KEY (cdcliente),
	CONSTRAINT FK_clientetipologradouro_id_tipologradourocdtipolog FOREIGN KEY (tipologradouro_id) REFERENCES tipologradouro (cdtipolog),
	CONSTRAINT FK_clientemunicipio_id_municipiocdmunicipio FOREIGN KEY (municipio_id) REFERENCES municipio (cdmunicipio),
	CONSTRAINT FK_clientepais_id_paiscdpais FOREIGN KEY (pais_id) REFERENCES pais (cdpais),
	CONSTRAINT FK_clienteuf_id_ufcduf FOREIGN KEY (uf_id) REFERENCES uf (cduf)
	
);