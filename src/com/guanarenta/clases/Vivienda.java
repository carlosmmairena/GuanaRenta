/*
 * Clase que contiene los atributos y métodos de una Vivienda
 */
package com.guanarenta.clases;

/**
 *
 * @author Ander Narvaez
 * @author Carlos Mairena
 */
public class Vivienda {
    private int idVivienda;
    private String descripcion;
    private String direccion;
    private float mtsConstruccion;
    private float mtsLote;
    private String tipoConstruccion;
    private Boolean cochera;
    private short cantHabitac;
    private float cantBanios;
    private String carretera;
    private int precioBase;
    private int depositoGarantia;
    private Propietario propietario;
    private String estado;
    
    /**
     * Construcor con todos los atributos
     * @param idVivienda
     * @param descripcion
     * @param direccion
     * @param mtsConstruccion
     * @param mtsLote
     * @param tipoConstruccion
     * @param cochera
     * @param cantHabitac
     * @param cantBanios
     * @param carretera
     * @param precioBase
     * @param depositoGarantia
     * @param propietario
     * @param estado 
     */
    public Vivienda(int idVivienda, String descripcion, String direccion, float mtsConstruccion, float mtsLote, String tipoConstruccion, Boolean cochera, short cantHabitac, float cantBanios, String carretera, int precioBase, int depositoGarantia, Propietario propietario, String estado) {
        this.idVivienda = idVivienda;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.mtsConstruccion = mtsConstruccion;
        this.mtsLote = mtsLote;
        this.tipoConstruccion = tipoConstruccion;
        this.cochera = cochera;
        this.cantHabitac = cantHabitac;
        this.cantBanios = cantBanios;
        this.carretera = carretera;
        this.precioBase = precioBase;
        this.depositoGarantia = depositoGarantia;
        this.propietario = propietario;
        this.estado = estado;
    }
    
    /**
     * Constructor vacío
     */
    public Vivienda() {
        this.idVivienda = 99;
        this.descripcion = "";
        this.direccion = "";
        this.mtsConstruccion = 0;
        this.mtsLote = 0;
        this.tipoConstruccion = "Baldozas";
        this.cochera = false;
        this.cantHabitac = 2;
        this.cantBanios = 1;
        this.carretera = "";
        this.precioBase = 0;
        this.depositoGarantia = 0;
        this.propietario = null;
        this.estado = "Disponible";
    }

    /**
     * 
     * @return idVivienda | Retorna el id de la vivienda
     */
    public int getIdVivienda() {
        return idVivienda;
    }
    
    /**
     * 
     * @param idVivienda | Recibe el id de la vivienda
     */
    public void setIdVivienda(int idVivienda) {
        this.idVivienda = idVivienda;
    }

    /**
     * 
     * @return descripcion | Retorna la descripción de la vivienda
     */
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getMtsConstruccion() {
        return mtsConstruccion;
    }

    public void setMtsConstruccion(float mtsConstruccion) {
        this.mtsConstruccion = mtsConstruccion;
    }

    public float getMtsLote() {
        return mtsLote;
    }

    public void setMtsLote(float mtsLote) {
        this.mtsLote = mtsLote;
    }

    public String getTipoConstruccion() {
        return tipoConstruccion;
    }

    public void setTipoConstruccion(String tipoConstruccion) {
        this.tipoConstruccion = tipoConstruccion;
    }

    public Boolean getCochera() {
        return cochera;
    }

    public void setCochera(Boolean cochera) {
        this.cochera = cochera;
    }

    public short getCantHabitac() {
        return cantHabitac;
    }

    public void setCantHabitac(short cantHabitac) {
        this.cantHabitac = cantHabitac;
    }

    public float getCantBanios() {
        return cantBanios;
    }

    public void setCantBanios(float cantBaños) {
        this.cantBanios = cantBaños;
    }

    public String getCarretera() {
        return carretera;
    }

    public void setCarretera(String carretera) {
        this.carretera = carretera;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }

    public int getDepositoGarantia() {
        return depositoGarantia;
    }

    public void setDepositoGarantia(int depositoGarantia) {
        this.depositoGarantia = depositoGarantia;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
