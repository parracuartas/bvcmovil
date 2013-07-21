/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvc.ws;

import com.bvc.dto.AccionDTO;
import com.bvc.dto.CompraDTO;
import com.bvc.dto.PortafolioDTO;
import com.bvc.helper.AccionHelper;
import com.bvc.helper.PortafolioHelper;
import com.bvc.proxy.AccionesProxy;
import com.bvc.proxy.PortafoliosProxy;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author HansO
 */
@WebService(serviceName = "MovilWS")
public class MovilWS {

    private static AccionesProxy accionesProxy;
    private static PortafoliosProxy portafoliosProxy;

    static {
        accionesProxy = new AccionesProxy();
        portafoliosProxy = new PortafoliosProxy();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtenerAcciones")
    public String obtenerAcciones() {
        try {
            List<AccionDTO> accionDTOs = accionesProxy.obtenerAcciones();
            return AccionHelper.getDocumento(accionDTOs);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtenerPortafolios")
    public String obtenerPortafolios(@WebParam(name = "idInversionista") final String idInversionista) {
        try {
            List<PortafolioDTO> portafolioDTOs = portafoliosProxy.obtenerPortafolios(idInversionista);
            return PortafolioHelper.getDocumento(portafolioDTOs);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "crearOrdenCompra")
    public int crearOrdenCompra(@WebParam(name = "compraId") final String compraId, @WebParam(name = "fechaInicial") final String fechaInicial, @WebParam(name = "fechaFinal") final String fechaFinal, @WebParam(name = "cantidad") final String cantidad, @WebParam(name = "valorUnidad") final String valorUnidad, @WebParam(name = "porcentajeComision") final String porcentajeComision, @WebParam(name = "porcentajeImpuestos") final String porcentajeImpuestos, @WebParam(name = "gastos") final String gastos, @WebParam(name = "observaciones") final String observaciones, @WebParam(name = "accionId") final String accionId, @WebParam(name = "portafolioId") final String portafolioId) {
        try {
            CompraDTO compraDTO = new CompraDTO();
            compraDTO.setCompraId(compraId);
            compraDTO.setFechaInicial(new Date(Long.parseLong(fechaInicial)));
            compraDTO.setFechaFinal(new Date(Long.parseLong(fechaFinal)));
            compraDTO.setCantidad(Integer.parseInt(cantidad));
            compraDTO.setValorUnidad(Float.parseFloat(valorUnidad));
            compraDTO.setPorcentajeComision(Float.parseFloat(porcentajeComision));
            compraDTO.setPorcentajeImpuestos(Float.parseFloat(porcentajeImpuestos));
            compraDTO.setGastos(Float.parseFloat(gastos));
            compraDTO.setObservaciones(observaciones);
            compraDTO.setEstado(1);
            compraDTO.setAccionId(accionId);
            compraDTO.setPortafolioId(Integer.parseInt(portafolioId));
            return portafoliosProxy.crearOrdenCompra(compraDTO);
        } catch (Exception e) {
            return 0;
        }
    }
}
