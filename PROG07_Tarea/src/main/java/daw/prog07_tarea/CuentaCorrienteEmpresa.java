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
public class CuentaCorrienteEmpresa extends CuentaCorriente implements Imprimible{
    
    private int maxDescubierto;
    private int tipoInteresDesc;
    private int comisionFija;
    
    public CuentaCorrienteEmpresa(Persona titular, long saldo, String iban, String entidades,
            int max, int tipo, int comision) {
        super(titular, saldo, iban, entidades);
        this.maxDescubierto = max;
        this.tipoInteresDesc = tipo;
        this.comisionFija = comision;
    }

    public int getMaxDescubierto() {
        return maxDescubierto;
    }

    public void setMaxDescubierto(int maxDescubierto) {
        this.maxDescubierto = maxDescubierto;
    }

    public int getTipoInteresDesc() {
        return tipoInteresDesc;
    }

    public void setTipoInteresDesc(int tipoInteresDesc) {
        this.tipoInteresDesc = tipoInteresDesc;
    }

    public int getComisionFija() {
        return comisionFija;
    }

    public void setComisionFija(int comisionFija) {
        this.comisionFija = comisionFija;
    }

    @Override
    public String devolverInfo() {
        return super.devolverInfo() + "maxDescubierto=" + maxDescubierto + ", tipoInteresDesc=" + tipoInteresDesc + ", comisionFija=" + comisionFija + '}';
    }
}
