/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.prog10_tarea;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class Validar {
    
    public boolean validarDNI(String dni){
        boolean resultado = true;
        if(dni.length() == 9){
            for(int i=0; i<8; i++){
                if(!Character.isDigit(dni.charAt(i))){
                    resultado = false;
                }
            }
            if(Character.isDigit(dni.charAt(8))){
                resultado = false;
            }
        }else{
            resultado = false;
        }
        return resultado;
    }
}
