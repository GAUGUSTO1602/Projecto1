/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package betaproyecto;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *Clase lista
 * @author Gabriel González
 * @param <T>
 */
public class Lista <T> {
    private Nodo <T> pFirst;
    private Nodo <T> pLast;
    private Nodo <T> pEntrada;
    private Nodo <T> pSalida;
    private int size;

    /**
     *
     */
    public Lista(){
        pFirst = pLast = null;
        size = 0;
    }

    /**
     *
     * @return
     */
    public Nodo<T> getpFirst() {
        return pFirst;
    }

    /**
     *
     * @param pFirst
     */
    public void setpFirst(Nodo<T> pFirst) {
        this.pFirst = pFirst;
    }

    /**
     *
     * @return
     */
    public Nodo<T> getpLast() {
        return pLast;
    }

    /**
     *
     * @param pLast
     */
    public void setpLast(Nodo<T> pLast) {
        this.pLast = pLast;
    }

    /**
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     *
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     *
     * @return
     */
    public boolean esVacio() {
        return pFirst == null;
    }

    /**
     *
     */
    public void Vaciar() {
        this.pFirst = this.pLast = null;
        this.size = 0;
    }

    /**
     *
     * @return
     */
    public Nodo<T> getpEntrada() {
        return pEntrada;
    }

    /**
     *
     * @param pEntrada
     */
    public void setpEntrada(Nodo<T> pEntrada) {
        this.pEntrada = pEntrada;
    }

    /**
     *
     * @return
     */
    public Nodo<T> getpSalida() {
        return pSalida;
    }

    /**
     *
     * @param pSalida
     */
    public void setpSalida(Nodo<T> pSalida) {
        this.pSalida = pSalida;
    }

    /**
     *Añade un nodo al final de la lista
     * @param x
     */
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

    /**
     *Crea una lista de adyacencia organizada en orden para que se asemeje a una matriz
     * @param Ancho
     * @param Largo
     * @return
     */
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

    /**
     *Crea el marco con el cual se cubrira el laberinto generado
     * @param x
     * @param ancho
     * @param Largo
     * @return
     */
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

    /**
     *Crea el laberinto usando un algoritmo parecido al algoritmo de Prim
     * @param lista
     * @param count
     */
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

    /**
     *Comprueba si un blouqe o celda del laberinto es un muro perteneciente al borde del laberinto
     * @param x
     * @return
     */
    public Boolean comprobarMuro(Nodo x){
        if(x.getFrontera() == 2){
            return false;
        } else{
            return true;
        }
    }

    /**
     *Comprueba los nodos o casillas adyacentes a un Nodo enviado
     * El objetivo es comprobar que no hayan casillas con un determinado valor alrededor del nodo enviado
     * @param x
     * @param i
     * @return
     */
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

    /**
     * Busca una casilla que sea adyacente a una casilla libre del laberinto y la marca como la entrada a este mismo
     * @param lista
     * @param Ancho
     * @param Largo
     */
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
                    lista.setpEntrada(pAux);
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

    /**
     * Busca una casilla que sea adyacente a una casilla libre del laberinto y la marca como la salida a este mismo
     * @param lista
     * @param Ancho
     * @param Largo
     */
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
                    lista.setpSalida(pAux);
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

    /**
     * Comprueba e valor frontera de las casillas adyacentes
     * @param x
     * @param i
     * @return
     */
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

