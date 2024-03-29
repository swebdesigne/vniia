--liquibase formatted sql

--changeset ISivolobov:1
create TABLE IF NOT EXISTS document (
    id BIGSERIAL PRIMARY KEY ,
    number VARCHAR(50) UNIQUE NOT NULL,
    date DATE NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    note VARCHAR(255)
);

--changeset ISivolobov:2
create TABLE IF NOT EXISTS position (
    id BIGSERIAL PRIMARY KEY ,
    document_id BIGSERIAL NOT NULL,
    number VARCHAR(50) NOT NULL,
    name VARCHAR(255) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (document_id) REFERENCES document(id)
);