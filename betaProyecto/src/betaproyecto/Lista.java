/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package betaproyecto;

/**
 *
 * @author veronica
 */
public class Lista <T> {
    private Nodo <T> pFirst;
    private Nodo <T> pLast;
    private int size;

    public Lista(){
        this.pFirst = this.pLast = null;
        size = 0;
    }

    public Nodo<T> getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo<T> pFirst) {
        this.pFirst = pFirst;
    }

    public Nodo<T> getpLast() {
        return pLast;
    }

    public void setpLast(Nodo<T> pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean esVacio() {
        return pFirst == null;
    }

    public void Vaciar() {
        this.pFirst = this.pLast = null;
        this.size = 0;
    }

    public void añadirAlInicio(T x){
        Nodo nuevo = new Nodo(x);
        if(esVacio()) {
            this.pFirst = this.pLast = nuevo;
        } else {
            this.pFirst.setpPrevious(nuevo);
            nuevo.setpNext(this.pFirst);
            this.pFirst = nuevo;
        }
    }

    public void añadirAlFinal(T x){
        Nodo nuevo = new Nodo(x);
        if(esVacio()) {
            this.pFirst = this.pLast = nuevo;
        } else {
            this.pLast.setpNext(nuevo);
            nuevo.setpPrevious(this.pLast);
            this.pLast = nuevo;
        }
    }

    public void borrarNodo(Arco a) {
        Nodo pAux = pFirst;
        Nodo borrar = new Nodo(a);
        while(pAux != null && pAux != borrar) {
            pAux = pAux.getpNext();
        }
        if(pAux == borrar){
            pAux.getpPrevious().setpNext(pAux.getpNext());
            pAux.getpNext().setpPrevious(pAux.getpPrevious());
        }
        
    }

    public boolean buscarArco(T data){
        Nodo pAux = pFirst;
        while(pAux != null){
            if (pAux.getData() == data){
                return true;
            }
            pAux = pAux.getpNext();
        }
    return false;
    }

}
