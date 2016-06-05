/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;
import br.senac.tads.pi3.blacksystem.entity.RelatorioCliente;
import br.senac.tads.pi3.blacksystem.entity.RelatorioFilial;
import br.senac.tads.pi3.blacksystem.entity.RelatorioFuncionario;
import br.senac.tads.pi3.blacksystem.entity.RelatorioPedido;
import java.sql.*;

import java.util.ArrayList;

/**
 *
 * @author miqueas.bsantos1
 */
public class RelatorioDAO extends Conexao{

    
    
    public ArrayList relatorioVendaFuncionaros(String inicio, String fim)
         throws ClassNotFoundException{
        
        String  relatorioVendaFuncionarios = "SELECT FUNCIONARIO.ID_FUNC, FUNCIONARIO.NOME_FUNC, FUNCIONARIO.SOBRENOME_FUNC, COUNT(DISTINCT PEDIDO.ID_PEDIDO) AS QTD, FILIAL.NOME_FILIAL, cast(SUM(SERVICO.VALOR_SERV) AS NUMERIC(10,2)) AS TOTAL " +
        "FROM PEDIDO INNER JOIN FUNCIONARIO ON FUNCIONARIO.ID_FUNC = PEDIDO.ID_FUNC INNER JOIN FILIAL ON FILIAL.ID_FILIAL = PEDIDO.ID_FILIAL " +
        "INNER JOIN PECA ON PECA.ID_PEDIDO = PEDIDO.ID_PEDIDO " +
        "INNER JOIN SERVICO ON SERVICO.ID_SERVICO = PECA.ID_SERVICO " +
        "where PEDIDO.DATA_ENTRADA >= date('" + inicio + "')  AND PEDIDO.DATA_ENTRADA <= date('" + fim +"') "+
        " GROUP BY FUNCIONARIO.ID_FUNC, FUNCIONARIO.NOME_FUNC, FUNCIONARIO.SOBRENOME_FUNC, FILIAL.NOME_FILIAL";
        
        Statement stm = null;
        Connection con = null;
        ResultSet rs = null;
        ArrayList<RelatorioFuncionario> relatorio = new ArrayList<>();
        try {
            con = getConexao();
            stm = con.createStatement();
            rs = stm.executeQuery(relatorioVendaFuncionarios);
            while (rs.next()) {                
                RelatorioFuncionario r = new RelatorioFuncionario();
                r.setId(rs.getInt("ID_FUNC"));
                r.setNomeFuncionario(rs.getString("NOME_FUNC"));
                r.setSobrenomeFuncionario(rs.getString("SOBRENOME_FUNC"));
                r.setQtd(rs.getInt("QTD"));
                r.setNomeFilial(rs.getString("NOME_FILIAL"));
                r.setValor(rs.getFloat("TOTAL"));
                relatorio.add(r);
            }
            stm.close();
            con.close();
            return relatorio;
        } catch (SQLException e) {
                System.out.println("Erro de conexao" + e.toString());
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado" + e.toString());
        }
        return null;
    }
    
