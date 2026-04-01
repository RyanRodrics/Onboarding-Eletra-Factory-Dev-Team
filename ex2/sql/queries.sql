-- 1. Filtro simples: Buscar todos os sensores instalados em um setor específico
SELECT id, model, installation_date
FROM sensors
WHERE location LIKE '%Montagem%';

-- 2. Filtro com ordenação: Listar os sensores do mais novo para o mais antigo
SELECT * FROM sensors
ORDER BY installation_date DESC;

-- 3. Tabela das temperaturras médias por localização física nas últimas 24 horas (uso do JOIN)
SELECT
    s.location AS setor_da_fabrica,
    ROUND(AVG(d.temperature)::numeric, 2) AS media_temperatura,
    COUNT(d.id) AS total_de_leituras
FROM sensors s
JOIN sensor_data d ON s.id = d.sensor_id
WHERE d.time > NOW() - INTERVAL '24 hours'
GROUP BY s.location
ORDER BY media_temperatura DESC;

-- 4. Buscar infos relacionados a temperatura máxima
SELECT
    s.id,
    s.model AS modelo_do_equipamento,
    s.location AS localizacao,
    ROUND(d.temperature::numeric, 2) as temperatura_maxima_registrada,
    d.time AS data_hora_do_registro
FROM sensors s
JOIN sensor_data d ON s.id = d.sensor_id
WHERE d.temperature = (SELECT MAX(temperature) FROM sensor_data)
LIMIT 1;