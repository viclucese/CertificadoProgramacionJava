package modelo;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Víctor
 */
public class ProductoDAO {
    public void insertarProducto(Producto producto, Connection conn){
        String sqlInsertar = "INSERT INTO productos (nombre, precio, categoria) VALUES (?,?,?)";
        PreparedStatement ps;
        int filasInsertadas = 0;
        
        try {
            ps = conn.prepareStatement(sqlInsertar);
            if (producto != null){
                ps.setString(1,producto.getNombre());
                ps.setDouble(2,producto.getPrecio());
                ps.setString(3,producto.getCategoria());
                
                filasInsertadas = ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Productos INSERTADOS correctamente: " + filasInsertadas);
                ps.close();
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void actualizarProducto(Producto producto, Connection conn){
        String sqlActualizar = "UPDATE productos SET nombre=?, precio=?, categoria=? WHERE id=?";
        
        PreparedStatement ps;
        int filasActualizadas = 0;
        try {
            ps = conn.prepareStatement(sqlActualizar);
            if(producto != null){
                ps.setString(1,producto.getNombre());
                ps.setDouble(2,producto.getPrecio());
                ps.setString(3,producto.getCategoria());
                ps.setInt(4,producto.getId());
                
                filasActualizadas = ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Productos ACTUALIZADOS correctamente: " + filasActualizadas);
                ps.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void eliminarProducto(Producto producto, Connection conn){
        String sqlEliminar = "DELETE FROM productos WHERE id=?";
        
        PreparedStatement ps;
        int filasEliminadas = 0;
        
        try {
            ps = conn.prepareStatement(sqlEliminar);
            if (producto != null){
                ps.setInt(1,producto.getId());
                filasEliminadas = ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Productos ELIMINADOS correctamente: "+filasEliminadas);
                ps.close();
                
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public ArrayList<Producto> buscarTodosLosProductos(Connection conn) {
        String sqlBuscar = "SELECT * FROM productos";
        ArrayList<Producto> listaProductos = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps = conn.prepareStatement(sqlBuscar);
            rs = ps.executeQuery();
            while(rs.next()){
                Producto producto = new Producto(rs.getInt("id")
                    ,rs.getString("nombre")
                    ,rs.getDouble("precio")
                    ,rs.getString("categoria"));
                listaProductos.add(producto);
            }
            
            return listaProductos;
        } catch (Exception ex){
            ex.printStackTrace();
        }            
        return null;
    }

    public ArrayList<Producto> buscarPorNombreProducto(String nombreProducto, Connection conn) {
        String sqlBuscar = "SELECT * FROM productos WHERE nombre like CONCAT ('%',?,'%')";
        ArrayList<Producto> listaProductos = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps = conn.prepareStatement(sqlBuscar);
            ps.setString(1, nombreProducto);
            rs = ps.executeQuery();
            while(rs.next()){
                Producto producto = new Producto(rs.getInt("id")
                    ,rs.getString("nombre")
                    ,rs.getDouble("precio")
                    ,rs.getString("categoria"));
                listaProductos.add(producto);
            }
            return listaProductos;
        } catch (Exception ex){
            ex.printStackTrace();
        }            
        return null;
    }
}
