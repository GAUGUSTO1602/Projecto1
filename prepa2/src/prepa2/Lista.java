/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prepa2;

import javax.swing.JOptionPane;

/**
 *
 * @author veronica
 */
public class Lista <T> {
  private Nodo <T> pFirst;
    private Nodo <T> pLast;
    private int size;
  
    public Lista() {
        this.pFirst = this.pLast = null;
        this.size = 0;
    }

    public boolean esVacio() {
        return pFirst == null;
    }

    public void Vaciar() {
        this.pFirst = this.pLast = null;
        this.size = 0;
    }

    public Nodo próximo(Nodo <T> pValor){
        if (pValor!=null){
            pValor=pValor.getpNext();
            return pValor;
        }else{
            return null;
        }
     }

    public Nodo primero(){
       return pFirst;
    }

    public Nodo elUltimo(){
        return pLast;
    }

    public Nodo<T> ultimo(){
      if (esVacio()){
          return null;
      } else{
           Nodo <T> pAux;
           pAux=primero();
           while(pAux.getpNext()!= null){
               pAux=próximo(pAux);
           }
       return pAux;
      } 
    }

    public void añadirAlFinal(T x){
        Nodo nuevo = new Nodo(x);
        if(esVacio()) {
            this.pFirst = this.pLast = nuevo;
        } else {
            this.pLast.setpNext(nuevo);
            nuevo.setPrevious(this.pLast);
            this.pLast = nuevo;
        }
        size++;
    }

    public void añadirAlInicio(T x){
        Nodo nuevo = new Nodo(x);
        if(esVacio()) {
            this.pFirst = this.pLast = nuevo;
        } else {
            this.pFirst.setPrevious(nuevo);
            nuevo.setpNext(this.pFirst);
            this.pFirst = nuevo;
        }
        size++;
    }

    public void postInsertar(T x, Nodo pValor){
        Nodo nuevo = new Nodo(x);
        if(esVacio()) {
            this.pFirst = this.pLast = nuevo;
        } else if (pValor.getpNext() == null) {
            this.pLast.setpNext(nuevo);
            nuevo.setPrevious(this.pLast);
            this.pLast = nuevo;
        } else {
            Nodo pAux = pValor.getpNext();
            nuevo.setPrevious(pValor);
            nuevo.setpNext(pAux);
            pValor.setpNext(nuevo);
            pAux.setPrevious(nuevo);
        }
        size++;
    }

    public void preInsertar(T x, Nodo pValor){
        Nodo nuevo = new Nodo(x);
        if(esVacio()) {
            this.pFirst = this.pLast = nuevo;
        } else if (pValor.getPrevious() == null) {
            this.pFirst.setPrevious(nuevo);
            nuevo.setpNext(this.pFirst);
            this.pFirst = nuevo;     
        } else {
            Nodo pAux = pValor.getPrevious();
            nuevo.setpNext(pValor);
            nuevo.setPrevious(pAux);
            pValor.setPrevious(nuevo);
            pAux.setpNext(nuevo);
        }
        size++;
    }

    public Nodo buscarNodo(T data){
        Nodo pAux = pFirst;
        while(pAux != null){
            if (pAux.getData() == data){
                return pAux;
            }
            pAux = próximo(pAux);
        }
    return null;
    }

    public Nodo borrarNodo(Nodo pValor) {
        if (pValor != null){
            if (size == 1){
                this.Vaciar();
            } else {
                if (this.pFirst == pValor){
                    pValor.getpNext().setPrevious(null);
                    this.pFirst = this.pFirst.getpNext();
                    //this.pFirst.setPrevious(null);
                } else if (this.pLast == pValor){
                    pValor.getPrevious().setpNext(null);
                    this.pLast = this.pLast.getPrevious();
                    //this.pLast.setpNext(null);
                } else {
                    pValor.getPrevious().setpNext(pValor.getpNext());
                    pValor.getpNext().setPrevious(pValor.getPrevious());
                }
                size--;
            }
        }
        return pValor;
    }

    public void Mostrar() {
        String cadena = "";
        System.out.println(size);
        Nodo aux = pFirst;
        for (int i = 0; i < (size); i++) {
            cadena = cadena + "[" + aux.getData() + "], ";
            aux = aux.getpNext();
        }
        JOptionPane.showMessageDialog(null, "La lista es: " + cadena);
    }  
}
