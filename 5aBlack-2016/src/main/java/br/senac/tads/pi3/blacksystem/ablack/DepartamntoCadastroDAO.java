/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import br.senac.tads.pi3.blacksystem.entity.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Rafael
 */
public class DepartamntoCadastroDAO extends Conexao {

    final String QUERY_INSERT_DEPARTAMENTO = "INSERT INTO DEPARTAMENTO(ID_DPT, NOME, ENDERECO, CIDADE, TEL, CEP, ESTADO)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";

    public void cadastrarDepartamento(Departamento dep)
            throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {

            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_DEPARTAMENTO);
            stm.setInt(1, dep.getIdDPT());
            stm.setString(2, dep.getNome());
            stm.setString(3, dep.getEndereco());
            stm.setString(4, dep.getCidade());
            stm.setString(5, dep.getTel());
            stm.setString(6, dep.getCep());
            stm.setString(7, dep.getEstado());
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
