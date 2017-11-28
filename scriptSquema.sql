create database EsqBaseD;
use EsqBaseD;

CREATE TABLE EsqBaseD.`Squemas` (
  `Squemaid` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Squemaid`)
);

CREATE TABLE EsqBaseD.`TablasBD` (
  `ID_Tabla` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `ID_FKSquema` int(11),
  PRIMARY KEY (`ID_Tabla`),
  FOREIGN KEY (ID_FKSquema) REFERENCES Squemas (Squemaid) 
);

CREATE TABLE EsqBaseD.`ColumnasBD` (
  `ID_Columna` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `TipoDato` varchar(45) DEFAULT NULL,
  `PKColumna` bool,  
  `ID_FKTabla` int(11),
  PRIMARY KEY (`ID_Columna`),
  FOREIGN KEY (ID_FKTabla) REFERENCES TablasBD (ID_Tabla) 
);