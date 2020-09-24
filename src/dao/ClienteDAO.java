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
import models.Cliente;

/**
 *
 * @author bernardo
 */
public class ClienteDAO {
    
    
    public void newCliente(Cliente c) {
        Connection conexao = ConnectionDB.getConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("INSERT INTO cliente (nome,telefone,email,senha)VALUES(?,?,?,?)");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getTelefone());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getSenha());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar cliente: " + ex);
           
        } finally {
            ConnectionDB.closeConexao(conexao, stmt);
        }
        
        
    }
    
    public Cliente login(String nome, String senha) {
        Connection conexao = ConnectionDB.getConexao();
        PreparedStatement stmt = null;
        Cliente c = new Cliente();
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM cliente WHERE nome=? and senha=?");
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
               
               c.setId(rs.getInt("id"));
               c.setNome(rs.getString("nome"));
               c.setEmail(rs.getString("email"));
               c.setTelefone(rs.getString("telefone"));
               c.setSenha(rs.getString("senha"));
            }
                    
        } catch(SQLException ex) {
            System.out.println("Erro ao salvar cliente: " + ex);
            
        } finally {
            ConnectionDB.closeConexao(conexao, stmt);
        }
        return c;

    }
}
