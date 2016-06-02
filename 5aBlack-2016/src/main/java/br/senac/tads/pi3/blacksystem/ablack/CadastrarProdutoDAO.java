/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import static br.senac.tads.pi3.blacksystem.ablack.Conexao.getConexao;
import br.senac.tads.pi3.blacksystem.entity.Produto;
import br.senac.tads.pi3.blacksystem.entity.TipoProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.client.am.Decimal;

/**
 *
 * @author Miqueas Santos
 */
public class CadastrarProdutoDAO extends Conexao {
//
//    final String QUERY_INSERT_PRODUTO = "INSERT INTO PRODUTO(NOME_PROD, VALIDADE_PROD, LOTE, STATUS, QTD_MIN, QTD_MAX, QTD_ATUAL)"
//            + "    VALUES(?, ?, ?, ?, ?, ?, ?)";
//
//    public void cadastrarTipoProduto(TipoProduto tipo)
//            throws ClassNotFoundException {
//        Connection conn = null;
//        PreparedStatement stm = null;
//        try {
//            conn = getConexao();
//            stm = conn.prepareStatement(QUERY_INSERT_PRODUTO);
//            stm.setInt(1, tipo.getIdTipo());
//            stm.setString(2, tipo.getNome());
//            stm.setString(3, tipo.getDescricao());
//            stm.executeQuery();
//            stm.close();
//            conn.close();
//        } catch (SQLException e) {
//            System.out.println("Erro de conexão");
//        } catch (NullPointerException e) {
//            System.out.println("Dao não inicializado");
//        }
//    }

    public void produtoCadastro(Produto p, String nome) throws ClassNotFoundException {
        String sql = "insert into PRODUTO ( NOME_PROD, VALIDADE_PROD,LOTE,STATUS,QTD_MIN,QTD_MAX,QTD_ATUAL,ID_TIPO_PROD)" + "values(?,?,?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement stm = null;
        TipoProduto tp = new TipoProduto();

        try {

            buscaTipoProd(nome);

            conn = getConexao();

            stm = conn.prepareStatement(sql);
            stm.setString(1, p.getNome().toLowerCase());
            stm.setDate(2, new java.sql.Date(1009 - 03 - 03));
            stm.setInt(3, p.getLote());
            stm.setString(4, "ATIVO");
            stm.setInt(5, (int) p.getQtdMin());
            stm.setInt(6, (int) p.getQtdMax());
            stm.setInt(7, (int) p.getQtdAtual());
            
            stm.setInt(8, (int) tp.getIdTipo());

            stm.executeUpdate();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro de conexão: Cadastrar ");
        } catch (NullPointerException e) {
            e.getMessage();
            System.out.println("não inicializado");
        }
    }

    /**
     *
     * @param tp
     * @return
     * @throws ClassNotFoundException
     */
    public void buscaTipoProd(String teste) {

        String slq = "SELECT * FROM TIPO_PRODUTO WHERE DESCRICAO_PROD ='" + teste + "'";

        TipoProduto tp = new TipoProduto();

        try {
            Connection conn = getConexao();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(slq);

            while (rs.next()) {
                tp.setIdTipo(rs.getInt("ID_TIPO_PROD"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            e.getMessage();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
