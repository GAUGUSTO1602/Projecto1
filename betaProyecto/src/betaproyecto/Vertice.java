/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package betaproyecto;

import java.util.LinkedList;

/**
 *
 * @author veronica
 */
public class Vertice {
    String nombre;
    int numVertice;
    LinkedList<Object> lad;

    public Vertice(String x) {
        nombre = x;
        numVertice = -1;
        lad = new LinkedList();
    }

    public boolean equals(Object d){
        Vertice dos = (Vertice) d;
        return nombre.equals(dos.nombre);
    }

    public void asigVert(int n){
        numVertice = n;
    }

    public String nomVertice() {
        return nombre;
    }

    public String toString(){
        return nombre + " (" + numVertice +")";
    }

}
