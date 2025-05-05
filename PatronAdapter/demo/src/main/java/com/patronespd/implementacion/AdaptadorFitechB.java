/*
 * Asignatura: Patrones de Diseño de Software 
 * Patrón Estructural - > Adapter
 * Tipo de Clase: Java
 */
package com.patronespd.implementacion;

import com.patronespd.fintech.b.FintechBSolicitudCredito;
import com.patronespd.fintech.b.FintechBRespuestaCredito;
import com.patronespd.fintech.b.FintechBCreditosAPI;

/**
 *
 * @author Fabrizio Bolaño
 */
public class AdaptadorFitechB implements InterfaceFintechAdaptador {

    @Override
    public FintechCreditoRespuesta EnvioSolicitudCredito(FintechSolicitudCredito request) {
        FintechBSolicitudCredito FBrequest = new FintechBSolicitudCredito();
        FBrequest.setNombreCliente(request.getCliente());
        FBrequest.setValorSolicitado(request.getValor());
        
        FintechBCreditosAPI api = new FintechBCreditosAPI();
        FintechBRespuestaCredito FBresponse = api.sendCreditRequest(FBrequest);
        
        FintechCreditoRespuesta response = new FintechCreditoRespuesta();
        response.setAprobacion(FBresponse.isResultadoAprobacion());
        return response;
    }
    
}