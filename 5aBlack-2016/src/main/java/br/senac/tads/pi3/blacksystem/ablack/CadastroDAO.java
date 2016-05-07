/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Rafael
 */
public class CadastroDAO extends Conexao{
    
    final String QUERY_INSERT_DEPARTAMENTO = "INSERT INTO DEPARTAMENTO(ID_DPT, NOME, ENDERECO, CIDADE, TEL, CEP, ESTADO)"
                                             + "VALUES (?, ?, ?, ?, ?, ?, ?);";
    final String QUERY_INSERT_CLIENTE      = "INSERT INTO CLIENTE( ID_CPF, NOME, SOBRENOME, DATANASC, TEL, EMAIL, DATA_ENTRADA, STATUS, ID_DPT)"
                                             + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    final String QUERY_INSERT_FUNCIORARIO  = "INSERT INTO FUNCIONARIO(ID_FUNCIONARIO, SENHA, CARGO, SALARIO, ID_CPF )"
                                             + "VALUES (? , ?, ?, ?, ?);";
    final String QUERY_INSERT_ENDERECO     =  "INSERT INTO ENDERECO(ID_ENDERECO, ENDERECO, COMPLEMENTO, BAIRRO, CIDADE, ESTADO, CEP, ID_CPF)"
                                             + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    final String QUERY_INSERT_PEDIDO       = "PEDIDO(ID_PEDIDO, STATUS, DATA_ENTRADA, DATA_SAIDA, ID_FUNCIONARIO, ID_CPF, ID_DPT)"
                                             + "VALUES (?, ?, ?, ?, ?, ?, ?);";
    final String QUERY_INSERT_SERVICO      = "INSERT INTO SERVICO(ID_SERVICO, TIPO_DE_SERVICO, VALOR, PRAZO)"
                                             + "VALUES (?, ?, ?, ?);";
    final String QUERY_INSERT_ROUPA        = "INSERT INTO ROUPA(ID_ROUPA, DESCRICAO, QUANTIDADE, TIPO_PECA, COR, TIPO_TECIDO, ID_PEDIDO, ID_SERVICO)"
                                             + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    final String QUERY_INSERT_CHAMADO      = "INSERT INTO CHAMADO(ID_CHAMADO, DESCRICAO, STATUS, DATA_ABERTURA, DATA_BAIXADA, TIPO_SOLICITACAO, ID_FUNCIONARIO)"
                                             + "VALUES (?, ?, ?, ?, ?, ?, ?);";
    final String QUERY_INSERT_TRATATIVA    = "INSERT INTO TRATATIVA_CHAMADO(ID_TRATATIVA, DATA_FECHAMENTO, DESCRICAO, ID_CHAMADO, ID_FUNCIONARIO)"
                                             + "VALUES (?, ?, ?, ?, ?);";
    final String QUERY_INSERT_FEED         = "INSERT INTO FEED_NOTICIAS(ID_FEED, DESCRICAO, DATA_POSTADO, TITULO, ID_FUNCIONARIO)"
                                             + "VALUES(?, ?, ?, ?, ?);";
    final String QUERY_INSERT_PRODUTO      = "INSERT INTO PRODUTO(ID_PRODUTO, NOME, VALIDADE, LOTE, STATUS, MIN_QTD, MAX_QTD, QUANTIDADE, ID_TIPO, ID_DPT, ID_FUNCIONARIO)"
                                             + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    final String QUERY_INSERT_MOVIMENTO    = "INSERT INTO MOVIMENTO(ID_MOVIMENTO, DATA_MOV, TIPO_MOVIMENTO, QUANTIDADE, DESCRICAO, ID_PRODUTO, ID_FUNCIONARIO)"
                                             + "VALUES(?, ?, ?, ?, ?, ?, ?);";
    final String QUERY_INSERT_TIPO_PRODUTO = "INSERT INTO TIPO_PRODUTO(ID_TIPO, NOME, DESCRICAO)"
                                             + "VALUES (?, ?, ?);";
    final String QUERY_INSERT_ALTERACAO    = "NÃO DEFINIDO AINDA";
    
    private PreparedStatement stm = null;
    private Connection conn = null;
    
    
    
    public void cadastrarDepartamento(int id_dpt, String nome, String endereco, String cidade, String telefone, String cep, String estado)
    throws ClassNotFoundException{
         try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_DEPARTAMENTO);
            stm.setInt(1, id_dpt);
            stm.setString(2, nome);
            stm.setString(3, endereco);
            stm.setString(4, cidade);
            stm.setString(5, telefone);
            stm.setString(6, cep);
            stm.setString(7, estado);
            stm.executeQuery();
            stm.close();
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("Erro de conexão");
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }
        
    }
    
    public void cadatrarPessoa(String cpf, String nome, String sobrenome, Date nasc , String telefone, String email, Date dataEntrada, String status, int id_dpt) 
        throws ClassNotFoundException {
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_CLIENTE);
            stm.setString(1, cpf);
            stm.setString(2, nome);
            stm.setString(3, sobrenome);
            stm.setDate(4, new java.sql.Date(nasc.getTime()));
            stm.setString(5, telefone);
            stm.setString(6, email);
            stm.setDate(7, new java.sql.Date(dataEntrada.getTime()));
            stm.setString(8, status);
            stm.setInt(9, id_dpt);
            stm.executeQuery();
            stm.close();
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("Erro de conexão: Cadastro do cliente");
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado: Cadastro do cliente");
        }
    }
    
    public void cadastrarFuncionario(int id_funcionario, String senha, String cargo, float salario, String cpf)
        throws ClassNotFoundException{
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_FUNCIORARIO);
            stm.setInt(1, id_funcionario);
            stm.setString(2, senha);
            stm.setString(3, cargo);
            stm.setFloat(4, salario);
            stm.setString(5, cpf);
            stm.executeQuery();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro de conexão");
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }
        
    }
    
    public void cadastrarEndereco(int id_end, String endereco, String complemento, String bairro, String cidade, String estado, String cep, String cpf)
        throws ClassNotFoundException{
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_FUNCIORARIO);
            stm.setInt(1, id_end);
            stm.setString(2, endereco);
            stm.setString(3, complemento);
            stm.setString(4, bairro);
            stm.setString(5, cidade);
            stm.setString(6, estado);
            stm.setString(7, cep);
            stm.setString(8, cpf);
            stm.executeQuery();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro de conexão");
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }
    }
    
    public void pedido(int ID_PEDIDO, String STATUS, Date DATA_ENTRADA, Date DATA_SAIDA, int ID_FUNCIONARIO, String ID_CPF, int ID_DPT)
        throws ClassNotFoundException{
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_FUNCIORARIO);
            stm.setInt(1, ID_PEDIDO);
            stm.setString(2, STATUS);
            stm.setDate(3, new java.sql.Date(DATA_ENTRADA.getTime()));
            stm.setDate(4, new java.sql.Date(DATA_SAIDA.getTime()));
            stm.setInt(5, ID_FUNCIONARIO);
            stm.setString(6, ID_CPF);
            stm.setInt(7, ID_DPT);
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
