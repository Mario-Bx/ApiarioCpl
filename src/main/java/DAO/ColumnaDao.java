/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dato.ColumnaJc;
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
public class ColumnaDao {

    private Connection connection;

    public ColumnaDao() throws URISyntaxException {
        connection = Conexion.getConnection();
    }

    public void addColumna(ColumnaJc columnaAdd) {
        try {
            System.out.println("Entro a Agregar");
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into ColumnasBD(Nombre, TipoDato, PKColumna, ID_FKTabla) values (?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, columnaAdd.getNombre());
            preparedStatement.setString(2, columnaAdd.getTipoDato());
            preparedStatement.setInt(3, columnaAdd.getFKColumna());
            preparedStatement.setInt(4, columnaAdd.getIdFk_Tabla());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteColumna(int TablaDl) {
        try {
            System.out.println("Entro a eliminar");
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from ColumnasBD where ID_Columna=?");
            // Parameters start with 1
            preparedStatement.setInt(1, TablaDl);
            preparedStatement.executeUpdate();
            System.out.println("Elimino La Tabla");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTabla(ColumnaJc columnaUP, int cs) {
        try {
            System.out.println("Entro a Acturalizar");
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update ColumnasBD set Nombre=?, TipoDato=?, PKColumna=?, ID_FKTabla,? where ID_Tabla=" + cs);
            // Parameters start with 1
            preparedStatement.setString(1, columnaUP.getNombre());
            preparedStatement.setString(1, columnaUP.getTipoDato());
            preparedStatement.setInt(2, columnaUP.getFKColumna());
            preparedStatement.setInt(3, columnaUP.getIdFk_Tabla());
            preparedStatement.executeUpdate();
            System.out.println("Actualizo La Tabla");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ColumnaJc> getAllColumnaJcs() {
        List<ColumnaJc> tablaLista = new ArrayList<ColumnaJc>();
        try {
            System.out.println("Emplezando a Listar");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from ColumnasBD");
            while (rs.next()) {
                ColumnaJc tablaLI = new ColumnaJc();
                tablaLI.setId_Colnmna(rs.getInt("ID_Columna"));
                tablaLI.setNombre(rs.getString("Nombre"));
                tablaLI.setTipoDato(rs.getString("TipoDato"));
                tablaLI.setFKColumna(rs.getInt("PKColumna"));
                tablaLI.setIdFk_Tabla(rs.getInt("ID_FKTabla"));
                tablaLista.add(tablaLI);
            }
            System.out.println("Se Termino de  Listar");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tablaLista;
    }

    public ColumnaJc getTablaById(int tablaId) {
        ColumnaJc tabla = new ColumnaJc();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from ColumnasBD where ID_Columna=?");
            preparedStatement.setInt(1, tablaId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                tabla.setId_Colnmna(rs.getInt("ID_Columna"));
                tabla.setNombre(rs.getString("Nombre"));
                tabla.setTipoDato(rs.getString("TipoDato"));
                tabla.setFKColumna(rs.getInt("PKColumna"));
                tabla.setIdFk_Tabla(rs.getInt("ID_FKTabla"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tabla;
    }

    public List<TablaJc> getAllTablas() {
        List<TablaJc> tablaLista = new ArrayList<TablaJc>();
        try {
            System.out.println("Emplezando a Listar Tablas");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from TablasBD");
            while (rs.next()) {
                TablaJc tablaLI = new TablaJc();
                tablaLI.setId_Tabla(rs.getInt("ID_Tabla"));
                tablaLI.setNombre(rs.getString("Nombre"));
                tablaLista.add(tablaLI);
            }
            System.out.println("Se Termino de  Listar Tablas");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tablaLista;
    }

}
