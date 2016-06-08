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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class ClienteCadastroDAO extends Conexao {

    String QUERY_INSERT_CLIENTE = "insert into CLIENTE( NOME_CLIENTE, SOBRENOME_CLIENTE, SEXO_CLIENTE, NASC_CLIENTE,"
            + "TEL_CLIENTE, CEL_CLIENTE,EMAIL_CLIENTE,STATUS_CLIENTE,CPF_CLIENTE, DTCADASTRO_CLIENTE)" + " values(?,?,?,?,?,?,?,?,?,?)";
    String QUERY_SELECT_CLIENTE = "SELECT * FROM APP.CLIENTE";

    public void cadatrarPessoa(Cliente cli) throws ClassNotFoundException {

        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = getConexao();
            String sql = QUERY_INSERT_CLIENTE;
            stm = conn.prepareStatement(sql);
            stm.setString(1, cli.getNome());
            stm.setString(2, cli.getSobrenome());
            stm.setString(3, cli.getSexo());
            Date data = new java.sql.Date(cli.getNasc().getTime());
            stm.setDate(4, (java.sql.Date) data);
            stm.setString(5, cli.getTelefone());
            stm.setString(6, cli.getCelular());
            stm.setString(7, cli.getEmail());
            stm.setString(8, "ATIVO");
            stm.setString(9, cli.pegarCpf());
            Date dtC = new java.sql.Date(cli.getDtCadastro().getTime());
            stm.setDate(10, (java.sql.Date) dtC);
            stm.executeUpdate();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro de conexão: Cadastro do cliente");
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado: Cadastro do cliente");
        }

    }
    
    
