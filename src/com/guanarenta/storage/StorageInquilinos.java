/*
 * Clase controladora del almacenamiento de los vectores de Inquilinos
 */
package com.guanarenta.storage;

import com.guanarenta.clases.Inquilino;

/**
 *
 * @author Ander Narvaez
 * @author Carlos Mairena
 */
public class StorageInquilinos {

    private Inquilino inquiVect[];
    private byte total;

    public StorageInquilinos(Inquilino[] inquiVect, byte total) {
        this.inquiVect = inquiVect;
        this.total = total;
    }

    public StorageInquilinos() {
        this.inquiVect = new Inquilino[20];
        this.total = 0;

        for (byte i = 0; i < inquiVect.length; i++) {
            this.inquiVect[i] = null;
        }

    }

    public Inquilino[] getInquiVect() {
        return inquiVect;
    }

    public void setInquiVect(Inquilino[] inquiVect) {
        this.inquiVect = inquiVect;
    }

    public byte getTotal() {
        return total;
    }

    public void setTotal(byte total) {
        this.total = total;
    }

    /**
     *
     * @param index índice del vector inquilinos
     * @return Inquilino retorna el vector con su posición indicada
     */
    public Inquilino obtenerInquilino(int index) {
        return this.inquiVect[index];
    }
    
    /**
     *
     * @return boolean retorna si el total de inquilinos ya está lleno
     */
    public boolean fullInquilinos() {
        // Talvez este mètodo no sea ya necesario, ya que gracias al ArrayList podemos tener arreglos dinàmicos
        return total == this.inquiVect.length;
    }

    /**
     * Método que realiza las operaciones para guardar un propietario
     *
     * @param inquilino corresponde al objeto que se desea guardar en el vector
     * @return boolean retorna si se guarda o no propietario
     */
    public boolean guardaInquilino(Inquilino inquilino) {

        if (!this.fullInquilinos()) {
            this.inquiVect[this.total] = inquilino;
            //System.out.println("Propietarios " + (this.propiArray.size()-1));
            this.total++;
            //this.propiArray.trimToSize();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que elimina una posición del vector inquilinos
     *
     * @param index índice del vector propietarios a eliminar
     */
    public void borrarInquilino(int index) {
        // Se debe revisar este método
        // Este mètodo deberìa mover cada posiciòn hacia arriba y eliminar la última que sobra
        if (index < this.total) {
            this.inquiVect[index] = new Inquilino();

            for (int i = index; i < total; i++) {

                this.inquiVect[i] = this.inquiVect[i + 1];

            }

            //Anulamos los sobrantes
            for (int i = total; i < inquiVect.length; i++) {
                this.inquiVect[i] = null;
            }

            //this.propiArray.set(index, null);
            this.total--;
        }
    }

    /**
     * Método que permite editar una posición del vector de inquilinos
     *
     * @param index
     * @param inquilino
     */
    public void editarInquilino(int index, Inquilino inquilino) {

        this.inquiVect[index] = new Inquilino();
        this.inquiVect[index] = inquilino;

    }

    /**
     * Método que comprueba de que la cédula sea única
     *
     * @param cedula
     * @return boolean
     */
    public boolean comprobarCedula(long cedula) {

        boolean unica = true;

        for (byte i = 0; i < this.total; i++) {

            if (this.inquiVect[i].getCedInqui() == cedula) {
                unica = false;
                break;

            }

        }

        return unica;

    }

}
