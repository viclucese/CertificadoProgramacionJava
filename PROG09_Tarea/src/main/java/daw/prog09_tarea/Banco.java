/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.prog09_tarea;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class Banco {
    
    private Cuenta[] cuentas;
    private int numCuentasAct;
    
    public Banco(){
        this.cuentas = new Cuenta[100];
        this.numCuentasAct = 0;
    }

    public Cuenta[] getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuenta[] cuentas) {
        this.cuentas = cuentas;
    }

    public int getNumCuentasAct() {
        return numCuentasAct;
    }

    public void setNumCuentasAct(int numCuentasAct) {
        this.numCuentasAct = numCuentasAct;
    }
    
    public boolean abrirCuenta(Cuenta cuenta){
        this.cuentas[numCuentasAct] = cuenta;
        this.numCuentasAct++;
        return true;
    }
    
    public String[] listadoCuentas(){
        String[] resultado = new String[this.numCuentasAct];
        for(int i=0; i<this.numCuentasAct; i++){
            resultado[i] = this.cuentas[i].devolverInfo();
        }
        return resultado;
    }
    
    public String informacionCuenta(String iban){
        String resultado = null;
        boolean enc = false;
        for(int i=0; i<this.numCuentasAct && !enc; i++){
            if(this.cuentas[i].getIban().equals(iban)){
                resultado = this.cuentas[i].devolverInfo();
                enc = true;
            }
        }
        return resultado;
    }
    
    public boolean ingresoCuenta(String iban, int cantidad){
        boolean enc = false;
        for(int i=0; i<this.numCuentasAct && !enc; i++){
            if(this.cuentas[i].getIban().equals(iban)){
                long saldo = this.cuentas[i].getSaldo();
                saldo += cantidad;
                this.cuentas[i].setSaldo(saldo);
                enc = true;
            }
        }
        return enc;
    }
    
    public boolean retiradaCuenta(String iban, int cantidad){
        boolean enc = false;
        for(int i=0; i<this.numCuentasAct && !enc; i++){
            if(this.cuentas[i].getIban().equals(iban)){
                long saldo = this.cuentas[i].getSaldo();
                if(saldo < cantidad){
                    enc = false;
                }else{
                    saldo -= cantidad;
                    this.cuentas[i].setSaldo(saldo);
                    enc = true;
                }
            }
        }
        return enc;
    }
    
    public long obtenerSaldo(String iban){
        boolean enc = false;
        long resultado = -1;
        for(int i=0; i<this.numCuentasAct && !enc; i++){
            if(this.cuentas[i].getIban().equals(iban)){
                resultado = this.cuentas[i].getSaldo();
                enc = true;
            }
        }
        return resultado;
    }
}
