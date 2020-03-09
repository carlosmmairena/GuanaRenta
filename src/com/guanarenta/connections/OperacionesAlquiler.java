package com.guanarenta.connections;

import com.guanarenta.clases.Alquileres;
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
public class OperacionesAlquiler implements OperacionesPrincipales {

    /**
     * Implementamos los métodos principales, en este caso para cargar los datos de la base de datos
     *
     * @param conexion
     * @param tabla
     * @return
     * @throws SQLException Tal vez pueda ser privado
     */
    public ArrayList<Alquileres> MostrarDatos(Connection conexion, String tabla) throws SQLException {
        ArrayList<Alquileres> alqui = new ArrayList();
        try {
            CallableStatement ps = conexion.prepareCall("{CALL stpMostrarDatos(?)}");
            ps.setString(1, tabla);
            ResultSet rs = ps.executeQuery();

            // Para poder recolectar todos los datos de la BD y agregarlos en el ArrayList
            while (rs.next()) {
                alqui.add(new Alquileres(rs.getInt("numAlquiler"), rs.getDate("fechContrato"), rs.getByte("cantMeses"),
                        rs.getByte("numAdultos"), rs.getByte("numNinos"), rs.getDouble("deposGarantia"), rs.getDouble("precioAlquiler"),
                        rs.getByte("porcIncremAnual"), rs.getLong("cedInqui"), rs.getInt("idVivienda"), rs.getString("estado")));
            }

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return alqui;
    }

    /**
     * Método que permite retornar el modelo ya cargado con los datos
     *
     * @param conectar
     * @param tabla
     * @return
     */
    public DefaultTableModel TodoAlquileres(Connection conectar, String tabla) {

        // Deshabilitamos que las celdas se puedan editar
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        try {

            ArrayList<Alquileres> array = this.MostrarDatos(conectar, tabla);
            String[] titulos = {"Num. Alquiler", "Fech. Contrato", "Estado", "ID. Vivienda",
                "Cédula Inquilino", "Precio Alquiler", "Dep. Garantía", "Porc. Aumento Anual"};
            modelo.setColumnIdentifiers(titulos);

            for (Alquileres alqui : array) {

                Object registro[] = {alqui.getNumAlquiler(), alqui.getFechContrato(), alqui.getEstado(), alqui.getIdVivienda(),
                    alqui.getCedInquilino(), alqui.getPrecioAlquiler(), alqui.getDepositoGarantia(), alqui.getPorcIncremAnual()};

                modelo.addRow(registro);
            }

            return modelo;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public boolean guardarAlquiler(Connection enlace, Alquileres alquiler) throws SQLException, ClassNotFoundException {

        try {

            CallableStatement ps = enlace.prepareCall("{CALL stpGuardarAlquiler(?,?,?,?,?,?,?,?,?,?)}");
            //ps.setInt(1, alquiler.getNumAlquiler());
            ps.setDate(1, (Date) alquiler.getFechContrato());
            ps.setInt(2, alquiler.getCanMeses());
            ps.setInt(3, alquiler.getNumAdultos());
            ps.setInt(4, alquiler.getNumNinos());
            ps.setDouble(5, alquiler.getDepositoGarantia());
            ps.setDouble(6, alquiler.getPrecioAlquiler());
            ps.setInt(7, alquiler.getPorcIncremAnual());
            ps.setLong(8, alquiler.getCedInquilino());
            ps.setInt(9, alquiler.getIdVivienda());
            ps.setString(10, alquiler.getEstado());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    /**
     * Editamos al alquiler
     *
     * @param enlace
     * @param alquiler
     * @return
     * @throws SQLException
     */
    public boolean editarAlquiler(Connection enlace, Alquileres alquiler) throws SQLException {
        try {

            CallableStatement ps = enlace.prepareCall("{CALL stpEditarAlquiler(?,?,?,?,?,?,?,?,?,?,?)}");
            ps.setInt(1, alquiler.getNumAlquiler());
            ps.setDate(2, (Date) alquiler.getFechContrato());
            ps.setInt(3, alquiler.getCanMeses());
            ps.setInt(4, alquiler.getNumAdultos());
            ps.setInt(5, alquiler.getNumNinos());
            ps.setDouble(6, alquiler.getDepositoGarantia());
            ps.setDouble(7, alquiler.getPrecioAlquiler());
            ps.setInt(8, alquiler.getPorcIncremAnual());
            ps.setLong(9, alquiler.getCedInquilino());
            ps.setInt(10, alquiler.getIdVivienda());
            ps.setString(11, alquiler.getEstado());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    /**
     * Recibimos el ID del alquiler a eliminar
     *
     * @param conexion
     * @param idAlquiler
     * @return
     * @throws SQLException
     */
    public boolean eliminarAlquiler(Connection conexion, int idAlquiler) throws SQLException {
        try {
            CallableStatement ps = conexion.prepareCall("{CALL stpEliminarAlquiler(?)}");
            ps.setInt(1, idAlquiler);
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
    public ArrayList<Alquileres> FiltroBD(Connection conexion, String campo, String datoP, String tabla) throws SQLException {
        ArrayList<Alquileres> alqui = new ArrayList();
        try {
            CallableStatement ps = conexion.prepareCall("{CALL stpBuscarPrincipal(?,?,?)}");
            ps.setString(1, campo);
            ps.setString(2, datoP);
            ps.setString(3, tabla);
            ResultSet rs = ps.executeQuery();

            // Para poder recolectar todos los datos de la BD y agregarlos en el ArrayList
            while (rs.next()) {
               
                alqui.add(new Alquileres(rs.getInt("numAlquiler"), rs.getDate("fechContrato"), rs.getByte("cantMeses"),
                        rs.getByte("numAdultos"), rs.getByte("numNinos"), rs.getInt("deposGarantia"), rs.getInt("precioAlquiler"),
                        rs.getByte("porcIncremAnual"), rs.getLong("cedInqui"), rs.getInt("idVivienda"), rs.getString("estado")));
            }

            return alqui;
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
            ArrayList<Alquileres> array = this.MostrarDatos(conectar, tabla);
            String[] titulos = {"Num. Alquiler", "Fech. Contrato", "Estado", "ID. Vivienda",
                "Cédula Inquilino", "Precio Alquiler", "Dep. Garantía", "Porc. Aumento Anual"};
            modelo.setColumnIdentifiers(titulos);

            for (Alquileres alqui : array) {

                Object registro[] = {alqui.getNumAlquiler(), alqui.getFechContrato(), alqui.getEstado(), alqui.getIdVivienda(),
                    alqui.getCedInquilino(), alqui.getPrecioAlquiler(), alqui.getDepositoGarantia(), alqui.getPorcIncremAnual()};

                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

}
