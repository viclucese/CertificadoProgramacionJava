/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.prog09_tarea;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public abstract class Cuenta implements Imprimible {
    
    private Persona titular;
    private long saldo;
    private String iban;
    private int tipoCuenta;
    
    public Cuenta(Persona titular, long saldo, String iban, int tipoCuenta){
        this.titular = titular;
        this.saldo = saldo;
        this.iban = iban;
        this.tipoCuenta = tipoCuenta;
    }
    
    public int getTipoCuenta(){
        return tipoCuenta;
    }
    
    public void setTipoCuenta (int tipo){
        this.tipoCuenta = tipo;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public String devolverInfo() {
        return "{" + "tipo:" + tipoCuenta + ", " + titular.toString() + ", saldo:" + saldo + ", iban:" + iban;
    }
}
