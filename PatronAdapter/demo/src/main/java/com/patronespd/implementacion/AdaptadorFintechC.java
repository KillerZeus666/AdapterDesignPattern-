package com.patronespd.implementacion;

import com.patronespd.fintech.c.FintechCCreditos;
import com.patronespd.fintech.c.FintechCRecepcionCredito;
import com.patronespd.fintech.c.FintechCResultadoAprobacion;
import com.patronespd.fintech.c.IntFintechCRecepcionCredito;

public class AdaptadorFintechC implements InterfaceFintechAdaptador, IntFintechCRecepcionCredito {

    private FintechCResultadoAprobacion FCresponse;

    @Override
    public FintechCreditoRespuesta EnvioSolicitudCredito(FintechSolicitudCredito request) {
        // Convertir la solicitud de crédito del cliente a la solicitud de FintechC
        FintechCCreditos FCrequest = new FintechCCreditos();
        FCrequest.setCredito((float) request.getValor()); // Asumiendo que el valor es un float
        FCrequest.setNombre(request.getCliente()); // Establecer el nombre del cliente

        // Enviar la solicitud a FintechC para validación (se procesará de manera asíncrona)
        FintechCRecepcionCredito sender = new FintechCRecepcionCredito();
        sender.sendCreditForValidate(FCrequest, this); // Llamada al nuevo método

        // Esperar a que el resultado sea procesado por FintechC
        while (FCresponse == null) {
            try {
                Thread.sleep(1000); // Espera activa de 1 segundo
                System.out.println("Fintech_C solicitud en espera...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Crear la respuesta del crédito y retornar el resultado
        FintechCreditoRespuesta response = new FintechCreditoRespuesta();
        response.setAprobacion(FCresponse.getAprobado().equals("Y")); // Convertir la respuesta de "Y"/"N" a boolean
        return response;
    }

    @Override
    public void NotificacionResultado(FintechCResultadoAprobacion resultado) {
        // Se asigna la respuesta recibida de FintechC
        this.FCresponse = resultado;
    }
}
