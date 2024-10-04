/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.febrero2023_ejer2;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class Profesor {
    private String nif_profesor;
    private String nombre;
    private String especialidad;
    private int edad;
    
    public Profesor(String nif, String nombre, String especialidad, int edad){
        this.nif_profesor = nif;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.edad = edad;
    }

    public String getNif_profesor() {
        return nif_profesor;
    }

    public void setNif_profesor(String nif_profesor) {
        this.nif_profesor = nif_profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Profesor{" + "nif_profesor=" + nif_profesor + ", nombre=" + nombre + ", especialidad=" + especialidad + ", edad=" + edad + '}';
    }
    
    
}
