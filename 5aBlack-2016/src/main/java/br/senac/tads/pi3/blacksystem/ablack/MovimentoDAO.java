/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import static br.senac.tads.pi3.blacksystem.ablack.Conexao.getConexao;
import br.senac.tads.pi3.blacksystem.entity.MovimentoProduto;
import br.senac.tads.pi3.blacksystem.entity.Produto;
import br.senac.tads.pi3.blacksystem.entity.TipoProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Miqueas Santos
 */
public class MovimentoDAO extends Conexao{
    
    
    public void produtoEntrada(MovimentoProduto m, Produto p) throws ClassNotFoundException {
        String sql = "INSERT INTO ENTRADA(DESCRICAO, ID_FUNCIONARIO, ID_FILIAL, QTD,DATA_ENTRADA, ID_PRODUTO)" +
        "    VALUES(?, ?, ?, ?, DATE(CURRENT TIMESTAMP), (SELECT ID_PROD FROM PRODUTO WHERE NOME_PROD = '"+p.getNome().toUpperCase()+"' AND LOTE = "+p.getLote()+"))";
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = getConexao();
            stm = conn.prepareStatement(sql);
            stm.setString(1, m.getDescricao());
            stm.setInt(2, m.getIdFuncionario());
            stm.setInt(3, m.getIdFilial());
            stm.setInt(4, p.getQtdAtual());
            stm.executeUpdate();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void produtoSaida(MovimentoProduto m, Produto p) throws ClassNotFoundException {
        String sql = "INSERT INTO SAIDA(DESCRICAO, ID_FUNCIONARIO, ID_FILIAL, QTD,DATA_ENTRADA, ID_PRODUTO)" +
        "    VALUES(?, ?, ?, ?, DATE(CURRENT TIMESTAMP), (SELECT ID_PROD FROM PRODUTO WHERE NOME_PROD = '"+p.getNome().toUpperCase()+"' AND LOTE = "+p.getLote()+"))";
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = getConexao();
            stm = conn.prepareStatement(sql);
            stm.setString(1, m.getDescricao());
            stm.setInt(2, m.getIdFuncionario());
            stm.setInt(3, m.getIdFilial());
            stm.setInt(4, p.getQtdAtual());
            stm.executeUpdate();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void produtoAtualizar(Produto p) throws ClassNotFoundException {
        String sql = "UPDATE PRODUTO SET NOME_PROD='"+p.getNome().toUpperCase()+"', VALIDADE_PROD=DATE('"+p.getValidade()+"'), LOTE="+p.getLote() +
        ", STATUS='"+p.getStatus()+"', QTD_MIN="+p.getQtdMin()+", QTD_MAX="+p.getQtdMax()+", QTD_ATUAL="+p.getQtdAtual()+", " +
        " ID_TIPO_PROD = "+ new ProdutoDAO().buscaTipoProd(p.getTipoDeProduto().getNome()) +
        " WHERE ID_PROD = " + p.getIdProduto();
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = getConexao();
            stm = conn.prepareStatement(sql);
            stm.executeUpdate();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    
}
