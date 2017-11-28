/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

/**
 *
 * @author Mario-Bx
 */
public class ColumnaJc {

    private int id_Colnmna;
    private String Nombre;
    private String tipoDato;
    private int FKColumna;
    private int idFk_Tabla;

    public ColumnaJc() {
    }

    public ColumnaJc(int id_Colnmna, String Nombre, String tipoDato, int FKColumna, int idFk_Tabla) {
        this.id_Colnmna = id_Colnmna;
        this.Nombre = Nombre;
        this.tipoDato = tipoDato;
        this.FKColumna = FKColumna;
        this.idFk_Tabla = idFk_Tabla;
    }

    public int getId_Colnmna() {
        return id_Colnmna;
    }

    public void setId_Colnmna(int id_Colnmna) {
        this.id_Colnmna = id_Colnmna;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    public int getFKColumna() {
        return FKColumna;
    }

    public void setFKColumna(int FKColumna) {
        this.FKColumna = FKColumna;
    }

    public int getIdFk_Tabla() {
        return idFk_Tabla;
    }

    public void setIdFk_Tabla(int idFk_Tabla) {
        this.idFk_Tabla = idFk_Tabla;
    }

    @Override
    public String toString() {
        return "ColumnaJc{" + "id_Colnmna=" + id_Colnmna + ", Nombre=" + Nombre + ", tipoDato=" + tipoDato + ", FKColumna=" + FKColumna + ", idFk_Tabla=" + idFk_Tabla + '}';
    }

}
