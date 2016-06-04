    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.servlet;
import br.senac.tads.pi3.blacksystem.ablack.FuncionarioDAO;
import br.senac.tads.pi3.blacksystem.entity.Endereco;
import br.senac.tads.pi3.blacksystem.entity.Filial;
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
@WebServlet(name = "FuncionarioCadastrarServlet", urlPatterns = {"/Funcionario-Cadastrar"})
public class FuncionarioCadastrarServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FuncionarioCadastrarServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FuncionarioCadastrarServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        request.getRequestDispatcher("WEB-INF/funcionario/Cadastrar.jspx").forward(request, response);
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
        
        FuncionarioDAO funcDAO = new FuncionarioDAO();
        Funcionario func = new Funcionario();

        Endereco end = new Endereco();
        
        func.setNome( request.getParameter("nome").toUpperCase());
        func.setSobrenome(request.getParameter("sobrenome" ).toUpperCase());
        func.setTelefone(request.getParameter("telefone"));
        func.setCelular(request.getParameter("celular"));
        func.setEmail(request.getParameter("email"));
        func.setDataNascimento(request.getParameter("dtNascimento"));
        func.setDataContratacao(request.getParameter("dtContratacao"));
        func.setCargo(request.getParameter("cargo").toUpperCase());
        func.setSalario(Float.parseFloat(request.getParameter("salario")));
        func.setHashSenha(request.getParameter("senha"));
        func.setCpf(request.getParameter("cpf"));
        ////        func.setDataContratacao(request.getParameter("2000-01-01"));
        
        System.err.println(request.getParameter("filial-Trabalho").toUpperCase());
        try {
            func.setFilial(funcDAO.buscarFilial(request.getParameter("filial-Trabalho").toUpperCase()));
            funcDAO.cadastrarFuncionario(func);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NullPointerException ex){
            System.err.println(ex.getMessage());
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