    /**
     *Algoritmo DFS para solucionar el laberinto
     * @param lista
     * @param mLista
     */
    public void DFS(Lista lista, Lista mLista ){
        long startTime = System.currentTimeMillis();

        Nodo pAux = lista.getpEntrada();
        Boolean fin = false;
        Integer i = 5;
        pAux = moverse(pAux, 1, 6);
        while(fin == false){
            if(comprobarAlr(pAux, i) == true){
                        fin = true;
                        break;
            } else if(pAux.getpNorte().getFrontera() == 1){
                while(pAux.getpNorte().getFrontera() != 0 && pAux.getpNorte().getFrontera() != 2 ){
                    pAux = pAux.getpNorte();
                    pAux.setFrontera(6);
                    if(comprobarAlr(pAux, i) == true){
                        fin = true;
                        break;
                    }
                }
                while(fin == false && (pAux.getpSur().getFrontera() != 2 && pAux.getpSur().getFrontera() != 0 )){
                    pAux = pAux.getpSur();
                    if(comprobarAlr(pAux, 1) == true){
                        break;
                    }
                }
            } else if(pAux.getpSur().getFrontera() == 1){
                while(pAux.getpSur().getFrontera() != 0 && pAux.getpSur().getFrontera() != 2 ){
                    pAux = pAux.getpSur();
                    pAux.setFrontera(6);
                    if(comprobarAlr(pAux, i) == true){
                        fin = true;
                        break;
                    }
                }
                while(fin == false && (pAux.getpNorte().getFrontera() != 2 && pAux.getpNorte().getFrontera() != 0 )){
                    pAux = pAux.getpNorte();
                    if(comprobarAlr(pAux, 1) == true){
                        break;
                    }
                }
            }else if(pAux.getpOeste().getFrontera() == 1){
                while(pAux.getpOeste().getFrontera() != 0 && pAux.getpOeste().getFrontera() != 2 ){
                    pAux = pAux.getpOeste();
                    pAux.setFrontera(6);
                    if(comprobarAlr(pAux, i) == true){
                        fin = true;
                        break;
                    }
                }
                while(fin == false && (pAux.getpEste().getFrontera() != 2 && pAux.getpEste().getFrontera() != 0 )){
                    pAux = pAux.getpEste();
                    if(comprobarAlr(pAux, 1) == true){
                        break;
                    }
                }
            }else if(pAux.getpEste().getFrontera() == 1){
                while(pAux.getpEste().getFrontera() != 0 && pAux.getpEste().getFrontera() != 2 ){
                    pAux = pAux.getpEste();
                    pAux.setFrontera(6);
                    if(comprobarAlr(pAux, i) == true){
                        fin = true;
                        break;
                    }
                }
                while(fin == false && (pAux.getpOeste().getFrontera() != 2 && pAux.getpOeste().getFrontera() != 0 )){
                    pAux = pAux.getpOeste();
                    if(comprobarAlr(pAux, 1) == true){
                        break;
                    }
                }
            }else{
                pAux = mLista.getpFirst();
                while(pAux.getpNext() != null){
                    if(pAux.getFrontera() == 6 && comprobarAlr(pAux, 5) == true){
                        fin = true;
                        break;
                    }else if( pAux.getFrontera() == 6 && comprobarAlr(pAux, 1) == true){
                        pAux = moverse(pAux, 1, 6);
                        break;
                    }
                    pAux = pAux.getpNext();
                }
                if(pAux == null){
                    fin = true;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        JOptionPane.showMessageDialog(null, "Tiempo de ejecución: " + (endTime - startTime) + " milisegundos");
    }

    /**
     * Comprueba la posición incial y se mueve a una posición disponible que concuerde con el valor frontera solicitado
     * @param x
     * @param i
     * @return
     */
    public Nodo moverse(Nodo x, Integer i, Integer j){
        if(x.getpNorte() != null && x.getpNorte().getFrontera() == i){
            x = x.getpNorte();
            x.setFrontera(j);
            return x;
        }else if (x.getpSur() != null && x.getpSur().getFrontera() == i){
            x = x.getpSur();
            x.setFrontera(j);
            return x;
        }else if (x.getpOeste() != null && x.getpOeste().getFrontera() == i){
            x = x.getpOeste();
            x.setFrontera(j);
            return x;
        }else{
            x = x.getpEste();
            x.setFrontera(j);
            return x;
        }
    }

}
