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
public class DaoLavanderia {

    private Connection conexao() throws ClassNotFoundException, SQLException {
        Connection con = null;
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/BlackSystemLavandeiria ", "app", "app");
        } catch (NullPointerException e) {
            System.out.println("error");
        }
        return con;
    }

    public void incluirPessoa(String nome, String telefone, String celular, String cpf, String email,
            String end, String numEnd, String cidade, String estado, String cep) throws ClassNotFoundException {
        PreparedStatement stm = null;
        Connection conn = null;
        String sql = "insert into TB_CLIENTE (NOME_CLIENTE,TEL, CEL, CPF, EMAIL, END, NUM_END,CIDADE,ESTADO,CEP)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = conexao();
            stm = conn.prepareStatement(sql);
            stm.executeUpdate();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro de conexão");
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }
    }

    public String buscaNome(String cpf) throws ClassNotFoundException {
        String nome = "";
        ResultSet rs = null;
        PreparedStatement stm = null;
        Connection conn = null;
        String sql = ("SELECT NOME_CLIENTE FROM TB_CLIENTE WHERE CPF='" + cpf + "'");
        try {
            conn = conexao();
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

        Connection con = null;
        PreparedStatement stm = null;
        String sql = "DELETE FROM NOME_CLIENTE WHERE CPF='" + cpf + "'";
        try {
            con = conexao();
            stm = con.prepareStatement(sql);

            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Ero de conexão");
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }

    }
}
