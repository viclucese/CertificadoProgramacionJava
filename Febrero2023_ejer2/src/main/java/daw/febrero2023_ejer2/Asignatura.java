/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.febrero2023_ejer2;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class Asignatura {
    private int codigo;
    private String nombre;
    private int curso;
    private int horas;
    private String especialidad;
    private String nif_profesor;
    
    public Asignatura(int codigo, String nombre, int curso, int horas, String especialidad, String nif){
        this.codigo = codigo;
        this.nombre = nombre;
        this.curso = curso;
        this.horas = horas;
        this.especialidad = especialidad;
        this.nif_profesor = nif;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNif_profesor() {
        return nif_profesor;
    }

    public void setNif_profesor(String nif_profesor) {
        this.nif_profesor = nif_profesor;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "codigo=" + codigo + ", nombre=" + nombre + ", curso=" + curso + ", horas=" + horas + ", especialidad=" + especialidad + ", nif_profesor=" + nif_profesor + '}';
    }
    
    
}
