/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Dato.KilosMielJC;
import Servicios.Conexion;
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
public class KilosDao {

    private Connection connection;

    

    public KilosDao() throws URISyntaxException {
        connection = Conexion.getConnection();
    }

    public void addTabla(KilosMielJC tablaAdd) {
        try {
            System.out.println("Entro a Agregar");
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into TablasBD(Nombre, ID_FKSquema) values (?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, tablaAdd.getNombre());
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

    public void updateTabla(KilosMielJC tablaUP, int cs) {
        try {
            System.out.println("Entro a Acturalizar");
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update TablasBD set Nombre=?, ID_FKSquema=? where ID_Tabla=" + cs);
            // Parameters start with 1
            preparedStatement.setString(1, tablaUP.getNombre());
            preparedStatement.executeUpdate();
            System.out.println("Actualizo La Tabla");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<KilosMielJC> getAllTablas() {
        List<KilosMielJC> tablaLista = new ArrayList<KilosMielJC>();
        try {
            System.out.println("Emplezando a Listar");
            Statement statement = connection.createStatement();

//            ResultSet rs = statement.executeQuery("SELECT ID_Produccion, Fecha, Nombre, ID_FkColmena, sum(Kilos_Miel) FROM prodcionmbd WHERE prodcionmbd.ID_Produccion != 1234 and Kilos_Miel>2 GROUP BY prodcionmbd.ID_FkColmena");
            ResultSet rs = statement.executeQuery("SELECT * FROM prodcionmbd WHERE prodcionmbd.ID_Produccion != 1234 and Kilos_Miel>2");
            while (rs.next()) {
                KilosMielJC tablaLI = new KilosMielJC();
                tablaLI.setID_Produccion(rs.getInt("ID_Produccion"));
                tablaLI.setFecha(rs.getString("Fecha"));
                tablaLI.setNombre(rs.getString("Nombre"));
                tablaLI.setID_FkColmena(rs.getInt("ID_FkColmena"));
                tablaLI.setKilos_Miel(rs.getInt("Kilos_Miel"));
                tablaLista.add(tablaLI);
            }
            System.out.println("Se Termino de  Listar");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tablaLista;
    }

    public KilosMielJC getTablaById(int tablaId) {
        KilosMielJC tabla = new KilosMielJC();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from TablasBD where ID_Tabla=?");
            preparedStatement.setInt(1, tablaId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                tabla.setID_Produccion(rs.getInt("ID_Produccion"));
                tabla.setNombre(rs.getString("Nombre"));
                tabla.setID_FkColmena(rs.getInt("ID_FkColmena"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tabla;
    }

}
