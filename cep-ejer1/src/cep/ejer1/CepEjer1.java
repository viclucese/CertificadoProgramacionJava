package cep.ejer1;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class CepEjer1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        Persona p1 = new Persona("53263991Q", "Victor", "Cerrato", "611453927", "viclucese@gmail.com");
//        Persona p2 = new Persona("4564879C", "Ana", "Gutierrez", "666888777", "cosas@gmail.com");
//
//        p1.desplegarInformacion();
//        
//        p2.desplegarInformacion();

            Alumno a1 = new Alumno("Victor", "Cerrato", 33);
            
            a1.info();
            a1.setNombre("Victor Luis");
            a1.setApellidos("Cerrato Segovia");
        
            
            a1.info();

    }

}
