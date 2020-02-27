/*
 * Clase controladora del almacenamiento de los vectores de alquileres
 */
package com.guanarenta.storage;

import com.guanarenta.clases.Alquileres;

/**
 *
 * @author Ander Narvaez
 * @author Carlos Mairena
 */
public class StorageAlquileres {

    private Alquileres alquiVect[];
    private int total;
    private int numAlquiler; // RECORDAR DE CAMBIAR ESTA FORMA DE OBTENER O CREAR EL CONSECUTIVO Y LOS DEMÁS CONSECUTIVOS DEL PROGRAMA

    public StorageAlquileres(Alquileres[] alquiVect, int total) {
        this.alquiVect = alquiVect;
        this.total = total;
    }

    public StorageAlquileres() {
        this.alquiVect = new Alquileres[20];
        this.total = 0;
        this.numAlquiler = 99;

        for (int i = 0; i < alquiVect.length; i++) {
            alquiVect[i] = null;
        }
    }

    public int getNumAlquiler() {
        return numAlquiler;
    }

    public void setNumAlquiler(int numAlquiler) {
        this.numAlquiler = numAlquiler;
    }

    public Alquileres[] getAlquiVect() {
        return alquiVect;
    }

    public void setAlquiVect(Alquileres[] alquiVect) {
        this.alquiVect = alquiVect;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    /**
     *
     * @param index índice del vector alquileres
     * @return Alquileres retorna el vector con su posición indicada
     */
    public Alquileres obtenerAlquiler(int index) {
        return this.alquiVect[index];
    }

    /**
     * Método que nos ayuda a revisar si le vector tiene espacio
     *
     * @return boolean
     */
    private boolean fullAlquiler() {
        return this.total == this.alquiVect.length;
    }

    /**
     * Método que permite guardar un alquiler
     *
     * @param alquiler
     * @return boolean
     */
    public boolean GuardarAlquiler(Alquileres alquiler) {
        if (!this.fullAlquiler()) {
            this.alquiVect[this.total] = alquiler;
            this.total++;
            return true;
        }
        return false;
    }

    /**
     * Método que permite editar un alquiler del vector de alquileres
     *
     * @param index
     * @param alquiler
     */
    public void EditarAlquiler(int index, Alquileres alquiler) {
        this.alquiVect[index] = new Alquileres();
        this.alquiVect[index] = alquiler;

    }

    /**
     * Método que permite borrar una posición del alquiler
     *
     * @param indice
     */
    public void BorrarAlquiler(int indice) {

        if (indice < this.total) {

            this.alquiVect[indice] = new Alquileres();

            for (int i = indice; i < total; i++) {

                this.alquiVect[i] = this.alquiVect[i + 1];
            }

            //Anulamos los sobrantes
            for (int i = total; i < alquiVect.length; i++) {
                this.alquiVect[i] = null;
            }

            this.total--;
        }

    }

    /**
     * Método que nos permite crear un número de alquiler.
     *
     * @return numAlquiler
     */
    public int crearNum() {
        this.numAlquiler++;
        return this.numAlquiler;
    }

    /**
     * Método que permite verificar si los alquileres registrados tienen más meses de lo indicado en el momento de registrar
     */
//    public void verificaFecha() {
//
//        for (int i = 0; i < total; i++) {
//            int meses = alquiVect[i].getFechContrato().compareTo(new Date());
//
//            if (meses > alquiVect[i].getCanMeses()) {
//
//                System.out.println("Esta mensualidad se ha pasado de la cantidad de meses.");
//                alquiVect[i].setEstado("Cancelado");
//
//            }
//        }
//    }

}
