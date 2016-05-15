/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import br.senac.tads.pi3.blacksystem.entity.TipoProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Rafael
 */
public class CadastraTipoProd extends Conexao{
    final String QUERY_INSERT_TIPO_PRODUTO = "INSERT INTO TIPO_PRODUTO(ID_TIPO, NOME, DESCRICAO)"
                                             + "VALUES (?, ?, ?)";
    public void cadastrarTipoProduto(TipoProduto tipo)   
        throws ClassNotFoundException{
                Connection conn= null;
        PreparedStatement stm= null;
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_TIPO_PRODUTO);
            stm.setInt(1, tipo.getIdTipo());
            stm.setString(2, tipo.getNome());
            stm.setString(3, tipo.getDescricao());
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
