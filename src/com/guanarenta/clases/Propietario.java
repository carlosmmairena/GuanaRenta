/*
 * Clase que contiene los atributos y métodos de un propietario
 */
package com.guanarenta.clases;


/**
 * @author Ander Narvaez
 * @author Carlos Mairena
 */
public class Propietario {
    private long cedula;
    private String nombre;
    private char genero;
    private String telefono;
    private String correo;

    public Propietario(long cedula, String nombre, char genero, String telefono, String correro) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.genero = genero;
        this.telefono = telefono;
        this.correo = correro;
    }
    
        public Propietario(){
        this.cedula = 0;
        this.nombre = "";
        this.genero = 'F';
        this.telefono ="";
        this.correo = "";
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorrero() {
        return correo;
    }

    public void setCorrero(String correo) {
        this.correo = correo;
    }
    
}
