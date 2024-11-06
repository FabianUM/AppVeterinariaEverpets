CREATE DATABASE VeterinariaEverpets;
USE VeterinariaEverpets;

-- creando tabla ROLES
CREATE TABLE ROLES(
idRol INT PRIMARY KEY,
descripcion VARCHAR(20) NOT NULL,
esActivo INT -- 1 (activo) 2 (no activo)
); 

INSERT INTO ROLES (idRol,descripcion,esActivo) VALUES
(1,'administrador',1),
(2,'supervisor',1),
(3,'empleado',1);


-- creando tabla USUARIOS
CREATE TABLE USUARIOS(
idUsuario INT AUTO_INCREMENT PRIMARY KEY,
apellidos VARCHAR(50) NOT NULL,
nombres VARCHAR(50) NOT NULL,
correo VARCHAR(50) NOT NULL,
clave VARCHAR(10) NOT NULL,
esActivo INT, -- 1 (activo) 2 (no activo)
imagen MEDIUMBLOB,
idRol INT NOT NULL,
KEY `fk_rol_idx` (`idRol`),
CONSTRAINT `fk_rol_idx` FOREIGN KEY (`idRol`) REFERENCES `ROLES` (`idRol`)
);

INSERT INTO USUARIOS (apellidos,nombres,correo,clave,idRol,esActivo) VALUES
('urcia','fabian','fabian@gmail.com','321',2,1),
('urcia','julio','julio@gmail.com','1234',3,1),
('mendives','israel','israel@gmail.com','123',1,1);



-- creando tabla EMPRESA
CREATE TABLE EMPRESA(
idEmpresa INT AUTO_INCREMENT PRIMARY KEY,
RUC VARCHAR(11) NOT NULL,
Nombre VARCHAR(100) NOT NULL,
Telefono VARCHAR(9) NOT NULL,
Direccion VARCHAR(100) NOT NULL,
imagen MEDIUMBLOB
);

INSERT INTO EMPRESA (RUC,Nombre,Telefono,Direccion) VALUES
('12345678901','Vterinaria Everpets','994114515','Saenz Peña');



-- creando tabla TIPO_MASCOTA
CREATE TABLE TIPO_MASCOTA(
idTipoMascota INT AUTO_INCREMENT PRIMARY KEY,
Nombre_TipoMascota VARCHAR(40)
);

INSERT INTO TIPO_MASCOTA VALUES
(1,'Perro'),
(2,'Gato'),
(3,'Conejo');



-- tabla de los dueños de las mascotas
CREATE TABLE PROPIETARIO(
idPropietario INT AUTO_INCREMENT PRIMARY KEY,
DNI VARCHAR(8) NOT NULL,
Nombres VARCHAR(40),
Apellidos VARCHAR(40),
Direccion VARCHAR(40),
Telefono VARCHAR(9),
Correo VARCHAR(40)
);

-- insertando en la tabla PROPIETARIO
INSERT INTO PROPIETARIO (DNI,Nombres,Apellidos,Direccion,Telefono,Correo) VALUES
('72724534','Fabian Israel','Urcia Mendives','Callao','967637050','fabian.israel.07@gmail.com'),
('42027952','Miluska Mercedes','Mendives Vilchez','Callao','947826248','miluskamercedezv@gmail.com'),
('25566430','Julio Cesar','Urcia Vilchez','Callao','960551530','julio23.a56@gmail.com');


-- creando la tabla MASCOTA
CREATE TABLE MASCOTA(
idMascota VARCHAR(8) NOT NULL PRIMARY KEY,
Nombre_mascota VARCHAR(40),
Sexo_mascota VARCHAR(1) NOT NULL,
Edad_mascota INT(2),
Peso_mascota DOUBLE,
idTipoMascota INT NOT NULL,
idPropietario INT NOT NULL,
KEY `fk_tipo_mascotas_idx` (`idTipoMascota`),
KEY `fk_propietario_idx` (`idPropietario`),
CONSTRAINT `fk_tipo_mascotas_idx` FOREIGN KEY (`idTipoMascota`) REFERENCES `TIPO_MASCOTA` (`idTipoMascota`),
CONSTRAINT `fk_propietario_idx` FOREIGN KEY (`idPropietario`) REFERENCES `PROPIETARIO` (`idPropietario`)
);

 -- Trigger Codigo idMascota
delimiter $
CREATE TRIGGER GenerarCodigo_mascota BEFORE INSERT ON MASCOTA FOR EACH ROW
BEGIN
	DECLARE siguiente_codigo INT;
	SET siguiente_codigo=(SELECT IFNULL(MAX(CONVERT(SUBSTRING(IdMascota,7),SIGNED INTEGER)),0)FROM MASCOTA) +1;
	SET NEW.IdMascota=CONCAT('PET-',LPAD(siguiente_codigo,4,'0'));
END $

-- codigo eliminar trigger
-- drop trigger GenerarCodigo_mascota


