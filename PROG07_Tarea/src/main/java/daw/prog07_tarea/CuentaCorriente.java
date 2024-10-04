/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.prog07_tarea;


/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public abstract class CuentaCorriente extends Cuenta implements Imprimible{
    
    protected String entidades; 
    
    public CuentaCorriente(Persona titular, long saldo, String iban, String entidades) {
        super(titular, saldo, iban);
        this.entidades = entidades;
    }
    
    public String getEntidades(){
        return this.entidades;
    }

    @Override
    public String devolverInfo() {
        return super.devolverInfo() + ", entidades=" + entidades;
    }
}
