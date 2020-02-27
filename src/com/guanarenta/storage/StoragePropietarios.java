/*
 * Clase controladora del almacenamiento de los vectores de Propietario
 */
package com.guanarenta.storage;

import com.guanarenta.clases.Propietario;

/**
 *
 * @author Ander Narvaez
 * @author Carlos Mairena
 */
public class StoragePropietarios {

    /**
     * total Cantidad de propietarios
     */
    //private ArrayList<Propietario> propiArray;
    private Propietario propiVect[];
    private byte total;

    // Posiblemente este constructor no sea necesario utilizar
    public StoragePropietarios(Propietario[] propiVect, byte total) {
        this.propiVect = propiVect;
        this.total = total;
    }

    public StoragePropietarios() {

        this.total = 0;
        this.propiVect = new Propietario[20];
        //this.propiArray.add(null);

        for (byte i = 0; i < propiVect.length; i++) {
            //this.propiArray.add(null);
            this.propiVect[i] = null;
        }
        //this.propiArray.trimToSize();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(byte total) {
        this.total = total;
    }

    public Propietario[] getPropiVect() {
        return propiVect;
    }

    public void setPropiVect(Propietario[] propiVect) {
        this.propiVect = propiVect;
    }

    /**
     *
     * @param index índice del vector propietarios, se coloca de tipo int para comparar con el valor null
     * @return Propietario retorna el vector con su posición indicada
     */
    public Propietario obtenerPropietario(int index) {
        return this.propiVect[index];
    }

    /**
     *
     * @return boolean retorna si el total de propietarios ya está lleno
     */
    private boolean fullPropietarios() {
        // Talvez este mètodo no sea ya necesario, ya que gracias al ArrayList podemos tener arreglos dinàmicos
        return total == this.propiVect.length;
    }

    /**
     * Método que realiza las operaciones para guardar un propietario
     *
     * @param propietario recibe el objeto de propietario a guardar
     * @return boolean retorna si se guarda o no propietario
     */
    public boolean guardaPropietario(Propietario propietario) {

        if (!this.fullPropietarios()) {
            this.propiVect[this.total] = propietario;
            this.total++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que elimina una posición del vector propietarios
     *
     * @param index índice del vector propietarios a eliminar
     */
    public void borrarPropietario(int index) {

        this.propiVect[index] = new Propietario();

        for (int i = index; i < total; i++) {

            this.propiVect[i] = this.propiVect[i + 1];

        }

        //Anulamos los sobrantes
        for (int i = total; i < propiVect.length; i++) {
            this.propiVect[i] = null;
        }
        //this.propiArray.set(index, null);
        this.total--;
    }

    /**
     * Método que permite editar una posición del vector de propietarios
     *
     * @param index
     * @param propietario
     */
    public void editarPropietario(int index, Propietario propietario) {

        this.propiVect[index] = new Propietario();
        this.propiVect[index] = propietario;
    }

    /**
     * Método que comprueba de que la cédula sea única
     *
     * @param cedula
     * @return
     */
    public boolean comprobarCédula(long cedula) {
        boolean unica = true;

        for (byte i = 0; i < this.total; i++) {

            if (this.propiVect[i].getCedula() == cedula) {
                unica = false;
                break;
            }
        }
        return unica;
    }
}
