/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cep.ejer1.poo;

/**
 *
 * @author Víctor Luis Cerrato Segovia
 */
public class Persona {
    
    private String dni;
    private String nombre;
    private String apellidos;

    public Persona(String dni, String nombre, String apellidos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    void mostrar(){
        System.out.println("Los datos de la persona son:");
        System.out.println("DNI: " + getDni());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellidos: " + getApellidos());
    }
}
