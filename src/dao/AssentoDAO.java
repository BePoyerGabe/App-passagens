/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectiondb.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Assento;

/**
 *
 * @author bernardo
 */
public class AssentoDAO {
    
    public boolean fazerResenva(Assento assento) {
        Connection con = ConnectionDB.getConexao();
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO assento \n" +
                                                   "SET numero = ?,\n" +
                                                   "   Onibus_id = (\n" +
                                                   "   SELECT idonibus\n" +
                                                   "       FROM onibus\n" +
                                                   "   WHERE idonibus = ?),\n" +
                                                   "   Cliente_id = (\n" +
                                                   "   SELECT id\n" +
                                                   "       FROM cliente\n" +
                                                   "   WHERE id = ?);");
            
            stmt.setInt(1, assento.getNumero());
            stmt.setInt(2, assento.getOnibus().getId());
            stmt.setInt(3, assento.getCliente().getId());
           
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(AssentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
}
