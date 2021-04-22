CREATE TABLE uf (
	cduf BIGINT NOT NULL AUTO_INCREMENT,
	codigouf int(2) NOT NULL,
	nome VARCHAR (50) NOT NULL,
	sigla VARCHAR (2) NOT NULL,
	regiao int NOT NULL,
	status bit(1),
  	dtcriacao DATETIME,
  	dtatual DATETIME,
  	cdusrcre bigint,
  	cdusratua bigint,
  	version int(11) NOT NULL DEFAULT '0',
  	PRIMARY KEY (cduf)
);