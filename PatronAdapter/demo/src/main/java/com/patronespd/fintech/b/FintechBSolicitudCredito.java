
/*
 * Asignatura: Patrones de Diseño de Software 
 * Patrón Estructural - > Adapter
 * Tipo de Clase: Java
 */
package com.patronespd.fintech.b;

/**
 *
 * @author Fabrizio Bolaño
 */
public class FintechBSolicitudCredito {
     private String NombreCliente;
     private double ValorSolicitado;

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public double getValorSolicitado() {
        return ValorSolicitado;
    }

    public void setValorSolicitado(double ValorSolicitado) {
        this.ValorSolicitado = ValorSolicitado;
    }
     
}