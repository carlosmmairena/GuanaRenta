package com.guanarenta.connections;

import com.guanarenta.clases.Vivienda;
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
public class OperacionesVivienda implements OperacionesPrincipales {
    
    /**
     * Elimina la vivienda que coincida con el ID enviado
     * @param conexion
     * @param idVivienda
     * @return
     * @throws SQLException 
     */
    public boolean eliminarVivienda(Connection conexion, int idVivienda) throws SQLException {
        try {
            CallableStatement ps = conexion.prepareCall("{CALL stpEliminarVivienda(?)}");
            ps.setLong(1, idVivienda);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    /**
     * Envía los datos editados de la vivienda
     * @param enlace
     * @param vivienda
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public boolean editarVivienda(Connection enlace, Vivienda vivienda) throws SQLException, ClassNotFoundException {

        try {

            CallableStatement ps = enlace.prepareCall("{CALL stpEditarVivienda(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            ps.setInt(1, (int) vivienda.getIdVivienda());
            ps.setString(2, vivienda.getDescripcion());
            ps.setString(3, vivienda.getDireccion());
            ps.setFloat(4, vivienda.getMtsConstruccion());
            ps.setFloat(5, vivienda.getMtsLote());
            ps.setString(6, vivienda.getTipoConstruccion());
            ps.setBoolean(7, vivienda.getCochera());
            ps.setShort(8, vivienda.getCantHabitac());
            ps.setShort(9, vivienda.getCantBanios());
            ps.setString(10, vivienda.getCarretera());
            ps.setInt(11, vivienda.getPrecioBase()); // Tal vez de error porque recibe un decimal y no un int la BD
            ps.setInt(12, vivienda.getDepositoGarantia()); // Tal vez de error porque recibe un decimal y no un int la BD
            ps.setInt(13, vivienda.getCedPropiet());
            ps.setString(14, vivienda.getEstado());
            
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    /**
     * Guardamos la vivienda recibida por los parámetros
     * @param enlace
     * @param vivienda
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public boolean guardarVivienda(Connection enlace, Vivienda vivienda) throws SQLException, ClassNotFoundException {

        try {

            CallableStatement ps = enlace.prepareCall("{CALL stpGuardarVivienda(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            //ps.setInt(1, (int) vivienda.getIdVivienda()); // La BD la crea
            ps.setString(1, vivienda.getDescripcion());
            ps.setString(2, vivienda.getDireccion());
            ps.setFloat(3, vivienda.getMtsConstruccion());
            ps.setFloat(4, vivienda.getMtsLote());
            ps.setString(5, vivienda.getTipoConstruccion());
            ps.setBoolean(6, vivienda.getCochera());
            ps.setShort(7, vivienda.getCantHabitac());
            ps.setShort(8, vivienda.getCantBanios());
            ps.setString(9, vivienda.getCarretera());
            ps.setInt(10, vivienda.getPrecioBase()); // Tal vez de error porque recibe un decimal y no un int la BD
            ps.setInt(11, vivienda.getDepositoGarantia()); // Tal vez de error porque recibe un decimal y no un int la BD
            ps.setInt(12, vivienda.getCedPropiet());
            ps.setString(13, vivienda.getEstado());
            
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    /**
     * Obtiene todos los datos de la BD y los carga en un ArrayList
     * @param conexion
     * @param tabla
     * @return
     * @throws SQLException 
     */
    private ArrayList<Vivienda> MostrarDatos(Connection conexion, String tabla) throws SQLException {

        ArrayList<Vivienda> vivi = new ArrayList();
        try {
            CallableStatement ps = conexion.prepareCall("{CALL stpMostrarDatos(?)}");
            ps.setString(1, tabla);
            ResultSet rs = ps.executeQuery();

            // Para poder recolectar todos los datos de la BD y agregarlos en el ArrayList
            while (rs.next()) {
                vivi.add(new Vivienda(rs.getInt("idVivienda"), rs.getString("descripcion"), rs.getString("direccion"),
                        rs.getFloat("mtsConstrucc"), rs.getFloat("mtsLote"), rs.getString("tipoConstrucc"),
                        rs.getBoolean("cochera"), rs.getShort("cantHabitac"), rs.getShort("cantBanios"),
                        rs.getString("carretera"), rs.getInt("precioBase"), rs.getInt("deposGarantia"),
                        rs.getInt("cedPropiet"), rs.getString("estado")));
            }

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return vivi;
    }

    /**
     * Método que permite retornar el modelo ya cargado con todos los datos existentes
     *
     * @param conectar
     * @param tabla
     * @param titulo
     * @return
     */
    public DefaultTableModel TodoViviendas(Connection conectar, String tabla, String titulo) {

        String cochera;
        // Deshabilitamos que las celdas se puedan editar
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        try {
            ArrayList<Vivienda> array = this.MostrarDatos(conectar, tabla);
            String[] titulos = {"ID", "Propietario", "Precio Base", "Dep. Garantía", "Estado", "Cochera",
                "Tamaño Vivienda", "Direccion"};
            modelo.setColumnIdentifiers(titulos);

            // En caso de que el título era seleccionar una vivienda, entonces se muestran las disponibles
            if (titulo.equals("Seleccionar")) {
                for (Vivienda vivi : array) {

                    if (vivi.getCochera()) { // Si tiene cochera
                        cochera = "Si";
                    } else {
                        cochera = "No";
                    }
                    // Si el estado de la vivinda es Disponible lo agrega a la fila
                    if ("Disponible".equals(vivi.getEstado())) {
                        Object registro[] = {vivi.getIdVivienda(), vivi.getCedPropiet(), vivi.getPrecioBase(), vivi.getDepositoGarantia(),
                            vivi.getEstado(), cochera, vivi.getMtsConstruccion(), vivi.getDireccion()};

                        modelo.addRow(registro);
                    }
                }
                // Si el título no dice que es para seleccionar, entonces agrega todas
            } else {
                for (Vivienda vivi : array) {

                    if (vivi.getCochera()) { // Si tiene cochera
                        cochera = "Si";
                    } else {
                        cochera = "No";
                    }
                    Object registro[] = {vivi.getIdVivienda(), vivi.getCedPropiet(), vivi.getPrecioBase(), vivi.getDepositoGarantia(),
                        vivi.getEstado(), cochera, vivi.getMtsConstruccion(), vivi.getDireccion()};

                    modelo.addRow(registro);
                }
            }
            return modelo;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    /**
     * Carga el ArrayList con los datos obtenidos al realizar la búsqueda la BD
     * @param conexion
     * @param campo
     * @param datoP
     * @param tabla
     * @return
     * @throws SQLException 
     */
    public ArrayList<Vivienda> FiltroBD(Connection conexion, String campo, String datoP, String tabla) throws SQLException {

        ArrayList<Vivienda> vivi = new ArrayList();
        try {
            CallableStatement ps = conexion.prepareCall("{CALL stpBuscarPrincipal(?,?,?)}");
            ps.setString(1, campo);
            ps.setString(2, datoP);
            ps.setString(3, tabla);
            ResultSet rs = ps.executeQuery();

            // Para poder recolectar todos los datos de la BD y agregarlos en el ArrayList
            while (rs.next()) {
                vivi.add(new Vivienda(rs.getInt("idVivienda"), rs.getString("descripcion"), rs.getString("direccion"),
                        rs.getFloat("mtsConstrucc"), rs.getFloat("mtsLote"), rs.getString("tipoConstrucc"),
                        rs.getBoolean("cochera"), rs.getShort("cantHabitac"), rs.getShort("cantBanios"),
                        rs.getString("carretera"), rs.getInt("precioBase"), rs.getInt("deposGarantia"),
                        rs.getInt("cedPropiet"), rs.getString("estado")));
            }

            return vivi;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

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
            ArrayList<Vivienda> array = this.FiltroBD(conectar, campo, datoP, tabla);

            String[] titulos = {"ID", "Céd. Propiet", "Precio Base", "Dep. Garantía", "Estado",
                "Cochera", "Tam. Vivienda", "Direccion"};
            modelo.setColumnIdentifiers(titulos);

            // Agregamos todos los datos al modelo de la tabla y la retornamos
            // Faltan mostrar datos
            for (Vivienda vivi : array) {

                Object registro[] = {vivi.getIdVivienda(), vivi.getCedPropiet(), vivi.getPrecioBase(), vivi.getDepositoGarantia(),
                    vivi.getEstado(), vivi.getCochera(), vivi.getMtsConstruccion(), vivi.getDireccion()};

                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
