package com.guanarenta.connections;

import com.guanarenta.clases.Propietario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Mairena
 */
public class OperacionesPropietario implements OperacionesPrincipales {

    // Tal vez este método no hace falta, está integrada un query en los insert, tal vez podamos separarlas
    public int ExisteUsuario(Connection enlace, int IdUsuario, String tipoUsuario) throws SQLException {

        try {
            CallableStatement ps = enlace.prepareCall("{CALL stpExisteUsuario(?,?)}");
            ps.setInt(1, IdUsuario);
            ps.setString(2, tipoUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 1;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return 1;
        }
    }

    /**
     * Implementamos los métodos principales, en este caso para cargar los datos de la base de datos
     *
     * @param conexion
     * @param tabla
     * @return
     * @throws SQLException
     * Tal vez pueda ser privado
     */
    public ArrayList<Propietario> MostrarDatos(Connection conexion, String tabla) throws SQLException {
        ArrayList<Propietario> propi = new ArrayList();
        try {
            CallableStatement ps = conexion.prepareCall("{CALL stpMostrarDatos(?)}");
            ps.setString(1, tabla);
            ResultSet rs = ps.executeQuery();

            // Para poder recolectar todos los datos de la BD y agregarlos en el ArrayList
            while (rs.next()) {
                propi.add(new Propietario(rs.getLong("cedPropiet"), rs.getString("nomPropiet"),
                        rs.getString("genero").charAt(0), rs.getInt("telefono"), rs.getString("email"),
                        rs.getString("direccion")));
            }

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return propi;
    }

    /**
     * Método que permite retornar el modelo ya cargado con los datos
     *
     * @param conectar
     * @param tabla
     * @return
     */
    public DefaultTableModel TodoPropietarios(Connection conectar, String tabla) {

        // Deshabilitamos que las celdas se puedan editar
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        try {

            ArrayList<Propietario> array = this.MostrarDatos(conectar, tabla);
            String[] titulos = {"Nombre", "Cédula", "Género", "E-mail", "Teléfono", "Dirección"};
            modelo.setColumnIdentifiers(titulos);

            for (Propietario propi : array) {

                Object registro[] = {propi.getNombre(), propi.getCedula(), propi.getGenero(), propi.getCorreo(),
                    propi.getTelefono(), propi.getDireccion()};

                modelo.addRow(registro);
            }

            return modelo;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public boolean guardarPropietario(Connection enlace, Propietario propietario) throws SQLException, ClassNotFoundException {

        try {

            CallableStatement ps = enlace.prepareCall("{CALL stpGuardarPropietario(?,?,?,?,?,?)}");
            ps.setInt(1, (int) propietario.getCedula());
            ps.setString(2, propietario.getNombre());
            ps.setString(3, String.valueOf(propietario.getGenero())); // es un tipo char, pero recibe String
            ps.setString(4, propietario.getDireccion());
            ps.setInt(5, propietario.getTelefono());
            ps.setString(6, propietario.getCorreo()); // es el email
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    /**
     * Editamos al propietario
     *
     * @param enlace
     * @param propietario
     * @return
     * @throws SQLException
     */
    public boolean editarPropietario(Connection enlace, Propietario propietario) throws SQLException {
        try {

            CallableStatement ps = enlace.prepareCall("{CALL stpEditarPropietario(?,?,?,?,?,?)}");
            ps.setLong(1, propietario.getCedula());
            ps.setString(2, propietario.getNombre());
            ps.setString(3, String.valueOf(propietario.getGenero())); // es un tipo char, pero recibe String
            ps.setString(4, propietario.getDireccion());
            ps.setInt(5, propietario.getTelefono());
            ps.setString(6, propietario.getCorreo()); // es el email
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    /**
     * Recibimos la cédula del propietario a eliminar
     *
     * @param conexion
     * @param cedula
     * @return
     * @throws SQLException
     */
    public boolean eliminarPropietario(Connection conexion, int cedula) throws SQLException {
        try {
            CallableStatement ps = conexion.prepareCall("{CALL stpEliminarPropietario(?)}");
            ps.setLong(1, cedula);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    /**
     * Retorna la lista de los registros que coinciden con datosP
     *
     * @param conexion
     * @param datoP Dato a buscar
     * @param campo Campo seleccionado
     * @param tabla
     * @return
     * @throws SQLException
     */
    public ArrayList<Propietario> FiltroBD(Connection conexion, String campo, String datoP, String tabla) throws SQLException {
        ArrayList<Propietario> propi = new ArrayList();
        try {
            CallableStatement ps = conexion.prepareCall("{CALL stpBuscarPrincipal(?,?,?)}");
            ps.setString(1, campo);
            ps.setString(2, datoP);
            ps.setString(3, tabla);
            ResultSet rs = ps.executeQuery();
            
            // Para poder recolectar todos los datos de la BD y agregarlos en el ArrayList
            while (rs.next()) {
                propi.add(new Propietario(rs.getLong("cedPropiet"), rs.getString("nomPropiet"),
                        rs.getString("genero").charAt(0), rs.getInt("telefono"), rs.getString("email"),
                        rs.getString("direccion")));
            }
            
            return propi;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    /**
     * Método llamado en la GUI, que recibe el campo a buscar, el datos y la tabla
     *
     * @param conectar
     * @param datoP Dato a buscar recibido desde la GUI
     * @param campo Campo seleccionado desde la GUI
     * @param tabla Tabla de la BD en que buscará los datos
     * @return
     */
    @Override
    public DefaultTableModel BuscarFiltrado(Connection conectar, String campo, String datoP, String tabla) {
        
        // Deshabilitamos que las celdas se puedan editar
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        
        try {
            // Recibimos el ArrayList ya con los datos cargado
            ArrayList<Propietario> array = this.FiltroBD(conectar, campo, datoP, tabla);
            
            String[] titulos = {"Nombre", "Cédula", "Género", "E-mail", "Teléfono", "Dirección"};
            modelo.setColumnIdentifiers(titulos);

            // Agregamos todos los datos al modelo de la tabla y la retornamos
            for (Propietario propi : array) {

                Object registro[] = {propi.getNombre(), propi.getCedula(), propi.getGenero(), propi.getCorreo(),
                    propi.getTelefono(), propi.getDireccion()};

                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
