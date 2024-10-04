/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cep.vehiculo;

/**
 *
 * @author Víctor Luis Cerrato Segovia
 */
public class Coche extends Vehiculo {
    
    protected int puertas;

    public Coche(int _potencia, int _peso, int _puertas) {
        super(_potencia, _peso);
        puertas = _puertas;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }    
    
}
