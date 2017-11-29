/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

/**
 *
 * @author Labing I5
 */
public class KilosMielJC {  
    
  private int ID_Produccion ;
  private String Fecha ;
  private String Nombre ;
  private int ID_FkColmena ;
  private int Kilos_Miel ;

    public KilosMielJC() {
    }
  
    public KilosMielJC(int ID_Produccion, String Fecha, String Nombre, int ID_FkColmena, int Kilos_Miel) {
        this.ID_Produccion = ID_Produccion;
        this.Fecha = Fecha;
        this.Nombre = Nombre;
        this.ID_FkColmena = ID_FkColmena;
        this.Kilos_Miel = Kilos_Miel;
    }

    public int getID_Produccion() {
        return ID_Produccion;
    }

    public void setID_Produccion(int ID_Produccion) {
        this.ID_Produccion = ID_Produccion;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getID_FkColmena() {
        return ID_FkColmena;
    }

    public void setID_FkColmena(int ID_FkColmena) {
        this.ID_FkColmena = ID_FkColmena;
    }

    public int getKilos_Miel() {
        return Kilos_Miel;
    }

    public void setKilos_Miel(int Kilos_Miel) {
        this.Kilos_Miel = Kilos_Miel;
    }
  
}
