create database ApiarioBDB;
use ApiarioBDB;

CREATE TABLE ApiarioBDB.FabricaBD (
  ID_Fabrica int(11) NOT NULL AUTO_INCREMENT,
  Nombre varchar(45) DEFAULT NULL,
  PRIMARY KEY (ID_Fabrica)
);

CREATE TABLE ApiarioBDB.ColmenaBD (
  ID_Colmena int(11) NOT NULL AUTO_INCREMENT,
  Coordenadas varchar(45) DEFAULT NULL,
  Fecha_intalcion varchar(45) DEFAULT NULL,
  ID_FKFabrica int(11),
  ID_FkColmena int(11),
  PRIMARY KEY (ID_Colmena),
  FOREIGN KEY (ID_FKFabrica) REFERENCES FabricaBD (ID_Fabrica),
  FOREIGN KEY (ID_FkColmena) REFERENCES ColmenaBD (ID_Colmena)  
);

CREATE TABLE ApiarioBDB.ProdcionMBD (
  ID_Produccion int(11) NOT NULL AUTO_INCREMENT,
  Fecha varchar(45) DEFAULT NULL,
  Nombre varchar(45) DEFAULT NULL,
  ID_FkColmena int(11),
  Kilos_Miel int(11),
  PRIMARY KEY (ID_Produccion),
  FOREIGN KEY (ID_FkColmena) REFERENCES ColmenaBD (ID_Colmena)
);

CREATE TABLE ApiarioBDB.InspectorBD (
  ID_Inspector int(11) NOT NULL AUTO_INCREMENT,
  Nombre varchar(45) DEFAULT NULL,
  PRIMARY KEY (ID_Inspector)
);

CREATE TABLE ApiarioBDB.VisitaTcBd (
  ID_Visita int(11) NOT NULL AUTO_INCREMENT,
  Cantidad varchar(45) DEFAULT NULL,
  Calidad varchar(45) DEFAULT NULL,
  Reina varchar(45) DEFAULT NULL,
  ProducionMiel varchar(45) DEFAULT NULL,
  PanelCera int(11),
  PanelAlimento int(11),
  PanelCria int(11),
  PanelVacios int(11),
  ID_FKInspector int(11),
  ID_FkColmena int(11),
  PRIMARY KEY (ID_Visita),
  FOREIGN KEY (ID_FKInspector) REFERENCES InspectorBD (ID_Inspector),
  FOREIGN KEY (ID_FkColmena) REFERENCES ColmenaBD (ID_Colmena)  
);

INSERT INTO prodcionmbd (Fecha, Nombre, ID_FkColmena, Kilos_Miel) VALUES ('29/11/2017', 'Arturo', 1, 10);
INSERT INTO prodcionmbd (Fecha, Nombre, ID_FkColmena, Kilos_Miel) VALUES ('29/11/2017', 'Ositos', 2, 20);
INSERT INTO prodcionmbd (Fecha, Nombre, ID_FkColmena, Kilos_Miel) VALUES ('29/11/2017', 'Salasa', 3, 30);

INSERT INTO visitatcbd (Cantidad, Calidad, Reina, ProducionMiel, PanelCera, PanelAlimento, PanelCria, PanelVacios, ID_FKInspector, ID_FkColmena) VALUES ('Alta', 'Media', 'Si', 'No', 5, 5, 5, 5, 1, 1);
INSERT INTO visitatcbd (Cantidad, Calidad, Reina, ProducionMiel, PanelCera, PanelAlimento, PanelCria, PanelVacios, ID_FKInspector, ID_FkColmena) VALUES ('Baja', 'Alta', 'No', 'No', 3, 6, 9, 12, 2, 2);
INSERT INTO visitatcbd (Cantidad, Calidad, Reina, ProducionMiel, PanelCera, PanelAlimento, PanelCria, PanelVacios, ID_FKInspector, ID_FkColmena) VALUES ('Media', 'Baja', 'Si', 'Si', 8, 6, 4, 2, 3, 2);


