/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw.prog07_tarea;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class PROG07_Tarea {
    
    private Banco banco;
    
    public PROG07_Tarea(){
        this.banco = new Banco();
    }
    
    public void menuPrincipal(){
        System.out.println("---------------------------------------------");
        System.out.println("(1) Abrir una nueva cuenta");
        System.out.println("(2) Ver listado de cuentas disponibles");
        System.out.println("(3) Obtener datos de una cuenta concreta");
        System.out.println("(4) Hacer un ingreso en una cuenta");
        System.out.println("(5) Retirar efectivo de una cuenta");
        System.out.println("(6) Consultar saldo actual de una cuenta");
        System.out.println("(7) Salir");
        System.out.println("---------------------------------------------");
    }
    
    public void abrirCuenta(){
        Scanner scan = new Scanner(System.in);
        System.out.println("---------------------------------------------");
        System.out.println("Introduzca los siguientes datos del titular de la cuenta.");
        System.out.println("Nombre:");
        String nombre = scan.nextLine();
        System.out.println("Apellidos:");
        String apellidos = scan.nextLine();
        System.out.println("DNI:");
        String dni = scan.nextLine();
        Persona p = new Persona(nombre, apellidos, dni);
        
        System.out.println("Introduzca el IBAN: ");
        String iban = scan.nextLine();
        Pattern pattern = Pattern.compile("[E]{1}[S]{1}[0-9]{22}");
        Matcher m = pattern.matcher(iban);
        if(m.matches()){
            
            System.out.println("Introduzca el saldo correspondiente a la cuenta:");
            int saldo = scan.nextInt();
            
            System.out.println("Formato de IBAN correcto...");
            System.out.println("Indique el tipo de cuenta que desea crear:");
            System.out.println("(1) Cuenta de ahorro");
            System.out.println("(2) Cuenta corriente personal");
            System.out.println("(3) Cuenta corriente de empresa");
            int tipoCuenta = scan.nextInt();
            
            Cuenta cuenta;
            switch(tipoCuenta){
                case 1:
                    cuenta = new CuentaAhorros(p, saldo, iban, 3);
                    break;
                case 2:
                    cuenta = new CuentaCorrientePersonal(p, saldo, iban, "A, B, C", 5);
                    break;
                default:
                    cuenta = new CuentaCorrienteEmpresa(p, saldo, iban, iban, 100, 4, 6);
                    break;
            }
            
            System.out.println("Creando cuenta nueva...");
            if(this.banco.getNumCuentasAct() != 100){
                this.banco.abrirCuenta(cuenta);
                System.out.println("Cuenta creada correctamente");
            }else{
                System.out.println("ERROR: Máximo número de cuentas alcanzado");
            }
            
        }else{
            System.out.println("ERROR: Formato de IBAN erróneo");
        }
        
        System.out.println("---------------------------------------------");
    }
    
    public void listarCuentasDisponibles(){
        System.out.println("---------------------------------------------");
        String[] resultado = this.banco.listadoCuentas();
        for(String info : resultado){
            System.out.println(info);
        }
        System.out.println("---------------------------------------------");
    }
    
    public void obtenerInfoCuenta(){
        System.out.println("---------------------------------------------");
        System.out.println("Introduzca el IBAN de la cuenta que desea consultar:");
        Scanner scan = new Scanner(System.in);
        String iban = scan.nextLine();
        String resultado = banco.informacionCuenta(iban);
        if(resultado == null){
            System.out.println("ERROR: No existe ninguna cuenta con dicho IBAN");
        }else{
            System.out.println(resultado);
        }
        System.out.println("---------------------------------------------");
    }
    
    public void realizarIngresoCuenta(){
        System.out.println("---------------------------------------------");
        Scanner scan = new Scanner(System.in);
        System.out.println("Indique el IBAN de la cuenta en la que desea ingresar");
        String iban = scan.nextLine();
        System.out.println("Indique la cantidad de dinero a ingresar");
        int cantidad = scan.nextInt();
        boolean resultado = banco.ingresoCuenta(iban, cantidad);
        if(resultado){
            System.out.println("Ingreso realizado correctamente.");
        }else{
            System.out.println("ERROR: Imposible realizar el ingreso.");
        }
        System.out.println("---------------------------------------------");
    }
    
    public void retirarEfectivoCuenta(){
        System.out.println("---------------------------------------------");
        Scanner scan = new Scanner(System.in);
        System.out.println("Indique el IBAN de la cuenta en la que desea hacer la retirada");
        String iban = scan.nextLine();
        System.out.println("Indique la cantidad de dinero a retirar");
        int cantidad = scan.nextInt();
        boolean resultado = banco.retiradaCuenta(iban, cantidad);
        if(resultado){
            System.out.println("Retirada de dinero realizada correctamente.");
        }else{
            System.out.println("ERROR: Imposible realizar la retirada. ");
        }
        System.out.println("---------------------------------------------");
    }
    
    public void consultarSaldoCuenta(){
        System.out.println("---------------------------------------------");
        Scanner scan = new Scanner(System.in);
        System.out.println("Indique el IBAN de la cuenta en la que desea hacer la retirada");
        String iban = scan.nextLine();
        long resultado = banco.obtenerSaldo(iban);
        if(resultado == -1){
            System.out.println("ERROR: Imposible consultar la información de dicha cuenta");
        }else{
            System.out.println("Saldo de la cuenta " + iban + ": " + String.valueOf(resultado));
        }
        System.out.println("---------------------------------------------");
    }

    public static void main(String[] args) {
        PROG07_Tarea menu = new PROG07_Tarea();
        Scanner scan = new Scanner(System.in);
        int op = -1;
        while(op != 7){
            menu.menuPrincipal();
            op = scan.nextInt();
            switch (op){
                case 1:
                    menu.abrirCuenta();
                    break;
                case 2:
                    menu.listarCuentasDisponibles();
                    break;
                case 3:
                    menu.obtenerInfoCuenta();
                    break;
                case 4:
                    menu.realizarIngresoCuenta();
                    break;
                case 5:
                    menu.retirarEfectivoCuenta();
                    break;
                case 6:
                    menu.consultarSaldoCuenta();
                    break;
                default:
                    break;
            }
        }
    }
}
