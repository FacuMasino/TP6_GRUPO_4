CREATE DATABASE `bdPersonas`;
USE bdPersonas;
CREATE TABLE `Personas`
(
`Dni` varchar(20) NOT NULL,
`Nombre` varchar(45) NOT NULL,
`Apellido` varchar(45) NOT NULL,
PRIMARY KEY (`Dni`));