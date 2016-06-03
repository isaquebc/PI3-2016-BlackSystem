    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import br.senac.tads.pi3.blacksystem.entity.Peca;
import br.senac.tads.pi3.blacksystem.entity.Pedido;
import br.senac.tads.pi3.blacksystem.entity.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Rafael
 */
public class ServicoDAO extends Conexao {

    public void cadastrarServico(Servico serv) throws ClassNotFoundException {

        String QUERY_INSERT_SERVICO = "INSERT INTO SERVICO(PRAZO_SERV, TIPO_SERV, VALOR)"
                + "VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_SERVICO);
            stm.setInt(1, Integer.parseInt(serv.getPrazo()));
            stm.setString(2, serv.getTipoServico().toLowerCase());
            stm.setDouble(3, serv.getPreco());

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
