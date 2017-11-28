/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dato.Squema;
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
public class SquemaDao {

    private Connection connection;

    public SquemaDao() throws URISyntaxException {
        connection = Conexion.getConnection();
    }

    public void addSquema(Squema squema) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into squemas(firstname) values (?)");
            // Parameters start with 1
            preparedStatement.setString(1, squema.getNombre());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSquema(int squemaId) {
        try {
            System.out.println("Entro a eliminar");
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from squemas where Squemaid=?");
            // Parameters start with 1
            preparedStatement.setInt(1, squemaId);
            preparedStatement.executeUpdate();
            System.out.println("Elimino El  Esquema");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSquema(Squema squema) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update squemas set firstname=?"
                            + "where Squemaid=?");
            // Parameters start with 1
            preparedStatement.setString(1, squema.getNombre());
            preparedStatement.setInt(2, squema.getId_Squema());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public Squema getSquemaById(int squemaId) {
        Squema squema = new Squema();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from squemas where Squemaid=?");
            preparedStatement.setInt(1, squemaId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                squema.setId_Squema(rs.getInt("squemaid"));
                squema.setNombre(rs.getString("firstname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return squema;
    }
}
