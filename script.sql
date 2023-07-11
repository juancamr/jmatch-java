DROP jmatch;

CREATE DATABASE if NOT EXISTS jmatch;

USE jmatch;

CREATE TABLE
    if NOT EXISTS cliente (
        id_cliente INT NOT NULL AUTO_INCREMENT,
        nombre VARCHAR(50) NOT NULL,
        apellido VARCHAR(50) NOT NULL,
        correo VARCHAR(50) NOT NULL,
        passwd VARCHAR(80) NOT NULL,
        telefono VARCHAR(20) NOT NULL,
        CONSTRAINT pk_id_cliente PRIMARY KEY (id_cliente),
        CONSTRAINT correo_cliente UNIQUE (correo)
    ) ENGINE = INNODB;

CREATE TABLE
    if NOT EXISTS freelancer (
        id_freelancer INT NOT NULL AUTO_INCREMENT,
        nombre VARCHAR(50) NOT NULL,
        apellido VARCHAR(50) NOT NULL,
        foto VARCHAR(200) NOT NULL,
        descripcion TEXT,
        correo VARCHAR(50) NOT NULL,
        passwd VARCHAR(80) NOT NULL,
        telefono VARCHAR(20) NOT NULL,
        categoria VARCHAR(30) NOT NULL,
        CONSTRAINT pk_id_freelancer PRIMARY KEY (id_freelancer),
        CONSTRAINT correo_freelancer UNIQUE (correo)
    ) ENGINE = INNODB;

CREATE TABLE
    if NOT EXISTS portfolio (
        id_portfolio INT NOT NULL AUTO_INCREMENT,
        id_freelancer INT NOT NULL,
        portada VARCHAR(200),
        titulo VARCHAR(100) NOT NULL,
        contenido TEXT,
        CONSTRAINT pk_id_portfolio PRIMARY KEY (id_portfolio),
        CONSTRAINT fk_id_freelancer_portfolio FOREIGN KEY (id_freelancer) REFERENCES freelancer (id_freelancer)
    ) ENGINE = INNODB;

CREATE TABLE
    if NOT EXISTS chat (
        id_chat INT NOT NULL AUTO_INCREMENT,
        id_cliente INT NOT NULL,
        id_freelancer INT NOT NULL,
        fecha_creacion DATE,
        CONSTRAINT pk_id_chat PRIMARY KEY (id_chat),
        CONSTRAINT fk_id_freelancer_chat FOREIGN KEY (id_freelancer) REFERENCES freelancer (id_freelancer),
        CONSTRAINT fk_id_cliente_chat FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
    ) ENGINE = INNODB;

CREATE TABLE
    if NOT EXISTS mensaje (
        id_mensaje INT NOT NULL AUTO_INCREMENT,
        id_chat INT NOT NULL,
        emisor VARCHAR(30) NOT NULL,
        contenido text NOT NULL,
        fecha_envio DATE NOT NULL,
        hora_envio VARCHAR(15) NOT NULL,
        CONSTRAINT pk_id_mensaje PRIMARY key (id_mensaje),
        CONSTRAINT fk_id_chat_mensaje FOREIGN key (id_chat) REFERENCES chat (id_chat)
    ) ENGINE = INNODB;

CREATE TABLE
    if NOT EXISTS propuesta (
        id_propuesta INT NOT NULL AUTO_INCREMENT,
        id_freelancer INT NOT NULL,
        id_cliente INT NOT NULL,
        descripcion_propuesta TEXT,
        fecha_presentacion DATE,
        presupuesto DECIMAL(10, 2),
        CONSTRAINT pk_id_propuesta PRIMARY key (id_propuesta),
        CONSTRAINT fk_id_freelancer_propuesta FOREIGN key (id_freelancer) REFERENCES freelancer (id_freelancer),
        CONSTRAINT fk_id_cliente_propuesta FOREIGN key (id_cliente) REFERENCES cliente (id_cliente)
    ) ENGINE = INNODB;

CREATE TABLE
    if NOT EXISTS proyecto (
        id_proyecto INT NOT NULL AUTO_INCREMENT,
        id_propuesta INT NOT NULL,
        titulo_proyecto VARCHAR(60) NOT NULL,
        descripcion_proyecto text,
        fecha_entrega DATE,
        presupuesto_proyecto DECIMAL(10, 2),
        CONSTRAINT pk_id_proyecto PRIMARY key (id_proyecto),
        CONSTRAINT fk_id_propuesta_proyecto FOREIGN key (id_propuesta) REFERENCES propuesta (id_propuesta)
    ) ENGINE = INNODB;

CREATE TABLE
    if NOT EXISTS recibo (
        id_recibo INT NOT NULL AUTO_INCREMENT,
        id_cliente INT NOT NULL,
        id_freelancer INT NOT NULL,
        id_proyecto INT NOT NULL,
        fecha DATE NOT NULL,
        monto_total DECIMAL(10, 2),
        CONSTRAINT pk_id_recibo PRIMARY key (id_recibo),
        CONSTRAINT fk_id_cliente_recibo FOREIGN key (id_cliente) REFERENCES cliente (id_cliente),
        CONSTRAINT fk_id_freelancer_recibo FOREIGN key (id_freelancer) REFERENCES freelancer (id_freelancer),
        CONSTRAINT fk_id_proyecto_recibo FOREIGN key (id_proyecto) REFERENCES proyecto (id_proyecto)
    ) ENGINE = INNODB;

CREATE TABLE
    if NOT EXISTS valoracion (
        id_valoracion INT NOT NULL AUTO_INCREMENT,
        id_freelancer INT NOT NULL,
        id_cliente INT NOT NULL,
        valoracion INT,
        comentario text,
        CONSTRAINT pk_id_valoracion PRIMARY key (id_valoracion),
        CONSTRAINT fk_id_freelancer_valoracion FOREIGN key (id_freelancer) REFERENCES freelancer (id_freelancer),
        CONSTRAINT fk_id_cliente_valoracion FOREIGN key (id_cliente) REFERENCES cliente (id_cliente)
    ) ENGINE = INNODB;