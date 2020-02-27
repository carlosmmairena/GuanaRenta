/*
 * Clase controladora del almacenamiento de los vectores de Vivienda
 */
package com.guanarenta.storage;

import com.guanarenta.clases.Vivienda;

/**
 *
 * @author Ander Narvaez
 * @author Carlos Mairena
 */
public class StorageViviendas {

    private Vivienda viviVect[];
    private byte total;
    private int idVivienda; // RECORDAR DE CAMBIAR ESTA FORMA DE OBTENER O CREAR EL CONSECUTIVO Y LOS DEMÁS CONSECUTIVOS DEL PROGRAMA

    // Posiblemente este constructor no sea necesario utilizar
    public StorageViviendas(Vivienda viviVect[], byte total) {
        this.viviVect = viviVect;
        this.total = total;
        this.idVivienda = 99;

    }

    public StorageViviendas() {
        this.total = 0;
        this.viviVect = new Vivienda[20];
        this.idVivienda = 99;

        for (byte i = 0; i < viviVect.length; i++) {
            this.viviVect[i] = null;
        }
    }

    public int getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(int idVivienda) {
        this.idVivienda = idVivienda;
    }

    public Vivienda[] getViviArray() {
        return viviVect;
    }

    public void setViviVect(Vivienda viviVect[]) {
        this.viviVect = viviVect;
    }

    public byte getTotal() {
        return total;
    }

    public void setTotal(byte total) {
        this.total = total;
    }

    /**
     *
     * @param index índice del vector propietarios, se coloca de tipo int para comparar con el valor null
     * @return Vivienda retorna el vector con su posición indicada
     */
    public Vivienda obtenerVivienda(int index) {
        // en este método deberìamos validar el ìndice de que no sea mayor al total
        return this.viviVect[index];
    }

    /**
     *
     * @return boolean retorna si el total de viviendas ya está lleno
     */
    public boolean fullViviendas() {
        // Talvez este mètodo no sea ya necesario, ya que gracias al ArrayList podemos tener arreglos dinàmicos
        return total == this.viviVect.length;
    }

    /**
     * Método que realiza las operaciones para guardar una vivienda
     *
     * @param vivienda recibe el objeto de tipo vivienda
     * @return boolean retorna si se guarda o no vivienda
     */
    public boolean guardaVivienda(Vivienda vivienda) {

        if (!this.fullViviendas()) {
            this.viviVect[total] = vivienda;
            this.total++;
            return true;
        } else {
            return false;
        }

    }

    /**
     * Método que elimina una posición del vector viviArray
     *
     * @param index índice del vector viviArray a eliminar
     */
    public void borrarVivienda(int index) {

        if (index < this.total) {
            this.viviVect[index] = new Vivienda();

            for (int i = index; i < total; i++) {

                this.viviVect[i] = this.viviVect[i + 1];

            }

            for (int i = total; i < viviVect.length; i++) {
                this.viviVect[i] = null;
            }

            this.total--;
        }
    }

    /**
     * Método que comprueba el IdVivienda
     *
     * @return Corresponde al valor del ID consecutivo de la vivienda
     */
    public int crearIdVivienda() {
        this.idVivienda++;
        return idVivienda;

    }

    /**
     * Método que permite editar una posición del vector de viviendas
     *
     * @param index
     * @param vivienda
     */
    public void editarVivienda(int index, Vivienda vivienda) {

        this.viviVect[index] = new Vivienda();
        this.viviVect[index] = vivienda;

    }

}
