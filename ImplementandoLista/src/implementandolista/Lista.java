/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementandolista;

/**
 *
 * @author Víctor
 */
public class Lista {
    protected Nodo inicio;
    protected Nodo fin;
    
    Lista(){
        inicio = null;
        fin = null;
    }
    
    void insertar_inicio(int _valor){
        Nodo nuevo = new Nodo();
        nuevo.dato = _valor;
        nuevo.siguiente = inicio;
        inicio = nuevo;
        if(fin == null) fin = inicio;
    }
    
    void insertar_fin(int _valor){
        Nodo nuevo = new Nodo();
        nuevo.dato = _valor;
        nuevo.siguiente = null;
        if (fin != null){
            fin.siguiente = nuevo;
        }
        fin = nuevo;
        if (inicio == null) inicio = fin;
    }
    
    void mostrar(){
        System.out.println("---------------------------");
        Nodo aux = inicio;
        while (aux != null){
            System.out.println(aux.dato + " ");
            aux = aux.siguiente;
        }
        System.out.println("");
    }
    
    boolean vacia(){
        return (inicio == null);
    }
    
    void borrar_inicio(){
        if (inicio == null) return;
        if(inicio == fin){
            inicio = null;
            fin = null;
            return;
        }
        inicio = inicio.siguiente;
    }
    
    int sacar_inicio(){
        if (inicio == null) return 0;
        int valor = inicio.dato;
        inicio = inicio.siguiente;
        if (inicio == null){
            fin = null;
        }
        return valor;
    }
    
    void borrar_fin(){
        Nodo aux;
        if (fin == null) return;
        if (inicio == fin){
            inicio = null;
            fin = null;
            return;
        }
        aux = inicio;
        
        while(aux.siguiente != fin){
            aux = aux.siguiente;
        }
        aux.siguiente = null;
        fin = aux;
    }
    
    int extraer_inicio(){
        if (inicio != null) return inicio.dato;
        return 0;
    }
    
    int extraer_final(){
        if (fin != null) return fin.dato;
        return 0;
    }
}
