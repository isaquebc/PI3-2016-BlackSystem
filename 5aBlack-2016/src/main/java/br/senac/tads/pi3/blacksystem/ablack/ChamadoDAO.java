/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import br.senac.tads.pi3.blacksystem.entity.Chamado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import static java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            String sql = "INSERT INTO CHAMADO(DESCRICAO_CHAMADO, TIPO_SOLICITACAO, ID_FUNC, STATUS, DATA_ABERTURA) VALUES(?, ?, ?, 'ABERTO', DATE(CURRENT TIMESTAMP))";
            stm = conn.prepareStatement(sql);
            stm.setString(1, chamado.getDescricao());
            stm.setString(2, chamado.getTipoSolicitacao());// TIPO_SOLICITACAO);
            stm.setInt(3, chamado.getIdFuncionario());
            stm.executeUpdate();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }
    }

    public List listaChamado()
            throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
         
        String listarCharado = "SELECT ID_CHAMADO, TIPO_SOLICITACAO, DATA_ABERTURA, STATUS, FUNCIONARIO.NOME_FUNC, FUNCIONARIO.TEL_FUNC, FILIAL.NOME_FILIAL  FROM CHAMADO" +
        " INNER JOIN FUNCIONARIO ON CHAMADO.ID_FUNC = FUNCIONARIO.ID_FUNC" +
        " INNER JOIN FILIAL ON FILIAL.ID_FILIAL = FUNCIONARIO.ID_FILIAL" +
        " order by STATUS asc";
        
        try {
            
            List<Chamado> lista = new ArrayList();
            conn = getConexao();
            stmt = conn.createStatement(TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(listarCharado);
            
            while (rs.next()) {
                Chamado chamado = new Chamado();
                chamado.setIdChamado(rs.getInt("ID_CHAMADO"));
                chamado.setTipoSolicitacao(rs.getString("TIPO_SOLICITACAO"));
                chamado.setDataAbertura(rs.getString("DATA_ABERTURA"));
                chamado.setStatus(rs.getString("STATUS"));
                chamado.setFuncionario(rs.getString("NOME_FUNC"));
                chamado.setTel(rs.getString("TEL_FUNC"));
                chamado.setDescricao(rs.getString("NOME_FILIAL"));
                lista.add(chamado);
            }
            stmt.close();
            conn.close();
            return lista;

        } catch (SQLException ex) {
            System.out.println(ex.toString());
            ex.getMessage();
            return null;
        } catch (NullPointerException ex) {
            System.out.println("DAO não inicializado");
            ex.getMessage();
            return null;
        }
    }
    
    
    public Chamado listaChamado(int id)
            throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
         
        String listarCharado = "SELECT ID_CHAMADO, TIPO_SOLICITACAO, DATA_ABERTURA, STATUS, FUNCIONARIO.NOME_FUNC, FUNCIONARIO.TEL_FUNC, FILIAL.NOME_FILIAL  FROM CHAMADO" +
        " INNER JOIN FUNCIONARIO ON CHAMADO.ID_FUNC = FUNCIONARIO.ID_FUNC" +
        " INNER JOIN FILIAL ON FILIAL.ID_FILIAL = FUNCIONARIO.ID_FILIAL"+
        " WHERE ID_CHAMADO =" + id;
        
        try {
            conn = getConexao();
            stmt = conn.createStatement(TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(listarCharado);
            Chamado chamado = new Chamado();
            while (rs.next()) {
                chamado.setIdChamado(rs.getInt("ID_CHAMADO"));
                chamado.setTipoSolicitacao(rs.getString("TIPO_SOLICITACAO"));
                chamado.setDataAbertura(rs.getString("DATA_ABERTURA"));
                chamado.setStatus(rs.getString("STATUS"));
                chamado.setFuncionario(rs.getString("NOME_FUNC"));
                chamado.setTel(rs.getString("TEL_FUNC"));
                chamado.setDescricao(rs.getString("NOME_FILIAL"));
            }
            stmt.close();
            conn.close();
            return chamado;

        } catch (SQLException ex) {
            System.out.println(ex.toString());
            ex.getMessage();
            return null;
        } catch (NullPointerException ex) {
            System.out.println("DAO não inicializado");
            ex.getMessage();
            return null;
        }
    }

}
