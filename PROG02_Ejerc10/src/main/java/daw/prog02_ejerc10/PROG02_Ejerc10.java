/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw.prog02_ejerc10;

/**
 *
 * @author Víctor
 */
public class PROG02_Ejerc10 {

    public static void main(String[] args) {
        float x = 4.5f;
        float y = 3.0f;
        int i = 2;
        double dx = 2.0;
        
        // Mostrar resultados
        System.out.println("------- Conversiones entre enteros y coma flotante -------");
        int j = (int) (i * x);
        System.out.println("Producto de int por float: j = i * x = " + j);
        double dz = dx * y;
        System.out.println("Producto de float por double: dz = dx * y = " + dz);
        System.out.println();
        
        System.out.println("------- Operaciones con byte -------");
        byte bx = 5;
        byte by = 2;
        byte bz = (byte) (bx - by);
        System.out.println("byte: 5 - 2 = " + bz);
        bx = -128;
        by = 1;
        bz = (byte) (bx - by);
        System.out.println("byte -128 - 1 = " + bz);
        System.out.println("(int)(-128 - 1) = " + ((int) (bx - by)));
        System.out.println();
        
        short sx = 5;
        short sy = 2;
        short sz = (short) (sx - sy);
        
        System.out.println("------- Operaciones con short -------");
        System.out.println("short: 5 - 2 = " + sz);
        sx = 32767;
        sy = 1;
        sz = (short) (sx + sy);
        System.out.println("short 32767 + 1 = " + sz);
        System.out.println();
        
        
        //char cx = '\u000F';
        char cx = 0x000F;
        //char cy = '\u0001';
        char cy = 0x0001;
        int z = cx - cy;
        z = cx - 1;
        z = cx;
        sx = (short) cx;
        

        
        System.out.println("------- Operaciones con char -------");
        System.out.println("char: - = " + z);
        //cx = '\u000F';
        cx = 0x000F;
        cy = '\u0001';
        System.out.println("char(0x000F) - 1 = " + (z = cx - 1));
        //System.out.println("(int)(0xFFFF) = " + ((int) '\uFFFF'));
        System.out.println("(int)(0xFFFF) = " + ((int) 0xFFFF));
        System.out.println("(short)(char)(-32768) = " + ((short) (char) -32768));
        short lx = -32768;
        cx = (char) lx;
        z = sx;
        System.out.println("-32768 short-char-int = " + z);
        sx = -1;
        cx = (char) sx;
        z = cx;
        //System.out.println("-1 short-char-int = " + ((short) (char) (int) -1));
        System.out.println("-1 short-char-int = " + z);
    }
}
