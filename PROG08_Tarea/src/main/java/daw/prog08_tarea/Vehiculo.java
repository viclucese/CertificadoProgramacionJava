/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.prog08_tarea;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class Vehiculo {
    
    private String marca;
    private String matricula;
    private int num_kilometros;
    private Date fecha_matriculacion;
    private String descripcion;
    private double precio;
    private String nombre_propietario;
    private String dni_propietario;

    public Vehiculo(String marca, String matricula, int num_kilometros, Date fecha_matriculacion, String descripcion, double precio, String nombre_propietario, String dni_propietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.num_kilometros = num_kilometros;
        this.fecha_matriculacion = fecha_matriculacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombre_propietario = nombre_propietario;
        this.dni_propietario = dni_propietario;
    }
    
    public Vehiculo(String dni, String marca, String matricula){
        this.dni_propietario = dni;
        this.marca = marca;
        this.matricula = matricula;
        this.num_kilometros = 0;
        this.fecha_matriculacion = new Date();
        this.descripcion = "vacío";
        this.precio = 10000;
        this.nombre_propietario = "vacio";
    }
    
    

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getNum_kilometros() {
        return num_kilometros;
    }

    public void setNum_kilometros(int num_kilometros) {
        this.num_kilometros = num_kilometros;
    }

    public Date getFecha_matriculacion() {
        return fecha_matriculacion;
    }

    public void setFecha_matriculacion(Date fecha_matriculacion) {
        this.fecha_matriculacion = fecha_matriculacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre_propietario() {
        return nombre_propietario;
    }

    public void setNombre_propietario(String nombre_propietario) {
        this.nombre_propietario = nombre_propietario;
    }

    public String getDni_propietario() {
        return dni_propietario;
    }

    public void setDni_propietario(String dni_propietario) {
        this.dni_propietario = dni_propietario;
    }
    
    public int get_Anios(){
        Calendar c = new GregorianCalendar();
        int anio_act = c.get(Calendar.YEAR);
        int anio_mat = fecha_matriculacion.getYear();
        return (anio_act - anio_mat);
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", matricula=" + matricula + ", num_kilometros=" + num_kilometros + ", fecha_matriculacion=" + fecha_matriculacion + ", descripcion=" + descripcion + ", precio=" + precio + ", nombre_propietario=" + nombre_propietario + ", dni_propietario=" + dni_propietario + '}';
    }

}