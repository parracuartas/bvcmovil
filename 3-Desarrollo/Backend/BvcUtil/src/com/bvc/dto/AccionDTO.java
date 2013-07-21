/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvc.dto;

/**
 *
 * @author HansO
 */
public class AccionDTO {

    private String id;
    private String nombre;
    private float valorActual;
    private int cantidadCirculacion;

    public AccionDTO() {
    }

    public AccionDTO(String id, String nombre, float valorActual, int cantidadCirculacion) {
        this.id = id;
        this.nombre = nombre;
        this.valorActual = valorActual;
        this.cantidadCirculacion = cantidadCirculacion;
    }

    public int getCantidadCirculacion() {
        return cantidadCirculacion;
    }

    public void setCantidadCirculacion(int cantidadCirculacion) {
        this.cantidadCirculacion = cantidadCirculacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getValorActual() {
        return valorActual;
    }

    public void setValorActual(float valorActual) {
        this.valorActual = valorActual;
    }
}
