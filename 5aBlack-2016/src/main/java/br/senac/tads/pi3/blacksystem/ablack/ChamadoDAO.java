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
        DateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            conn = getConexao();
            String sql = "INSERT INTO CHAMADO(DESCRICAO, STATUS, DATA_ABERTURA, TIPO_SOLICITACAO) VALUES(?, ?, ?, ?)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, chamado.getDescricao());
            stm.setString(2, chamado.getStatus());
            try {
                stm.setDate(3, (Date) formatar.parse(chamado.getDataAbertura()));
            } catch (ParseException ex) {
                Logger.getLogger(ChamadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            stm.setString(4, chamado.getTipoSolicitacao());// TIPO_SOLICITACAO);
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
        DateFormat formatar = new SimpleDateFormat("dd-MM-yyyy");
         
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
                String n = formatar.format(rs.getDate("DATA_ABERTURA"));
                chamado.setTipoSolicitacao(rs.getString("TIPO_SOLICITACAO"));
//                chamado.setDataAbertura(n);
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
