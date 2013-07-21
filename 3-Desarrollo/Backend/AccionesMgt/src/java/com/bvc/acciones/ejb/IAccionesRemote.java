/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvc.acciones.ejb;

import com.bvc.dto.AccionDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author HansO
 */
@Remote
public interface IAccionesRemote {

    public List<AccionDTO> obtenerAcciones();
}
