/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.prog06_tarea;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class Concesionario {
    
    private int maxVehiculos;
    private int maxClientes;
    private Vehiculo[] vehiculos;
    private Cliente[] clientes;
    private int clientesActuales;
    private int vehiculosActuales;
    
    public Concesionario(){
        this.maxClientes = 20;
        this.maxVehiculos = 50;
        this.vehiculos = new Vehiculo[maxVehiculos];
        this.clientes = new Cliente[maxClientes];
        this.clientesActuales = 0;
        this.vehiculosActuales = 0;
    }
    
    public int insertarVehiculo(Vehiculo v){
        int inserted = 0;
        if(this.vehiculosActuales == maxVehiculos || buscarVehiculo(v.getMatricula())!=null){
            inserted = -1;
        }
        
        if(inserted==0){
            this.vehiculos[vehiculosActuales] = v;
            this.vehiculosActuales++;
        }
        return inserted;
    }
    
    public int insertarCliente(Cliente c){
        int inserted = 0;
        if(this.clientesActuales == maxClientes){
            inserted = -1;
        }else{
            if(buscarCliente(c.getDni()) != null){
                inserted = -2;
            }
        }
        if(inserted==0){
            this.clientes[clientesActuales] = c;
            this.clientesActuales++; 
        }
        return inserted;
    }
    
    public String buscarVehiculo(String matricula){
        String resultado = null;
        boolean enc = false;
        for(int i=0; i<this.vehiculosActuales && !enc; i++){
            if(this.vehiculos[i].getMatricula().equals(matricula)){
                resultado = this.vehiculos[i].toString();
                enc = true;
            }
        }
        return resultado;
    }
    
    public boolean listarVehiculos(String dni){
        boolean enc = false;
        for(int i=0; i<this.vehiculosActuales; i++){
            if(this.vehiculos[i].getDni_propietario().equals(dni)){
                System.out.println(this.vehiculos[i].toString());
                enc = true;
            }
        }
        return enc;
    }
    
    public String buscarCliente(String dni){
        String resultado = null;
        boolean enc = false;
        for(int i=0; i<this.clientesActuales && !enc; i++){
            if(this.clientes[i].getDni().equals(dni)){
                resultado = this.clientes[i].toString();
                enc = true;
            }
        }
        return resultado;
    }
    
    public void listarClientes(){
        for(int i=0; i<this.clientesActuales; i++){
            System.out.println(this.clientes[i].toString());
        }
    }
}
