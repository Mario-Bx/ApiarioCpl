/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.SquemaDao;
import Dato.Squema;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mario-Bx
 */
public class SquemaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Squema.jsp";
    private static String LIST_USER = "/SquemaLista.jsp";
    private SquemaDao dao;

    public SquemaController() {
        super();
        dao = new SquemaDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            System.out.println("Entro a la accion");
            int squemaId = Integer.parseInt(request.getParameter("Squemaid"));
            dao.deleteSquema(squemaId);
            forward = LIST_USER;
            ///primero va la tabla de sql
            request.setAttribute("squemas", dao.getAllSquemas());
            System.out.println(" Realizo la accion de eliminar");
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int squemaId = Integer.parseInt(request.getParameter("Squemaid"));
            Squema squema = dao.getSquemaById(squemaId);
            ///primero va la tabla de sql
            request.setAttribute("Squema", squema);
        } else if (action.equalsIgnoreCase("SquemaLista")) {
            forward = LIST_USER;
            request.setAttribute("squemas", dao.getAllSquemas());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Squema squema = new Squema();
        squema.setNombre(request.getParameter("Name"));
        String squemaid = request.getParameter("Squemaid");
        if (squemaid == null || squemaid.isEmpty()) {
            dao.addSquema(squema);
        } else {
            squema.setId_Squema(Integer.parseInt(squemaid));
            dao.updateSquema(squema);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("squemas", dao.getAllSquemas());
        view.forward(request, response);
    }

}
