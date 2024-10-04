/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cep.ejer1.poo;

/**
 *
 * @author Víctor Luis Cerrato Segovia
 */
public class PersonalLaboral extends Trabajador {
    
    protected String puesto;

    public PersonalLaboral(String dni, String nombre, String apellidos, String direccion, String puesto) {
        super(dni, nombre, apellidos, direccion);
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    void mostrar() {
        System.out.println("Mostrando informacion del personal laboral: ");
        super.mostrar(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("Puesto: " + getPuesto());
    }
    
    
    
    
}
