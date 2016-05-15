/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import br.senac.tads.pi3.blacksystem.entity.Cliente;
import br.senac.tads.pi3.blacksystem.entity.Departamento;
import br.senac.tads.pi3.blacksystem.entity.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Rafael
 */
public class PedidoDAO extends Conexao {

    final String QUERY_INSERT_PEDIDO = "PEDIDO(ID_PEDIDO, STATUS, DATA_ENTRADA, DATA_SAIDA, ID_CPF, ID_DPT)"
            + "VALUES (?, ?, ?, ?, ?, ?)";

    public void cadastrarPedido(int ID_PEDIDO, Pedido pedido, Cliente cli, Departamento dep)
            throws ClassNotFoundException {

        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_PEDIDO);
            stm.setInt(1, ID_PEDIDO);
            stm.setString(2, pedido.getStatus());
            stm.setDate(3, new java.sql.Date(pedido.getDataEntrada().getTime()));
            stm.setDate(4, new java.sql.Date(pedido.getDataSaida().getTime()));
            stm.setString(5, cli.getCpf());
            stm.setInt(6, dep.getIdDPT());
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
