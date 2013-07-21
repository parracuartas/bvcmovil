/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvc.dao;

import com.bvc.excepciones.DAOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author xHANSx
 */
public class UtilDAO {

    /***
     * Crea una conexion en la BD
     * 
     * @param usuario usuario de conexion a la BD
     * @param clave passwor de conexion a la BD
     * @return Objeto de tipo Connection con una sesion de la BD
     * @throws ReporteadorExcepcion
     */
    protected Connection getConnection() throws DAOException {
        try {
            Context initCtx = new InitialContext();
            DataSource dataSource = (DataSource) initCtx.lookup("jdbc/bvc");
            return dataSource.getConnection();
        } catch (NamingException ex) {
            String mensaje = "Error al utilizar el recurso JNDI que hace referencia al DataSource: ";
            throw new DAOException(mensaje + ex.getMessage());
        } catch (SQLException ex) {
            String mensaje = "Error al conectarse a la base de datos: ";
            throw new DAOException(mensaje + ex.getMessage());
        }
    }

    /***
     * Cierra objetos Connection, PreparedStatement y ResultSet al terminar la transaccion
     * 
     * @param con Objeto de tipo Connection con una sesion de la BD
     * @param ss PreparedStatement de trabajo durante la sesion
     * @param rss ResultSet de trabajo durante la sesion
     * @throws ReporteadorExcepcion 
     */
    protected void closeResources(Connection con, Statement[] ss, ResultSet[] rss) throws DAOException {
        try {
            for (ResultSet rs : rss) {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            }
            for (Statement s : ss) {
                if (s != null) {
                    s.close();
                    s = null;
                }
            }
            if (con != null && !con.isClosed()) {
                con.close();
                con = null;
            }
        } catch (SQLException ex) {
            String mensaje = "Error cerrando recursos asociados con la base de datos: ";
            throw new DAOException(mensaje + ex.getMessage());
        }
    }

    /***
     * Cierra objetos PreparedStatement y ResultSet al terminar la transaccion
     * 
     * @param ss PreparedStatement de trabajo durante la sesion
     * @param rss ResultSet de trabajo durante la sesion
     * @throws ReporteadorExcepcion 
     */
    protected void closeResources(Statement[] ss, ResultSet[] rss) throws DAOException {
        try {
            for (ResultSet rs : rss) {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            }
            for (Statement s : ss) {
                if (s != null) {
                    s.close();
                    s = null;
                }
            }
        } catch (SQLException ex) {
            String mensaje = "Error cerrando recursos asociados con la base de datos: ";
            throw new DAOException(mensaje + ex.getMessage());
        }
    }
}
