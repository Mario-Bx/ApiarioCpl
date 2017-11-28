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
public class Squema {

    private int id_Squema;
    private String Nombre;
    ArrayList<TablaJc> listaTablas = new ArrayList<TablaJc>();

    public Squema() {
    }

    public Squema(int id_Squema, String Nombre) {
        this.id_Squema = id_Squema;
        this.Nombre = Nombre;
    }

    public int getId_Squema() {
        return id_Squema;
    }

    public void setId_Squema(int id_Squema) {
        this.id_Squema = id_Squema;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public ArrayList<TablaJc> getListaTablas() {
        return listaTablas;
    }

    public void setListaTablas(ArrayList<TablaJc> listaTablas) {
        this.listaTablas = listaTablas;
    }

    public String ImplimirSquema() {
        return "Squema{\n" + "id_Squema=" + id_Squema + ", Nombre=" + Nombre
                + "\n  listaTablas=" + listaTablas + "}\n\n";
    }

}
