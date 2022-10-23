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
public class Grafo {
    int numVerts;
    static int maxVerts = 20;
    Vertice [] tablAdc;

    public Grafo(int mx){
        tablAdc = new Vertice[mx];
        numVerts = 0;
        maxVerts = mx;
    }

    public Grafo(){
        this(maxVerts);
    }

    public Vertice[] vertices(){
        return tablAdc;
    }

    public LinkedList listaAdcy(int v) throws Exception {
        if (v < 0 || v >= numVerts){
            throw new Exception("Vertice fuera de rango");
        }
        return tablAdc[v].lad;
    }
   
    public int numVertice(String nombre) {
        Vertice v = new Vertice(nombre);
        boolean encontrado = false;
        int i = 0;
        for (;(i < numVerts)&& !encontrado ;) {
            encontrado = tablAdc[i].equals(v);
            if(!encontrado){
                i++;
            }
        }
        return (i < numVerts) ? i : -1;
    }

    public void nuevoVertice(String nombre){
        boolean existe = numVertice(nombre) >= 0;
        if (!existe) {
            Vertice v = new Vertice(nombre);
            v.asigVert(numVerts);
            tablAdc[numVerts++] = v;
        }
    }

    boolean adyacente(String a, String b) throws Exception{
        int v1, v2;
        v1 = numVertice(a);
        v2 = numVertice(b);
        if (v1 < 0 || v2 < 0){
            throw new Exception("El vertice no existe");
        }
        if (tablAdc[v1].lad.contains(new Arco(v2))){
            return true;
        } else{
            return false;        
        }
    }

    boolean adyacente(int v1, int v2) throws Exception{
        if (tablAdc[v1].lad.contains(new Arco(v2))){
            return true;
        } else{
            return false;
        }
    }

    public void nuevoArco(String a, String b) throws Exception{
        if (!adyacente(a,b)){
            int v1 = numVertice(a);
            int v2 = numVertice(b);
            if (v1 < 0 || v2 < 0){
                throw new Exception("El vertice no existe");
            }
            Arco ab = new Arco(v2);
            tablAdc[v1].lad.addFirst(ab);
        }
    }

    public void borrarArco(String a, String b) throws Exception{
        int v1 = numVertice(a);
        int v2 = numVertice(b);
        if (v1 < 0 || v2 < 0){
            throw new Exception("El vertice no existe");
        }
        Arco ab = new Arco(v2);
        tablAdc[v1].lad.remove(ab);
    }
    

}
