/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvc.dto;

import java.util.Date;

/**
 *
 * @author HansO
 */
public class CompraDTO {

    private String compraId;
    private Date fechaInicial;
    private Date fechaFinal;
    private int cantidad;
    private float valorUnidad;
    private float porcentajeComision;
    private float porcentajeImpuestos;
    private float gastos;
    private String observaciones;
    private int estado;
    private String accionId;
    private int portafolioId;

    public CompraDTO() {
    }

    public CompraDTO(String compraId, Date fechaInicial, Date fechaFinal, int cantidad, float valorUnidad, float porcentajeComision, float porcentajeImpuestos, float gastos, String observaciones, int estado, String accionId, int portafolioId) {
        this.compraId = compraId;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.cantidad = cantidad;
        this.valorUnidad = valorUnidad;
        this.porcentajeComision = porcentajeComision;
        this.porcentajeImpuestos = porcentajeImpuestos;
        this.gastos = gastos;
        this.observaciones = observaciones;
        this.estado = estado;
        this.accionId = accionId;
        this.portafolioId = portafolioId;
    }

    public String getCompraId() {
        return compraId;
    }

    public void setCompraId(String compraId) {
        this.compraId = compraId;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getValorUnidad() {
        return valorUnidad;
    }

    public void setValorUnidad(float valorUnidad) {
        this.valorUnidad = valorUnidad;
    }

    public float getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(float porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public float getPorcentajeImpuestos() {
        return porcentajeImpuestos;
    }

    public void setPorcentajeImpuestos(float porcentajeImpuestos) {
        this.porcentajeImpuestos = porcentajeImpuestos;
    }

    public float getGastos() {
        return gastos;
    }

    public void setGastos(float gastos) {
        this.gastos = gastos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getAccionId() {
        return accionId;
    }

    public void setAccionId(String accionId) {
        this.accionId = accionId;
    }

    public int getPortafolioId() {
        return portafolioId;
    }

    public void setPortafolioId(int portafolioId) {
        this.portafolioId = portafolioId;
    }
}
