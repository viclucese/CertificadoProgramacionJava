/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cep.vehiculo;

/**
 *
 * @author Víctor Luis Cerrato Segovia
 */
public class CepVehiculo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Furgoneta furgo = new Furgoneta(100, 1500, 3500);
        
        furgo.mostrar();
        
        Moto versys = new Moto(45, 120);
        versys.mostrar();
        
        Monovolumen kia = new Monovolumen(100, 1500, 5, 7);
        
        kia.mostrar();
    }
    
}
