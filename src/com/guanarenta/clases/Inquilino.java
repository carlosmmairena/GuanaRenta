/*
 * Clase que contiene los atributos y métodos de un inquilino
 */
package com.guanarenta.clases;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author Ander Narvaez
 * @author Carlos Mairena
 */
public class Inquilino {
    
    private long cedInqui;
    private String nomInqui;
    private char genero;
    private Date fechNac;
    private String direccion;
    private String telefono;
    private String email;
    private String ocupacion;

    /**
     * Constructor con todos los atributos
     * @param cedInqui
     * @param nomInqui
     * @param genero
     * @param fechNac
     * @param direccion
     * @param telefono
     * @param email
     * @param ocupacion 
     */
    public Inquilino(long cedInqui, String nomInqui, char genero, Date fechNac, String direccion, String telefono, String email, String ocupacion) {
        this.cedInqui = cedInqui;
        this.nomInqui = nomInqui;
        this.genero = genero;
        this.fechNac = fechNac;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.ocupacion = ocupacion;
    }
    
    /**
     * Constructor vacío
     */
    public Inquilino() {
        this.cedInqui = 0;
        this.nomInqui = "";
        this.genero = 'F';
        this.fechNac = Date.from(Instant.now());
        this.direccion = "";
        this.telefono = "";
        this.email = "";
        this.ocupacion = "";
    }

    public long getCedInqui() {
        return cedInqui;
    }

    public void setCedInqui(long cedInqui) {
        this.cedInqui = cedInqui;
    }

    public String getNomInqui() {
        return nomInqui;
    }

    public void setNomInqui(String nomInqui) {
        this.nomInqui = nomInqui;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public Date getFechNac() {
        return fechNac;
    }

    public void setFechNac(Date fechNac) {
        this.fechNac = fechNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    
}
