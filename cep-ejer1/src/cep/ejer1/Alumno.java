/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cep.ejer1;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class Alumno {
    
    private String nombre;
    private String apellidos;
    private int edad;
    
    Alumno(String _nombre, String _apellidos, int _edad){
        nombre = _nombre;
        apellidos = _apellidos;
        edad = _edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void info(){
        System.out.println("nombre = " + this.getNombre());
        System.out.println("apellidos = " + this.getApellidos());
        System.out.println("edad = " + this.getEdad());
    }
    
}
