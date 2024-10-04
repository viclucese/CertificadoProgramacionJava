/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cep.ejer1.poo;

/**
 *
 * @author Víctor Luis Cerrato Segovia
 */
public class Alumno extends Persona {
    
    protected String curso;

    public Alumno(String dni, String nombre, String apellidos, String curso) {
        super(dni, nombre, apellidos);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    

    @Override
    void mostrar() {
        System.out.println("Mostrando info de Alumno:");
        super.mostrar();
        System.out.println("Curso: " + getCurso());
    }
    
}
