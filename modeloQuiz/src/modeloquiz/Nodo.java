/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloquiz;

/**
 *
 * @author veronica
 */
public class Nodo {
    Object data;
    Nodo pnext;
    Integer marcador;
    String señal;

    public Nodo() {
        pnext = null;
        señal = "";
    }

    public Integer getMarcador() {
        return marcador;
    }

    public void setMarcador(Integer marcador) {
        this.marcador = marcador;
    }

    public String getSeñal() {
        return señal;
    }

    public void setSeñal(String señal) {
        this.señal = señal;
    }


}
