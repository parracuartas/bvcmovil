/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvc.acciones.ejb;

import com.bvc.acciones.dao.AccionesDAO;
import com.bvc.dto.AccionDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author HansO
 */
@Stateless
public class IAcciones implements IAccionesRemote, IAccionesLocal {

    private static AccionesDAO accionesDAO;

    static {
        accionesDAO = new AccionesDAO();
    }

    @Override
    public List<AccionDTO> obtenerAcciones() {
        List<AccionDTO> accionDTOs;
        try {
            accionDTOs = accionesDAO.obtenerAcciones();
        } catch (Exception ex) {
            accionDTOs = new ArrayList<AccionDTO>();
        }
        return accionDTOs;
    }
}
