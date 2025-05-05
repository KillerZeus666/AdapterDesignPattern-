package com.patronespd.fintech.c;

public class FintechCCreditos {
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

    public boolean autorizarCredito() throws Exception {
        // Simula la validación del crédito.
        if (credito <= 1500) {
            return true; // Crédito aprobado
        } else {
            throw new Exception("Crédito no autorizado"); // Lanza una excepción si no se aprueba el crédito
        }
    }
}
