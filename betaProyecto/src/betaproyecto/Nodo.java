/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package betaproyecto;

/**
 *
 * @author veronica
 */
public class Nodo <T> {
    private T data;
    private Integer indice;
    private Integer frontera;
    private Nodo pNext;
    private Nodo pPrevious;
    private Nodo pNorte;
    private Nodo pSur;
    private Nodo pEste;
    private Nodo pOeste;

    public Nodo(Integer i){
        this.pNext = this.pPrevious = this.pNorte = this.pSur = this.pEste = this.pOeste = null;
        indice = i;
        frontera = 0;
    }


    public Nodo(T o){
        this.data = o;
        this.pNext = this.pPrevious = this.pNorte = this.pSur = this.pEste = this.pOeste = null;
    }

    public Nodo getpPrevious() {
        return pPrevious;
    }

    public void setpPrevious(Nodo pPrevious) {
        this.pPrevious = pPrevious;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Nodo getpNext() {
        return pNext;
    }

    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }


    public Nodo getpNorte() {
        return pNorte;
    }

    public void setpNorte(Nodo pNorte) {
        this.pNorte = pNorte;
    }

    public Nodo getpSur() {
        return pSur;
    }

    public void setpSur(Nodo pSur) {
        this.pSur = pSur;
    }

    public Nodo getpEste() {
        return pEste;
    }

    public void setpEste(Nodo pEste) {
        this.pEste = pEste;
    }

    public Nodo getpOeste() {
        return pOeste;
    }

    public void setpOeste(Nodo pOeste) {
        this.pOeste = pOeste;
    }

    public Integer getFrontera() {
        return frontera;
    }

    public void setFrontera(Integer frontera) {
        this.frontera = frontera;
    }



}
