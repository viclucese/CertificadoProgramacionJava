/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw.prog02_ejerc6;

/**
 *
 * @author Víctor
 */
public class PROG02_Ejerc6 {

    enum RazaPerro {Mastin, Terrier, Bulldog, Pekines, Caniche, Galgo};
    
    public static void main(String[] args) {
        RazaPerro var1 = RazaPerro.Bulldog;
        RazaPerro var2 = RazaPerro.Galgo;

        System.out.println(var1.compareTo(var2));

        System.out.println(var1.ordinal());
        System.out.println(var2.ordinal());
        System.out.println(RazaPerro.values().length);
    }
}
