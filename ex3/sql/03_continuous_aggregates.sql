-- 1. Cria uma Continuous Aggregate (Materialized View otimizada) para resumos por hora
CREATE MATERIALIZED VIEW sensor_data_hourly
WITH (timescaledb.continuous) AS
SELECT
    time_bucket('1 hour', time) AS hour,
    sensor_id,
    ROUND(AVG(temperature)::numeric, 2) AS avg_temp,
    ROUND(AVG(humidity)::numeric, 2) AS avg_humidity,
    ROUND(AVG(pressure)::numeric, 2) AS avg_pressure,
    ROUND(MIN(temperature)::numeric, 2) AS min_temp,
    ROUND(MAX(temperature)::numeric, 2) AS max_temp,
    COUNT(*) AS reading_count
FROM sensor_data
GROUP BY hour, sensor_id;

-- 2. Define a política de atualização automática dessa view em background
SELECT add_continuous_aggregate_policy(
    'sensor_data_hourly',
    start_offset => INTERVAL '3 hours',
    end_offset => INTERVAL '1 hour',
    schedule_interval => INTERVAL '1 hour'
);
