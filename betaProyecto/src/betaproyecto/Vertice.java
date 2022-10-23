/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package betaproyecto;



/**
 *
 * @author veronica
 */
public class Vertice {
    private String nombre;
    private int numVertice;
    private Lista lad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumVertice() {
        return numVertice;
    }

    public void setNumVertice(int numVertice) {
        this.numVertice = numVertice;
    }

    public Lista getLad() {
        return lad;
    }

    public void setLad(Lista lad) {
        this.lad = lad;
    }


    public Vertice(String x) {
        nombre = x;
        numVertice = -1;
        lad = new Lista();
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
