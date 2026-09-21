CREATE DATABASE IF NOT EXISTS roteirizacao_logistica
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE roteirizacao_logistica;

CREATE TABLE IF NOT EXISTS clientes (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(120) NOT NULL,
	email VARCHAR(120) NOT NULL UNIQUE,
	telefone VARCHAR(20),
	endereco VARCHAR(200) NOT NULL,
	cidade VARCHAR(80) NOT NULL,
	cep VARCHAR(8) NOT NULL,
	latitude DOUBLE,
	longitude DOUBLE
);

CREATE TABLE IF NOT EXISTS motoristas (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(120) NOT NULL,
	cnh VARCHAR(20) NOT NULL UNIQUE,
	telefone VARCHAR(20),
	ativo BIT NOT NULL DEFAULT 1
);

CREATE TABLE IF NOT EXISTS veiculos (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	placa VARCHAR(10) NOT NULL UNIQUE,
	modelo VARCHAR(80) NOT NULL,
	capacidade_peso DECIMAL(10,2) NOT NULL,
	capacidade_entregas INT NOT NULL,
	ativo BIT NOT NULL DEFAULT 1
);

CREATE TABLE IF NOT EXISTS entregas (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	cliente_id BIGINT NOT NULL,
	endereco VARCHAR(200) NOT NULL,
	cidade VARCHAR(80) NOT NULL,
	cep VARCHAR(8) NOT NULL,
	latitude DOUBLE NOT NULL,
	longitude DOUBLE NOT NULL,
	peso DECIMAL(10,2) NOT NULL,
	status VARCHAR(20) NOT NULL,
	observacao VARCHAR(255),
	CONSTRAINT fk_entrega_cliente FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

CREATE TABLE IF NOT EXISTS rotas (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	motorista_id BIGINT NOT NULL,
	veiculo_id BIGINT NOT NULL,
	data DATE NOT NULL,
	status VARCHAR(20) NOT NULL,
	distancia_total_km DECIMAL(12,2),
	tempo_estimado_minutos INT,
	CONSTRAINT fk_rota_motorista FOREIGN KEY (motorista_id) REFERENCES motoristas(id),
	CONSTRAINT fk_rota_veiculo FOREIGN KEY (veiculo_id) REFERENCES veiculos(id)
);

CREATE TABLE IF NOT EXISTS paradas (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	rota_id BIGINT NOT NULL,
	entrega_id BIGINT NOT NULL,
	sequencia INT NOT NULL,
	distancia_do_ponto_anterior_km DECIMAL(12,2),
	CONSTRAINT fk_parada_rota FOREIGN KEY (rota_id) REFERENCES rotas(id),
	CONSTRAINT fk_parada_entrega FOREIGN KEY (entrega_id) REFERENCES entregas(id)
);
