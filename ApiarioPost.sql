CREATE TABLE FabricaBD (
  ID_Fabrica serial,
  Nombre varchar,
  PRIMARY KEY (ID_Fabrica)
);

CREATE TABLE ColmenaBD (
  ID_Colmena serial,
  Coordenadas varchar,
  Fecha_intalcion varchar,
  ID_FKFabrica int,
  ID_FkColmena int,
  PRIMARY KEY (ID_Colmena),
  FOREIGN KEY (ID_FKFabrica) REFERENCES FabricaBD (ID_Fabrica),
  FOREIGN KEY (ID_FkColmena) REFERENCES ColmenaBD (ID_Colmena)  
);

CREATE TABLE ProdcionMBD (
  ID_Produccion serial,
  Fecha varchar,
  Nombre varchar,
  ID_FkColmena int,
  Kilos_Miel int,
  PRIMARY KEY (ID_Produccion),
  FOREIGN KEY (ID_FkColmena) REFERENCES ColmenaBD (ID_Colmena)
);

CREATE TABLE InspectorBD (
  ID_Inspector serial,
  Nombre varchar,
  PRIMARY KEY (ID_Inspector)
);

CREATE TABLE VisitaTcBd (
  ID_Visita serial,
  Cantidad varchar,
  Calidad varchar,
  Reina varchar,
  ProducionMiel varchar,
  PanelCera int,
  PanelAlimento int,
  PanelCria int,
  PanelVacios int,
  ID_FKInspector int,
  ID_FkColmena int,
  PRIMARY KEY (ID_Visita),
  FOREIGN KEY (ID_FKInspector) REFERENCES InspectorBD (ID_Inspector),
  FOREIGN KEY (ID_FkColmena) REFERENCES ColmenaBD (ID_Colmena)  
);

INSERT INTO prodcionmbd (Fecha, Nombre, ID_FkColmena, Kilos_Miel) VALUES ('29/11/2017', 'Arturo', 1, 10);
INSERT INTO prodcionmbd (Fecha, Nombre, ID_FkColmena, Kilos_Miel) VALUES ('29/11/2017', 'Ositos', 2, 20);
INSERT INTO prodcionmbd (Fecha, Nombre, ID_FkColmena, Kilos_Miel) VALUES ('29/11/2017', 'Salasa', 1, 30);

INSERT INTO visitatcbd (Cantidad, Calidad, Reina, ProducionMiel, PanelCera, PanelAlimento, PanelCria, PanelVacios, ID_FKInspector, ID_FkColmena) VALUES ('Alta', 'Media', 'Si', 'No', 5, 5, 5, 5, 1, 1);
INSERT INTO visitatcbd (Cantidad, Calidad, Reina, ProducionMiel, PanelCera, PanelAlimento, PanelCria, PanelVacios, ID_FKInspector, ID_FkColmena) VALUES ('Baja', 'Alta', 'No', 'No', 3, 6, 9, 12, 2, 2);
INSERT INTO visitatcbd (Cantidad, Calidad, Reina, ProducionMiel, PanelCera, PanelAlimento, PanelCria, PanelVacios, ID_FKInspector, ID_FkColmena) VALUES ('Media', 'Baja', 'Si', 'Si', 8, 6, 4, 2, 3, 2);