INSERT INTO MASCOTA (Nombre_mascota,Sexo_mascota,idTipoMascota,Edad_mascota,Peso_mascota,idPropietario) VALUES
('Chester','M',1,2,25.3,1);



-- creando la tabla CARNET_MASCOTA
CREATE TABLE CARNET_MASCOTA(
idCarnet INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
imagen MEDIUMBLOB,
idMascota VARCHAR(8) NOT NULL,
KEY `fk_mascota_idx` (`idMascota`),
CONSTRAINT `fk_mascota_idx` FOREIGN KEY (`idMascota`) REFERENCES `MASCOTA` (`idMascota`),
CONSTRAINT `unique_idMascota` UNIQUE (`idMascota`)
);



-- creando tabla SERVICIOS
CREATE TABLE SERVICIOS(
idServicios INT AUTO_INCREMENT PRIMARY KEY,
NombreServicio VARCHAR(40) NOT NULL,
precioServicio DOUBLE NOT NULL,
idTipoMascota INT NOT NULL,
KEY `fk_tipo_mascotas_2_idx` (`idTipoMascota`),
CONSTRAINT `fk_tipo_mascotas_2_idx` FOREIGN KEY (`idTipoMascota`) REFERENCES `TIPO_MASCOTA` (`idTipoMascota`)
);

INSERT INTO SERVICIOS VALUES
(1,'Baño y corte de pelo',34.50,1),
(2,'Desparacitacion',49.10,1),
(3,'Adiestramiento',40,1),
(4,'Operacion',120,1);
INSERT INTO SERVICIOS (NombreServicio,idTipoMascota,precioServicio)
VALUES('Desparacitacion',2,34.50);


 -- creando tabla VETERINARIO
 CREATE TABLE VETERINARIO(
 idVeterinario VARCHAR(8) NOT NULL PRIMARY KEY,
 NombresVeterinario VARCHAR(40),
 ApellidosVeterinario VARCHAR(40),
 Sueldo DOUBLE,
 estado INT, -- activo(1) inactivo (0)
 idTipoMascota INT NOT NULL,
 idServicios INT NOT NULL,
 KEY `fk_tipo_mascotas2_idx` (`idTipoMascota`),
 KEY `fk_tipo_servicios_idx` (`idServicios`),
 CONSTRAINT `fk_tipo_mascotas2_idx` FOREIGN KEY (`idTipoMascota`) REFERENCES `TIPO_MASCOTA` (`idTipoMascota`),
 CONSTRAINT `fk_tipo_servicios_idx` FOREIGN KEY (`idServicios`) REFERENCES `SERVICIOS` (`idServicios`)
);

 -- Trigger Codigo IdVeterinario
delimiter $
CREATE TRIGGER GenerarCodigo_veterinario BEFORE INSERT ON VETERINARIO FOR EACH ROW
BEGIN
	DECLARE siguiente_codigo INT;
	SET siguiente_codigo=(SELECT IFNULL(MAX(CONVERT(SUBSTRING(IdVeterinario,7),SIGNED INTEGER)),0)FROM VETERINARIO) +1;
	SET NEW.IdVeterinario=CONCAT('VET-',LPAD(siguiente_codigo,4,'0'));
END $

INSERT INTO VETERINARIO (NombresVeterinario,ApellidosVeterinario,Sueldo,estado,idTipoMascota,idServicios) VALUES
('Alonso','Belaunde',1400.00,1,1,1);


-- creando tabla TURNO
CREATE TABLE TURNO(
idTurno INT AUTO_INCREMENT PRIMARY KEY,
hora TIME,
estado INT DEFAULT 1, -- inactivo (0) activo (1)
descripcion VARCHAR(40)
);

INSERT INTO TURNO(hora,estado,descripcion) VALUES
('08:00',1,'2 horas y 30 min'),
('11:00',1,'30 min');



-- creando tabla ESTADO de CITAS
CREATE TABLE ESTADO_CITA(
idEstado INT AUTO_INCREMENT PRIMARY KEY,
TipoEstado VARCHAR(40)
);

INSERT INTO ESTADO_CITA(TipoEstado) VALUES
('Pendiente'),
('Terminado'),
('Cancelado');



-- creando tabla CITA
CREATE TABLE CITA(
IdCita VARCHAR(9) NOT NULL PRIMARY KEY,

Precio DOUBLE NOT NULL,
Descripcion VARCHAR(100),
FechaCita DATE NOT NULL,

idMascota VARCHAR(8) NOT NULL,
idVeterinario VARCHAR(8) NOT NULL,
idTurno INT NOT NULL,
idServicios INT NOT NULL,
idEstado INT NOT NULL,

KEY `fk_mascota_idx` (`idMascota`),
KEY `fk_veterinario_idx` (`idVeterinario`),
KEY `fk_turno_idx` (`idTurno`),
KEY `fk_tipo_servicios2_idx` (`idServicios`),
KEY `fk_estado_idx` (`idEstado`),
CONSTRAINT `fk_mascota2_idx` FOREIGN KEY (`idMascota`) REFERENCES `MASCOTA` (`idMascota`),
CONSTRAINT `fk_veterinario_idx` FOREIGN KEY (`idVeterinario`) REFERENCES `VETERINARIO` (`idVeterinario`),
CONSTRAINT `fk_turno_idx` FOREIGN KEY (`idTurno`) REFERENCES `TURNO` (`idTurno`),
CONSTRAINT `fk_tipo_servicio2s_idx` FOREIGN KEY (`idServicios`) REFERENCES `SERVICIOS` (`idServicios`),
CONSTRAINT `fk_estado_idx` FOREIGN KEY (`idEstado`) REFERENCES `ESTADO_CITA` (`idEstado`)
);
 
 -- Trigger Codigo IdCita
