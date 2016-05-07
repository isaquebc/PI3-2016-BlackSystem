/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Rafael
 */
public class AtualizarDAO extends Conexao{

    @Override
    public void deletaCliente(String cpf) throws ClassNotFoundException {
        super.deletaCliente(cpf); //To change body of generated methods, choose Tools | Templates.
        
        Connection con = null;
        PreparedStatement stm = null;
        String sql = "DELETE FROM NOME_CLIENTE WHERE CPF='" + cpf + "'";
        try {
            con = getConexao();
            stm = con.prepareStatement(sql);

            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Ero de conexão");
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }
    }
    
   
    
}
