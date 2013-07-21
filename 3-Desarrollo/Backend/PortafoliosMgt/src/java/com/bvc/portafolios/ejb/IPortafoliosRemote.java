/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvc.portafolios.ejb;

import com.bvc.dto.CompraDTO;
import com.bvc.dto.PortafolioDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author HansO
 */
@Remote
public interface IPortafoliosRemote {

    public int crearOrdenCompra(CompraDTO compraDTO);

    public List<PortafolioDTO> obtenerPortafolios(String idInversionista);
}
