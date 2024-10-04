package controlador;

/**
 *
 * @author Víctor
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.Producto;
import modelo.ProductoDAO;
import java.sql.Connection;
import vista.VentanaPrograma;

public class ControladorPrograma implements ActionListener {

    //atributos
    private VentanaPrograma ventanaPrograma;
    private ArrayList<Producto> listaProductos;
    private ProductoDAO productoDAO;
    private Producto producto;
    private Connection conn;

    //constructor
    public ControladorPrograma() {
        ventanaPrograma = new VentanaPrograma();
        ventanaPrograma.setActionListener(this);
        ventanaPrograma.setLocationRelativeTo(ventanaPrograma);
        ventanaPrograma.setVisible(true);

        listaProductos = new ArrayList<>();
        productoDAO = new ProductoDAO();
        producto = new Producto();

        //1: Cargamos la lista de productos nada mas abrir el programa
        conn = Conexion.obtenerConexion();
        //2: Obtenemos la lista de productos de la base de datos
        listaProductos = productoDAO.buscarTodosLosProductos(conn);
        //3: Cargamos lo datos en la tabla
        ventanaPrograma.cargarDatosTabla(listaProductos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "INSERTAR" -> {
                //1: Limpiamos la tabla antes de mostrar nada
                ventanaPrograma.limpiarDatosTabla();
                //2: Abrimos la conexion
                conn = Conexion.obtenerConexion();
                //3: Obtenemos el producto para insertar
                producto = ventanaPrograma.obtenerProducto();
                //4: Insertamos el producto
                productoDAO.insertarProducto(producto, conn);
                //5: Obtenemos los productos para mostrarlos en la lista
                listaProductos = productoDAO.buscarTodosLosProductos(conn);
                //6: Cargamos la lista de los productos en la tabla
                ventanaPrograma.cargarDatosTabla(listaProductos);
                //7: Cerramos la conexion
                Conexion.cerrarConexion(conn);
            }
            case "ACTUALIZAR" -> {
                //1:Limpiamos la tabla antes de mostrar nada
                ventanaPrograma.limpiarDatosTabla();
                //2: Abrimos la conexion
                conn = Conexion.obtenerConexion();
                //3: Obtemos el producto para actualizar
                producto = ventanaPrograma.obtenerProducto();
                //4: Actualizamos el producto
                productoDAO.actualizarProducto(producto, conn);
                //5: Obtenemos los productos para mostrarlos en la lista
                listaProductos = productoDAO.buscarTodosLosProductos(conn);
                //6: Cargamos la lista de los productos en la tabla
                ventanaPrograma.cargarDatosTabla(listaProductos);
                //7: Cerramos la conexion
                Conexion.cerrarConexion(conn);
            }
            case "ELIMINAR" -> {
                //1:Limpiamos la tabla antes de mostrar nada
                ventanaPrograma.limpiarDatosTabla();
                //2: Abrimos la conexion
                conn = Conexion.obtenerConexion();
                //3: Obtemos el producto para eliminar
                producto = ventanaPrograma.obtenerProducto();
                //4: Eliminamos el producto
                productoDAO.eliminarProducto(producto, conn);
                //5: Obtenemos los productos para mostrarlos en la lista
                listaProductos = productoDAO.buscarTodosLosProductos(conn);
                //6: Cargamos la lista de los productos en la tabla
                ventanaPrograma.cargarDatosTabla(listaProductos);
                //7: Cerramos la conexion
                Conexion.cerrarConexion(conn);
            }
            case "BUSCAR" -> {
                //1:Limpiamos la tabla antes de mostrar nada
                ventanaPrograma.limpiarDatosTabla();
                //2: Abrimos la conexion
                conn = Conexion.obtenerConexion();
                //3: Obtenemos el nombre del producto a buscar
                String nombreProducto = ventanaPrograma.obtenerNombreProductoBuscar();
                //4: Buscamos el producto segun el nombre indicado
                listaProductos = productoDAO.buscarPorNombreProducto(nombreProducto, conn);
                //5: Cargamos la lista de los productos en la tabla
                ventanaPrograma.cargarDatosTabla(listaProductos);
                //6: Cerramos la conexion
                Conexion.cerrarConexion(conn);
            }
            default -> throw new AssertionError();
        }
    }
}