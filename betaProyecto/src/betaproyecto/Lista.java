/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package betaproyecto;
import java.util.Random;

/**
 *
 * @author veronica
 */
public class Lista <T> {
    private Nodo <T> pFirst;
    private Nodo <T> pLast;
    private int size;

    public Lista(){
        pFirst = pLast = null;
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

    public void añadirArco(Arco a){
        Nodo nuevo = new Nodo(a);
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

    public void añadirAlFinalAux(Nodo x){
        Nodo nuevo = x;
        if(esVacio()) {
            pFirst = pLast = nuevo;
            size++;
        } else {
            pLast.setpNext(nuevo);
            nuevo.setpPrevious(pLast);
            pLast = nuevo;
            size++; 
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

    public Nodo buscar(Integer i){
        int count = 0;
        Nodo pAux = pFirst;
        while(count < i){
            pAux = pAux.getpNext();
            count++;
        }
        return pAux;
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

    public Lista crearMLista(Integer Ancho, Integer Largo){
        Lista lista = new Lista();
        Integer num = 1;
        Nodo firstNodo = new Nodo(num);
        Nodo pAux = firstNodo;
        lista.añadirAlFinalAux(pAux);
        for (int i = 1; i < Ancho; i++) {
            num++; 
            Nodo nuevo = new Nodo(num);
            pAux.setpEste(nuevo);
            nuevo.setpOeste(pAux);
            pAux = pAux.getpEste();
            lista.añadirAlFinalAux(pAux);             
        }
        Nodo pAux2 = firstNodo;
        for (int i = 1; i < Largo; i++) {
            num++;
            Nodo nuevo = new Nodo(num);
            pAux = nuevo;
            pAux2.setpSur(pAux);
            pAux.setpNorte(pAux2);
            lista.añadirAlFinalAux(pAux);
            for (int j = 1; j < Ancho; j++) {
                num++; 
                Nodo nuevo2 = new Nodo(num);
                pAux.setpEste(nuevo2);
                nuevo2.setpOeste(pAux);
                pAux = pAux.getpEste();
                pAux2 = pAux2.getpEste();
                pAux.setpNorte(pAux2);
                pAux2.setpSur(pAux);
                lista.añadirAlFinalAux(pAux);  
            }
            pAux2 = firstNodo;
            while(pAux2.getpSur() != null)
                pAux2 = pAux2.getpSur();       
        }
        return lista;
            
    }

    public void Prim(){
        Integer count = 0;
        Nodo pAux = pFirst;
        pAux.setFrontera(1);
        Nodo pAux2;
        Random valor = new Random();
        Boolean fin = true;
        Integer num = valor.nextInt(1);
        while(fin == true){
            if(num == 0 && pAux.getpEste() != null){

                if(pAux.getpEste().getFrontera() == 1){
                    pAux = pAux.getpEste();
                } else{
                    pAux2 = pAux.getpEste();
                    if(comprobarFrontera(pAux2, num) == true){
                        pAux = pAux.getpEste();
                        pAux.setFrontera(1);
                    }
                }
            } else if(num == 1 && pAux.getpSur() != null){
                if(pAux.getpSur().getFrontera() == 1){
                    pAux = pAux.getpSur();
                } else{
                    pAux2 = pAux.getpSur();
                    if(comprobarFrontera(pAux2, num)){
                        pAux = pAux.getpSur();
                        pAux.setFrontera(1);
                    }
                    }
            } else if(num == 2 && pAux.getpNorte() != null){
                if(pAux.getpNorte().getFrontera() == 1){
                    pAux = pAux.getpNorte();
                } else{
                    pAux2 = pAux.getpNorte();
                    if(comprobarFrontera(pAux2, num)){
                        pAux = pAux.getpNorte();
                        pAux.setFrontera(1);
                    }
                }
            } else if(num == 3 && pAux.getpOeste() != null){
                if(pAux.getpOeste().getFrontera() == 1){
                    pAux = pAux.getpOeste();
                } else{
                    pAux2 = pAux.getpOeste();
                    if(comprobarFrontera(pAux2, num)){
                        pAux = pAux.getpOeste();
                        pAux.setFrontera(1);
                    }
                }
            }
            num = 0;
            count++;
            if(count == 25){
                fin = false;
            }
        }
    }

    public Boolean comprobarFrontera(Nodo x, Integer i){
        if( i == 0 && ((x.getpEste() != null && x.getpEste().getFrontera() == 1 ) || (x.getpNorte() != null && x.getpNorte().getFrontera() == 1) || (x.getpSur() != null && x.getpSur().getFrontera() == 1))){
            return false;
        } else if (i == 1 && (x.getpEste() != null && x.getpEste().getFrontera() == 1 )|| (x.getpOeste() != null && x.getpOeste().getFrontera() == 1) || (x.getpSur() != null && x.getpSur().getFrontera() == 1)) {
            return false;
        } else if (i == 2 && (x.getpEste() != null && x.getpEste().getFrontera() == 1 )|| (x.getpNorte() != null && x.getpNorte().getFrontera() == 1) || (x.getpOeste() != null && x.getpOeste().getFrontera() == 1)) {
            return false;
        } else if (i == 3 &&(x.getpOeste() != null && x.getpOeste().getFrontera() == 1 )|| (x.getpNorte() != null && x.getpNorte().getFrontera() == 1) || (x.getpSur() != null && x.getpSur().getFrontera() == 1)) {
            return false;
        } 
        return true;
    }

}
