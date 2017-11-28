<%-- 
    Document   : TablaLista
    Created on : 25/11/2017, 02:28:42 PM
    Author     : Mario-Bx
--%>

<%@page import="java.util.List"%>
<%@page import="Dato.TablaJc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tablas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum.scale=1.0">
        <link rel="stylesheet" href="ui/Css/MenuDesplegableSub.css">
        <link rel="stylesheet" href="ui/Css/Etilo Fomulario.css">
    </head>

    <body>
        <div id="Centrar">
            <div id="Telon" align="center">
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

                <div class="form-style-5">
                    <a href="TablaController?action=incertarAc"><input type="submit" value="Add Tabla"/></a>
                    <table border=1>
                        <thead>
                            <tr>
                                <th>Tabla Id</th>
                                <th>Nombre</th>
                                <th>ID del Squema</th>
                                <th colspan=2>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<TablaJc> newCliente = (List<TablaJc>) request.getAttribute("TablaListaJsp");
                                if (newCliente != null) {
                                    for (TablaJc cliente : newCliente) {
                            %>
                            <tr>
                                <td><%=cliente.getId_Tabla()%></td>
                                <td><%=cliente.getNombre()%></td>
                                <td><%=cliente.getIdFK_Squema()%></td>
                                <td><a href="TablaController?action=edit&TablaJspAc=<%=cliente.getId_Tabla()%>">Aatualizar</a></td>
                                <td><a href="TablaController?action=delete&TablaJspAc=<%=cliente.getId_Tabla()%>">Eliminar</a></td>
                            </tr>

                            <%
                                    }

                                }

                            %>

                        </tbody>
                    </table>

                </div>

            </div>
        </div>

    </body>
</html>