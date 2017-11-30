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


<table border=1>
                        <thead>
                            <tr>
                                <th>ID Colmena</th>
                                <th>Coordenadas</th>
                                <th>Intalacion</th>
                                <th>Fabrica</th>
                                <th>Colmena Madre</th>
                                <th colspan=2>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<ColmenasJc> newCliente = (List<ColmenasJc>) request.getAttribute("TablaListaJsp2");
                                if (newCliente != null) {
                                    for (ColmenasJc cliente : newCliente) {
                            %>
                            <tr>
                                <td><%=cliente.getID_Colmena()%></td>
                                <td><%=cliente.getCoordenadas()%></td>
                                <td><%=cliente.getFecha_intalcion()%></td>
                                <td><%=cliente.getID_FKFabrica()%></td>
                                <td><%=cliente.getID_FkColmena()%></td>
                                <td><a href="TablaController?action=edit&TablaJspAc=<%=cliente.getID_Colmena()%>">Aatualizar</a></td>
                                <td><a href="TablaController?action=delete&TablaJspAc=<%=cliente.getID_Colmena()%>">Eliminar</a></td>
                            </tr>

                            <%
                                    }

                                }

                            %>

                        </tbody>
                    </table>





<table border=1>
                        <thead>
                            <tr>
                                <th>Tabla Id</th>
                                <th>Fecha</th>
                                <th>Nombre</th>
                                <th>Colmena Madre</th>
                                <th>Kilos de Miel</th>
                                <th colspan=2>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<KilosMielJC> newCliente = (List<KilosMielJC>) request.getAttribute("TablaListaJsp1");
                                if (newCliente != null) {
                                    for (KilosMielJC cliente : newCliente) {
                            %>
                            <tr>
                                <td><%=cliente.getID_Produccion()%></td>
                                <td><%=cliente.getFecha()%></td>
                                <td><%=cliente.getNombre()%></td>
                                <td><%=cliente.getID_FkColmena()%></td>
                                <td><%=cliente.getKilos_Miel()%></td>
                                <td><a href="TablaController?action=edit&TablaJspAc=<%=cliente.getID_Produccion()%>">Aatualizar</a></td>
                                <td><a href="TablaController?action=delete&TablaJspAc=<%=cliente.getID_Produccion()%>">Eliminar</a></td>
                            </tr>

                            <%
                                    }

                                }

                            %>

                        </tbody>
                    </table>