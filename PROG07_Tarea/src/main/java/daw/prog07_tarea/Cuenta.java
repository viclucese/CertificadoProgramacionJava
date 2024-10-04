/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.prog07_tarea;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public abstract class Cuenta implements Imprimible {
    
    protected Persona titular;
    protected long saldo;
    protected String iban;
    
    public Cuenta(Persona titular, long saldo, String iban){
        this.titular = titular;
        this.saldo = saldo;
        this.iban = iban;
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
        return "Cuenta{" + "titular=" + titular + ", saldo=" + saldo + ", iban=" + iban;
    }
}
