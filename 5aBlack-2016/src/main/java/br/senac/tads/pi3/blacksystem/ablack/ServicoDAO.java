    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import static br.senac.tads.pi3.blacksystem.ablack.Conexao.getConexao;
import br.senac.tads.pi3.blacksystem.entity.Peca;
import br.senac.tads.pi3.blacksystem.entity.Pedido;
import br.senac.tads.pi3.blacksystem.entity.Produto;
import br.senac.tads.pi3.blacksystem.entity.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class ServicoDAO extends Conexao {

    public void cadastrarServico(Servico serv) throws ClassNotFoundException {

        String QUERY_INSERT_SERVICO = "INSERT INTO SERVICO(NOME_SERV, TIPO_SERV, VALOR_SERV, PRAZO_SERV)"
                + "VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_SERVICO);
            stm.setString(1, serv.getNomeServico());
            stm.setString(2, serv.getTipoServico());
            stm.setDouble(3, serv.getValorServico());
            stm.setInt(4, serv.getPrazo());
            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }finally{
            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ArrayList<Servico> buscarServico(Servico serv) throws ClassNotFoundException{
        
        String QUERY_BUSCAR_SERVICO = "select ID_SERVICO, NOME_SERV, TIPO_SERV, VALOR_SERV, PRAZO_SERV from SERVICO where " +
        " NOME_SERV like '%"+ serv.getNomeServico().charAt(0) +"%' OR " +
        " TIPO_SERV like '%"+serv.getTipoServico().charAt(0)+"%' OR  " +
        " NOME_SERV = '"+serv.getNomeServico()+"' OR " +
        " TIPO_SERV = '"+serv.getTipoServico()+"'" +
        " ORDER BY VALOR_SERV DESC";
        
        ResultSet rs = null;
        Connection conn = null;
        Statement stm = null;
        
        try {
            conn = getConexao();
            stm = conn.createStatement();
            rs = stm.executeQuery(QUERY_BUSCAR_SERVICO);
            ArrayList<Servico> servicos = new ArrayList<>();
            while (rs.next()) {                
                Servico s = new Servico(
                        rs.getString("NOME_SERV"),
                        rs.getString("TIPO_SERV"),
                        rs.getFloat("VALOR_SERV"),
                        rs.getInt("PRAZO_SERV"),
                        rs.getInt("ID_SERVICO")
                );
                
//                s.setNomeServico(rs.getString("NOME_SERV"));
//                s.setTipoServico(rs.getString("TIPO_SERV"));
//                s.setValorServico(rs.getFloat("VALOR_SERV"));
//                s.setPrazo(rs.getInt("PRAZO_SERV"));
                servicos.add(s);                
            }
            rs.close();
            stm.close();
            conn.close();
            return servicos;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
            
        }
        return null;
    }
    
    public void servicoAtualizar(Servico s) throws ClassNotFoundException {
        String sql = "UPDATE SERVICO SET NOME_SERV='"+s.getNomeServico()+"' ,TIPO_SERV='"+s.getTipoServico()+"', VALOR_SERV="+s.getValorServico()+", PRAZO_SERV="+s.getPrazo()+" WHERE ID_SERVICO ="+s.getId();
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
    
    public ArrayList<Servico> buscarServico() throws ClassNotFoundException{
        
        String QUERY_BUSCAR_SERVICO = "SELECT * FROM SERVICO";
        
        ResultSet rs = null;
        Connection conn = null;
        Statement stm = null;
        
        try {
            conn = getConexao();
            stm = conn.createStatement();
            rs = stm.executeQuery(QUERY_BUSCAR_SERVICO);
            ArrayList<Servico> servicos = new ArrayList<>();
            while (rs.next()) {                
                Servico s = new Servico(
                        rs.getString("NOME_SERV"),
                        rs.getString("TIPO_SERV"),
                        rs.getFloat("VALOR_SERV"),
                        rs.getInt("PRAZO_SERV"),
                        rs.getInt("ID_SERVICO")
                );
                
//                s.setNomeServico(rs.getString("NOME_SERV"));
//                s.setTipoServico(rs.getString("TIPO_SERV"));
//                s.setValorServico(rs.getFloat("VALOR_SERV"));
//                s.setPrazo(rs.getInt("PRAZO_SERV"));
                servicos.add(s);                
            }
            rs.close();
            stm.close();
            conn.close();
            return servicos;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
            
        }
        return null;
    }
    
    
}
