/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import br.senac.tads.pi3.blacksystem.entity.TratativaChamado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Rafael
 */
public class CadastroTratativaDAO extends Conexao{
        final String QUERY_INSERT_TRATATIVA    = "INSERT INTO TRATATIVA_CHAMADO(ID_TRATATIVA, DATA_FECHAMENTO, DESCRICAO, ID_CHAMADO, ID_FUNCIONARIO)"
                                             + "VALUES (?, ?, ?, ?, ?)";
    
        public void cadastrarTratativaChamado(TratativaChamado trat)
        throws ClassNotFoundException{
            
            Connection conn=null;
            PreparedStatement stm=null;
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_TRATATIVA);
            stm.setInt(1, trat.getIdChamado());
            stm.setDate(2, new java.sql.Date(trat.getDataFechamento().getTime()));
            stm.setString(3, trat.getDescricao());
            stm.setInt(4, trat.getIdChamado());
            stm.setInt(5, trat.getIdFuncionario());
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
