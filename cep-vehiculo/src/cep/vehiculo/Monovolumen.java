/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cep.vehiculo;

/**
 *
 * @author Víctor Luis Cerrato Segovia
 */
public class Monovolumen extends Coche {
    
    protected int numeroAsientos;

    public Monovolumen(int _potencia, int _peso, int _puertas, int _numeroAsientos) {
        super(_potencia, _peso, _puertas);
        numeroAsientos = _numeroAsientos;
    }

    public int getNumeroAsientos() {
        return numeroAsientos;
    }

    public void setNumeroAsientos(int numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }
    
    
    void mostrar(){
        super.mostrar();
        System.out.println("Monovolumen con " + getNumeroAsientos() + " asientos");
    }    
    
}
