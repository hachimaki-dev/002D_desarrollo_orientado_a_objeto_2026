CREATE TABLE destinos (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    ciudad VARCHAR2(60) NOT NULL UNIQUE,
    region VARCHAR2(60) NOT NULL
);

CREATE TABLE alojamientos (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tipo VARCHAR2(20) NOT NULL, -- 'HOTEL' o 'CABANA'
    nombre VARCHAR2(100) NOT NULL,
    precio_noche NUMBER(10) NOT NULL,
    id_destino NUMBER NOT NULL,
    -- Columnas exclusivas de HOTEL (NULL si es CABANA)
    piso NUMBER(3),
    incluye_desayuno NUMBER(1), -- 1 = Sí, 0 = No
    -- Columnas exclusivas de CABANA (NULL si es HOTEL)
    capacidad NUMBER(3),
    tiene_tinaja NUMBER(1), -- 1 = Sí, 0 = No
    CONSTRAINT fk_alojamiento_destino FOREIGN KEY (id_destino) REFERENCES destinos(id)
);

-- Destinos iniciales (generan IDs 1, 2, 3 y 4)
INSERT INTO destinos (ciudad, region) VALUES ('Pucón', 'La Araucanía');
INSERT INTO destinos (ciudad, region) VALUES ('Valdivia', 'Los Ríos');
INSERT INTO destinos (ciudad, region) VALUES ('Puerto Varas', 'Los Lagos');
INSERT INTO destinos (ciudad, region) VALUES ('Chiloé', 'Los Lagos');

-- Alojamientos de prueba
INSERT INTO alojamientos (tipo, nombre, precio_noche, id_destino, piso, incluye_desayuno)
VALUES ('HOTEL', 'Hotel Lago Azul - Hab. 302', 85000, 1, 3, 1);

INSERT INTO alojamientos (tipo, nombre, precio_noche, id_destino, capacidad, tiene_tinaja)
VALUES ('CABANA', 'Cabaña Bosque Nativo', 120000, 1, 6, 1);

INSERT INTO alojamientos (tipo, nombre, precio_noche, id_destino, piso, incluye_desayuno)
VALUES ('HOTEL', 'Hotel Calle-Calle - Suite 201', 72000, 2, 2, 0);

INSERT INTO alojamientos (tipo, nombre, precio_noche, id_destino, capacidad, tiene_tinaja)
VALUES ('CABANA', 'Cabaña Mirador Osorno', 145000, 3, 8, 1);
COMMIT;