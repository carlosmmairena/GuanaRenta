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
    private int telefono;
    private String correo;
    private String direccion;

    public Propietario(long cedula, String nombre, char genero, int telefono, String correro, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.genero = genero;
        this.telefono = telefono;
        this.correo = correro;
        this.direccion = direccion;
    }

    public Propietario() {
        this.cedula = 0;
        this.nombre = "";
        this.genero = 'F';
        this.telefono = 0;
        this.correo = "";
        this.direccion = "";
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
