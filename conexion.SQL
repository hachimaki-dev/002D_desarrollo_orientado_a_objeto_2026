ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;

-- Crear el usuario de trabajo con contraseña 12345
CREATE USER usuario_desarrollador IDENTIFIED BY "Oracle12345"
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP";

-- Asignar cuota de almacenamiento y permisos básicos
ALTER USER usuario_desarrollador QUOTA UNLIMITED ON USERS;
GRANT CREATE SESSION TO usuario_desarrollador;
GRANT "RESOURCE" TO usuario_desarrollador;
ALTER USER usuario_desarrollador DEFAULT ROLE "RESOURCE";