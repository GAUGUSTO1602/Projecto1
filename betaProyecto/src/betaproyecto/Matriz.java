/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package betaproyecto;

/**
 *
 * @author veronica
 */
public class Matriz {
    private Integer [][] celdas; 

    public Matriz(){
        celdas = null; 
    }

    public Integer[][] getCeldas() {
        return celdas;
    }

    public void setCeldas(Integer[][] celdas) {
        this.celdas = celdas;
    }

    public Integer[][] crearMatriz(Integer[][] x, Integer columnas, Integer filas){
        x = new Integer[filas][columnas];
        return x;
    }

    public void ingresarValores(Integer[][] x, Lista lista){
        Nodo pAux = lista.getpFirst();
        for (int i = 1; i < x.length - 1; i++) {
            for (int j = 1; j < x[i].length - 1; j++) {
                if(pAux != null){
                    x[i][j] = pAux.getFrontera();
                    pAux = pAux.getpNext();
                }
            } 
        }
    }

    public void ingresarValoresMarco(Integer[][] x, Lista lista){
        Nodo pAux = lista.getpFirst();
        x[0][0] = pAux.getpOeste().getFrontera();
        Integer k = x[0].length - 1;
        Integer q = x.length -1;

        for (int j = 1; j < x[0].length ; j++) {
            if(pAux != null){
                x[0][j] = pAux.getFrontera();
                pAux = pAux.getpNext();
            }
        }        
        
        for (int i = 1; i < x.length - 1; i++) {
            if(pAux != null){
                x[i][k] = pAux.getFrontera();
                pAux = pAux.getpNext();
            }
        }
        
        for (int j = k; j >= 0 ; j--) {
            if(pAux != null){
                x[q][j] = pAux.getFrontera();
                pAux = pAux.getpNext();
            }
        }

        for (int i = q -1; i > 0; i--) {
            if(pAux != null){
                x[i][0] = pAux.getFrontera();
                pAux = pAux.getpNext();
            }
        }
    }

    public void imprimirValores(Integer[][] x){
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
