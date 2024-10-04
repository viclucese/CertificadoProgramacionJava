/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cep.ejer1;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class Persona {

    String dni;
    String nombre;
    String apellidos;
    String telefono;
    String email;

    public Persona(String dni, String nombre, String apellidos, String telefono, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
    }

    public void desplegarInformacion() {
        System.out.println("dni = " + dni);
        System.out.println("nombre = " + nombre);
        System.out.println("apellidos = " + apellidos);
        System.out.println("telefono = " + telefono);
        System.out.println("email = " + email);
    }

}
