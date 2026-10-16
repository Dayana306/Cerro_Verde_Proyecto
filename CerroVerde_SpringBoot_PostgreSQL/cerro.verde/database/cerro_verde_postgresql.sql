-- Crear la base por separado: CREATE DATABASE cerro_verde;
-- Ejecutar este archivo dentro de la base cerro_verde si se desea crear las tablas manualmente.
-- Si se inicia Spring Boot con ddl-auto=update, Hibernate crea las tablas automáticamente.
CREATE TABLE IF NOT EXISTS area (
 id_area BIGSERIAL PRIMARY KEY, nombre_area VARCHAR(100) NOT NULL UNIQUE,
 descripcion VARCHAR(300), estado BOOLEAN NOT NULL DEFAULT TRUE
);
CREATE TABLE IF NOT EXISTS region (
 id_region BIGSERIAL PRIMARY KEY, nombre_region VARCHAR(100) NOT NULL UNIQUE,
 descripcion VARCHAR(300), estado BOOLEAN NOT NULL DEFAULT TRUE
);
CREATE TABLE IF NOT EXISTS zona (
 id_zona BIGSERIAL PRIMARY KEY, nombre_zona VARCHAR(100) NOT NULL,
 descripcion VARCHAR(300), estado BOOLEAN NOT NULL DEFAULT TRUE,
 id_region BIGINT NOT NULL REFERENCES region(id_region) ON DELETE RESTRICT
);
CREATE TABLE IF NOT EXISTS punto_monitoreo (
 id_punto BIGSERIAL PRIMARY KEY, nombre_punto VARCHAR(120) NOT NULL,
 descripcion VARCHAR(300), latitud DOUBLE PRECISION, longitud DOUBLE PRECISION,
 estado BOOLEAN NOT NULL DEFAULT TRUE,
 id_zona BIGINT NOT NULL REFERENCES zona(id_zona) ON DELETE RESTRICT,
 id_area BIGINT REFERENCES area(id_area) ON DELETE RESTRICT
);
CREATE TABLE IF NOT EXISTS parametro (
 id_parametro BIGSERIAL PRIMARY KEY, nombre_parametro VARCHAR(100) NOT NULL UNIQUE,
 descripcion VARCHAR(300), unidad_medida VARCHAR(30) NOT NULL,
 rango_min DOUBLE PRECISION, rango_max DOUBLE PRECISION, estado BOOLEAN NOT NULL DEFAULT TRUE
);
CREATE TABLE IF NOT EXISTS monitoreo (
 id_monitoreo BIGSERIAL PRIMARY KEY, tipo_muestreo VARCHAR(60) NOT NULL,
 hora_muestreo TIMESTAMP NOT NULL, observacion VARCHAR(1000),
 id_punto BIGINT NOT NULL REFERENCES punto_monitoreo(id_punto) ON DELETE RESTRICT
);
CREATE TABLE IF NOT EXISTS lectura_parametro (
 id_lectura BIGSERIAL PRIMARY KEY, valor DOUBLE PRECISION NOT NULL,
 fecha_hora TIMESTAMP NOT NULL,
 id_monitoreo BIGINT NOT NULL REFERENCES monitoreo(id_monitoreo) ON DELETE RESTRICT,
 id_parametro BIGINT NOT NULL REFERENCES parametro(id_parametro) ON DELETE RESTRICT
);
CREATE INDEX IF NOT EXISTS idx_lectura_fecha ON lectura_parametro(fecha_hora);
CREATE TABLE IF NOT EXISTS alerta (
 id_alerta BIGSERIAL PRIMARY KEY, tipo_alerta VARCHAR(40) NOT NULL,
 valor_detectado DOUBLE PRECISION NOT NULL, fecha_deteccion TIMESTAMP NOT NULL,
 estado VARCHAR(30) NOT NULL DEFAULT 'ACTIVA',
 id_monitoreo BIGINT NOT NULL REFERENCES monitoreo(id_monitoreo) ON DELETE RESTRICT,
 id_parametro BIGINT NOT NULL REFERENCES parametro(id_parametro) ON DELETE RESTRICT
);
CREATE INDEX IF NOT EXISTS idx_alerta_estado_tipo ON alerta(estado,tipo_alerta);
