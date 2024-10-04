/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cep.operaciones;

/**
 *
 * @author Víctor Luis Cerrato Segovia
 */
public class principal {
    
    public static void main(String[] args) {
        Aritmetica ar1 = new Aritmetica();
        ar1.a= 3;
        ar1.b = 2;
        int resultado;
        
        resultado = ar1.sumarConRetorno();
        ar1.sumar();
        
        System.out.println("Mi resultado es " + resultado);
                
    }
    
}
