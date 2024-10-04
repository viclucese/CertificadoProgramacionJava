/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.prog05_tarea;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class Cliente {
    
    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String poblacion;
    private int codigo_postal;
    private int num_vehiculos;

    public Cliente(String dni, String nombre, String apellidos, String direccion, String poblacion, int codigo_postal, int num_vehiculos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.codigo_postal = codigo_postal;
        this.num_vehiculos = num_vehiculos;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public int getNum_vehiculos() {
        return num_vehiculos;
    }

    public void setNum_vehiculos(int num_vehiculos) {
        this.num_vehiculos = num_vehiculos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", poblacion=" + poblacion + ", codigo_postal=" + codigo_postal + ", num_vehiculos=" + num_vehiculos + '}';
    }    
}
