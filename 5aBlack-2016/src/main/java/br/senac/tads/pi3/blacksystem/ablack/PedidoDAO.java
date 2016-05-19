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

String QUERY_INSERT_PEDIDO = "PEDIDO( STATUS, DATA_ENTRADA, DATA_SAIDA, ID_CPF, ID_DPT)"
            + "VALUES (?, ?, ?, ?, ?)";

    public void cadastrarPedido(Pedido pedido, Cliente cli)
            throws ClassNotFoundException {

        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_PEDIDO);
            stm.setString(1, "ABERTO");
            stm.setDate(2,new java.sql.Date(1009 - 03 - 03));
            stm.setDate(3,java.sql.Date.valueOf(pedido.getDataSaida()));
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
