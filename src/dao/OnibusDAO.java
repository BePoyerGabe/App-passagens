/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectiondb.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Assento;
import models.Onibus;
import models.Viagem;

/**
 *
 * @author bernardo
 */
public class OnibusDAO {
    
    public Assento[] assentosLivres(String companhia) {
        Connection con = ConnectionDB.getConexao();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        //  RETORNARÁ OS ASSENTOS POR MEIO DO GET ASSENTOS DA CLASSE ONIBUS
       
       Onibus oni = new Onibus();
        
        try {
            stmt = con.prepareStatement("select numero from assento a inner join onibus o on a.Onibus_id = o.idonibus inner join viagem v on a.Viagem_id = v.id where o.companhia = ?");
            stmt.setString(1, companhia);
            rs = stmt.executeQuery();
            
            
            
            while (rs.next()) {                
                Assento a = new Assento();
                
                a.setNumero(rs.getInt("numero"));
                
                
                
                oni.setLugares(a.getNumero());
                
                
            }
            
        } catch (SQLException ex ) {
            Logger.getLogger(ViagemDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            ConnectionDB.closeConexao(con, stmt, rs);
        }
        
        return oni.getLugares();
    }
}
