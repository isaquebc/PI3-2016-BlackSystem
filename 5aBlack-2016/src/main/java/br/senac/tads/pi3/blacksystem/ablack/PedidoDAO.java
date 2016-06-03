/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import br.senac.tads.pi3.blacksystem.entity.*;
import br.senac.tads.pi3.blacksystem.entity.Peca;
import br.senac.tads.pi3.blacksystem.entity.Pedido;
import br.senac.tads.pi3.blacksystem.entity.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class PedidoDAO extends Conexao {
//, funcionario , ID_FILIAL, DATA_SAIDA,

  
 /*=================================================================
         Aqui inserimos o pedido no banco, fazendo assim ele gerar um ID
         ====================================================================*/
//    public void cadastrarPedido(Cliente cliente)//, Funcionario funcionario, 
//            throws ClassNotFoundException {
//
//        Connection conn = null;
//        PreparedStatement stm = null;
//      
//      
//        try {
//            String QUERY_INSERT_PEDIDO = "INSERT IN TO PEDIDO( STATUS, DATA_ENTRADA, ID_CLIENTE)"+ "VALUES (?, ?, ?)";
//
//            conn = getConexao();
//            stm = conn.prepareStatement(QUERY_INSERT_PEDIDO);
//            
//            stm.setString(1, "ABERTO");
//            stm.setDate(2, new java.sql.Date(1009 - 03 - 03));
//            stm.setInt(3, 3);
//            stm.executeUpdate();
//            stm.close();
//            conn.close();
//        } catch (SQLException e) {
//            System.out.println("Erro de conexão");
//        } catch (NullPointerException e) {
//            System.out.println("Dao não inicializado");
//        }
//    }

    /*=================================================================
     Inseriu o pedido no banco 
     ====================================================================*/
    public int consultaPedido(Pedido ped, Cliente cli) throws ClassNotFoundException {
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            conn = getConexao();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * FROM PEDIDO WHERE ID_CLIENTE ='1'");

            while(rs.next()){
            ped.setIdPedido(rs.getInt("ID_PEDIDO"));
            }
            stm.close();
            conn.close();

            return ped.getIdPedido();
        } catch (SQLException ex) {
            System.out.println("erro ao conectar com o banco");
            System.out.println(ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("DAO não inicializado");
            ex.getMessage();
        }
        return 0;
    }
    /*=================================================================
     Aqui ele gera o loop para adicionar todas as peças. Porem, antes ele peda o ID do serviço
     ====================================================================*/

    public int consultaServ(Servico serv) {

        Connection conn = null;
        Statement stm = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String pesqIdServ = "SELECT ID_SERVICO FROM SERVICO WHERE NOME_SERV ='Lavagem Simples'";
        try {
            conn = getConexao();
            stm = conn.createStatement();
            rs = stm.executeQuery(pesqIdServ);

            rs.next();
            serv.setId(rs.getInt("ID_SERVICO"));

            stm.close();
            conn.close();
            return serv.getId();

        } catch (SQLException ex) {
            System.out.println("erro ao conectar com o banco");
            System.out.println(ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("DAO não inicializado");
            ex.getMessage();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void setPecas(ArrayList<Peca> pecas) {
        Connection conn = null;
        Statement stm = null;
        String sql = "INSERT INTO PECA(QTD_PECA,TIPO_PECA,COR_PECA,TIPO_TECIDO,ID_PEDIDO,ID_SERVICO)";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Pedido ped = new Pedido();
        Cliente cli = new Cliente();
        Servico serv = new Servico();

        for (Peca peca : pecas) {
            try {
                conn=getConexao();
                serv.setId(consultaPedido(ped, cli));

                conn.prepareStatement(sql);
                pstm.setInt(1, Integer.parseInt(peca.getQdt()));
                pstm.setString(2, (peca.getTipoPeca()));
                pstm.setString(3, (peca.getCor()));
                pstm.setString(4, peca.getTipoTecido());
                pstm.setInt(5, (ped.getIdPedido()));
                pstm.setInt(6, serv.getId());
                pstm.executeUpdate();
                pstm.close();
                conn.close();

            } catch (SQLException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}

//String sqlInsert = "insert into MOVIMENTACAO_ENTRADA (id_entrada, id_produto, id_vendedor,data_chegada, qtd) values (?,?,?,?,?)";
//        String sqlUpdate = "update produto set QTD_ESTOQUE=? where ID_PRODUTO=?";
//        conecta.conexao();
//
//        try {
//            /**
//             * prepareStatement receberá como parametro a String com comando SQL
//             */
//            pst = conecta.conn.prepareStatement(sqlInsert);
//            pst1 = conecta.conn.prepareStatement(sqlUpdate);
//            /**
//             * Percorrendo ArrayList do tipo Entrada, para inserir as
//             * informações na tabela do BD movimentação_entrada
//             */
//            for (Entrada e : colecao) {
//                pst.setInt(1, e.getIdEntrada());
//                pst.setInt(2, e.getIdProduto());
//                pst.setInt(3, codigoVendedor = buscarCodigoVendedor(e.getIdVendedor()));
//                pst.setString(4, e.getDataChegada());
//                pst.setInt(5, e.getQtdItem());
//                pst.executeUpdate();
//                /**
//                 * Atualizando no BD a quantidade atual do estoque dos produtos
//                 */
//                pst1.setInt(1, e.getSomaQtd());
//                pst1.setInt(2, e.getIdProduto());
//                pst1.executeUpdate();
//            }
