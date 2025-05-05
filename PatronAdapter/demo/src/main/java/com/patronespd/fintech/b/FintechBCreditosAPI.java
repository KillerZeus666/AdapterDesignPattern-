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
public class FintechBCreditosAPI {
    
     public FintechBRespuestaCredito sendCreditRequest(FintechBSolicitudCredito request){
        FintechBRespuestaCredito response =new FintechBRespuestaCredito();
        if(request.getValorSolicitado()<= 5000){
            response.setResultadoAprobacion(true);
        }else{
            response.setResultadoAprobacion(false);
        }
        return response;
    }
}