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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.client.am.Decimal;

/**
 *
 * @author Miqueas Santos
 */
public class ProdutoDAO extends Conexao {

     String QUERY_INSERT_PRODUTO = "INSERT INTO PRODUTO(NOME_PROD, VALIDADE_PROD, LOTE, STATUS, QTD_MIN, QTD_MAX, QTD_ATUAL)"
            + "    VALUES(?, ?, ?, ?, ?, ?, ?)";
//
    public void cadastrarTipoProduto(TipoProduto tipo)
            throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stm = null;
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

    public void produtoCadastro(Produto p) throws ClassNotFoundException {
        String sql = "insert into PRODUTO ( NOME_PROD, VALIDADE_PROD,LOTE,STATUS,QTD_MIN,QTD_MAX,QTD_ATUAL,ID_TIPO_PROD)" + "values(?,?,?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement stm = null;
        TipoProduto tp = new TipoProduto();

        try {

            p.getTipoDeProduto().setIdTipo(buscaTipoProd(p.getTipoDeProduto().getNome()));

            conn = getConexao();

            stm = conn.prepareStatement(sql);
            stm.setString(1, p.getNome().toUpperCase());
            stm.setDate(2, new java.sql.Date(1009 - 03 - 03));
            stm.setString(3, p.getLote());
            stm.setString(4, "ATIVO");
            stm.setInt(5,  p.getQtdMin());
            stm.setInt(6,  p.getQtdMax());
            stm.setInt(7,  p.getQtdAtual());
            stm.setInt(8, p.getTipoDeProduto().getIdTipo());

            stm.executeUpdate();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
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
    public int buscaTipoProd(String tipoDoProduto) {

        String slq = "SELECT * FROM TIPO_PRODUTO WHERE  DESCRICAO_PROD ='" + tipoDoProduto + "'";

        int saida=0;

        try {
            Connection conn = getConexao();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(slq);

            while (rs.next()) {
                saida=(rs.getInt("ID_TIPO_PROD"));
            }
            return saida;  
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            System.err.println(e.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return saida;    
    }
    
    public ArrayList<Produto> buscaProduto(String nomeProduto) {

        String slq = "SELECT ID_PROD, PRODUTO.NOME_PROD AS PRODUTO, VALIDADE_PROD, LOTE, STATUS, QTD_MIN, QTD_MAX, QTD_ATUAL, TIPO_PRODUTO.NOME_PROD AS TIPO FROM PRODUTO" +
        " INNER JOIN TIPO_PRODUTO ON PRODUTO.ID_TIPO_PROD = TIPO_PRODUTO.ID_TIPO_PROD WHERE PRODUTO.NOME_PROD LIKE '%"+nomeProduto+"%' OR PRODUTO.NOME_PROD LIKE '%"+nomeProduto.charAt(0)+"%'";

        try {
            Connection conn = getConexao();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(slq);
            ArrayList<Produto> p = new ArrayList<>();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("ID_PROD"));
                produto.setNome(rs.getString("PRODUTO"));
                produto.setValidade(rs.getString("VALIDADE_PROD"));
                produto.setLote(rs.getString("LOTE"));
                produto.setStatus(rs.getString("STATUS"));
                produto.setQtdMin(rs.getInt("QTD_MIN"));
                produto.setQtdMax(rs.getInt("QTD_MAX"));
                produto.setQtdAtual(rs.getInt("QTD_ATUAL"));
                produto.getTipoDeProduto().setNome(rs.getString("TIPO"));
                p.add(produto);
            }
            
            return p;  
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            System.err.println(e.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;    
    }
    
    
    
}
