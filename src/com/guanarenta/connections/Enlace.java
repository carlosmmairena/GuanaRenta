/**
 * Ver luego cuando se debe cerrar las conexiones
 */
package com.guanarenta.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Carlos Mairena
 */
public abstract class Enlace {
    
    private static Connection conexion = null;

    /**
     * Crear la comunicación con el servicio BD
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static Connection crearEnlace() throws SQLException,ClassNotFoundException {
        if (conexion == null) {
            try {
                // Con esta nueva librería, la clase controladora cambia de ruta, la anterior está obsoleta
                //Class.forName("com.mysql.jdbc.Driver");
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/BD_GuanaRenta", "root", "Lbrtr2m20!");
                System.out.println("Conexión exitosa: "+conexion.getCatalog());
            } catch (SQLException ex) {
                throw new SQLException(ex.getMessage());
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }
        return conexion;
    }

    /**
     * Cerramos la comunicación
     * @throws SQLException 
     */
    public static void cerrar() throws SQLException {
        if (conexion != null) {
            conexion.close();
            System.out.println("Conexión cerrada exitosamente");
        }
    }
}
