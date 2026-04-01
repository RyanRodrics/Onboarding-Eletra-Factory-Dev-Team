-- 1. Carrega a extensão na sessão atual (recomendado no caso se utilizar o DataGrip)
LOAD 'timescaledb';

-- 2. Habilita a compressão na Hypertable agrupando pelo ID do sensor
ALTER TABLE sensor_data SET (
    timescaledb.compress,
    timescaledb.compress_segmentby = 'sensor_id'
);

-- 3. Habilita a inserção direta no formato comprimido (Columnstore) para alta performance
SET timescaledb.enable_direct_compress_insert = on;

-- 4. Seed de Dados: Simula leituras de 10 sensores a cada 1 minuto nos últimos 7 dias
INSERT INTO sensor_data (sensor_id, time, temperature, humidity, pressure)
SELECT
    'sensor_' || ((random() * 9)::int + 1) AS sensor_id,
    time,
    20 + (random() * 15) AS temperature,
    40 + (random() * 30) AS humidity,
    1000 + (random() * 50) AS pressure
FROM generate_series(
    NOW() - INTERVAL '7 days',
    NOW(),
    INTERVAL '1 minute'
) AS time;

-- 5. Otimiza e reordena os dados inseridos em formato colunar
DO $$
DECLARE ch TEXT;
BEGIN
    FOR ch IN SELECT show_chunks('sensor_data') LOOP
        CALL convert_to_columnstore(ch, recompress := true);
    END LOOP;
END $$;
