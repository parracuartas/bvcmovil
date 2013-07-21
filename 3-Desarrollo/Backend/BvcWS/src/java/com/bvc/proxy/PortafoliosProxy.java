/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvc.proxy;

import com.bvc.dto.CompraDTO;
import com.bvc.dto.PortafolioDTO;
import com.bvc.portafolios.ejb.IPortafoliosRemote;
import java.util.List;

/**
 *
 * @author HansO
 */
public class PortafoliosProxy {

    public List<PortafolioDTO> obtenerPortafolios(String idInversionista) {
        try {
            IPortafoliosRemote testEJB = (IPortafoliosRemote) ProxyUtil.getInstancia().CTX.lookup("com.bvc.portafolios.ejb.IPortafoliosRemote");
            return testEJB.obtenerPortafolios(idInversionista);
        } catch (Exception e) {
            return null;
        }
    }

    public int crearOrdenCompra(CompraDTO compraDTO) {
        try {
            IPortafoliosRemote testEJB = (IPortafoliosRemote) ProxyUtil.getInstancia().CTX.lookup("com.bvc.portafolios.ejb.IPortafoliosRemote");
            return testEJB.crearOrdenCompra(compraDTO);
        } catch (Exception e) {
            return 0;
        }
    }
}
