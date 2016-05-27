/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import br.senac.tads.pi3.blacksystem.entity.Funcionario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Miqueas Santos
 */
public class FuncionarioDAO extends Conexao{
    
    public ArrayList buscarFuncionario(String cpf) throws ClassNotFoundException{
        Statement stm = null;
        ResultSet rs = null;
        Connection con = null;
        String QUERY_SELECT_FUNCIONARIO = "SELECT FUNCIONARIO.ID_FUNC, FUNCIONARIO.NOME_FUNC, FUNCIONARIO.SOBRENOME_FUNC, FUNCIONARIO.CPF_FUNC, FUNCIONARIO.NASC_FUNC," +
        " FUNCIONARIO.TEL_FUNC, FUNCIONARIO.CEL_FUNC, FUNCIONARIO.EMAIL_FUNC, ENDERECO_FUNCIONARIO.LOGRADOURO_FUNC, ENDERECO_FUNCIONARIO.NUMERO_CLI," +
        " ENDERECO_FUNCIONARIO.ESTADO_FUNC, ENDERECO_FUNCIONARIO.CIDADE_FUNC, ENDERECO_FUNCIONARIO.CEP_FUNC" +
        " FROM FUNCIONARIO LEFT JOIN ENDERECO_FUNCIONARIO ON FUNCIONARIO.ID_FUNC = ENDERECO_FUNCIONARIO.ID_FUNC" +
        " WHERE FUNCIONARIO.CPF_FUNC='".concat(cpf)+"'"; 
        //10485544150
        try {
            
            con = getConexao();
            stm = con.createStatement();
            rs = stm.executeQuery(QUERY_SELECT_FUNCIONARIO);
            ArrayList<Funcionario> funcionarios = new ArrayList<>();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("ID_FUNC"));
                f.setCpf(rs.getString("NOME_FUNC"));
                f.setSobrenome(rs.getString("SOBRENOME_FUNC"));
                f.setCpf(rs.getString("CPF_FUNC"));
                f.setDataNascimento(rs.getString("NASC_FUNC"));
                f.setTelefone(rs.getString("TEL_FUNC"));
                f.setCelular(rs.getString("CEL_FUNC"));
                f.setEmail(rs.getString("EMAIL_FUNC"));
                f.setRua(rs.getString("LOGRADOURO_FUNC"));
                f.setNumero(rs.getInt("NUMERO_CLI"));
                f.setEstado(rs.getString("ESTADO_FUNC"));
                f.setCidade(rs.getString("CIDADE_FUNC"));
                f.setCep(rs.getString("CEP_FUNC"));
                funcionarios.add(f);
            }
            con.close();
            rs.close();
            stm.close();
            return funcionarios;
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        
        return null;
    }
    
}
