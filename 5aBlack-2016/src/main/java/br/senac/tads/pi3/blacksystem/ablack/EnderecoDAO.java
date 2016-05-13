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
public class EnderecoDAO extends Conexao{
final String QUERY_INSERT_ENDERECO     =  "INSERT INTO ENDERECO(ID_ENDERECO, ENDERECO, COMPLEMENTO, BAIRRO, CIDADE, ESTADO, CEP, ID_CPF)"
                                             + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";    

public void cadastrarEndereco(Cliente cli,int id_end,Endereco end)
        throws ClassNotFoundException{
    
    Connection conn= null;
        PreparedStatement stm= null;
        try {
              conn = getConexao();
             stm = conn.prepareStatement(QUERY_INSERT_ENDERECO);
            stm.setInt(1, id_end);
            stm.setString(2, end.getEndereco());
            stm.setString(3, end.getComplemento());
            stm.setString(4, end.getBairro());
            stm.setString(5, end.getCidade());
            stm.setString(6, end.getEstado());
            stm.setString(7, end.getCep());
            stm.setString(8, cli.getCpf());
            stm.executeQuery();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro de conexão");
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }
    }
    
}
