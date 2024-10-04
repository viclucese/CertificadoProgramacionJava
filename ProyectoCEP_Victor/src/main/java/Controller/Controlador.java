package Controller;

/**
 *
 * @author Víctor
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Model.*;
import java.sql.Connection;
import View.VentanaPrograma;

public class Controlador implements ActionListener{
    private VentanaPrograma ventanaPrograma;
    private ArrayList<Victoria> listaVictorias;
    private VictoriaDAO victoriaDAO;
    private Victoria victoria;
    private Connection conn;
    
    public Controlador(){
        ventanaPrograma = new VentanaPrograma();
        ventanaPrograma.setActionListener(this);
        ventanaPrograma.setLocationRelativeTo(ventanaPrograma);
        ventanaPrograma.setVisible(true);
        
        listaVictorias = new ArrayList<>();
        victoriaDAO = new VictoriaDAO();
        victoria = new Victoria();
        
        conn = Conexion.obtenerConexion();
        listaVictorias = victoriaDAO.buscarTodasLosVictorias(conn);
        ventanaPrograma.cargarDatosTabla(listaVictorias);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "INSERTAR" -> {
                ventanaPrograma.limpiarDatosTabla();
                conn = Conexion.obtenerConexion();
                victoria = ventanaPrograma.obtenerVictoria();
                victoriaDAO.insertarVictoria(victoria, conn);                
                System.out.println("Insertando victoria:");
                System.out.println(victoria.toString());
                listaVictorias = victoriaDAO.buscarTodasLosVictorias(conn);
                ventanaPrograma.cargarDatosTabla(listaVictorias);
                Conexion.cerrarConexion(conn);
            }
            case "ACTUALIZAR" -> {
                ventanaPrograma.limpiarDatosTabla();
                conn = Conexion.obtenerConexion();
                victoria = ventanaPrograma.obtenerVictoria();
                victoriaDAO.actualizarVictoria(victoria, conn);                
                System.out.println("Actualizando victoria:");
                System.out.println(victoria.toString());
                listaVictorias = victoriaDAO.buscarTodasLosVictorias(conn);
                ventanaPrograma.cargarDatosTabla(listaVictorias);
                Conexion.cerrarConexion(conn);
            }
            case "ELIMINAR" -> {
                ventanaPrograma.limpiarDatosTabla();
                conn = Conexion.obtenerConexion();
                victoria = ventanaPrograma.obtenerVictoria();
                victoriaDAO.eliminarVictoria(victoria, conn);
                System.out.println("Eliminando victoria:");
                System.out.println(victoria.toString());
                listaVictorias = victoriaDAO.buscarTodasLosVictorias(conn);
                ventanaPrograma.cargarDatosTabla(listaVictorias);
                Conexion.cerrarConexion(conn);
            }
            case "Circuito" -> {
                ventanaPrograma.limpiarDatosTabla();
                conn = Conexion.obtenerConexion();
                String nombreCircuito = ventanaPrograma.obtenerTextoBuscar();
                listaVictorias = victoriaDAO.buscarPorCircuito(nombreCircuito, conn);
                System.out.println("Buscando victorias en el circuito: " + nombreCircuito);
                ventanaPrograma.cargarDatosTabla(listaVictorias);
                Conexion.cerrarConexion(conn);
            }
            case "Gran Premio" -> {
                ventanaPrograma.limpiarDatosTabla();
                conn = Conexion.obtenerConexion();
                String nombreGP = ventanaPrograma.obtenerTextoBuscar();
                listaVictorias = victoriaDAO.buscarPorGP(nombreGP, conn);
                System.out.println("Buscando victorias en el gran premio: " + nombreGP);
                ventanaPrograma.cargarDatosTabla(listaVictorias);
                Conexion.cerrarConexion(conn);
            }
            case "Equipo" -> {
                ventanaPrograma.limpiarDatosTabla();
                conn = Conexion.obtenerConexion();
                String nombreEquipo = ventanaPrograma.obtenerTextoBuscar();
                listaVictorias = victoriaDAO.buscarPorEquipo(nombreEquipo, conn);
                System.out.println("Buscando victorias en el equipo: " + nombreEquipo);
                ventanaPrograma.cargarDatosTabla(listaVictorias);
                Conexion.cerrarConexion(conn);
            }
            default -> throw new AssertionError();
        }
    }
}
