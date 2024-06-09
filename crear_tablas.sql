/* Creación tabla “agencias_airbnb” */

CREATE TABLE agencias_airbnb (
    id INT PRIMARY KEY,
    nombre VARCHAR(100)
);


/*Creación tabla “alojamiento”*/

CREATE TABLE alojamiento (
    id INT PRIMARY KEY,
    agencia_id INT,
    direccion VARCHAR(255),
    tipo VARCHAR(50),
    precio_noche FLOAT,
    estado VARCHAR(50),
    FOREIGN KEY (agencia_id) REFERENCES agencias_airbnb(id)
);


/*Creación tabla “reserva”*/


CREATE TABLE reserva (
    id INT PRIMARY KEY,
    alojamiento_id INT,
    cliente_id INT,
    fecha_inicio DATETIME,
    fecha_fin DATETIME,
    precio_total FLOAT,
    FOREIGN KEY (alojamiento_id) REFERENCES alojamiento(id),
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);


/*Creación tabla “clientes”*/


CREATE TABLE clientes (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100),
    telefono VARCHAR(20)
);

