CREATE TABLE tipologradouro (
	cdtipolog BIGINT NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(50) NOT NULL,
	cdtiplog VARCHAR(10),
	status bit(1),
  	dtcriacao DATETIME,
  	dtatual DATETIME,
  	cdusrcre bigint,
  	cdusratua bigint,
  	version int(11) NOT NULL DEFAULT '0',
  	PRIMARY KEY (cdtipolog)
);