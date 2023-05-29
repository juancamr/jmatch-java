CREATE database if NOT EXISTS jmatch;

use jmatch;

CREATE TABLE
  if NOT EXISTS cliente (
    id_cliente VARCHAR(10) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    telefono INT (11) NOT NULL,
    correo VARCHAR(80) NOT NULL,
    password VARCHAR(80) NOT NULL,
    CONSTRAINT PRIMARY key (id_cliente)
  ) ENGINE = InnoDB;

CREATE TABLE
  if NOT EXISTS proyecto (
    id_proyecto VARCHAR(10) NOT NULL,
    id_cliente VARCHAR(10) NOT NULL,
    Titulo_Proyecto VARCHAR(60) NOT NULL,
    Descripcion_Proyecto VARCHAR(100) NOT NULL,
    Fecha_Publicacion VARCHAR(80) NOT NULL,
    Fecha_Limite VARCHAR(80) NOT NULL,
    Presupuesto_Proyecto DECIMAL(10, 2) NOT NULL,
    CONSTRAINT PRIMARY key (id_proyecto),
    CONSTRAINT proyecto_ibfk_1 FOREIGN key (id_cliente) REFERENCES cliente (id_cliente)
  ) ENGINE = InnoDB;

INSERT INTO
  cliente (
    id_cliente,
    nombre,
    apellido,
    telefono,
    correo,
    password
  )
VALUES
  (
    'zzzz',
    'zzzzzz',
    'zzzz',
    3535,
    'zzzz@zzzzzzz',
    'zzz'
  );

INSERT INTO
  proyecto (
    id_proyecto,
    id_cliente,
    Titulo_Proyecto,
    Descripcion_Proyecto,
    Fecha_Publicacion,
    Fecha_Limite,
    Presupuesto_Proyecto
  )
VALUES
  (
    '15434',
    'zzzz',
    'aoeu',
    'aoeu',
    'aoeu',
    'aoeu',
    35.00
  );