/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmatch.modelo;

/**
 *
 * @author JOSE HUAVIL
 */
public class ProyectoDTO {
    private String id_proyecto;
    private Cliente cliente;
    private String titulo;
    private String descri;
    private String f_publi;
    private String f_limi;
    private double presupuesto;

    public ProyectoDTO() {
    }

    public ProyectoDTO(String id_proyecto, Cliente cliente, String titulo, String descri, String f_publi, String f_limi, double presupuesto) {
        this.id_proyecto = id_proyecto;
        this.cliente = cliente;
        this.titulo = titulo;
        this.descri = descri;
        this.f_publi = f_publi;
        this.f_limi = f_limi;
        this.presupuesto = presupuesto;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(String id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public String getF_publi() {
        return f_publi;
    }

    public void setF_publi(String f_publi) {
        this.f_publi = f_publi;
    }

    public String getF_limi() {
        return f_limi;
    }

    public void setF_limi(String f_limi) {
        this.f_limi = f_limi;
    }
    
    
    
}
