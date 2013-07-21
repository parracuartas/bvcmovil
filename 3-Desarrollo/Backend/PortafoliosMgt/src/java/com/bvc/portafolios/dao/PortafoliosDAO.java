/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvc.portafolios.dao;

import com.bvc.dao.UtilDAO;
import com.bvc.dto.PortafolioDTO;
import com.bvc.excepciones.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HansO
 */
public class PortafoliosDAO extends UtilDAO {

    public List<PortafolioDTO> obtenerPortafolios(String idInversionista) throws DAOException, SQLException {
        Connection con = null;
        PreparedStatement psSel = null;
        ResultSet rsSel = null;
        List<PortafolioDTO> portafolioDTOs = new ArrayList<PortafolioDTO>();
        try {
            con = getConnection();

            StringBuilder query = new StringBuilder();
            query.append("SELECT * ");
            query.append("FROM \"Portafolios\" ");
            query.append("WHERE inversionista = ? ");
            query.append("ORDER BY nombre ");

            psSel = con.prepareStatement(query.toString());
            int i = 1;
            psSel.setString(i++, idInversionista);

            // Ejecuta la sentencia
            rsSel = psSel.executeQuery();

            // Consulta los nombres de las columnas
            while (rsSel.next()) {
                portafolioDTOs.add(new PortafolioDTO(rsSel.getString("id"),
                        rsSel.getString("nombre"), rsSel.getFloat("saldo"),
                        rsSel.getString("inversionista")));
            }

        } finally {
            Statement[] ss = {psSel};
            ResultSet[] rss = {rsSel};
            closeResources(con, ss, rss);
        }
        return portafolioDTOs;
    }
}
