/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import br.senac.tads.pi3.blacksystem.entity.Cliente;
import br.senac.tads.pi3.blacksystem.entity.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class FuncinarioCadastroDAO extends Conexao {

    String QUERY_INSERT_FUNCIORARIO = "INSERT INTO FUNCIONARIO( CPF_FUNC, NOME_FUNC, SOBRENOME_FUNC,SEXO_INSERT INTO CLIENTE( CPF_FUNC, CPF_FUNC, CPF_FUNC,CPF_FUNC,"
            + " CPF_FUNC, CPF_FUNC, CPF_FUNC, CPF_FUNC, CPF_FUNC)"
            + "VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)"
            + " CPF_FUNC, CPF_FUNC, CPF_FUNC, CPF_FUNC, CPF_FUNC)"
            + "VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)";

    public void cadastrarFuncionario(Funcionario func)
            throws ClassNotFoundException {

        Connection conn = null;
        PreparedStatement stm = null;
        
        
            try {
                conn = getConexao();
                String sql = QUERY_INSERT_FUNCIORARIO;
                stm = conn.prepareStatement(sql);
                stm.setString(1, func.getCpf());
                stm.setString(2, func.getNome());
                stm.setString(3, func.getSobrenome());
                stm.setString(4,func.getSexo());
                stm.setDate(5, new java.sql.Date(1009 - 03 - 03));
                stm.setString(6, func.getTelefone());
                stm.setString(7, func.getCelular());
                stm.setString(8, func.getEmail());
                stm.setString(9, func.getStatus());
                stm.executeUpdate();
                stm.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println("Erro de conexão: Cadastro do cliente");
            } catch (NullPointerException e) {
                System.out.println("Dao não inicializado: Cadastro do cliente");
            }

        }

}
