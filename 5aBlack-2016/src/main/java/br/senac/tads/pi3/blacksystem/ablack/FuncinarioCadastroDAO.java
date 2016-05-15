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

    String QUERY_INSERT_FUNCIORARIO = "INSERT INTO FUNCIONARIO( SENHA, CARGO, SALARIO, ID_CPF )"
            + "VALUES (?, ?, ?, ?)";

    public void cadastrarFuncionario(Funcionario func)
            throws ClassNotFoundException {

        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_FUNCIORARIO);

            stm.setString(1, func.getSenha());
            stm.setString(2, func.getCargo());
            stm.setFloat(3, func.getSalario());
            stm.setString(4, func.getCpf());
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
