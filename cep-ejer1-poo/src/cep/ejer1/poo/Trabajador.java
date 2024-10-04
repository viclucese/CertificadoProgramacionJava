/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cep.ejer1.poo;

/**
 *
 * @author Víctor Luis Cerrato Segovia
 */
public class Trabajador extends Persona {
    protected String direccion;

    public Trabajador(String dni, String nombre, String apellidos, String direccion) {
        super(dni, nombre, apellidos);
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    void mostrar() {
        System.out.println("--Datos de un trabajador--");
        super.mostrar(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("Direccion: " + getDireccion());
    }
    
    
    
}
