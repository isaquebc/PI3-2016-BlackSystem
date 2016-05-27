/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import static br.senac.tads.pi3.blacksystem.ablack.Conexao.getConexao;
import br.senac.tads.pi3.blacksystem.entity.TipoProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Miqueas Santos
 */
public class CadastrarProdutoDAO extends Conexao{
    
    final String QUERY_INSERT_PRODUTO = "INSERT INTO PRODUTO(NOME_PROD, VALIDADE_PROD, LOTE, STATUS, QTD_MIN, QTD_MAX, QTD_ATUAL)" +
    "    VALUES(?, ?, ?, ?, ?, ?, ?)";
    public void cadastrarTipoProduto(TipoProduto tipo)   
        throws ClassNotFoundException{
                Connection conn= null;
        PreparedStatement stm= null;
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_PRODUTO);
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
