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
public class ServicoDAO extends Conexao{
    
    final String QUERY_INSERT_SERVICO      = "INSERT INTO SERVICO(ID_SERVICO, TIPO_DE_SERVICO, VALOR, PRAZO)"
                                             + "VALUES (?, ?, ?, ?)";    
    
          public void cadastrarServico( Servico serv)
        throws ClassNotFoundException{
         Connection conn=null;
         PreparedStatement stm= null;
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_SERVICO);
            stm.setLong(1, serv.getId());
            stm.setString(2, serv.getTipoServico());
            stm.setDouble(3,serv.getPreco() );
            stm.setString(4, serv.getPrazo());
            
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
