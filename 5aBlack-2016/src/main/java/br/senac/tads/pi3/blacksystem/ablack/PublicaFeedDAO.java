/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import br.senac.tads.pi3.blacksystem.entity.FeedNoticias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Rafael
 */
public class PublicaFeedDAO extends Conexao{
    final String QUERY_INSERT_FEED         = "INSERT INTO FEED_NOTICIAS(ID_FEED, DESCRICAO, DATA_POSTADO, TITULO, ID_FUNCIONARIO)"
                                             + "VALUES(?, ?, ?, ?, ?);";
    
    public void cadastrarFeedNoticias(FeedNoticias feed)
        throws ClassNotFoundException{
        
        Connection conn=null;
        PreparedStatement stm= null;
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_FEED);
            stm.setInt(1, feed.getId());
            stm.setString(2, feed.getDescricao());
            stm.setDate(3, new java.sql.Date(feed.getDataPostagem().getTime()));
            stm.setString(4, feed.getTitulo());
            stm.setInt(5, feed.getIdFuncionario());
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
