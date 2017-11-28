<%-- 
    Document   : Columna
    Created on : 25/11/2017, 08:59:19 PM
    Author     : Mario-Bx
--%>

<%@page import="Dato.TablaJc"%>
<%@page import="java.util.List"%>
<%@page import="Dato.ColumnaJc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add new Columnas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum.scale=1.0">
        <link rel="stylesheet" href="ui/Css/MenuDesplegableSub.css">
        <link rel="stylesheet" href="ui/Css/Etilo Fomulario.css">
    </head>

    <body>
        <div id="Centrar">
            <div id="Telon" align="center">
                <div class="Menu">
                    <a href="Cliente.jsp"></a>
                    <header class="Menu_Des">
                        <input type="checkbox" id="btn_Menu">
                        <label for="btn_Menu"> <img class="icon"  src="ui/Imagenes/menu-icon.png"></label>
                        <div class="Menu">
                            <header class="Menu_Des">
                                <input type="checkbox" id="btn_Menu">
                                <label for="btn_Menu"> <img class="icon"  src="ui/Imagenes/menu-icon.png"></label>
                                <nav class="MenuCss">
                                    <ul>
                                        <li><a href="index.jsp"><span class="uno"><img class="icon" src="ui/Imagenes/icon1.png" /></span>Inicio</a></li>
                                        <li><a href="SquemaIndex.jsp"><span class="dos"><img class="icon" src="ui/Imagenes/Esquema.png" /> </span>Esquemas</a></li>
                                        <li><a href="TablaIndex.jsp"><span class="tres"><img class="icon" src="ui/Imagenes/Database-Table-icon.png" /> </span>Tablas</a></li>
                                        <li><a href="ColumnaIndex.jsp"><span class="cuatro"><img class="icon" src="ui/Imagenes/Columna.png" /> </span>Columnas</a></li>
                                    </ul>
                                </nav>
                            </header>                
                        </div>
                    </header>                
                </div>

                <div class="form-style-5">
                    <%
                        ColumnaJc newTabla = (ColumnaJc) request.getAttribute("frmAddSquema");
                        if (request.getParameter("action").equals("incertarAc")) {
                    %>
                    <form method="POST" action='ColumnaController' name="frmAddUser">
                        Columna ID : <input type="text" readonly="readonly" name="ColumnaIdHtml"/>
                        <br /> 
                        Nombre Columna : <input type="text" name="NombreHtml"/>
                        <br />
                        Tipo De Dato :
                        <SELECT name="TipoHtml" SIZE="1"> 
                            <OPTION VALUE="Integer">Integer</OPTION>
                            <OPTION VALUE="Double">Double</OPTION> 
                            <OPTION VALUE="String">String</OPTION> 
                            <OPTION VALUE="Float">Float</OPTION>                              
                        </SELECT>
                        <br />
                        llave primaria : 
                        <SELECT name="PrimariaHtml" SIZE="1"> 
                            <OPTION VALUE="0">No</OPTION> 
                            <OPTION VALUE="1">Si</OPTION> 
                        </SELECT> 
                        <br />
                        Id de la Tabla : 
                        <SELECT name="FKTablaIdHtml" SIZE="1"> 
                            <%
                                List<TablaJc> newCliente = (List<TablaJc>) request.getAttribute("TablaListaJsp");
                                if (newCliente != null) {
                                    for (TablaJc cliente : newCliente) {
                            %>
                            <OPTION VALUE="<%=cliente.getId_Tabla()%>"><%=cliente.getNombre()%></OPTION> 
                                <%
                                        }
                                    }
                                %>
                        </SELECT>
                        <br />
                        <input type="submit" value="Insertar" />
                    </form>




                    <%
                    } else if ((request.getParameter("action").equals("edit"))) {
                        ColumnaJc Squemas = (ColumnaJc) request.getAttribute("ColumnaJsp");
                    %>
                    <form method="POST" action='ColumnaController' name="frmAddSquema">
                        Columna ID : <input type="text" readonly="readonly" name="TablaIdHtml" value="<%=Squemas.getId_Colnmna()%>"/>
                        <br /> 
                        Nombre Columna : <input type="text" name="NombreHtml" value="<%=Squemas.getNombre()%>"/>
                        <br />
                        Tipo De Dato :
                        <SELECT name="TipoHtml" SIZE="1"> 
                            <OPTION VALUE="<%=Squemas.getTipoDato()%>">(<%=Squemas.getTipoDato()%>)</OPTION>
                            <OPTION VALUE="Integer">Integer</OPTION>
                            <OPTION VALUE="Double">Double</OPTION> 
                            <OPTION VALUE="String">String</OPTION> 
                            <OPTION VALUE="Float">Float</OPTION>                              
                        </SELECT>
                        <br />
                        llave primaria : 
                        <SELECT name="PrimariaHtml" SIZE="1"> 
                            <OPTION VALUE="<%=Squemas.getFKColumna()%>">
                                <%
                                    if (Squemas.getFKColumna() == 0) {
                                %>
                                (NO)
                                <%
                                } else {
                                %>
                                (SI)
                                <%
                                    }
                                %>                        
                            </OPTION>
                            <OPTION VALUE="0">No</OPTION> 
                            <OPTION VALUE="1">si</OPTION> 
                        </SELECT>
                        <br />
                        Id de la Tabla : 
                        <SELECT name="FKTablaIdHtml" SIZE="1"> 

                            <%
                                List<TablaJc> newCliente = (List<TablaJc>) request.getAttribute("TablaListaJsp");

                                if (newCliente != null) {
                                    for (TablaJc cliente : newCliente) {
                                        if (Squemas.getIdFk_Tabla() == cliente.getId_Tabla()) {
                            %>
                            <OPTION VALUE="<%=cliente.getId_Tabla()%>">(<%=cliente.getNombre()%>)</OPTION> 
                                <%
                                    }
                                %>
                            <OPTION VALUE="<%=cliente.getId_Tabla()%>"><%=cliente.getNombre()%></OPTION> 
                                <%
                                        }
                                    }
                                %>
                        </SELECT>
                        <br />
                        <input type="submit" value="Editar" />
                    </form>
                    <%
                        }
                    %>
                </div>

            </div>
        </div>

    </body>
</html>