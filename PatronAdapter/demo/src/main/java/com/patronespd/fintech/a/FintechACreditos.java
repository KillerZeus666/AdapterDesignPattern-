/*
 * Asignatura: Patrones de Diseño de Software 
 * Patrón Estructural - > Adapter
 * Tipo de Clase: Java
 */
package com.patronespd.fintech.a;

/**
 *
 * @author Fabrizio Bolaño
 */
public class FintechACreditos {
    public String nombre;
    public float credito;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCredito() {
        return credito;
    }

    public void setCredito(float credito) {
        this.credito = credito;
    }
}