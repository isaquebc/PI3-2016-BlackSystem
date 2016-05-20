/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import br.senac.tads.pi3.blacksystem.entity.Cliente;
import br.senac.tads.pi3.blacksystem.entity.Departamento;
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

    String QUERY_INSERT_PEDIDO = "INSERT INTO PEDIDO( STATUS, DATA_ENTRADA, DATA_SAIDA, ID_CPF, ID_DPT)"
            + "VALUES (?, ?, ?, ?, ?)";

    String QUERY_INSERT_PECA = "INSERT INTO PECA(QTD_PECA, TIPO_PECA,COR_PECA, TIPO_TECIDO,ID_PEDIDO,ID_SERVICO)" + "(?,?,?,?,?)";

    public void cadastrarPedido(Pedido ped, ArrayList<Peca> peca, Cliente cli, Servico serv)
            throws ClassNotFoundException {

        String pesqIdServ = "SELECT ID_SERVICO WHERE NOME_SERV ='" + serv.getTipoServico() + "'";
        Connection conn = null;
        PreparedStatement stm = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            
            conn = getConexao();
            stmt = conn.createStatement();
            stmt.executeQuery(pesqIdServ);
            rs.first();
            serv.setId(rs.getInt("ID_SERVICO"));

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("erro ao conectar com o banco");
            ex.getMessage();
        } catch (NullPointerException ex) {
            System.out.println("DAO não inicializado");
            ex.getMessage();
        }

        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_PEDIDO);
            stm.setString(1, "ABERTO");
            stm.setDate(2, new java.sql.Date(1009 - 03 - 03));
            stm.setDate(3, java.sql.Date.valueOf(ped.getDataSaida()));
            stm.setString(4, cli.getCpf());
            stm.setInt(5, 1);

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