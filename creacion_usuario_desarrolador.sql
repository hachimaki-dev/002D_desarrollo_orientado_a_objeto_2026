-- Habilita la creación de usuarios con nombres normales en Oracle 12c/19c/21c/23ai
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;

-- Crear el usuario de trabajo con contraseña 123456
CREATE USER usuario_desarrollador IDENTIFIED BY "123456"
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP";

-- Asignar cuota de almacenamiento y permisos básicos
ALTER USER usuario_desarrollador QUOTA UNLIMITED ON USERS;
GRANT CREATE SESSION TO usuario_desarrollador;
GRANT "RESOURCE" TO usuario_desarrollador;
ALTER USER usuario_desarrollador DEFAULT ROLE "RESOURCE";