/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloquiz;

import javax.swing.JOptionPane;

/**
 *
 * @author veronica
 */
public class Lista <T>{
    private Nodo pFirst;
    private String nombre;
    private Boolean ciclo;

    public Lista(String s) {
        pFirst = null;
        nombre = s;
        ciclo = false;
    }

    public Boolean getCiclo() {
        return ciclo;
    }

    public void setCiclo(Boolean ciclo) {
        this.ciclo = ciclo;
    }

    public boolean esVacio(){
        return pFirst == null;
    }

    public boolean esCiclo() {
        return ciclo;
    }

    public Nodo proximo(Nodo pValor) {
        if (pValor != null){
            pValor=pValor.pnext;
            return pValor;
        }else{
        return null;
        }
    }

    public void vaciar(){
        pFirst = null;
        ciclo = false;
        JOptionPane.showMessageDialog(null, "Lista vaciada");
    }

    public void insertarAlFinal(boolean ins, Integer stop) {
        Nodo nuevo = new Nodo();
        if (!esCiclo()){
            if(esVacio()){
                pFirst = nuevo;
                nuevo.setMarcador(1);
            JOptionPane.showMessageDialog(null, "Primer nodo insertado con exito");
            } else {
                Nodo pAux = pFirst;
                int count = 2;
                while ( pAux.pnext != null) {
                    pAux=proximo(pAux);
                    count ++;
                }
                pAux.pnext = nuevo;
                nuevo.setMarcador(count);
                if (ins == true){
                    Nodo pAux2 = pFirst;
                    while (pAux2.getMarcador() == stop)
                        pAux2 = proximo(pAux2);
                    nuevo.pnext = pAux2;
                    ciclo = true;
                    JOptionPane.showMessageDialog(null, "Insertado con exito a un nodo");
                }
                JOptionPane.showMessageDialog(null, "Nodo insertado con exito");

            }
        } else {
            JOptionPane.showMessageDialog(null, "La lista es un ciclo, no se pueden añadir mas nodos");
        }

    }


    public int tamanioLista(boolean v){
        Nodo pAux;
        Nodo pAux2;
        int count = 0;
        if(esVacio()){
            JOptionPane.showMessageDialog(null, "No hay elementos en la lista");
            return -1;
        } else {
            pAux = pFirst;
            while (pAux != null && pAux.getSeñal() != "." ) {
                count ++;
                pAux.setSeñal(".");
                pAux=proximo(pAux);
            }
            pAux2 = pFirst;
            while (pAux2 != null && pAux2.getSeñal() != "" ) {
                pAux2.setSeñal("");
                pAux2 = proximo(pAux2);
            }
            if(v == true){
                JOptionPane.showMessageDialog(null, "La lista tiene un tamaño de " + count + " nodos");
                return -1;
            } else {
                return count;
            }
        }
    }
}
