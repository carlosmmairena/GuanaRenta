package com.guanarenta.connections;

import com.guanarenta.clases.Inquilino;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Mairena
 */
public class OperacionesInquilino implements OperacionesPrincipales {

    // Tal vez este método no hace falta, está integrada un query en los insert, tal vez podamos separarlas
    public int ExisteUsuario(Connection enlace, long IdUsuario, String tipoUsuario) throws SQLException {

        try {
            CallableStatement ps = enlace.prepareCall("{CALL stpExisteUsuario(?,?)}");
            ps.setLong(1, IdUsuario);
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
     * @throws SQLException Tal vez pueda ser privado
     */
    public ArrayList<Inquilino> MostrarDatos(Connection conexion, String tabla) throws SQLException {

        ArrayList<Inquilino> inqui = new ArrayList();
        try {
            CallableStatement ps = conexion.prepareCall("{CALL stpMostrarDatos(?)}");
            ps.setString(1, tabla);
            ResultSet rs = ps.executeQuery();

            // Para poder recolectar todos los datos de la BD y agregarlos en el ArrayList
            while (rs.next()) {
                inqui.add(new Inquilino(rs.getLong("cedInqui"), rs.getString("nomInqui"),
                        rs.getString("genero").charAt(0), rs.getDate("fechNac"), rs.getString("direccion"),
                        rs.getInt("telefono"), rs.getString("email"), rs.getString("ocupacion")));
            }

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return inqui;
    }

    /**
     * Método que permite retornar el modelo ya cargado con los datos
     *
     * @param conectar
     * @param tabla
     * @return
     */
    public DefaultTableModel TodoInquilinos(Connection conectar, String tabla) {

        // Deshabilitamos que las celdas se puedan editar
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        try {
            ArrayList<Inquilino> array = this.MostrarDatos(conectar, tabla);
            String[] titulos = {"Nombre", "Cédula", "Género", "E-mail", "Teléfono",
                "Ocupación", "Fecha Nacimiento"};
            modelo.setColumnIdentifiers(titulos);

            for (Inquilino inqui : array) {

                Object registro[] = {inqui.getNomInqui(), inqui.getCedInqui(), inqui.getGenero(), inqui.getEmail(),
                    inqui.getTelefono(), inqui.getOcupacion(), inqui.getFechNac()};

                modelo.addRow(registro);
            }

            return modelo;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public boolean guardarInquilino(Connection enlace, Inquilino inquilino) throws SQLException, ClassNotFoundException {

        try {

            CallableStatement ps = enlace.prepareCall("{CALL stpGuardarInquilino(?,?,?,?,?,?,?,?)}");
            ps.setLong(1, inquilino.getCedInqui());
            ps.setString(2, inquilino.getNomInqui());
            ps.setString(3, String.valueOf(inquilino.getGenero()));
            ps.setDate(4, (Date) inquilino.getFechNac());
            ps.setString(5, inquilino.getDireccion());
            ps.setInt(5, inquilino.getTelefono());
            ps.setString(6, inquilino.getEmail());
            ps.setString(7, inquilino.getOcupacion());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    /**
     * Editamos al inquilino con los datos enviados
     *
     * @param enlace
     * @param inquilino
     * @return
     * @throws SQLException
     */
    public boolean editarPropietario(Connection enlace, Inquilino inquilino) throws SQLException {
        try {

            CallableStatement ps = enlace.prepareCall("{CALL stpEditarInquilino(?,?,?,?,?,?,?,?)}");
            ps.setLong(1, inquilino.getCedInqui());
            ps.setString(2, inquilino.getNomInqui());
            ps.setString(3, String.valueOf(inquilino.getGenero()));
            ps.setDate(4, (Date) inquilino.getFechNac());
            ps.setString(5, inquilino.getDireccion());
            ps.setInt(5, inquilino.getTelefono());
            ps.setString(6, inquilino.getEmail());
            ps.setString(7, inquilino.getOcupacion());
            
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
     * @param cedInqui
     * @return
     * @throws SQLException
     */
    public boolean eliminarInquilino(Connection conexion, int cedInqui) throws SQLException {
        try {
            CallableStatement ps = conexion.prepareCall("{CALL stpEliminarInquilino(?)}");
            ps.setLong(1, cedInqui);
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
    public ArrayList<Inquilino> FiltroBD(Connection conexion, String campo, String datoP, String tabla) throws SQLException {
        ArrayList<Inquilino> inqui = new ArrayList();
        try {
            CallableStatement ps = conexion.prepareCall("{CALL stpBuscarPrincipal(?,?,?)}");
            ps.setString(1, campo);
            ps.setString(2, datoP);
            ps.setString(3, tabla);
            ResultSet rs = ps.executeQuery();

            // Para poder recolectar todos los datos de la BD y agregarlos en el ArrayList
            while (rs.next()) {
                inqui.add(new Inquilino(rs.getLong("cedInqui"), rs.getString("nomInqui"),
                        rs.getString("genero").charAt(0), rs.getDate("fechNac"), rs.getString("direccion"),
                        rs.getInt("telefono"), rs.getString("email"), rs.getString("ocupacion")));
            }

            return inqui;
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
            ArrayList<Inquilino> array = this.FiltroBD(conectar, campo, datoP, tabla);
            String[] titulos = {"Nombre", "Cédula", "Género", "E-mail", "Teléfono",
                "Ocupación", "Fecha Nacimiento"};
            modelo.setColumnIdentifiers(titulos);

            // Agregamos todos los datos al modelo de la tabla y la retornamos
            for (Inquilino inqui : array) {
                Object registro[] = {inqui.getNomInqui(), inqui.getCedInqui(), inqui.getGenero(), inqui.getEmail(),
                    inqui.getTelefono(), inqui.getOcupacion(), inqui.getFechNac()};

                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
