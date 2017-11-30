/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

/**
 *
 * @author camilo
 */
public class ColmenasJc {
    
  private int ID_Colmena;
  private String Coordenadas;
  private String Fecha_intalcion;
  private int ID_FKFabrica;
  private int ID_FkColmena;

    public ColmenasJc() {
    }

    public int getID_Colmena() {
        return ID_Colmena;
    }

    public void setID_Colmena(int ID_Colmena) {
        this.ID_Colmena = ID_Colmena;
    }

    public String getCoordenadas() {
        return Coordenadas;
    }

    public void setCoordenadas(String Coordenadas) {
        this.Coordenadas = Coordenadas;
    }

    public String getFecha_intalcion() {
        return Fecha_intalcion;
    }

    public void setFecha_intalcion(String Fecha_intalcion) {
        this.Fecha_intalcion = Fecha_intalcion;
    }

    public int getID_FKFabrica() {
        return ID_FKFabrica;
    }

    public void setID_FKFabrica(int ID_FKFabrica) {
        this.ID_FKFabrica = ID_FKFabrica;
    }

    public int getID_FkColmena() {
        return ID_FkColmena;
    }

    public void setID_FkColmena(int ID_FkColmena) {
        this.ID_FkColmena = ID_FkColmena;
    }
  
  
}