//    public void cadastrarEndCliente(Cliente cliente, Endereco endereco) throws ClassNotFoundException{
//        Connection conn = null;
//        PreparedStatement preStm = null;
//        String QUERY_INSERT_CLIENTE_END = "INSERT INTO ENDERECO_CLIENTE (LOGRADOURO_CLI, NUMERO_CLI, BAIRRO_CLI, CIDADE_CLI, ESTADO_CLI, CEP_CLI, ID_CLIENTE) " +
//        " VALUES(?, ?, ?, ?, ?, ?, (SELECT ID_CLIENTE FROM CLIENTE WHERE CPF_CLIENTE ='"+cliente.pegarCpf()+"')\n)";
//        try {
//            conn = getConexao();
//            preStm = conn.prepareStatement(QUERY_INSERT_CLIENTE_END);
//            preStm.setString(1, endereco.getEndereco());
//            preStm.setInt(2, endereco.getNumero());
//            preStm.setString(3, endereco.getBairro());
//            preStm.setString(4, endereco.getCidade());
//            preStm.setString(5, endereco.getEstado());
//            preStm.setString(6, endereco.getCep());
//            preStm.executeUpdate();
//            preStm.close();
//            conn.close();
//        } catch (SQLException e) {
//            System.out.println(e.toString());
//        }
//    }

    public List listarClinte() throws SQLException {
        List lista = new ArrayList();
        
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            conn = getConexao();
            stm = conn.createStatement();
            rs = stm.executeQuery(QUERY_SELECT_CLIENTE);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("ID_CLIENTE"));
                cliente.setCpf(rs.getString("CPF_CLIENTE"));
                cliente.setNome(rs.getString("NOME_CLIENTE"));
                cliente.setSobrenome(rs.getString("SOBRENOME_CLIENTE"));
                cliente.setSexo(rs.getString("SEXO_CLIENTE"));
                cliente.setNasc(rs.getDate("NASC_CLIENTE"));
                cliente.setTelefone(rs.getString("TEL_CLIENTE"));
                cliente.setCelular(rs.getString("CEL_CLIENTE"));
                cliente.setEmail(rs.getString("EMAIL_CLIENTE"));
                cliente.setStatus(rs.getString("STATUS_CLIENTE"));
                cliente.setDtCadastro(rs.getDate("DTCADASTRO_CLIENTE"));
                lista.add(cliente);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteCadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            stm.close();
            conn.close();
        }

        return lista;
    }
    
    
    // a java preparedstatement
    public void alterarCliente(Cliente cliente)
            throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        String query = "UPDATE CLIENTE SET " +
                        "CPF_CLIENTE=?, " +
                        "NOME_CLIENTE=?, " +
                        "SOBRENOME_CLIENTE=?, " +
                        "SEXO_CLIENTE=?, " +
                        "NASC_CLIENTE=?, " +
                        "TEL_CLIENTE=?, " +
                        "CEL_CLIENTE=?, " +
                        "EMAIL_CLIENTE=?, " +
                        "STATUS_CLIENTE=?, " +
                        "DTCADASTRO_CLIENTE=? " +
                        "WHERE CPF_CLIENTE = ?";
        try {
            conn = getConexao();
            // create our java preparedstatement using a sql update query
            ps = conn.prepareStatement(query);

            // set the preparedstatement parameters
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getSobrenome());
            ps.setString(4, cliente.getSexo());
            ps.setDate(5, new java.sql.Date(cliente.getNasc().getTime()));
            ps.setString(6, cliente.getTelefone());
            ps.setString(7, cliente.getCelular());
            ps.setString(8, cliente.getEmail());
            ps.setString(9, cliente.getStatus());
            ps.setDate(10, new java.sql.Date(cliente.getDtCadastro().getTime()));
            ps.setInt(11, cliente.getId());
      
            // call executeUpdate to execute our sql update statement
            ps.executeUpdate();
            ps.close();
        } catch (SQLException se) {
            // log the exception
            System.out.println(se.toString());
        }
    }
    
    // a java preparedstatement
    public void alterarEnderecoCliente(Cliente cliente, Endereco endereco)
            throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        String query =  "UPDATE ENDERECO_CLIENTE SET " +
                        "LOGRADOURO_CLI=?, " +
                        "NUMERO_CLI=?, " +
                        "BAIRRO_CLI=?, " +
                        "CIDADE_CLI=?, " +
                        "ESTADO_CLI=?, " +
                        "CEP_CLI=? " +
                        "WHERE ID_CLIENTE = ?";
        try {
            conn = getConexao();
            // create our java preparedstatement using a sql update query
            ps = conn.prepareStatement(query);

            // set the preparedstatement parameters
            ps.setString(1, endereco.getEndereco());
            ps.setInt(2, endereco.getNumero());
            ps.setString(3, endereco.getBairro());
            ps.setString(4, endereco.getCidade());
            ps.setString(5, endereco.getEstado());
            ps.setString(6, endereco.getCep());
            ps.setInt(7, cliente.getId());
            // call executeUpdate to execute our sql update statement
            ps.executeUpdate();
            ps.close();
        } catch (SQLException se) {
            // log the exception
        }
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
//    final String QUERY_INSERT_SERVICO = "INSERT INTO SERVICO(ID_SERVICO, TIPO_DE_SERVICO, VALOR, PRAZO)"
//            + "VALUES (?, ?, ?, ?)";
////    String QUERY_INSERT_CHAMADO = "INSERT INTO CHAMADO(DESCRICAO, STATUS, DATA_ABERTURA, DATA_BAIXADA, TIPO_SOLICITACAO, ID_FUNCIONARIO)"
//            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
////    final String QUERY_INSERT_PRODUTO = "INSERT INTO PRODUTO(ID_PRODUTO, NOME, VALIDADE, LOTE, STATUS, MIN_QTD, MAX_QTD, QUANTIDADE, ID_TIPO, ID_DPT, ID_FUNCIONARIO)"
//            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";//
//    final String QUERY_INSERT_ALTERACAO = "NÃO DEFINIDO AINDA";

////    public boolean consultaCPF(String cpf) throws ClassNotFoundException{
////        String cpf="SELECT CPF_CLIENTE FROM CLIENTE='"+cpf+"'";
////        
////        Connection conn = null;
////        PreparedStatement stm = null;
////        boolean pesCPF=false;
////        String retCPF="";
////        Statement stmt = null;
////        ResultSet rs = null;
////        try {
////            
////            conn = getConexao();
////            stmt = conn.createStatement();
////            stmt.executeQuery(retCPF);
////            rs.first();
////            retCPF=rs.getString("CPF_CLIENTE");
////            retCPF=rs.getString("");
////            retCPF=rs.getString("CPF_CLIENTE");
////            retCPF=rs.getString("CPF_CLIENTE");
////            retCPF=rs.getString("CPF_CLIENTE");
////            
////            if(retCPF.equals(cpf)){
////                pesCPF= true;
////                
////            }
////            //serv.setTipoServico(rs.getString("TIPO_SERV"));
////            
////            //serv.setPrazo(rs.getString("PRAZO_SERV"));
////            stmt.close();
////            conn.close();
////        } catch (SQLException ex) {
////            System.out.println("erro ao conectar com o banco");
////            ex.getMessage();
////        } catch (NullPointerException ex) {
////            System.out.println("DAO não inicializado");
////            ex.getMessage();
////        }
////        return pesCPF;
////    

