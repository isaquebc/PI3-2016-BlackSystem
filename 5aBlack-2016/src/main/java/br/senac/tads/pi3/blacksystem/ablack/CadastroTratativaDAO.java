/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import br.senac.tads.pi3.blacksystem.entity.TratativaChamado;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rafael
 */
public class CadastroTratativaDAO extends Conexao {

    public void cadastrarTratativaChamado(TratativaChamado trat)
            throws ClassNotFoundException {
        String QUERY_INSERT_TRATATIVA = "INSERT INTO TRATATIVA_CHAMADO(DATA_FECHAMENTO, DESCRICAO_TRATATIVA, ID_CHAMADO, ID_FUNC)"
                + " VALUES(DATE(CURRENT TIMESTAMP), '" + trat.getDescricao() + "', " + trat.getIdChamado() + ", " + trat.getIdFuncionario() + ")";
        Connection conn = null;
        Statement stm = null;
        try {
            conn = getConexao();
            stm = conn.createStatement();
            stm.executeUpdate(QUERY_INSERT_TRATATIVA);
            baixaChamado(trat.getIdChamado());
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }
    }

    public void baixaChamado(int id)
            throws ClassNotFoundException {
        String QUERY_INSERT_TRATATIVA = "UPDATE CHAMADO SET STATUS ='BAIXADO' " +
        "WHERE ID_CHAMADO="+id;
        Connection conn = null;
        Statement stm = null;
        try {
            conn = getConexao();
            stm = conn.createStatement();
            stm.executeUpdate(QUERY_INSERT_TRATATIVA);
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }
    }
}
