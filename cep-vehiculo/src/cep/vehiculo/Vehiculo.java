/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cep.vehiculo;

/**
 *
 * @author Víctor Luis Cerrato Segovia
 */
public class Vehiculo {
    protected int potencia;
    protected int peso;
    
    Vehiculo(int _potencia, int _peso){
        potencia = _potencia;
        peso = _peso;
    }
    
    void echar_combustible(){
        System.out.println("Echando combustible...");
    }
    
    void mostrar(){
        System.out.println("Vehiculo de potencia " + potencia + " y peso " + peso);
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
}
