/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvc.portafolios.ejb;

import com.bvc.dto.CompraDTO;
import com.bvc.dto.PortafolioDTO;
import com.bvc.portafolios.dao.CompraDAO;
import com.bvc.portafolios.dao.PortafoliosDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author HansO
 */
@Stateless
public class IPortafolios implements IPortafoliosRemote, IPortafoliosLocal {

    private static PortafoliosDAO portafoliosDAO;
    private static CompraDAO compraDAO;

    static {
        portafoliosDAO = new PortafoliosDAO();
        compraDAO = new CompraDAO();
    }

    @Override
    public int crearOrdenCompra(CompraDTO compraDTO) {
        int retorno;
        try {
            retorno = compraDAO.crearOrdenCompra(compraDTO);
        } catch (Exception ex) {
            retorno = 1;
        }
        return retorno;
    }

    @Override
    public List<PortafolioDTO> obtenerPortafolios(String idInversionista) {
        List<PortafolioDTO> portafolioDTOs;
        try {
            portafolioDTOs = portafoliosDAO.obtenerPortafolios(idInversionista);
        } catch (Exception ex) {
            portafolioDTOs = new ArrayList<PortafolioDTO>();
        }
        return portafolioDTOs;
    }
}
