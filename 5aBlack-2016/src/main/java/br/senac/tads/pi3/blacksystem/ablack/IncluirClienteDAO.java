/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Rafael
 */
public class IncluirClienteDAO extends Conexao{
    
    
    public void incluirPessoa(String nome, String telefone, String celular, String cpf, String email,
            String end, String numEnd, String cidade, String estado, String cep) throws ClassNotFoundException {
        PreparedStatement stm = null;
        Connection conn = null;
        
        String sql = "insert into TB_CLIENTE (NOME_CLIENTE,TEL, CEL, CPF, EMAIL, END, NUM_END,CIDADE,ESTADO,CEP)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = getConexao();
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

}
