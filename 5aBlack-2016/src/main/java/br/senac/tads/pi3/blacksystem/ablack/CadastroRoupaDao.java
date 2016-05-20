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
public class CadastroRoupaDao extends Conexao{
    
final String QUERY_INSERT_ROUPA  = "INSERT INTO ROUPA(ID_ROUPA, DESCRICAO, QUANTIDADE, TIPO_PECA, COR, TIPO_TECIDO, ID_PEDIDO, ID_SERVICO)"
                                             + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";    
    public void cadastrarRoupa(int ID_ROUPA, Peca peca, Pedido pedido, Servico serv)
        throws ClassNotFoundException{
        
        Connection conn= null;
        PreparedStatement stm= null;
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_ROUPA);
            stm.setInt(1, ID_ROUPA);
            stm.setString(2, peca.getDescricao());
            //stm.setInt(3, Integer.parseInt(peca.getQdt()));
            stm.setString(4, peca.getTipoPeca());
            stm.setString(5, peca.getCor());
            stm.setString(6, peca.getTipoTecido());
            stm.setLong(7, pedido.getIdPedido());
            stm.setLong(8, serv.getId());
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
