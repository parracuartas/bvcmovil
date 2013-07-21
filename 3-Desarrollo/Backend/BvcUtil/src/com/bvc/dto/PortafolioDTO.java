/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvc.dto;

/**
 *
 * @author HansO
 */
public class PortafolioDTO {

    private String id;
    private String nombre;
    private float saldo;
    private String inversionista;

    public PortafolioDTO() {
    }

    public PortafolioDTO(String id, String nombre, float saldo, String inversionista) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
        this.inversionista = inversionista;
    }

    public String getInversionista() {
        return inversionista;
    }

    public void setInversionista(String inversionista) {
        this.inversionista = inversionista;
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

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
