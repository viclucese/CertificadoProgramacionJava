/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package implementandolista;

/**
 *
 * @author Víctor
 */
public class ImplementandoLista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista listaEnlazada = new Lista();
        listaEnlazada.insertar_inicio(10);
        listaEnlazada.insertar_inicio(20);
        listaEnlazada.insertar_fin(30);
        System.out.println("Elementos de la lista");
        listaEnlazada.mostrar();
        
        listaEnlazada.insertar_fin(45);
        listaEnlazada.insertar_inicio(55);
        
        listaEnlazada.mostrar();
        
        listaEnlazada.borrar_inicio();
        listaEnlazada.borrar_fin();
        listaEnlazada.mostrar();
    }
    
}
