/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cep.vehiculo;

/**
 *
 * @author Víctor Luis Cerrato Segovia
 */
public class Camion extends Vehiculo {
    
    protected byte ruedas;
    protected int capacidad_remolque;

    public Camion(int _potencia, int _peso, byte _ruedas, int _capacidad_remolque) {
        super(_potencia, _peso);
        ruedas = _ruedas;
        capacidad_remolque = _capacidad_remolque;
    }  
    
}
