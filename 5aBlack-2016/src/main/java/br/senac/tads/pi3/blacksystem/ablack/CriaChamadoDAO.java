/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import br.senac.tads.pi3.blacksystem.entity.Chamado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Rafael
 */
public class CriaChamadoDAO extends Conexao{
    
        public void cadastrarChamado(Chamado chamado)
        throws ClassNotFoundException{
            
            Connection conn=null;
            PreparedStatement stm =null;
        try {
            conn = getConexao();
            String sql = "INSERT INTO CHAMADO(DESCRICAO, STATUS, TIPO_SOLICITACAO) VALUES(?, ?, ?)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, chamado.getDescricao());
            stm.setString(2, chamado.getStatus());
            stm.setString(3, chamado.getTipoSolicitacao());// TIPO_SOLICITACAO);
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
