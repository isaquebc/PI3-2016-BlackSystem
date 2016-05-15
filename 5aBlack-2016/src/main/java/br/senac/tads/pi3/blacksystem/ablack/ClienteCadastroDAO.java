/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.ablack;
import br.senac.tads.pi3.blacksystem.entity.Chamado;
import br.senac.tads.pi3.blacksystem.entity.Cliente;
import br.senac.tads.pi3.blacksystem.entity.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Rafael
 */
public class ClienteCadastroDAO extends Conexao{
    
    
    String QUERY_INSERT_CLIENTE      = "INSERT INTO CLIENTE( ID_CPF, NOME, SOBRENOME, DATANASC, TEL, CEL, EMAIL, STATUS)"
                                             + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    final String QUERY_INSERT_SERVICO      = "INSERT INTO SERVICO(ID_SERVICO, TIPO_DE_SERVICO, VALOR, PRAZO)"
                                             + "VALUES (?, ?, ?, ?)";    
    
    String QUERY_INSERT_CHAMADO      = "INSERT INTO CHAMADO(DESCRICAO, STATUS, DATA_ABERTURA, DATA_BAIXADA, TIPO_SOLICITACAO, ID_FUNCIONARIO)"
                                             + "VALUES (?, ?, ?, ?, ?, ?, ?)";

    final String QUERY_INSERT_PRODUTO      = "INSERT INTO PRODUTO(ID_PRODUTO, NOME, VALIDADE, LOTE, STATUS, MIN_QTD, MAX_QTD, QUANTIDADE, ID_TIPO, ID_DPT, ID_FUNCIONARIO)"
                                             + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    final String QUERY_INSERT_ALTERACAO    = "NÃO DEFINIDO AINDA";
    
    public  void cadatrarPessoa(Cliente cli,Date dataEntrada)throws ClassNotFoundException {
        try {
            
            Connection conn=null;
            PreparedStatement stm=null;
            conn = getConexao();
            String sql = QUERY_INSERT_CLIENTE;
            stm = conn.prepareStatement(sql);
            stm.setString(1, cli.getCpf());
            stm.setString(2, cli.getNome());
            stm.setString(3, cli.getSobrenome());
            stm.setDate(4, new java.sql.Date(1009-03-03));
            stm.setString(5, cli.getTelefone());
            stm.setString(6, cli.getCelular());
            stm.setString(7, cli.getEmail());
            stm.setString(8, cli.getStatus());
            stm.executeUpdate();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro de conexão: Cadastro do cliente");
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado: Cadastro do cliente");
        }
//        public void cadastrarMovimento()
//        throws ClassNotFoundException{
//     final String QUERY_INSERT_MOVIMENTO    = "INSERT INTO MOVIMENTO(ID_MOVIMENTO, DATA_MOV, TIPO_MOVIMENTO, QUANTIDADE, DESCRICAO, ID_PRODUTO, ID_FUNCIONARIO)"
//                                             + "VALUES(?, ?, ?, ?, ?, ?, ?)";   
//Connection conn= null;
//        PreparedStatement stm= null;
//        try {
//            conn = getConexao();
//            stm = conn.prepareStatement(QUERY_INSERT_MOVIMENTO);
//            stm.setInt(1, ID_MOVIMENTO);
//            stm.setDate(2, new java.sql.Date(DATA_MOV.getTime()));
//            stm.setString(3, TIPO_MOVIMENTO);
//            stm.setFloat(4, QUANTIDADE);
//            stm.setString(5, DESCRICAO);
//            stm.setInt(6, ID_PRODUTO);
//            stm.setInt(7, ID_FUNCIONARIO);
//            stm.executeQuery();
//            stm.close();
//            conn.close();
//        } catch (SQLException e) {
//            System.out.println("Erro de conexão");
//        } catch (NullPointerException e) {
//            System.out.println("Dao não inicializado");
//        }
//    }
        
    }    
    //stm.setDate(3, chamado.getDataAbertura());
            //stm.setDate(3, new java.sql.Date(DATA_BAIXADA.getTime()));

     
    
    
    
    
    
}
