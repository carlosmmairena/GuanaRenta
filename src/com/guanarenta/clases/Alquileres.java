/*
 * Clase que contiene los atributos y métodos de un alquiler
 */
package com.guanarenta.clases;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author Ander Narvaez
 * @author Carlos Mairena
 */
public class Alquileres {

    private int numAlquiler;
    private Date fechContrato;
    private byte canMeses;
    private byte numAdultos;
    private byte numNinos;
    private int depositoGarantia;
    private int precioAlquiler;
    private byte porcIncremAnual;
    private long cedInquilino;
    private int idVivienda;
    private String estado;

    public Alquileres(int numAlquiler, Date fechContrato, byte cantMeses, byte numAdultos, byte numNinos, int depositoGarantia, int precioAlquiler, byte porcIncremAnual, long cedInquilino, int idVivienda, String estado) {
        this.numAlquiler = numAlquiler;
        this.fechContrato = fechContrato;
        this.canMeses = cantMeses;
        this.numAdultos = numAdultos;
        this.numNinos = numNinos;
        this.depositoGarantia = depositoGarantia;
        this.precioAlquiler = precioAlquiler;
        this.porcIncremAnual = porcIncremAnual;
        this.cedInquilino = cedInquilino;
        this.idVivienda = idVivienda;
        this.estado = estado;
    }

    public Alquileres() {
        this.numAlquiler = 100;
        this.fechContrato = Date.from(Instant.now());
        this.canMeses = 1;
        this.numAdultos = 2;
        this.numNinos = 2;
        this.depositoGarantia = 0;
        this.precioAlquiler = 0;
        this.porcIncremAnual = 0;
        this.cedInquilino = 0;
        this.idVivienda = 100;
        this.estado = "Vigente";
    }

    public byte getCanMeses() {
        return canMeses;
    }

    public void setCanMeses(byte canMeses) {
        this.canMeses = canMeses;
    }

    public int getNumAlquiler() {
        return numAlquiler;
    }

    public void setNumAlquiler(int numAlquiler) {
        this.numAlquiler = numAlquiler;
    }

    public Date getFechContrato() {
        return fechContrato;
    }

    public void setFechContrato(Date fechContrato) {
        this.fechContrato = fechContrato;
    }

    public byte getNumAdultos() {
        return numAdultos;
    }

    public void setNumAdultos(byte numAdultos) {
        this.numAdultos = numAdultos;
    }

    public byte getNumNinos() {
        return numNinos;
    }

    public void setNumNinos(byte numNinos) {
        this.numNinos = numNinos;
    }

    public int getDepositoGarantia() {
        return depositoGarantia;
    }

    public void setDepositoGarantia(int depositoGarantia) {
        this.depositoGarantia = depositoGarantia;
    }

    public int getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(int precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public byte getPorcIncremAnual() {
        return porcIncremAnual;
    }

    public void setPorcIncremAnual(byte porcIncremAnual) {
        this.porcIncremAnual = porcIncremAnual;
    }

    public long getCedInquilino() {
        return cedInquilino;
    }

    public void setCedInquilino(long cedInquilino) {
        this.cedInquilino = cedInquilino;
    }

    public int getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(int idVivienda) {
        this.idVivienda = idVivienda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
