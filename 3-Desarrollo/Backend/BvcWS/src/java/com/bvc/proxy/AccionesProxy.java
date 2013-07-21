/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvc.proxy;

import com.bvc.acciones.ejb.IAccionesRemote;
import com.bvc.dto.AccionDTO;
import java.util.List;

/**
 *
 * @author HansO
 */
public class AccionesProxy {

    public List<AccionDTO> obtenerAcciones() {
        try {
            IAccionesRemote testEJB = (IAccionesRemote) ProxyUtil.getInstancia().CTX.lookup("com.bvc.acciones.ejb.IAccionesRemote");
            return testEJB.obtenerAcciones();
        } catch (Exception e) {
            return null;
        }
    }
}
