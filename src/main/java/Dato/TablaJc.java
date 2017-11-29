/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

import java.util.*;

/**
 *
 * @author Mario-Bx
 */
public class TablaJc {

    private int id_Tabla;
    private String Nombre;
    private int idFK_Squema;


    public TablaJc() {
    }

    public TablaJc(int id_Tabla, String Nombre, int idFK_Tabla) {
        this.id_Tabla = id_Tabla;
        this.Nombre = Nombre;
        this.idFK_Squema = idFK_Tabla;
    }

    public int getIdFK_Squema() {
        return idFK_Squema;
    }

    public void setIdFK_Squema(int idFK_Columna) {
        this.idFK_Squema = idFK_Columna;
    }

    public int getId_Tabla() {
        return id_Tabla;
    }

    public void setId_Tabla(int id_Tabla) {
        this.id_Tabla = id_Tabla;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

}
