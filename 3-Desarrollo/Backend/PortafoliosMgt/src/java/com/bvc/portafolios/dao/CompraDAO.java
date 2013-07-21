/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvc.portafolios.dao;

import com.bvc.dao.UtilDAO;
import com.bvc.dto.CompraDTO;
import com.bvc.excepciones.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author HansO
 */
public class CompraDAO extends UtilDAO {

    public int crearOrdenCompra(CompraDTO compraDTO) throws DAOException, SQLException {
        Connection con = null;
        PreparedStatement psSel = null;
        ResultSet rsSel = null;
        int retorno;
        try {
            con = getConnection();

            StringBuilder query = new StringBuilder();
            query.append("INSERT INTO \"Compras\"(id, fecha_inicial, fecha_final, cantidad, valor_unitario, porcentaje_comision, ");
            query.append("porcentaje_impuestos, gastos, observaciones, estado, accion_id, portafolio_id) ");
            query.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");

            psSel = con.prepareStatement(query.toString());
            int i = 1;
            psSel.setString(i++, compraDTO.getCompraId());
            psSel.setTimestamp(i++, new Timestamp(compraDTO.getFechaInicial().getTime()));
            psSel.setTimestamp(i++, new Timestamp(compraDTO.getFechaFinal().getTime()));
            psSel.setInt(i++, compraDTO.getCantidad());
            psSel.setFloat(i++, compraDTO.getValorUnidad());
            psSel.setFloat(i++, compraDTO.getPorcentajeComision());
            psSel.setFloat(i++, compraDTO.getPorcentajeImpuestos());
            psSel.setFloat(i++, compraDTO.getGastos());
            psSel.setString(i++, compraDTO.getObservaciones());
            psSel.setInt(i++, compraDTO.getEstado());
            psSel.setString(i++, compraDTO.getAccionId());
            psSel.setInt(i++, compraDTO.getPortafolioId());

            // Ejecuta la sentencia
            retorno = psSel.executeUpdate();

        } finally {
            Statement[] ss = {psSel};
            ResultSet[] rss = {rsSel};
            closeResources(con, ss, rss);
        }
        return retorno;
    }
}
