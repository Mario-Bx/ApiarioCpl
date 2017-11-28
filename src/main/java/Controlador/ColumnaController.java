/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ColumnaDao;
import Dato.ColumnaJc;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mario-Bx
 */
public class ColumnaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Columna.jsp";
    private static String LIST_USER = "/ColumnaLista.jsp";
    private ColumnaDao dao;

    public ColumnaController() throws URISyntaxException {
        super();
        dao = new ColumnaDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            System.out.println("Entro a la accion");
            int tablaId = Integer.parseInt(request.getParameter("ColumnaJspAc"));
            dao.deleteColumna(tablaId);
            forward = LIST_USER;
            ///primero va la tabla de sql
            request.setAttribute("ColumnaListaJsp", dao.getAllColumnaJcs());
            System.out.println(" Realizo la accion de eliminar");
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int tablaID = Integer.parseInt(request.getParameter("ColumnaJspAc"));
            ColumnaJc tabla = dao.getTablaById(tablaID);
            ///primero va la tabla de sql
            request.setAttribute("TablaListaJsp", dao.getAllTablas());
            request.setAttribute("ColumnaJsp", tabla);
        } else if (action.equalsIgnoreCase("ListarColumnasJspAC")) {
            forward = LIST_USER;
            request.setAttribute("ColumnaListaJsp", dao.getAllColumnaJcs());
        } else {
            forward = INSERT_OR_EDIT;
            request.setAttribute("TablaListaJsp", dao.getAllTablas());
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ColumnaJc newTabla = new ColumnaJc();
        newTabla.setNombre(request.getParameter("NombreHtml"));
        newTabla.setTipoDato(request.getParameter("TipoHtml"));
        newTabla.setFKColumna(Integer.parseInt(request.getParameter("PrimariaHtml")));
        newTabla.setIdFk_Tabla(Integer.parseInt(request.getParameter("FKTablaIdHtml")));

        String tablaid = request.getParameter("ColumnaIdHtml");

        if (tablaid == null || tablaid.isEmpty()) {
            dao.addColumna(newTabla);
        } else {
            newTabla.setFKColumna(Integer.parseInt(tablaid));
            int tablaId = Integer.parseInt(request.getParameter("ColumnaIdHtml"));
            dao.updateTabla(newTabla, tablaId);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("ColumnaListaJsp", dao.getAllColumnaJcs());
        view.forward(request, response);
    }
}
