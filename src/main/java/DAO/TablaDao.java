/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dato.Squema;
import Dato.TablaJc;
import Servicios.Conexion;
import Servicios.DbUtil;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario-Bx
 */
public class TablaDao {

    private Connection connection;

    public TablaDao() throws URISyntaxException {
        connection = Conexion.getConnection();
    }

    public void addTabla(TablaJc tablaAdd) {
        try {
            System.out.println("Entro a Agregar");
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into TablasBD(Nombre, ID_FKSquema) values (?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, tablaAdd.getNombre());
            preparedStatement.setInt(2, tablaAdd.getIdFK_Squema());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTabla(int TablaDl) {
        try {
            System.out.println("Entro a eliminar");
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from TablasBD where ID_Tabla=?");
            // Parameters start with 1
            preparedStatement.setInt(1, TablaDl);
            preparedStatement.executeUpdate();
            System.out.println("Elimino La Tabla");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTabla(TablaJc tablaUP, int cs) {
        try {
            System.out.println("Entro a Acturalizar");
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update TablasBD set Nombre=?, ID_FKSquema=? where ID_Tabla=" + cs);
            // Parameters start with 1
            preparedStatement.setString(1, tablaUP.getNombre());
            preparedStatement.setInt(2, tablaUP.getIdFK_Squema());
            preparedStatement.setInt(3, tablaUP.getId_Tabla());
            preparedStatement.executeUpdate();
            System.out.println("Actualizo La Tabla");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<TablaJc> getAllTablas() {
        List<TablaJc> tablaLista = new ArrayList<TablaJc>();
        try {
            System.out.println("Emplezando a Listar");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from TablasBD");
            while (rs.next()) {
                TablaJc tablaLI = new TablaJc();
                tablaLI.setId_Tabla(rs.getInt("ID_Tabla"));
                tablaLI.setNombre(rs.getString("Nombre"));
                tablaLI.setIdFK_Squema(rs.getInt("ID_FKSquema"));
                tablaLista.add(tablaLI);
            }
            System.out.println("Se Termino de  Listar");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tablaLista;
    }

    public TablaJc getTablaById(int tablaId) {
        TablaJc tabla = new TablaJc();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from TablasBD where ID_Tabla=?");
            preparedStatement.setInt(1, tablaId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                tabla.setId_Tabla(rs.getInt("ID_Tabla"));
                tabla.setNombre(rs.getString("Nombre"));
                tabla.setIdFK_Squema(rs.getInt("ID_FKSquema"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tabla;
    }

    public List<Squema> getAllSquemas() {
        List<Squema> squemaLista = new ArrayList<Squema>();
        try {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from squemas");
            while (rs.next()) {
                Squema squema = new Squema();
                squema.setId_Squema(rs.getInt("squemaid"));
                squema.setNombre(rs.getString("firstname"));
                squemaLista.add(squema);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return squemaLista;
    }

}
