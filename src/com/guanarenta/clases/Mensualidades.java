/*
 * Clase que contiene los atributos y métodos de las mensualidades
 */
package com.guanarenta.clases;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author Ander Narvaez
 * @author Carlos Mairena
 */
public class Mensualidades {

    private int consecutivo;
    // numAlquiler, este atributo ya está en la clase Alquileres
    private int numAlquiler;
    private Date fechCreacion;
    // nomInqui, este atributo ya está en la clase Inquilinos
    private String nomInqui;
    private int mesCobro;
    private short anioActual;
    private int descuento;
    private float montoMes;
    private String estado;

    /**
     * Constructor con todos los atributos
     *
     * @param consecutivo
     * @param numAlquiler
     * @param fechCreacion
     * @param nomInqui
     * @param mesCobro
     * @param anioActual
     * @param descuento
     * @param montoMes
     * @param estado
     */
    public Mensualidades(int consecutivo, int numAlquiler, Date fechCreacion, String nomInqui, int mesCobro,
            short anioActual, int descuento, float montoMes, String estado) {
        
        this.consecutivo = consecutivo;
        this.numAlquiler = numAlquiler;
        this.fechCreacion = fechCreacion;
        this.nomInqui = nomInqui;
        this.mesCobro = mesCobro;
        this.anioActual = anioActual;
        this.descuento = descuento;
        this.montoMes = montoMes;
        this.estado = estado;
    }

    /**
     * Constructor vacío
     */
    public Mensualidades() {
        this.consecutivo = 99;
        this.numAlquiler = 99;
        this.fechCreacion = Date.from(Instant.now());
        this.nomInqui = "";
        this.mesCobro = 1;
        this.anioActual = 2020;
        this.descuento = 0;
        this.montoMes = 100000;
        this.estado = "Pendiente";
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public int getNumAlquiler() {
        return numAlquiler;
    }

    public void setNumAlquiler(int numAlquiler) {
        this.numAlquiler = numAlquiler;
    }

    public Date getFechCreacion() {
        return fechCreacion;
    }

    public void setFechCreacion(Date fechCreacion) {
        this.fechCreacion = fechCreacion;
    }

    public String getNomInqui() {
        return nomInqui;
    }

    public void setNomInqui(String nomInqui) {
        this.nomInqui = nomInqui;
    }

    public int getMesCobro() {
        return mesCobro;
    }

    public void setMesCobro(int mesCobro) {
        this.mesCobro = mesCobro;
    }

    public short getAnioActual() {
        return anioActual;
    }

    public void setAnioActual(short anioActual) {
        this.anioActual = anioActual;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public float getMontoMes() {
        return montoMes;
    }

    public void setMontoMes(float montoMes) {
        this.montoMes = montoMes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
