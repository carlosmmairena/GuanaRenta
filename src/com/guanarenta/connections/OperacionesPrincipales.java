/**
 * En esta interfaz van todos lo métodos principales
 */
package com.guanarenta.connections;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public interface OperacionesPrincipales { 
   
    /**
     * Abstracto que recibe una conexión y la tabla a buscar
     * @param conexion
     * @param tabla
     * @return
     * @throws SQLException 
     */
//    public abstract ArrayList<Propietario> MostrarDatos(Connection conexion, String tabla) throws SQLException;
    
    /**
     * Abstracto que busca si existe el usuario ingresado
     * @param enlace
     * @param IdUsuario
     * @param tipoUsuario
     * @return
     * @throws SQLException 
     */
//    public abstract int ExisteUsuario(Connection enlace, int IdUsuario, String tipoUsuario) throws SQLException;
    
    /**
     *  Abstracto que obtiene datos desde la BD y los agrega en un ArrayList
     * @param conexion
     * @param campo
     * @param datoP
     * @param tabla
     * @return
     * @throws SQLException 
     */
//    public abstract ArrayList<Object> FiltroBD(Connection conexion, String campo, String datoP, String tabla) throws SQLException;
    
    /**
     * Retorna un modelo cargado de registros que coinciden con el datoP recibido en el campo
     * @param conectar
     * @param campo
     * @param datoP
     * @param tabla
     * @return 
     */
    public abstract DefaultTableModel BuscarFiltrado(Connection conectar, String campo, String datoP, String tabla);
    
}
