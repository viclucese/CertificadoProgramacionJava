/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.prog08_tarea;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class Concesionario {
    
    private List<Vehiculo> vehiculos;
    private List<Cliente> clientes;
    
    class ComparadorVehiculo implements Comparator<Vehiculo>{
        @Override
        //Devuelve 1 si o1 > o2; 0 si o1 = o2; -1 si o1 < o2
        public int compare(Vehiculo o1, Vehiculo o2) { 
            String matriculaA = o1.getMatricula();
            String matriculaB = o2.getMatricula();
            int numMatA = Integer.parseInt(matriculaA.substring(0, 4));
            int numMatB = Integer.parseInt(matriculaB.substring(0, 4));
            String letrasMatA = matriculaA.substring(4);
            String letrasMatB = matriculaB.substring(4);
            
            //System.out.println(matriculaA + ", " + matriculaB + ", " + numMatA + ", " + numMatB + ", " + letrasMatA + ", " + letrasMatB);

            if(letrasMatA.compareTo(letrasMatB) > 0){
                return 1;
            }else if(letrasMatA.compareTo(letrasMatB) < 0){
                return -1;
            }else{
                if(numMatA > numMatB){
                    return 1;
                }else if(numMatA < numMatB){
                    return -1;
                }else{
                    return 0;
                }
            }
        }
    }
    
    public Concesionario(){
        this.vehiculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }
    
    public boolean eliminarVehiculo(String matricula){
        boolean enc = false;
        for(int i=0; i<this.vehiculos.size() && !enc; i++){
            if(this.vehiculos.get(i).getMatricula().equals(matricula)){
                this.vehiculos.remove(i);
                enc = true;
            }
        }
        //this.vehiculos.sort(new ComparadorVehiculo());
        return enc;
    }
    
    public int insertarVehiculo(Vehiculo v){
        if(buscarVehiculo(v.getMatricula())!=null){
            return -1;
        }else{
            this.vehiculos.add(v);
            this.vehiculos.sort(new ComparadorVehiculo());
            return 0;
        }
    }
    
    public int insertarCliente(Cliente c){       
        if(buscarCliente(c.getDni()) != null){
            return -1;
        }else{
            this.clientes.add(c);
            return 0;
        }
    }
    
    public String buscarVehiculo(String matricula){
        String resultado = null;
        boolean enc = false;
        for(int i=0; i<this.vehiculos.size() && !enc; i++){
            if(this.vehiculos.get(i).getMatricula().compareTo(matricula)==0){
                resultado = this.vehiculos.get(i).toString();
                enc = true;
            }
        }
        return resultado;
    }
    
    public boolean listarVehiculos(String dni){
        boolean enc = false;
        ArrayList<Vehiculo> encontrados = new ArrayList<>();
        for(int i=0; i<this.vehiculos.size(); i++){
            if(this.vehiculos.get(i).getDni_propietario().equals(dni)){
                encontrados.add(this.vehiculos.get(i));
                enc = true;
            }
        }
        //this.vehiculos.sort(new ComparadorVehiculo());
        for(int i=0; i<encontrados.size(); i++){
            System.out.println(encontrados.get(i).toString());
        }
        
        return enc;
    }
    
    public String buscarCliente(String dni){
        String resultado = null;
        boolean enc = false;
        for(int i=0; i<this.clientes.size() && !enc; i++){
            if(this.clientes.get(i).getDni().equals(dni)){
                resultado = this.clientes.get(i).toString();
                enc = true;
            }
        }
        return resultado;
    }
    
    public void listarClientes(){
        for(int i=0; i<this.clientes.size(); i++){
            System.out.println(this.clientes.get(i).toString());
        }
    }
}
