/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cep.vehiculo;

/**
 *
 * @author Víctor Luis Cerrato Segovia
 */
public class Moto extends Vehiculo {
    
    Moto(int _potencia, int _peso){
        super(_potencia, _peso);
    }
    
    
    @Override
    void mostrar(){
        System.out.println("Esta moto tiene " + getPotencia() + " caballos y pesa " + getPeso() + " kilos");
    }
}