    public ArrayList relatorioPedidosMaisRealizados(String inicio, String fim)
         throws ClassNotFoundException{
        
        String  relatorioPedidosMaisRealizados = "SELECT COUNT(PECA.ID_SERVICO) AS QUANTIDADE, SERVICO.NOME_SERV, SERVICO.TIPO_SERV, SERVICO.PRAZO_SERV, FILIAL.NOME_FILIAL" +
        " FROM PECA INNER JOIN SERVICO ON PECA.ID_SERVICO = SERVICO.ID_SERVICO" +
        " INNER JOIN PEDIDO ON PEDIDO.ID_PEDIDO = PECA.ID_PEDIDO" +
        " INNER JOIN FILIAL ON PEDIDO.ID_FILIAL = FILIAL.ID_FILIAL"+
        " where PEDIDO.DATA_ENTRADA >= date('"+inicio+"') and" +
        " PEDIDO.DATA_ENTRADA <= date('"+fim+"')" +
        " GROUP BY PECA.ID_SERVICO, SERVICO.TIPO_SERV, SERVICO.PRAZO_SERV, SERVICO.NOME_SERV, FILIAL.NOME_FILIAL" +
        " ORDER BY COUNT(PECA.ID_SERVICO) DESC";
        
        Statement stm = null;
        Connection con = null;
        ResultSet rs = null;
        ArrayList<RelatorioPedido> relatorio = new ArrayList<>();
        try {
            con = getConexao();
            stm = con.createStatement();
            rs = stm.executeQuery(relatorioPedidosMaisRealizados);
            while (rs.next()) {                
                RelatorioPedido r = new RelatorioPedido();
                r.setQtd(rs.getInt("QUANTIDADE"));
                r.setNomeServico(rs.getString("NOME_SERV"));
                r.setTipoServico(rs.getString("TIPO_SERV"));
                r.setPrazo(rs.getInt("PRAZO_SERV"));
                r.setNomeFilial(rs.getString("NOME_FILIAL"));
                relatorio.add(r);
            }
            stm.close();
            con.close();
            return relatorio;
        } catch (SQLException e) {
                System.out.println("Erro de conexao" + e.toString());
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado" + e.toString());
        }
        return null;
    }
    
    
    public ArrayList relatorioDeFilial(String inicio, String fim)
         throws ClassNotFoundException{
        
        String  relatorioFilial = "SELECT FILIAL.ID_FILIAL, FILIAL.NOME_FILIAL, FILIAL.CIDADE_FILIAL, FILIAL.TEL_FIFLIAL, COUNT(DISTINCT PEDIDO.ID_PEDIDO) AS QTD, cast(SUM(SERVICO.VALOR_SERV) AS NUMERIC(10,2)) AS TOTAL " +
        " FROM FILIAL INNER JOIN PEDIDO ON PEDIDO.ID_FILIAL = FILIAL.ID_FILIAL" +
        " INNER JOIN PECA ON PECA.ID_PEDIDO = PEDIDO.ID_PEDIDO" +
        " INNER JOIN SERVICO ON PECA.ID_SERVICO = SERVICO.ID_SERVICO" +
        " where PEDIDO.DATA_ENTRADA >= date('"+inicio+"') and" +
        " PEDIDO.DATA_ENTRADA <= date('"+fim+"')" +
        " GROUP BY FILIAL.ID_FILIAL, FILIAL.NOME_FILIAL, FILIAL.CIDADE_FILIAL, FILIAL.TEL_FIFLIAL";
        
        Statement stm = null;
        Connection con = null;
        ResultSet rs = null;
        ArrayList<RelatorioFilial> relatorio = new ArrayList<>();
        try {
            con = getConexao();
            stm = con.createStatement();
            rs = stm.executeQuery(relatorioFilial);
            while (rs.next()) {                
                RelatorioFilial r = new RelatorioFilial();
                r.setIdFilial(rs.getInt("ID_FILIAL"));
                r.setNome(rs.getString("NOME_FILIAL"));
                r.setCidade(rs.getString("CIDADE_FILIAL"));
                r.setTelefone(rs.getString("TEL_FIFLIAL"));
                r.setPedidos(rs.getInt("QTD"));
                r.setValor(rs.getDouble("TOTAL"));
                relatorio.add(r);
            }
            stm.close();
            con.close();
            return relatorio;
        } catch (SQLException e) {
                System.out.println("Erro de conexao" + e.toString());
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado" + e.toString());
        }
        return null;
    }
    
        public ArrayList relatorioDeCliente(String inicio, String fim)
         throws ClassNotFoundException{
        
        String  relatorioPedidoCliente = "SELECT CLIENTE.ID_CLIENTE, CLIENTE.NOME_CLIENTE, CLIENTE.SOBRENOME_CLIENTE, CLIENTE.EMAIL_CLIENTE, CLIENTE.TEL_CLIENTE, COUNT(DISTINCT PEDIDO.ID_PEDIDO) AS QTD, cast(SUM(SERVICO.VALOR_SERV) AS NUMERIC(10,2)) AS TOTAL, FILIAL.NOME_FILIAL" +
        " FROM CLIENTE INNER JOIN PEDIDO ON PEDIDO.ID_CLIENTE = CLIENTE.ID_CLIENTE" +
        " INNER JOIN PECA ON PECA.ID_PEDIDO = PEDIDO.ID_PEDIDO" +
        " INNER JOIN SERVICO ON SERVICO.ID_SERVICO = PECA.ID_SERVICO" +
        " INNER JOIN FILIAL ON FILIAL.ID_FILIAL = PEDIDO.ID_FILIAL" +
        " where PEDIDO.DATA_ENTRADA >= date('"+ inicio +"') and" +
        " PEDIDO.DATA_ENTRADA <= date('"+ fim +"')" +
        " GROUP BY CLIENTE.ID_CLIENTE, CLIENTE.NOME_CLIENTE, CLIENTE.SOBRENOME_CLIENTE, CLIENTE.EMAIL_CLIENTE, CLIENTE.TEL_CLIENTE, FILIAL.NOME_FILIAL" +
        " ORDER BY SUM(SERVICO.VALOR_SERV) DESC";
        
        Statement stm = null;
        Connection con = null;
        ResultSet rs = null;
        ArrayList<RelatorioCliente> relatorio = new ArrayList<>();
        try {
            con = getConexao();
            stm = con.createStatement();
            rs = stm.executeQuery(relatorioPedidoCliente);
            while (rs.next()) {                
                RelatorioCliente r = new RelatorioCliente();
                r.setId(rs.getInt("ID_CLIENTE"));
                r.setNome(rs.getString("NOME_CLIENTE"));
                r.setSobrenome(rs.getString("SOBRENOME_CLIENTE"));
                r.setEmail(rs.getString("EMAIL_CLIENTE"));
                r.setTelefone(rs.getString("TEL_CLIENTE"));
                r.setPedidos(rs.getInt("QTD"));
                r.setTotal(rs.getDouble("TOTAL"));
                r.setFilial(rs.getString("NOME_FILIAL"));
                relatorio.add(r);
            }
            stm.close();
            con.close();
            return relatorio;
        } catch (SQLException e) {
                System.out.println("Erro de conexao" + e.toString());
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado" + e.toString());
        }
        return null;
    }
    
    
}