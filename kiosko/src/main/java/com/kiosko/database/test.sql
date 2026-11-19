ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;



-- Crear el usuario

CREATE USER usuario_desarrollador IDENTIFIED BY "123456"

DEFAULT TABLESPACE "USERS"

TEMPORARY TABLESPACE "TEMP";



-- Asignar cuota y permisos básicos

ALTER USER usuario_desarrollador QUOTA UNLIMITED ON USERS;

GRANT CREATE SESSION TO usuario_desarrollador;

GRANT "RESOURCE" TO usuario_desarrollador;

ALTER USER usuario_desarrollador DEFAULT ROLE "RESOURCE";