package com.patronespd.fintech.c;

public class FintechCRecepcionCredito {

    // Método ya existente
    public boolean procesarCredito(FintechCCreditos request) {
        try {
            System.out.println("La Fintech C está procesando su solicitud de crédito.");
            return request.autorizarCredito(); // Llamada síncrona al método que autoriza el crédito
        } catch (Exception e) {
            System.out.println(e.getMessage()); // En caso de excepción, la impresión del mensaje de error
            return false;
        }
    }

    // Nuevo método sendCreditForValidate
    public void sendCreditForValidate(FintechCCreditos request, IntFintechCRecepcionCredito listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("La Fintech C está procesando su solicitud de crédito.");

                // Procesamiento del crédito
                FintechCResultadoAprobacion response = new FintechCResultadoAprobacion();

                // Aquí se podría añadir la lógica de validación del crédito
                if (request.getCredito() <= 1500) {
                    response.setAprobado("Y");
                } else {
                    response.setAprobado("N");
                }

                // Notificar el resultado
                listener.NotificacionResultado(response);
            }
        }).start();
    }
}
