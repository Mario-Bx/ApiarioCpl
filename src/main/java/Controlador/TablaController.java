/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import DAO.KilosDao;
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
public class TablaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Tabla.jsp";
    private static String LIST_USER = "/TablaLista.jsp";
    private KilosDao dao;

    public TablaController() throws URISyntaxException {
        super();
        dao = new KilosDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            System.out.println("Entro a la accion");
            int tablaId = Integer.parseInt(request.getParameter("TablaJspAc"));
            dao.deleteTabla(tablaId);
            forward = LIST_USER;
            ///primero va la tabla de sql
            request.setAttribute("TablaListaJsp", dao.getAllTablas());
            System.out.println(" Realizo la accion de eliminar");
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int tablaID = Integer.parseInt(request.getParameter("TablaJspAc"));
//            TablaJc tabla = dao.getTablaById(tablaID);
            ///primero va la tabla de sql
//            request.setAttribute("TablaJsp", tabla);
        } else if (action.equalsIgnoreCase("ListarTablasJspAC")) {
            forward = LIST_USER;            
            request.setAttribute("TablaListaJsp1", dao.getAllTablas());
            request.setAttribute("TablaListaJsp2", dao.getAllColmenas());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        TablaJc newTabla = new TablaJc();
//        newTabla.setNombre(request.getParameter("NombreHtml"));
//        newTabla.setIdFK_Squema(Integer.parseInt(request.getParameter("SquemaIdHtml")));

        String tablaid = request.getParameter("TablaIdHtml");

        if (tablaid == null || tablaid.isEmpty()) {
//            dao.addTabla(newTabla);
        } else {
//            newTabla.setId_Tabla(Integer.parseInt(tablaid));
            int tablaId = Integer.parseInt(request.getParameter("TablaIdHtml"));
//            dao.updateTabla(newTabla, tablaId);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("TablaListaJsp", dao.getAllTablas());
        view.forward(request, response);
    }

}
