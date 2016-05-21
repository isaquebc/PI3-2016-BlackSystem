/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.servlet;

import br.senac.tads.pi3.blacksystem.ablack.FuncinarioCadastroDAO;
import br.senac.tads.pi3.blacksystem.entity.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Isaque
 */
@WebServlet(name = "FuncionarioBuscarServlet", urlPatterns = {"/FuncionarioBuscarServlet"})
public class FuncionarioBuscarServlet extends HttpServlet {

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
        request.getRequestDispatcher("WEB-INF/funcionario/Buscar.jspx").forward(request, response);
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
        
        Funcionario func= new Funcionario();
        FuncinarioCadastroDAO funDAO= new FuncinarioCadastroDAO();
        
        func.setCpf(request.getParameter("cpf"));
        func.setNome( request.getParameter("nome"));
        func.setSobrenome(request.getParameter("sobreNome" ));
        func.setTelefone(request.getParameter("telefone"));
        func.setSexo("M");
        func.setEmail(request.getParameter("email"));
//        func.setEndereco( request.getParameter("rua"));
//        endCli.setNumero( request.getParameter("numero"));
//        endCli.setEstado(request.getParameter("estado"));
//        endCli.setCidade(null); request.getParameter("cidade");
//        endCli.setCep( request.getParameter( "cep"));
            
//        cli.setCpf("00000000000");
//        cli.setNome("fulano");
//        cli.setSobrenome("de tal");
//        cli.setTelefone("11 982335099");
//        cli.setEmail("iiiii@gmail.com");
        
        try {
             
            funDAO.cadastrarFuncionario(func);
            
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
