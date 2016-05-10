/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;
import br.senac.tads.pi3.blacksystem.entity.Cliente;
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
    
    public void cadatrarPessoa(Cliente cli,Date dataEntrada,int id_dpt)throws ClassNotFoundException {
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_CLIENTE);
            stm.setString(1, cli.getCpf());
            stm.setString(2, cli.getNome());
            stm.setString(3, cli.getSobrenome());
            stm.setDate(4, new java.sql.Date(cli.getNasc().getTime()));
            stm.setString(5, cli.getTelefone());
            stm.setString(6, cli.getEmail());
            stm.setDate(7, new java.sql.Date(dataEntrada.getTime()));
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
    
    public void cadastrarEndereco(Cliente cli,int id_end, String endereco, String complemento, String bairro, String cidade, String estado, String cep, String cpf)
        throws ClassNotFoundException{
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_ENDERECO);
            stm.setInt(1, id_end);
            stm.setString(2, endereco);
            stm.setString(3, complemento);
            stm.setString(4, bairro);
            stm.setString(5, cidade);
            stm.setString(6, estado);
            stm.setString(7, cep);
            stm.setString(8, cli.getCpf());
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
            stm = conn.prepareStatement(QUERY_INSERT_PEDIDO);
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
    
    public void sevico(int ID_SERVICO, String TIPO_DE_SERVICO, float VALOR, String PRAZO)
        throws ClassNotFoundException{
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_SERVICO);
            stm.setInt(1, ID_SERVICO);
            stm.setString(2, TIPO_DE_SERVICO);
            stm.setFloat(3, VALOR);
            stm.setString(4, PRAZO);
            stm.executeQuery();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro de conexão");
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }
    }
    
    public void roupa(int ID_ROUPA, String DESCRICAO, int QUANTIDADE, String TIPO_PECA, String COR, String TIPO_TECIDO, int ID_PEDIDO, int ID_SERVICO)
        throws ClassNotFoundException{
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_ROUPA);
            stm.setInt(1, ID_ROUPA);
            stm.setString(2, DESCRICAO);
            stm.setInt(3, QUANTIDADE);
            stm.setString(4, TIPO_PECA);
            stm.setString(5, COR);
            stm.setString(6, TIPO_TECIDO);
            stm.setInt(7, ID_PEDIDO);
            stm.setInt(8, ID_SERVICO);
            stm.executeQuery();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro de conexão");
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }
    }
    
    public void chamado(int ID_CHAMADO, String DESCRICAO, String STATUS, Date DATA_ABERTURA, Date DATA_BAIXADA, String TIPO_SOLICITACAO, int ID_FUNCIONARIO)
        throws ClassNotFoundException{
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_CHAMADO);
            stm.setInt(1, ID_CHAMADO);
            stm.setString(2, DESCRICAO);
            stm.setDate(3, new java.sql.Date(DATA_ABERTURA.getTime()));
            stm.setDate(4, new java.sql.Date(DATA_BAIXADA.getTime()));
            stm.setString(5, TIPO_SOLICITACAO);
            stm.setInt(6, ID_FUNCIONARIO);
            stm.executeQuery();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro de conexão");
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }
    }
    
    public void tratativaChamado(int ID_TRATATIVA, Date DATA_FECHAMENTO, String DESCRICAO, int ID_CHAMADO, int ID_FUNCIONARIO)
        throws ClassNotFoundException{
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_TRATATIVA);
            stm.setInt(1, ID_TRATATIVA);
            stm.setDate(2, new java.sql.Date(DATA_FECHAMENTO.getTime()));
            stm.setString(3, DESCRICAO);
            stm.setInt(4, ID_CHAMADO);
            stm.setInt(5, ID_FUNCIONARIO);
            stm.executeQuery();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro de conexão");
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }
    }
     
    public void feedNoticias(int ID_FEED, String DESCRICAO, Date DATA_POSTADO, String TITULO, int ID_FUNCIONARIO)
        throws ClassNotFoundException{
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_FEED);
            stm.setInt(1, ID_FEED);
            stm.setString(2, DESCRICAO);
            stm.setDate(3, new java.sql.Date(DATA_POSTADO.getTime()));
            stm.setString(4, TITULO);
            stm.setInt(5, ID_FUNCIONARIO);
            stm.executeQuery();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro de conexão");
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }
    }
    
    public void movimento(int ID_MOVIMENTO, Date DATA_MOV, String TIPO_MOVIMENTO, float QUANTIDADE, String DESCRICAO, int ID_PRODUTO, int ID_FUNCIONARIO)
        throws ClassNotFoundException{
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_MOVIMENTO);
            stm.setInt(1, ID_MOVIMENTO);
            stm.setDate(2, new java.sql.Date(DATA_MOV.getTime()));
            stm.setString(3, TIPO_MOVIMENTO);
            stm.setFloat(4, QUANTIDADE);
            stm.setString(5, DESCRICAO);
            stm.setInt(6, ID_PRODUTO);
            stm.setInt(7, ID_FUNCIONARIO);
            stm.executeQuery();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro de conexão");
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }
    }
    
    public void tipoProduto(int ID_TIPO, String NOME, String DESCRICAO)   
        throws ClassNotFoundException{
        try {
            conn = getConexao();
            stm = conn.prepareStatement(QUERY_INSERT_TIPO_PRODUTO);
            stm.setInt(1, ID_TIPO);
            stm.setString(2, NOME);
            stm.setString(3, DESCRICAO);
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
