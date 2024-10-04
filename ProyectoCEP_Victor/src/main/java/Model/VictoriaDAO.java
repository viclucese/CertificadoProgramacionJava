package Model;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Víctor
 */
public class VictoriaDAO {
    public void insertarVictoria(Victoria v, Connection conn){
        String sqlInsertar = "INSERT INTO victorias (circuito, gp, equipo, anio) VALUES (?,?,?,?)";
        PreparedStatement ps;
        int filasInsertadas = 0;
        
        try {
            ps = conn.prepareStatement(sqlInsertar);
            if (v != null){
                ps.setString(1,v.getCircuito());
                ps.setString(2,v.getGp());
                ps.setString(3,v.getEquipo());
                ps.setInt(4, v.getAnio());
                
                filasInsertadas = ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Victorias INSERTADAS correctamente: " + filasInsertadas);
                ps.close();
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void actualizarVictoria(Victoria v, Connection conn){
        String sqlActualizar = "UPDATE victorias SET circuito=?, gp=?, equipo=?, anio=? WHERE id=?";
        
        PreparedStatement ps;
        int filasActualizadas = 0;
        try {
            ps = conn.prepareStatement(sqlActualizar);
            if(v != null){
                ps.setString(1,v.getCircuito());
                ps.setString(2,v.getGp());
                ps.setString(3,v.getEquipo());
                ps.setInt(4, v.getAnio());
                ps.setInt(5, v.getId());
                
                filasActualizadas = ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Victorias ACTUALIZADAS correctamente: " + filasActualizadas);
                ps.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void eliminarVictoria(Victoria v, Connection conn){
        String sqlEliminar = "DELETE FROM victorias WHERE id=?";
        
        PreparedStatement ps;
        int filasEliminadas = 0;
        
        try {
            ps = conn.prepareStatement(sqlEliminar);
            if (v != null){
                ps.setInt(1,v.getId());
                filasEliminadas = ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Victorias ELIMINADAS correctamente: "+filasEliminadas);
                ps.close();
                
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Victoria> buscarTodasLosVictorias(Connection conn) {
        String sqlBuscar = "SELECT * FROM victorias";
        ArrayList<Victoria> listaVictorias = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps = conn.prepareStatement(sqlBuscar);
            rs = ps.executeQuery();
            while(rs.next()){
                Victoria v = new Victoria(rs.getInt("id")
                    ,rs.getString("circuito")
                    ,rs.getString("gp")
                    ,rs.getString("equipo")
                    ,rs.getInt("anio"));
                listaVictorias.add(v);
            }
            
            return listaVictorias;
        } catch (Exception ex){
            ex.printStackTrace();
        }            
        return null;
    }
    public ArrayList<Victoria> buscarPorCircuito(String nombreCircuito, Connection conn) {
        String sqlBuscar = "SELECT * FROM victorias WHERE circuito like CONCAT ('%',?,'%')";
        ArrayList<Victoria> listaVictorias = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps = conn.prepareStatement(sqlBuscar);
            ps.setString(1, nombreCircuito);
            rs = ps.executeQuery();
            while(rs.next()){
                Victoria v = new Victoria(rs.getInt("id")
                    ,rs.getString("circuito")
                    ,rs.getString("gp")
                    ,rs.getString("equipo")
                    ,rs.getInt("anio"));
                listaVictorias.add(v);
            }
            return listaVictorias;
        } catch (Exception ex){
            ex.printStackTrace();
        }            
        return null;
    }
    public ArrayList<Victoria> buscarPorEquipo(String nombreEquipo, Connection conn) {
        String sqlBuscar = "SELECT * FROM victorias WHERE equipo like CONCAT ('%',?,'%')";
        ArrayList<Victoria> listaVictorias = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps = conn.prepareStatement(sqlBuscar);
            ps.setString(1, nombreEquipo);
            rs = ps.executeQuery();
            while(rs.next()){
                Victoria v = new Victoria(rs.getInt("id")
                    ,rs.getString("circuito")
                    ,rs.getString("gp")
                    ,rs.getString("equipo")
                    ,rs.getInt("anio"));
                listaVictorias.add(v);
            }
            return listaVictorias;
        } catch (Exception ex){
            ex.printStackTrace();
        }            
        return null;
    }
    public ArrayList<Victoria> buscarPorGP(String nombreGP, Connection conn) {
        String sqlBuscar = "SELECT * FROM victorias WHERE gp like CONCAT ('%',?,'%')";
        ArrayList<Victoria> listaVictorias = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps = conn.prepareStatement(sqlBuscar);
            ps.setString(1, nombreGP);
            rs = ps.executeQuery();
            while(rs.next()){
                Victoria v = new Victoria(rs.getInt("id")
                    ,rs.getString("circuito")
                    ,rs.getString("gp")
                    ,rs.getString("equipo")
                    ,rs.getInt("anio"));
                listaVictorias.add(v);
            }
            return listaVictorias;
        } catch (Exception ex){
            ex.printStackTrace();
        }            
        return null;
    }
}
