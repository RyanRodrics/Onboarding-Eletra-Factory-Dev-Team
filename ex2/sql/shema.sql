-- Criação da tabela de metadados dos sensores
CREATE TABLE sensors (
    id BIGSERIAL PRIMARY KEY,
    location TEXT NOT NULL,
    model TEXT NOT NULL,
    installation_date DATE NOT NULL,
);
