/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prepa2;

import prepa2.funciones.listaGrupo;

/**
 *
 * @author veronica
 */
public class Prepa2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        funciones f = new funciones();

        Lista lista1 = new Lista();

        lista1.añadirAlFinal(1);
        lista1.añadirAlFinal(7);
        lista1.añadirAlFinal(4);
        lista1.añadirAlFinal(20);

        Lista lista2 = new Lista();

        lista2.añadirAlFinal(12);
        lista2.añadirAlFinal(3);
        lista2.añadirAlFinal(1);
        lista2.añadirAlFinal(20);
        lista2.añadirAlFinal(7);

        listaGrupo listaFinal = f.generarLista(lista1, lista2);

        listaFinal.getUnion().Mostrar();
        listaFinal.getInterseccion().Mostrar();
        listaFinal.getComplemento().Mostrar();
    }
    
}
