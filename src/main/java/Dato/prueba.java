/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

import java.util.ArrayList;

/**
 *
 * @author Mario-Bx
 */
public class prueba {

    public static void main(String[] args) {

        Squema newSquema1 = new Squema(1, "Universidades");
        Squema newSquema2 = new Squema(2, "Deporte");

        ArrayList<TablaJc> listaTablas1 = new ArrayList<TablaJc>();
        ArrayList<TablaJc> listaTablas2 = new ArrayList<TablaJc>();
        TablaJc newTabla1 = new TablaJc(1, "Sergio Arboleda", 1);
        TablaJc newTabla2 = new TablaJc(2, "Los Andes", 1);
        TablaJc newTabla3 = new TablaJc(1, "Naacion", 1);
        TablaJc newTabla4 = new TablaJc(2, "Futbol", 1);

        listaTablas1.add(newTabla1);
        listaTablas1.add(newTabla2);
        listaTablas2.add(newTabla3);
        listaTablas2.add(newTabla4);

        newSquema1.setListaTablas(listaTablas1);
        newSquema2.setListaTablas(listaTablas2);

        ArrayList<ForingKey> listaForingKeys = new ArrayList<ForingKey>();
        ArrayList<ColumnaJc> listaColumnas = new ArrayList<ColumnaJc>();
        ArrayList<Key> listaKey = new ArrayList<Key>();
//        ForingKey newForingKey = new ForingKey(1, "Nombre", "String");
//        ColumnaJc newColumna = new ColumnaJc(1, "Edad", "int");
//        Key newKey = new Key(1, "Cedula", "String");

//        listaForingKeys.add(newForingKey);
//        listaColumnas.add(newColumna);
//        listaKey.add(newKey);
//        
//        newTabla1.setListaForingKey(listaForingKeys);
//        newTabla1.setListaColumnas(listaColumnas);
//        newTabla1.setListaKey(listaKey);
        System.out.println(newSquema1.ImplimirSquema());

    }

}
