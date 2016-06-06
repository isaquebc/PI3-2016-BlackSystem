/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import static br.senac.tads.pi3.blacksystem.ablack.Conexao.getConexao;
import br.senac.tads.pi3.blacksystem.entity.Criptografia;
import br.senac.tads.pi3.blacksystem.entity.Funcionario;
import br.senac.tads.pi3.blacksystem.entity.Usuario;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Miqueas Santos
 */
public class FuncionarioDAO extends Conexao {

    public ArrayList buscarFuncionarios(String cpf) throws ClassNotFoundException {
        Statement stm = null;
        ResultSet rs = null;
        Connection con = null;
        String QUERY_SELECT_FUNCIONARIO = "SELECT FUNCIONARIO.ID_FUNC, FUNCIONARIO.NOME_FUNC, FUNCIONARIO.SOBRENOME_FUNC, FUNCIONARIO.CPF_FUNC, FUNCIONARIO.NASC_FUNC,"
                + " FUNCIONARIO.TEL_FUNC, FUNCIONARIO.CEL_FUNC, FUNCIONARIO.EMAIL_FUNC, ENDERECO_FUNCIONARIO.LOGRADOURO_FUNC,"
                + " ENDERECO_FUNCIONARIO.ESTADO_FUNC, ENDERECO_FUNCIONARIO.CIDADE_FUNC, ENDERECO_FUNCIONARIO.CEP_FUNC"
                + " FROM FUNCIONARIO LEFT JOIN ENDERECO_FUNCIONARIO ON FUNCIONARIO.ID_FUNC = ENDERECO_FUNCIONARIO.ID_FUNC"
                + " WHERE FUNCIONARIO.CPF_FUNC='".concat(cpf) + "'";
        //10485544150
        try {

            con = getConexao();
            stm = con.createStatement();
            rs = stm.executeQuery(QUERY_SELECT_FUNCIONARIO);
            ArrayList<Funcionario> funcionarios = new ArrayList<>();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("ID_FUNC"));
                f.setCpf(rs.getString("NOME_FUNC"));
                f.setSobrenome(rs.getString("SOBRENOME_FUNC"));
                f.setCpf(rs.getString("CPF_FUNC"));
                f.setDataNascimento(rs.getString("NASC_FUNC"));
                f.setTelefone(rs.getString("TEL_FUNC"));
                f.setCelular(rs.getString("CEL_FUNC"));
                f.setEmail(rs.getString("EMAIL_FUNC"));
                f.setRua(rs.getString("LOGRADOURO_FUNC"));
                //f.setNumero(rs.getInt("NUMERO_CLI"));
                f.setEstado(rs.getString("ESTADO_FUNC"));
                f.setCidade(rs.getString("CIDADE_FUNC"));
                f.setCep(rs.getString("CEP_FUNC"));
                funcionarios.add(f);
            }
            con.close();
            rs.close();
            stm.close();
            return funcionarios;
        } catch (SQLException e) {
            System.err.println(e.toString());
        }

        return null;
    }
    
    public Usuario buscarFuncionario(String cpf) throws ClassNotFoundException {
        Statement stm = null;
        ResultSet rs = null;
        Connection con = null;
        String QUERY_SELECT_FUNCIONARIO = "SELECT FUNCIONARIO.ID_FUNC, FUNCIONARIO.NOME_FUNC, FUNCIONARIO.SOBRENOME_FUNC, FUNCIONARIO.CPF_FUNC, FUNCIONARIO.SENHA_FUNC , FUNCIONARIO.NASC_FUNC,"
                + " FUNCIONARIO.SALT, FUNCIONARIO.TEL_FUNC, FUNCIONARIO.CEL_FUNC, FUNCIONARIO.EMAIL_FUNC, ENDERECO_FUNCIONARIO.LOGRADOURO_FUNC,"
                + " ENDERECO_FUNCIONARIO.ESTADO_FUNC, ENDERECO_FUNCIONARIO.CIDADE_FUNC, ENDERECO_FUNCIONARIO.CEP_FUNC"
                + " FROM FUNCIONARIO LEFT JOIN ENDERECO_FUNCIONARIO ON FUNCIONARIO.ID_FUNC = ENDERECO_FUNCIONARIO.ID_FUNC"
                + " WHERE FUNCIONARIO.CPF_FUNC='".concat(cpf) + "'";
        //10485544150
        try {

            con = getConexao();
            stm = con.createStatement();
            rs = stm.executeQuery(QUERY_SELECT_FUNCIONARIO);
            Usuario f = new Usuario();
            if(rs.next()) {
                f.setId(rs.getInt("ID_FUNC"));
                f.setCpf(rs.getString("NOME_FUNC"));
                f.setSobrenome(rs.getString("SOBRENOME_FUNC"));
                f.setCpf(rs.getString("CPF_FUNC"));
                f.setDataNascimento(rs.getString("NASC_FUNC"));
                f.setTelefone(rs.getString("TEL_FUNC"));
                f.setCelular(rs.getString("CEL_FUNC"));
                f.setEmail(rs.getString("EMAIL_FUNC"));
                f.setRua(rs.getString("LOGRADOURO_FUNC"));
                //f.setNumero(rs.getInt("NUMERO_CLI"));
                f.setEstado(rs.getString("ESTADO_FUNC"));
                f.setCidade(rs.getString("CIDADE_FUNC"));
                f.setCep(rs.getString("CEP_FUNC"));
                f.setSalt(rs.getString("SALT").replace(" ", ""));
                f.setHashSenha(rs.getString("SENHA_FUNC"));
            }
            con.close();
            rs.close();
            stm.close();
            return f;
        } catch (SQLException e) {
            System.err.println(e.toString());
        }

        return null;
    }
    

    String QUERY_INSERT_FUNCIORARIO = "insert into FUNCIONARIO(CPF_FUNC, NOME_FUNC,SOBRENOME_FUNC, SEXO_FUNC, NASC_FUNC,TEL_FUNC,"
            + " CEL_FUNC, EMAIL_FUNC, STATUS_FUNC, SENHA_FUNC, CARGO_FUNC, SALARIO_FUNC, ID_FILIAL, SALT)" + "values(?,?,?,?,?,?,?,?,?,?,?, ?, ?, ?)";

    public void cadastrarFuncionario(Funcionario func)
            throws ClassNotFoundException {

        Connection conn = null;
        PreparedStatement stm = null;
        Criptografia  criptografar = new Criptografia();
        Usuario user = new Usuario(func.getHashSenha(), criptografar.convertParaHex());
        
        try {
            conn = getConexao();
            String sql = QUERY_INSERT_FUNCIORARIO;
            stm = conn.prepareStatement(sql);
            stm.setString(1, func.getCpf());
            stm.setString(2, func.getNome());
            stm.setString(3, func.getSobrenome());
            stm.setString(4, func.getSexo());
            stm.setDate(5, new java.sql.Date(1009 - 03 - 03));
            stm.setString(6, func.getTelefone());
            stm.setString(7, func.getCelular());
            stm.setString(8, func.getEmail());
            stm.setString(9, "ATIVO");
            stm.setString(10, criptografar.gerarHashSenhaPBKDF2(user));
            stm.setString(11, func.getCargo());
            stm.setDouble(12, func.getSalario());
            stm.setInt(13, func.getFilial());
            stm.setString(14, user.getSalt());
            stm.executeUpdate();
            
            stm.close();
            conn.close();
        } catch (SQLException | InvalidKeySpecException | NoSuchAlgorithmException e) {
            System.out.println(e.toString());
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }

    }

    public int buscarFilial(String filial)
            throws ClassNotFoundException {

        String query = "SELECT ID_FILIAL FROM FILIAL WHERE CIDADE_FILIAL LIKE '" + filial.toUpperCase() + "'";
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {

            conn = getConexao();
            stm = conn.createStatement();
            rs = stm.executeQuery(query);
            int id = 0;
            if (rs.next()) {
                id = rs.getInt("ID_FILIAL");
            }

            stm.close();
            conn.close();
            rs.close();
            return id;
        } catch (SQLException e) {
            System.err.println(e.toString() + " " + filial);
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }
        return 0;
    }
    
    public void cadastrarEndFuncionario(Funcionario funcionario) throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement preStm = null;
        final String QUERY_INSERT_FUNCIORARIO_END = "INSERT INTO ENDERECO_FUNCIONARIO (LOGRADOURO_FUNC, NUMERO_FUNC, COMPLEMENTO_FUNC, BAIRRO_FUNC, CIDADE_FUNC, ESTADO_FUNC, CEP_FUNC, ID_FUNC) " +
        " VALUES(?, ?, ?, ?, ?, ? , ?, (SELECT ID_FUNC FROM FUNCIONARIO WHERE CPF_FUNC ="+funcionario.getCpf()+"))";
        try {
            conn = getConexao();
            preStm = conn.prepareStatement(QUERY_INSERT_FUNCIORARIO_END);
            
            preStm.setString(1, funcionario.getEndereco().getEndereco());
            preStm.setInt(2, funcionario.getEndereco().getNumero());
            preStm.setString(3, funcionario.getEndereco().getComplemento());
            preStm.setString(4, funcionario.getEndereco().getBairro());
            preStm.setString(5, funcionario.getEndereco().getCidade());
            preStm.setString(6, funcionario.getEndereco().getEstado());
            preStm.setString(7, funcionario.getEndereco().getCep());
            preStm.executeUpdate();
            preStm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

}
