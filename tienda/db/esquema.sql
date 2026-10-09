CREATE TABLE producto(
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR2 (100) NOT NULL ,
    precio NUMBER (10) NOT NULL,
    stock NUMBER (10) NOT NULL
);
INSERT INTO producto(nombre , stock , precio) VALUES('Biscocho' , 500 , 30);
INSERT INTO producto(nombre , stock , precio) VALUES('Bebida' , 900 , 50);
INSERT INTO producto(nombre , stock , precio) VALUES('Empanadas de Queso' , 500 , 30);


CREATE TABLE categoria(
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre_categoria VARCHAR2 (100) NOT NULL
);
COMMIT;