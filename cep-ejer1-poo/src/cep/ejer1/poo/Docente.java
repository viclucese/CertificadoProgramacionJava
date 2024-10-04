/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cep.ejer1.poo;

/**
 *
 * @author Víctor Luis Cerrato Segovia
 */
public class Docente extends Trabajador {
    
    protected String departamento;

    public Docente(String dni, String nombre, String apellidos, String direccion, String departamento) {
        super(dni, nombre, apellidos, direccion);        
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    void mostrar() {
        System.out.println("Mostrando informacion de Docente: ");
        super.mostrar(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("Departamento: " + getDepartamento());
    }
    
    
    
}
