CREATE TABLE pais (
	cdpais BIGINT NOT NULL AUTO_INCREMENT,
	nome VARCHAR (60) NOT NULL,
	nomept VARCHAR (60) NOT NULL,
	sigla VARCHAR (2) NOT NULL,
	bacen int(6) NOT NULL,
	status bit(1),
  	dtcriacao DATETIME,
  	dtatual DATETIME,
  	cdusrcre bigint,
  	cdusratua bigint,
  	version int(11) NOT NULL DEFAULT '0',
  	PRIMARY KEY (cdpais)
);