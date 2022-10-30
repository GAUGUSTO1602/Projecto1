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



    public Nodo buscar(Integer i){
        int count = 0;
        Nodo pAux = pFirst;
        while(count < i){
            pAux = pAux.getpNext();
            count++;
        }
        return pAux;
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

    public Lista crearMarco(Nodo x, Integer ancho, Integer Largo){
        Lista marco = new Lista();
        Nodo pAux = x;
        Nodo pAux2 = new Nodo(0);
        pAux2.setFrontera(2);
        pAux.setpNorte(pAux2);
        pAux2.setpSur(pAux);
        marco.añadirAlFinalAux(pAux2);
        Integer count = 1;
        for (int i = 1; i < ancho; i++) {
            Nodo nuevo = new Nodo(count);
            pAux2.setpEste(nuevo);
            nuevo.setpOeste(pAux2);
            pAux = pAux.getpEste();
            nuevo.setpSur(pAux);
            pAux.setpNorte(nuevo);
            nuevo.setFrontera(2);
            marco.añadirAlFinalAux(nuevo);
            pAux2 = pAux2.getpEste();
            count++;
        }
        Nodo esquina = new Nodo(count);
        pAux2.setpEste(esquina);
        esquina.setpOeste(pAux2);
        esquina.setFrontera(3);
        marco.añadirAlFinalAux(esquina);
        pAux2 = pAux2.getpEste();
        count++;
        for (int i = 0; i < Largo; i++) {
            Nodo nuevo = new Nodo(count);
            pAux2.setpSur(nuevo);
            nuevo.setpNorte(pAux2);
            pAux.setpEste(nuevo);
            nuevo.setpOeste(pAux);
            pAux = pAux.getpSur();
            nuevo.setFrontera(2);
            marco.añadirAlFinalAux(nuevo);
            pAux2 = pAux2.getpSur();
            count++;
        }
        pAux = pAux2.getpOeste();
        Nodo esquina2 = new Nodo(count);
        pAux2.setpSur(esquina2);
        esquina2.setpNorte(pAux2);
        esquina2.setFrontera(3);
        marco.añadirAlFinalAux(esquina2);
        pAux2 = pAux2.getpSur();
        count++;
        for (int i = 0; i < ancho; i++) {
            Nodo nuevo = new Nodo(count);
            pAux2.setpOeste(nuevo);
            nuevo.setpEste(pAux2);
            pAux.setpSur(nuevo);
            nuevo.setpNorte(pAux);
            pAux = pAux.getpOeste();
            nuevo.setFrontera(2);
            marco.añadirAlFinalAux(nuevo);
            pAux2 = pAux2.getpOeste();
            count++;
        }
        pAux = pAux2.getpNorte();
        Nodo esquina3 = new Nodo(count);
        pAux2.setpOeste(esquina3);
        esquina3.setpEste(pAux2);
        esquina3.setFrontera(3);
        marco.añadirAlFinalAux(esquina3);
        pAux2 = pAux2.getpOeste();
        count++;
        for (int i = 0; i < Largo; i++) {
            Nodo nuevo = new Nodo(count);
            pAux2.setpNorte(nuevo);
            nuevo.setpSur(pAux2);
            pAux.setpOeste(nuevo);
            nuevo.setpEste(pAux);
            pAux = pAux.getpNorte();
            nuevo.setFrontera(2);
            marco.añadirAlFinalAux(nuevo);
            pAux2 = pAux2.getpNorte();
            count++;
        }
        Nodo esquina4 = new Nodo(count);
        pAux2.setpNorte(esquina4);
        esquina4.setpSur(pAux2);
        esquina4.setFrontera(3);
        marco.añadirAlFinalAux(esquina4);
        pAux2 = marco.getpFirst();
        pAux2.setpOeste(esquina4);
        esquina4.setpEste(pAux2);
        return marco;
    }

    public void Prim(Lista lista, Integer count){
        Nodo pAux = lista.getpFirst();
        pAux.setFrontera(1);
        Nodo pAux2;
        Random valor = new Random();
        Integer num = valor.nextInt(4);
        while(count > 0){
            if(num == 0 && pAux.getpEste() != null){

                if(pAux.getpEste().getFrontera() == 1){
                    pAux = pAux.getpEste();
                } else{
                    pAux2 = pAux.getpEste();
                    if(comprobarMuro(pAux2) && comprobarFrontera(pAux2, num) == true){
                        pAux = pAux.getpEste();
                        pAux.setFrontera(1);
                    }
                }
            } else if(num == 1 && pAux.getpSur() != null){
                if(pAux.getpSur().getFrontera() == 1){
                    pAux = pAux.getpSur();
                } else{
                    pAux2 = pAux.getpSur();
                    if(comprobarMuro(pAux2) && comprobarFrontera(pAux2, num)){
                        pAux = pAux.getpSur();
                        pAux.setFrontera(1);
                    }
                    }
            } else if(num == 2 && pAux.getpNorte() != null){
                if(pAux.getpNorte().getFrontera() == 1){
                    pAux = pAux.getpNorte();
                } else{
                    pAux2 = pAux.getpNorte();
                    if(comprobarMuro(pAux2) && comprobarFrontera(pAux2, num)){
                        pAux = pAux.getpNorte();
                        pAux.setFrontera(1);
                    }
                }
            } else if(num == 3 && pAux.getpOeste() != null){
                if(pAux.getpOeste().getFrontera() == 1){
                    pAux = pAux.getpOeste();
                } else{
                    pAux2 = pAux.getpOeste();
                    if(comprobarMuro(pAux2) && comprobarFrontera(pAux2, num)){
                        pAux = pAux.getpOeste();
                        pAux.setFrontera(1);
                    }
                }
            }
            num = valor.nextInt(4);;
            count--;
        }
    }

    public Boolean comprobarMuro(Nodo x){
        if(x.getFrontera() == 2){
            return false;
        } else{
            return true;
        }
    }

    public Boolean comprobarFrontera(Nodo x, Integer i){
        if( i == 0 && ( x.getpEste().getFrontera() == 1 || x.getpNorte().getFrontera() == 1 || x.getpSur().getFrontera() == 1)){
            return false;
        } else if (i == 1 && ( x.getpEste().getFrontera() == 1 || x.getpOeste().getFrontera() == 1 || x.getpSur().getFrontera() == 1)) {
            return false;
        } else if (i == 2 && ( x.getpEste().getFrontera() == 1 || x.getpNorte().getFrontera() == 1 ||  x.getpOeste().getFrontera() == 1)) {
            return false;
        } else if (i == 3 &&( x.getpOeste().getFrontera() == 1 || x.getpNorte().getFrontera() == 1 ||  x.getpSur().getFrontera() == 1)) {
            return false;
        } 
        return true;
    }

    public void marcarEntrada(Lista lista, Integer Ancho, Integer Largo){
        Nodo pAux = lista.getpFirst();
        Integer indice = Ancho + Largo;
        Random valor = new Random();
        Integer num = valor.nextInt(indice);
        while (pAux != null){
            if(pAux.getIndice() == num){
                if(pAux.getFrontera() == 3){
                    pAux = lista.getpFirst();
                    num = valor.nextInt(indice);
                }else if(comprobarAlr(pAux, 1)){
                    pAux.setFrontera(4);
                    pAux.setpEntrada(pAux);
                    break;
                }else{
                    pAux = lista.getpFirst();
                    num = valor.nextInt(indice);
                }
            }else{
                pAux = pAux.getpNext();
            }
        }
    }

    public void marcarSalida(Lista lista, Integer Ancho, Integer Largo){
        Nodo pAux = lista.getpFirst();
        Integer indice = Ancho + Largo;
        Random valor = new Random();
        Integer num = valor.nextInt(indice);
        while (pAux != null){
            if(pAux.getIndice() == num){
                if(pAux.getFrontera() == 3 || pAux.getFrontera() == 4){
                    pAux = lista.getpFirst();
                    num = valor.nextInt(indice);
                }else if(comprobarAlr(pAux, 1) && !comprobarAlr(pAux, 4)){
                    pAux.setFrontera(5);
                    pAux.setpSalida(pAux);
                    break;
                }else{
                    pAux = lista.getpFirst();
                    num = valor.nextInt(indice);
                }
            }else{
                pAux = pAux.getpNext();
            }
        }
    }

    public Boolean comprobarAlr(Nodo x, Integer i){
        if(x.getpEste() != null && x.getpEste().getFrontera() == i){
            return true;
        } else if (x.getpOeste() != null && x.getpOeste().getFrontera() == i){
            return true;
        }else if (x.getpNorte() != null && x.getpNorte().getFrontera() == i){
            return true;
        }else if (x.getpSur() != null && x.getpSur().getFrontera() == i){
            return true;
        }
        return false;
    }

}
