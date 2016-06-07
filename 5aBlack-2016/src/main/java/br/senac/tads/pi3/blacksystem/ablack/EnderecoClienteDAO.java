/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import br.senac.tads.pi3.blacksystem.entity.Cliente;
import br.senac.tads.pi3.blacksystem.entity.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rafael
 */
public class EnderecoClienteDAO extends Conexao {

        final String QUERY_INSERT_ENDERECO = "INSERT INTO ENDERECO_CLIENTE(LOGRADOURO_CLI,NUMERO_CLI, COMPLEMENTO_CLI"
                + ",BAIRRO_CLI, CIDADE_CLI, ESTADO_CLI, CEP_CLI, ID_CLIENTE)"+"values (?,?,?,?,?,?,?,?)";

    
    public void cadastrarEndereco(Cliente cli, Endereco end) throws ClassNotFoundException {
        
        cli.setId(consultaCli(cli));
    
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_ENDERECO);

            stm.setString(1, end.getEndereco());
            stm.setInt(2, end.getNumero());
            stm.setString(3, end.getComplemento());
            stm.setString(4, end.getBairro());
            stm.setString(5, end.getCidade());
            stm.setString(6, end.getEstado());
            stm.setString(7, end.getCep());
            stm.setInt(8, cli.getId());
            stm.executeUpdate();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro de conexão");
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }
    }

    public int consultaCli(Cliente cli) {
        
        int saida= 0;
        try {
            Connection conn= getConexao();
            Statement stm= null;
            stm= conn.createStatement();
            ResultSet rs= stm.executeQuery("select ID_CLIENTE from CLIENTE WHERE CPF_CLIENTE='"+ cli.getCpf()+"'");
            
            while(rs.next()){
                saida= (rs.getInt("ID_CLIENTE"));
                
            }
            
            rs.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("erro de conexão");
            e.getMessage();
        }
        return saida ;
    }

}
