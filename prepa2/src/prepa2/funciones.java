/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prepa2;

/**
 *
 * @author veronica
 */
public class funciones {
    
    public listaGrupo generarLista(Lista lista1, Lista lista2){
        Lista union = new Lista();
        Lista interseccion = new Lista();
        Lista complemento = new Lista();

        while(!lista1.esVacio() && !lista2.esVacio()){
            Nodo nodo1 = lista1.borrarNodo(lista1.primero());
            Nodo nodo2 = lista2.borrarNodo(lista2.buscarNodo(nodo1.getData()));

            union.añadirAlFinal(nodo1.getData());

            if(nodo2 != null){
                interseccion.añadirAlFinal(nodo1.getData());
            } else{
                complemento.añadirAlFinal(nodo1.getData());
            }
        }
        if (!lista1.esVacio() && lista2.esVacio()){
            Nodo aux = lista1.primero();
            while(aux != null){
                union.añadirAlFinal(aux.getData());
                complemento.añadirAlFinal(aux.getData());
                aux = aux.getpNext();
            }
        } else if (lista1.esVacio() && !lista2.esVacio()){
            Nodo aux = lista2.primero();
            while(aux != null){
                union.añadirAlFinal(aux.getData());
                complemento.añadirAlFinal(aux.getData());
                aux = aux.getpNext();
            }
        }
        
    return new listaGrupo(union, interseccion, complemento);
    }

    public class listaGrupo {
        private Lista union;
        private Lista interseccion;
        private Lista complemento;

        public listaGrupo(Lista union, Lista interseccion, Lista complemento) {
            this.union = union;
            this.interseccion = interseccion;
            this.complemento = complemento;

        }
        /**
         * @return the union
         */
        public Lista getUnion() {
            return union;
        }

        /**
         * @param union the union to set
         */
        public void setUnion(Lista union) {
            this.union = union;
        }

        /**
         * @return the interseccion
         */
        public Lista getInterseccion() {
            return interseccion;
        }

        /**
         * @param interseccion the interseccion to set
         */
        public void setInterseccion(Lista interseccion) {
            this.interseccion = interseccion;
        }

        /**
         * @return the complemento
         */
        public Lista getComplemento() {
            return complemento;
        }

        /**
         * @param complemento the complemento to set
         */
        public void setComplemento(Lista complemento) {
            this.complemento = complemento;
        }

    }
}
