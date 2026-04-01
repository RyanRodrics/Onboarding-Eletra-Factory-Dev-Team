-- 1. Garante que a extensão do TimescaleDB está ativa nesta base de dados
CREATE EXTENSION IF NOT EXISTS timescaledb CASCADE;

-- 2. Criação da tabela base, que armazena os dados dos sensores
CREATE TABLE sensor_data (
    id BIGSERIAL,
    sensor_id BIGINT NOT NULL,
    time TIMESTAMPTZ NOT NULL,
    temperature DOUBLE PRECISION,
    humidity DOUBLE PRECISION,
    pressure DOUBLE PRECISION,
    PRIMARY KEY (id, time)
);

-- 3. Transforma a tabela em uma Hypertable (Particionamento automático por tempo)
SELECT create_hypertable('sensor_data', 'time');

-- 4. Criação do índice composto recomendado para Time-Series (Busca rápida por sensor ordenado no tempo)
CREATE INDEX idx_sensor_id_time ON sensor_data(sensor_id, time DESC);
