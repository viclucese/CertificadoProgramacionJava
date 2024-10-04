/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.prog07_tarea;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class CuentaAhorros extends Cuenta implements Imprimible{
    
    private int tipoInteres;
    
    public CuentaAhorros(Persona titular, long saldo, String iban, int tipo) {
        super(titular, saldo, iban);
        this.tipoInteres = tipo;
    }

    public int getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(int tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    @Override
    public String devolverInfo() {
        return super.devolverInfo() + ", tipoInteres=" + tipoInteres + '}';
    }
}
