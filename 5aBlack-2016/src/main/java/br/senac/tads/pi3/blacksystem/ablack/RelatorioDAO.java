/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;
import br.senac.tads.pi3.blacksystem.entity.Relatorio;
import java.sql.*;

import java.util.ArrayList;

/**
 *
 * @author miqueas.bsantos1
 */
public class RelatorioDAO extends Conexao{
    
    String  relatorioVendaFuncionarios = "SELECT FUNCIONARIO.ID_FUNC, FUNCIONARIO.NOME_FUNC, FUNCIONARIO.SOBRENOME_FUNC, COUNT(DISTINCT PEDIDO.ID_PEDIDO) AS QTD, FILIAL.NOME_FILIAL, SUM(SERVICO.VALOR_SERV) AS TOTAL\n" +
                                        "FROM PEDIDO INNER JOIN FUNCIONARIO ON FUNCIONARIO.ID_FUNC = PEDIDO.ID_FUNC\n" +
                                        "INNER JOIN FILIAL ON FILIAL.ID_FILIAL = PEDIDO.ID_FILIAL\n" +
                                        "INNER JOIN PECA ON PECA.ID_PEDIDO = PEDIDO.ID_PEDIDO\n" +
                                        "INNER JOIN SERVICO ON SERVICO.ID_SERVICO = PECA.ID_SERVICO\n" +
                                        "GROUP BY FUNCIONARIO.ID_FUNC, FUNCIONARIO.NOME_FUNC, FUNCIONARIO.SOBRENOME_FUNC, FILIAL.NOME_FILIAL;";
    
    
    public ArrayList relatorioVendaFuncionaros(Date inicio, Date fim)
         throws ClassNotFoundException{
        
        Statement stm = null;
        Connection con = null;
        ResultSet rs = null;
        ArrayList<Relatorio> relatorio = new ArrayList<>();
        try {
            con = getConexao();
            stm = con.createStatement();
            rs = stm.executeQuery(relatorioVendaFuncionarios);
            while (rs.next()) {                
                Relatorio r = new Relatorio();
                r.funcionario.setId(rs.getInt("FUNCIONARIO.ID_FUNC"));
                r.funcionario.setNome("FUNCIONARIO.NOME_FUNC");
                r.funcionario.setSobrenome("FUNCIONARIO.SOBRENOME_FUNC");
                r.peca.setQdt(rs.getString("QTD"));
                r.filial.setNome(rs.getString("FILIAL.NOME_FILIAL"));
                r.servico.setPreco(rs.getFloat("TOTAL"));
                relatorio.add(r);
            }
            stm.close();
            con.close();
            return relatorio;
        } catch (SQLException e) {
                System.out.println("Erro de conexao" + e.toString());
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado" + e.toString());
        }
        return null;
    }
}
