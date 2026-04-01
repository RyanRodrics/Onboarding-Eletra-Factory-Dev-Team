-- Query 1: Resumo geral dos últimos 7 dias por sensor
SELECT 
    sensor_id, 
    COUNT(*) as leituras_totais, 
    ROUND(AVG(temperature)::numeric, 2) as media_temp_7d, 
    ROUND(AVG(humidity)::numeric, 2) as media_umidade_7d 
FROM sensor_data 
WHERE time > NOW() - INTERVAL '7 days'
GROUP BY sensor_id
ORDER BY sensor_id;

-- Query 2: Análise agregada usando a Materialized View
SELECT
    hour AS data_hora,
    sensor_id,
    avg_temp AS media_temperatura,
    avg_humidity AS media_umidade,
    reading_count AS total_leituras_na_hora
FROM sensor_data_hourly
WHERE hour > NOW() - INTERVAL '24 hours'
ORDER BY hour DESC, sensor_id
LIMIT 50;

-- Query 3: Busca a última leitura conhecida de cada sensor
SELECT DISTINCT ON (sensor_id)
    sensor_id,
    time AS ultima_leitura,
    ROUND(temperature::numeric, 2) as temperatura,
    ROUND(humidity::numeric, 2) as umidade
FROM sensor_data
ORDER BY sensor_id, time DESC;
