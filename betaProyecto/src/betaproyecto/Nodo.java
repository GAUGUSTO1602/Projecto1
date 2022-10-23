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
    private Nodo pNext;
    private Nodo pPrevious;

    public Nodo(T o){
        this.data = o;
        this.pNext = this.pPrevious = null;
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


}
