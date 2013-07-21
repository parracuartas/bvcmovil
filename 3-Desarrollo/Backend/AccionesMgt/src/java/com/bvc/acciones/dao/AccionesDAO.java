/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvc.acciones.dao;

import com.bvc.dao.UtilDAO;
import com.bvc.dto.AccionDTO;
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
public class AccionesDAO extends UtilDAO {

    public List<AccionDTO> obtenerAcciones() throws DAOException, SQLException {
        Connection con = null;
        PreparedStatement psSel = null;
        ResultSet rsSel = null;
        List<AccionDTO> accionDTOs = new ArrayList<AccionDTO>();
        try {
            con = getConnection();

            StringBuilder query = new StringBuilder();
            query.append("SELECT * ");
            query.append("FROM \"Acciones\" ");
            query.append("ORDER BY nombre ");

            psSel = con.prepareStatement(query.toString());

            // Ejecuta la sentencia
            rsSel = psSel.executeQuery();

            // Consulta los nombres de las columnas
            while (rsSel.next()) {
                accionDTOs.add(new AccionDTO(rsSel.getString("id"),
                        rsSel.getString("nombre"), rsSel.getFloat("valor_actual"),
                        rsSel.getInt("cantidad_circulacion")));
            }

        } finally {
            Statement[] ss = {psSel};
            ResultSet[] rss = {rsSel};
            closeResources(con, ss, rss);
        }
        return accionDTOs;
    }
}
