/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package betaproyecto;

/**
 *Clase nodo
 * @author Alfredo Herrera
 * @param <T>
 */
public class Nodo <T> {
    private Integer indice;
    private Integer frontera;
    private Nodo pNext;
    private Nodo pPrevious;
    private Nodo pNorte;
    private Nodo pSur;
    private Nodo pEste;
    private Nodo pOeste;

    /**
     *
     * @param i
     */
    public Nodo(Integer i){
        this.pNext = this.pPrevious = this.pNorte = this.pSur = this.pEste = this.pOeste = null;
        indice = i;
        frontera = 0;
    }

    /**
     *
     * @return
     */
    public Nodo getpPrevious() {
        return pPrevious;
    }

    /**
     *
     * @param pPrevious
     */
    public void setpPrevious(Nodo pPrevious) {
        this.pPrevious = pPrevious;
    }

    /**
     *
     * @return
     */
    public Nodo getpNext() {
        return pNext;
    }

    /**
     *
     * @param pNext
     */
    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }

    /**
     *
     * @return
     */
    public int getIndice() {
        return indice;
    }

    /**
     *
     * @param indice
     */
    public void setIndice(int indice) {
        this.indice = indice;
    }

    /**
     *
     * @return
     */
    public Nodo getpNorte() {
        return pNorte;
    }

    /**
     *
     * @param pNorte
     */
    public void setpNorte(Nodo pNorte) {
        this.pNorte = pNorte;
    }

    /**
     *
     * @return
     */
    public Nodo getpSur() {
        return pSur;
    }

    /**
     *
     * @param pSur
     */
    public void setpSur(Nodo pSur) {
        this.pSur = pSur;
    }

    /**
     *
     * @return
     */
    public Nodo getpEste() {
        return pEste;
    }

    /**
     *
     * @param pEste
     */
    public void setpEste(Nodo pEste) {
        this.pEste = pEste;
    }

    /**
     *
     * @return
     */
    public Nodo getpOeste() {
        return pOeste;
    }

    /**
     *
     * @param pOeste
     */
    public void setpOeste(Nodo pOeste) {
        this.pOeste = pOeste;
    }

    /**
     *
     * @return
     */
    public Integer getFrontera() {
        return frontera;
    }

    /**
     *
     * @param frontera
     */
    public void setFrontera(Integer frontera) {
        this.frontera = frontera;
    }



}
