/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;

import Dominio.Persona;
import datos.PersonaDAO;
import java.util.List;

/**
 *
 * @author Víctor
 */
public class PruebaManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
        
        Persona p = new Persona("Martina", "Garcia-Adamez Cerrato", "lamasguapa@correo.com", "666444555");
        personaDao.insertar(p);
        
        List<Persona> personas = personaDao.seleccionar();
        for (Persona persona : personas){
            System.out.println("persona = " + persona);
        }
        
        //personas.forEach(persona -> {
        //    System.out.println("persona = " + persona);
        //});
             
    }
}
