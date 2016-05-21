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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Rafael
 */
public class PedidoDAO extends Conexao {

    String QUERY_INSERT_PEDIDO = "INSERT INTO PEDIDO( STATUS, DATA_ENTRADA, DATA_SAIDA, ID_FUNC, ID_CLIENTE, ID_FILIAL)"
            + "VALUES (?, ?, ?, ?, ?, ?)";

    String QUERY_INSERT_PECA = "INSERT INTO PECA(QTD_PECA, TIPO_PECA,COR_PECA, TIPO_TECIDO,ID_PEDIDO,ID_SERVICO)" + "(?,?,?,?,?,?)";

    public void cadastrarPedido(Pedido ped, ArrayList<Peca> pecas, Cliente cliente, Funcionario funcionario)
            throws ClassNotFoundException {

        Connection conn = null;
        PreparedStatement stm = null;

        Statement stmt = null;
        ResultSet rs = null;
        Integer idPedido=0;
        /*=================================================================
         Aqui inserimos o pedido no banco, fazendo assim ele gerar um ID
         ====================================================================*/
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_PEDIDO);
            stm.setString(1, "ABERTO");
            stm.setDate(2, new java.sql.Date(1009 - 03 - 03));
            stm.setDate(3, java.sql.Date.valueOf(ped.getDataSaida()));
            stm.setInt(4, funcionario.getId());
            stm.setInt(5, cliente.getId());
            stm.executeUpdate();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro de conexão");
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }
        /*=================================================================
         Inseriu o pedido no banco
         ====================================================================*/
        try {
            String pesqIdServ = "SELECT ID_PEDIDO FROM PEDIDO WHERE NOME_SERV ='" + cliente.getCpf() + "'";
            conn = getConexao();
            stmt = conn.createStatement();
            stmt.executeQuery(pesqIdServ);
            rs.last();
            idPedido = (rs.getInt("ID_PEDIDO"));
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("erro ao conectar com o banco");
            ex.getMessage();
        } catch (NullPointerException ex) {
            System.out.println("DAO não inicializado");
            ex.getMessage();
        }
        /*=================================================================
         Aqui ele gera o loop para adicionar todas as peças. Porem, antes ele peda o ID do serviço
         ====================================================================*/
        for (Peca peca : pecas) {
            Integer idServico = 0;
            try {
                String pesqIdServ = "SELECT ID_SERVICO FROM SERVICO WHERE NOME_SERV ='" + peca.getNomeServico() + "'";
                conn = getConexao();
                stmt = conn.createStatement();
                stmt.executeQuery(pesqIdServ);
                idServico = (rs.getInt("ID_SERVICO"));
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println("erro ao conectar com o banco");
                ex.getMessage();
            } catch (NullPointerException ex) {
                System.out.println("DAO não inicializado");
                ex.getMessage();
            }

            /*percorre a lista de pecas cadastraas e inseri no banco*/
            try {
                conn = getConexao();
                stm = conn.prepareStatement(QUERY_INSERT_PECA);
                stm.setInt(1, Integer.parseInt(peca.getQdt()));
                stm.setString(2, peca.getTipoPeca());
                stm.setString(3, peca.getTipoTecido());
                stm.setInt(4, idPedido);
                stm.setInt(5, idServico);
                stm.executeUpdate();
                stm.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println("Erro de conexão");
            } catch (NullPointerException e) {
                System.out.println("Dao não inicializado");
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
