/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.servlet;

import br.senac.tads.pi3.blacksystem.ablack.ClienteCadastroDAO;
import br.senac.tads.pi3.blacksystem.ablack.EnderecoClienteDAO;
import br.senac.tads.pi3.blacksystem.entity.Cliente;
import br.senac.tads.pi3.blacksystem.entity.Endereco;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rafael
 */
@WebServlet(name="ClienteCadastrarServlet",urlPatterns = {"/ClienteCadastrarServlet"})
public class ClienteCadastrarServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("servicos", "Mensagem");
        request.getRequestDispatcher("WEB-INF/cliente/Cadastrar.jspx").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClienteCadastroDAO cadCli= new ClienteCadastroDAO();
        EnderecoClienteDAO DAOenddCli = new EnderecoClienteDAO();
        Endereco endCli= new Endereco();
        Cliente cli= new Cliente();
 //       DateFormat form= new SimpleDateFormat("dd/mm/yyyy");
//        try{
//            java.util.Date data= form.parse(request.getParameter(null));

//        }
//        catch (ParseException e){

//        }
        cli.setCpf(request.getParameter("cpf"));
        cli.setNome( request.getParameter("nome"));
        cli.setSobrenome(request.getParameter("sobreNome" ));
        cli.setTelefone(request.getParameter("telefone"));
        cli.setSexo("M");
        cli.setEmail(request.getParameter("email"));
        endCli.setEndereco( request.getParameter("rua"));
        endCli.setNumero( request.getParameter("numero"));
        endCli.setEstado(request.getParameter("estado"));
        endCli.setCidade(null); request.getParameter("cidade");
        endCli.setCep( request.getParameter( "cep"));
            
//        cli.setCpf("00000000000");
//        cli.setNome("fulano");
//        cli.setSobrenome("de tal");
//        cli.setTelefone("11 982335099");
//        cli.setEmail("iiiii@gmail.com");
        
        try {
            cadCli.cadatrarPessoa(cli);
            DAOenddCli.cadastrarEndereco(cli,endCli );
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch(NullPointerException ex){
            
            
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
