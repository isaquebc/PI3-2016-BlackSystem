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
import java.sql.SQLException;

/**
 *
 * @author Rafael
 */
public class EnderecoFuncionarioDAO extends Conexao{
final String QUERY_INSERT_ENDERECO     =  "INSERT INTO ENDERECO(LOGRADOURO_CLI,COMPLEMENTO_CLI,"
        + "BAIRRO_CLI, CIDADE_CLI, ESTADO_CLI,CEP_CLI, CPF_CLIENTE)" + "VALUES (?, ?, ?, ?, ?, ?, ? )";    

public void cadastrarEndereco(Cliente cli,int id_end,Endereco end)
        throws ClassNotFoundException{
    
    Connection conn= null;
        PreparedStatement stm= null;
        try {
              conn = getConexao();
             stm = conn.prepareStatement(QUERY_INSERT_ENDERECO);
            
            stm.setString(1, end.getEndereco());
            stm.setString(2, end.getComplemento());
            stm.setString(3, end.getBairro());
            stm.setString(4, end.getCidade());
            stm.setString(5, end.getEstado());
            stm.setString(6, end.getCep());
            stm.setString(7, cli.getCpf());
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