delimiter $
CREATE TRIGGER GenerarCodigo_citaVet BEFORE INSERT ON CITA FOR EACH ROW
BEGIN
	DECLARE siguiente_codigo INT;
	SET siguiente_codigo=(SELECT IFNULL(MAX(CONVERT(SUBSTRING(IdCita,8),SIGNED INTEGER)),0)FROM CITA) +1;
	SET NEW.IdCita=CONCAT('CITA-',LPAD(siguiente_codigo,4,'0'));
END $

INSERT INTO CITA (idMascota,FechaCita,idTurno,idServicios,idVeterinario,Precio,Descripcion,idEstado) VALUES
('PET-0001','2024-03-22',1,2,'VET-0001',200.00,'Requiere desparacitacion de la mascota',1);



-- creando tabla TICKET
CREATE TABLE TICKET(
idTicket INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
IdCita VARCHAR(9) NOT NULL,

KEY `fk_cita_idx` (`IdCita`),
CONSTRAINT `fk_cita_idx` FOREIGN KEY (`IdCita`) REFERENCES `CITA` (`IdCita`)
);

-- trigger que hace inserción de ticket automaticamente luego de insercion a la tabla cita
delimiter $
CREATE TRIGGER InsertarTicket AFTER INSERT ON CITA FOR EACH ROW
BEGIN
    INSERT INTO TICKET (IdCita) VALUES (NEW.IdCita);
END $
delimiter ;



-- creando tabla RECIBO
CREATE TABLE RECIBO(
idRecibo INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
IdCita VARCHAR(9) NOT NULL,

KEY `fk_cita2_idx` (`IdCita`),
CONSTRAINT `fk_cita2_idx` FOREIGN KEY (`IdCita`) REFERENCES `CITA` (`IdCita`)
);

-- trigger que hace inserción de recibo automaticamente luego de terminar una cita
delimiter $
CREATE TRIGGER InsertarRecibo AFTER UPDATE ON CITA FOR EACH ROW
BEGIN
    IF NEW.idEstado = 2 AND OLD.idEstado != 2 THEN
        INSERT INTO RECIBO (IdCita) VALUES (NEW.IdCita);
    END IF;
END $
delimiter ;







-- ***************************************** CONSULTAS SQL *****************************************
SELECT * FROM ROLES;
SELECT * FROM USUARIOS;
SELECT * FROM EMPRESA;
SELECT * FROM TICKET;
SELECT * FROM ESTADO_CITA;
SELECT * FROM MASCOTA;
SELECT * FROM TURNO;

SELECT t.idTicket, t.idCita, c.FechaCita, tu.Hora 
FROM TICKET t 
INNER JOIN CITA c ON c.idCita=t.idCita  
INNER JOIN TURNO tu ON tu.idTurno=c.idTurno
WHERE c.idMascota='PET-0001';

SELECT p.Nombres, p.Apellidos, p.DNI, m.idMascota, m.Nombre_mascota, s.NombreServicio, v.NombresVeterinario, v.ApellidosVeterinario, c.FechaCita, t.hora, c.Precio
FROM RECIBO r
INNER JOIN CITA c ON r.IdCita=c.IdCita
INNER JOIN MASCOTA m ON c.IdMascota=m.IdMascota
INNER JOIN PROPIETARIO p ON m.IdPropietario=p.IdPropietario
INNER JOIN SERVICIOS s ON c.idServicios=s.idServicios
INNER JOIN VETERINARIO v ON c.idVeterinario=v.idVeterinario
INNER JOIN TURNO t ON c.idTurno=t.idTurno
WHERE r.IdCita='CITA-0001';



SELECT tm.Nombre_TipoMascota, COUNT(m.idMascota) AS cantidad 
FROM MASCOTA m 
JOIN TIPO_MASCOTA tm ON m.idTipoMascota = tm.idTipoMascota 
GROUP BY tm.Nombre_TipoMascota;

SELECT p.Nombres, COUNT(m.idMascota) AS cantidad
FROM PROPIETARIO p 
LEFT JOIN MASCOTA m ON p.idPropietario = m.idPropietario
GROUP BY p.Nombres;

-- Datos EMPRESA
SELECT MAX(idEmpresa) as idEmpresa, RUC, Nombre, Telefono, Direccion, Imagen FROM EMPRESA GROUP BY idEmpresa;

