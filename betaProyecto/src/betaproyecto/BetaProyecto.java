/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package betaproyecto;

/**
 *
 * @author veronica
 */
public class BetaProyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Grafo grafoLista = new Grafo(5);
        grafoLista.nuevoVertice("a");
        grafoLista.nuevoVertice("b");
        grafoLista.nuevoVertice("c");
        grafoLista.nuevoVertice("d");
        grafoLista.nuevoVertice("f");
        try {
            grafoLista.nuevoArco("a", "b");
            grafoLista.nuevoArco("a", "f");

            for (int i = 0; i < grafoLista.tablAdc.length; i++) {
                System.out.println("Posición del vector " + i);
                System.out.println("Nombre del vetor: " + grafoLista.tablAdc[i].getNombre());
                for (int j = 0; j < grafoLista.tablAdc[i].getLad().getSize(); j++) {
                    System.out.println(grafoLista.tablAdc[i].getLad().buscar(j));
                    System.out.println("Destino: " + grafoLista.tablAdc[i].getLad().buscar(j).getArco().getDestino());
                }
                
            }
        } catch (Exception e) {
            System.out.println("Verga we");
        }
        

    }
    
}
