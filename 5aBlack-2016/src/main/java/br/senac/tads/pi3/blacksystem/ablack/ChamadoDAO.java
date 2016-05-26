/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import br.senac.tads.pi3.blacksystem.entity.Chamado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class ChamadoDAO extends Conexao {

    public void cadastrarChamado(Chamado chamado)
            throws ClassNotFoundException {

        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = getConexao();
            String sql = "INSERT INTO CHAMADO(DESCRICAO, STATUS, TIPO_SOLICITACAO) VALUES(?, ?, ?)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, chamado.getDescricao());
            stm.setString(2, chamado.getStatus());
            stm.setString(3, chamado.getTipoSolicitacao());// TIPO_SOLICITACAO);
            stm.executeUpdate();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro de conexão");
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }
    }

    public List listaChamado()
            throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement stmt = null;
         ResultSet rs = null;

        String listarCharado = "SELECT ID_CHAMADO, STATUS, DATA_ABERTURA, TIPO_SOLICITACAO FROM CHAMADO WHERE STATUS ='aberto'";
        
        try {
            
            List lista = new ArrayList();
            conn = getConexao();
            stmt = conn.createStatement(TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(listarCharado);
            
            while (rs.next()) {
                Chamado chamado = new Chamado();
                chamado.setIdChamado(rs.getInt("ID_CHAMADO"));
                chamado.setStatus(rs.getString("STATUS"));
                chamado.setDataAbertura(rs.getString("DATA_ABERTURA"));
                chamado.setTipoSolicitacao(rs.getString("TIPO_SOLICITACAO"));
                lista.add(chamado);
            }
            stmt.close();
            conn.close();
            return lista;

        } catch (SQLException ex) {
            System.out.println("erro ao conectar com o banco");
            ex.getMessage();
            return null;
        } catch (NullPointerException ex) {
            System.out.println("DAO não inicializado");
            ex.getMessage();
            return null;
        }
        
    }

}
