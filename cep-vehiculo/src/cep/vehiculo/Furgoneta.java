/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cep.vehiculo;

/**
 *
 * @author Víctor Luis Cerrato Segovia
 */
public class Furgoneta extends Vehiculo {
    protected int pesoMaximo;
    
    Furgoneta(int _potencia, int _peso, int _pesoMaximo){
        super(_potencia, _peso);
        pesoMaximo = _pesoMaximo;
    }

    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }
      
    @Override
    void mostrar(){
        super.mostrar();
        System.out.println("Esta furgoneta tiene " + getPotencia() + " caballos, pesa " + getPeso() + " y puede cargar hasta " + getPesoMaximo());
    }
}
