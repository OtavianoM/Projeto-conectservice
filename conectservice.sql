create database conectservice;
use conectservice;




CREATE TABLE usuario (
	nome VARCHAR(50),
    cpf VARCHAR(50),
    login VARCHAR(20),
    senha VARCHAR(8),
	prestado_servico ENUM('não'),
    CONSTRAINT PRIMARY KEY (cpf)
    
);


CREATE TABLE prestador_servico (
	nome VARCHAR(50),
    cnpj VARCHAR(50),
    login VARCHAR(20),
    senha VARCHAR(8),
    atuacao VARCHAR(30) NOT NULL,
	valor INT NOT NULL,
	prestado_servico ENUM('sim'),
    CONSTRAINT PRIMARY KEY (cnpj)
    
);

CREATE TABLE login (
    login VARCHAR(20),
    senha VARCHAR(8),
    prestado_servico ENUM('sim', 'não'),
	codusuario INT,
	codprestador INT,
	CONSTRAINT PRIMARY KEY (login),
	CONSTRAINT FOREIGN KEY (codusuario)
        REFERENCES usuario (codusuario),
    CONSTRAINT FOREIGN KEY (codprestador)
        REFERENCES prestador_servico (codprestador)
	
	
    
);


CREATE TABLE pagamento (
    codpagamento INT NOT NULL AUTO_INCREMENT,
    formas_pagamento ENUM('a vista','debito','cartao de credito'),
	valor INT NOT NULL,
	cnpj VARCHAR(50),
	cpf VARCHAR(50),
    CONSTRAINT PRIMARY KEY (codpagamento),
	CONSTRAINT FOREIGN KEY (cnpj)
        REFERENCES prestador_servico (cnpj),
	CONSTRAINT FOREIGN KEY (cpf)
        REFERENCES usuario (cpf)
);



CREATE TABLE servico_pagamento (
    codsetor INT NOT NULL,
    codservico INT NOT NULL,
    codpagamento INT NOT NULL,
	codusuario INT NOT NULL,
    CONSTRAINT FOREIGN KEY (codsetor)
        REFERENCES setor (codsetor),
    CONSTRAINT FOREIGN KEY (codservico)
        REFERENCES servico (codservico),
    CONSTRAINT FOREIGN KEY (codpagamento)
        REFERENCES formas_Pagamento (codpagamento),
        CONSTRAINT FOREIGN KEY (codusuario)
        REFERENCES usuario (codusuario)
);

