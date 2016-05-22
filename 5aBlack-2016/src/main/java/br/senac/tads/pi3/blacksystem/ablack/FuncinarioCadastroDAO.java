/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import br.senac.tads.pi3.blacksystem.entity.Cliente;
import br.senac.tads.pi3.blacksystem.entity.Filial;
import br.senac.tads.pi3.blacksystem.entity.Funcionario;
import java.sql.Connection;
import java.sql.Date;
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

     
    public void cadastrarFuncionario(Funcionario func,Filial filial)
            throws ClassNotFoundException {

String QUERY_INSERT_FUNCIORARIO = "INSERT INTO FUNCIONARIO( CPF_FUNC, NOME_FUNC, SOBRENOME_FUNC,SEXO_FUNC,NASC_FUNC,"
 +"TEL_FUNC ,CEL_FUNC,EMAIL_FUNC, STATUS_FUNC,SENHA_FUNC,CARGO_FUNC,SALARIO_FUNC,ID_FILIAL)"+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement stm = null;
                
            try {
                conn = getConexao();
                String sql = QUERY_INSERT_FUNCIORARIO;
                stm = conn.prepareStatement(sql);
                stm.setString(1, func.getCpf());
                stm.setString(2, func.getNome());
                stm.setString(3, func.getSobrenome());
                stm.setString(4,"M");
                stm.setDate(5,Date.valueOf(func.getDataNascimento()));
                stm.setString(6, func.getTelefone());
                stm.setString(7, func.getCelular());
                stm.setString(8, func.getEmail());
                stm.setString(9, "ATIVO");
                stm.setString(10, func.getSenha());
                stm.setString(11, func.getCargo());
                stm.setDouble(12, func.getSalario());
                stm.setInt(13,(1));
                
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
