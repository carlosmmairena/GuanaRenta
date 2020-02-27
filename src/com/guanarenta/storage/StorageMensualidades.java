/*
 * Clase de almacenamiento para las mensualidades de las mensualidades
 */
package com.guanarenta.storage;

import com.guanarenta.clases.Mensualidades;

/**
 *
 * @author Ander Narvaez
 * @author Carlos Mairena
 */
public class StorageMensualidades {

    private Mensualidades MensualidadVect[];
    private byte total;
    private int consecutivo; // RECORDAR DE CAMBIAR ESTA FORMA DE OBTENER O CREAR EL CONSECUTIVO Y LOS DEMÁS CONSECUTIVOS DEL PROGRAMA

    public StorageMensualidades(Mensualidades[] MensualidadVect, byte total) {
        this.MensualidadVect = MensualidadVect;
        this.total = total;
    }

    public StorageMensualidades() {
        this.MensualidadVect = new Mensualidades[100];
        this.total = 0;
        this.consecutivo = 99;

        for (byte i = 0; i < MensualidadVect.length; i++) {

            this.MensualidadVect[i] = null;
        }
    }

    public Mensualidades[] getMensualidadVect() {
        return MensualidadVect;
    }

    public byte getTotal() {
        return total;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public void setMensualidadVect(Mensualidades[] MensualidadVect) {
        this.MensualidadVect = MensualidadVect;
    }

    public void setTotal(byte total) {
        this.total = total;
    }

    /**
     *
     * @param index índice del vector Mensualidades
     * @return Mensualidades retorna el vector con su posición indicada
     */
    public Mensualidades obtenerMensualidad(int index) {
        return this.MensualidadVect[index];
    }

    /**
     * Método que nos ayuda a revisar si le vector tiene espacio
     *
     * @return boolean
     */
    private boolean fullMensualidades() {
        return this.total == this.MensualidadVect.length;
    }

    /**
     * Método que permite guardar un mensualidad
     *
     * @param mensualidad
     * @return boolean
     */
    public boolean GuardarMensualidad(Mensualidades mensualidad) {
        if (!this.fullMensualidades()) {
            this.MensualidadVect[this.total] = mensualidad;
            this.total++;
            return true;
        }
        return false;
    }

    /**
     * Método que permite editar una mensualidad en su respectivo vector
     *
     * @param index
     * @param mensualidad
     */
    public void EditarMensualidad(int index, Mensualidades mensualidad) {
        this.MensualidadVect[index] = new Mensualidades();
        this.MensualidadVect[index] = mensualidad;

    }

    /**
     * Método que nos permite crear un consecutivo nuevo para la mensualidad
     *
     * @return consecutivo
     */
    public int crearConsecutivo() {
        this.consecutivo++;
        return consecutivo;

    }

}
