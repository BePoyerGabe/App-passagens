/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import connectiondb.ConnectionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Onibus;
import models.Viagem;

/**
 *
 * @author bernardo
 */
public class ViagemDAO {
    
    public ArrayList<String> listaOrigem() {
        Connection con = ConnectionDB.getConexao();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<String> viagens = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT origem FROM viagem");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Viagem v = new Viagem();

                v.setOrigem(rs.getString("origem"));
                
                viagens.add(v.getOrigem());
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConexao(con, stmt, rs);
        }
        
        return viagens;
    }
    
    
     public List<Viagem> listarViagens(String origem, String destino) {
        Connection con = ConnectionDB.getConexao();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Viagem> viagens = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM viagem v INNER JOIN onibus o on v.Onibus_id = o.idonibus WHERE v.origem=? AND v.destino=?");
            stmt.setString(1, origem);
            stmt.setString(2, destino);
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Viagem v = new Viagem();
                
                v.setId(rs.getInt("id"));
                v.setOrigem(rs.getString("origem"));
                v.setDestino(rs.getString("destino"));
                v.setHoraPartida(rs.getString("horaPartida"));
                v.setDestino(rs.getString("dia"));
                v.setDia(rs.getString("dia"));
                v.setPreco(rs.getFloat("preco"));
                
                Onibus onibus = new Onibus();
                onibus.setId(rs.getInt("Onibus_id"));
                onibus.setMotorista(rs.getString("motorista"));
                onibus.setCompanhia(rs.getString("companhia"));
                
                v.setOnibus(onibus);
                
                viagens.add(v);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConexao(con, stmt, rs);
        }
        
        return viagens;
    }
    
    public ArrayList<String> buscaDestino(String des) {
        Connection con = ConnectionDB.getConexao();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<String> destinos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT destino FROM viagem WHERE origem=?");
            stmt.setString(1, des);
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                destinos.add(rs.getString("destino"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConexao(con, stmt);
        }
        
        return destinos;
    }
    
    public ArrayList<String> filtroViagem(ArrayList<String> viagens) {
        ArrayList<String> filtro = new ArrayList();
        
        for (String destino : viagens) {
            
            if(!filtro.contains(destino)) {
                filtro.add(destino);
            }
        }
        /*String filtro[] = new String[30];
        String aux = null;
        
        for (int i=0; i < viagens.size(); i++) {
            Viagem v1 = viagens.get(i);
            
            if(!v1.getOrigem().equals(aux)) {
               aux = v1.getOrigem();
               filtro[i] = aux;
                System.out.println(filtro[i]);
               
            }
        }    
        */
        return filtro;
    }

}
