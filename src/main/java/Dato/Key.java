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
public class Key extends ColumnaJc {

    public Key() {
    }

    public Key(int id_Colnmna, String Nombre, String tipoDato, int FKColumna, int idFk_Tabla) {
        super(id_Colnmna, Nombre, tipoDato, FKColumna, idFk_Tabla);
    }

}
