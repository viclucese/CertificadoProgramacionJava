/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.prog07_tarea;

import java.util.List;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class CuentaCorrientePersonal extends CuentaCorriente implements Imprimible{
    
    private int comision;
    
    public CuentaCorrientePersonal(Persona titular, long saldo, String iban, String entidades, int comision) {
        super(titular, saldo, iban, entidades);
        this.comision = comision;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    @Override
    public String devolverInfo() {
        return super.devolverInfo() + "comision=" + comision + '}';
    }
    
}
