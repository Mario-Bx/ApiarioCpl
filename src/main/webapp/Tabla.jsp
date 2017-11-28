<%-- 
    Document   : Tabla
    Created on : 25/11/2017, 03:05:57 PM
    Author     : Mario-Bx
--%>

<%@page import="Dato.Squema"%>
<%@page import="java.util.List"%>
<%@page import="Dato.TablaJc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add new Tablas</title>
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
                        TablaJc newTabla = (TablaJc) request.getAttribute("frmAddSquema");
                        if (request.getParameter("action").equals("incertarAc")) {
                    %>
                    <form method="POST" action='TablaController' name="frmAddUser">
                        Tabla ID : <input type="text" readonly="readonly" name="TablaIdHtml"/>
                        <br /> 
                        Nombre Cliente : <input type="text" name="NombreHtml"/>
                        <br />
                        Id del Squema :
                        <SELECT name="SquemaIdHtml" SIZE="1"> 
                            <%
                                List<Squema> squemas = (List<Squema>) request.getAttribute("squemas");
                                if (squemas != null) {
                                    for (Squema squema : squemas) {
                            %>
                            <OPTION VALUE="<%=squema.getId_Squema()%>"><%=squema.getNombre()%></OPTION> 
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
                        TablaJc Squemas = (TablaJc) request.getAttribute("TablaJsp");
                    %>
                    <form method="POST" action='ClienteClontroller' name="frmAddSquema">
                        Cliente ID : <input type="text" readonly="readonly" name="TablaIdHtml" value="<%=Squemas.getId_Tabla()%>"/>
                        <br /> 
                        Nombre Cliente : <input type="text" name="NombreHtml" value="<%=Squemas.getNombre()%>"/>
                        <br />
                        Id del Squema : 
                        <SELECT name="SquemaIdHtml" SIZE="1"> 
                            <%
                                List<Squema> squemas = (List<Squema>) request.getAttribute("squemas");
                                if (squemas != null) {
                                    for (Squema squema : squemas) {
                                        if (Squemas.getIdFK_Squema() == squema.getId_Squema()) {
                            %>
                            <OPTION VALUE="<%=squema.getId_Squema()%>">(<%=squema.getNombre()%>)</OPTION> 
                                <%
                                    }
                                %>
                            <OPTION VALUE="<%=squema.getId_Squema()%>"><%=squema.getNombre()%></OPTION> 
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