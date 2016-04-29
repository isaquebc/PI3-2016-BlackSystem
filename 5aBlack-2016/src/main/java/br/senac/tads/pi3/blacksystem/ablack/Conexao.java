package br.senac.tads.pi3.blacksystem.ablack;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafael
 */
public  abstract class Conexao {
   

    final Connection getConexao() throws ClassNotFoundException, SQLException {
        Connection con = null;
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/BlackSystemLavandeiria ", "app", "app");
        } catch (NullPointerException e) {
            System.out.println("error");
        }
        return con;
    }

    
    public String buscaNome(String cpf) throws ClassNotFoundException {
        String nome = "";
        ResultSet rs = null;
        PreparedStatement stm = null;
        Connection conn = null;
        String sql = ("SELECT NOME_CLIENTE FROM TB_CLIENTE WHERE CPF='" + cpf + "'");
        try {
            conn = getConexao();
            stm = conn.prepareStatement(sql);
            nome = rs.getString("NOME_CLIENTE");
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro de Conexão");
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }
        return nome;
    }

//    public void alteraDados(){
//        
//        Connection con=null;
//        org.apache.derby.client.am.Statement;
//    }
    public void deletaCliente(String cpf) throws ClassNotFoundException {

    }        
}
