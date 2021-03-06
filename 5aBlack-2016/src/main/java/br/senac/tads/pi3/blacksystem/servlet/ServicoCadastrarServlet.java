/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.servlet;

import br.senac.tads.pi3.blacksystem.ablack.ServicoDAO;
import br.senac.tads.pi3.blacksystem.entity.Mensagem;
import br.senac.tads.pi3.blacksystem.entity.Servico;
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
@WebServlet(name = "ServicoCadastrarServlet", urlPatterns = {"/ServicoCadastrarServlet"})
public class ServicoCadastrarServlet extends HttpServlet {

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
        //request.setAttribute("servicos", "Mensagem");
        request.getRequestDispatcher("WEB-INF/servicoProduto/CadastrarServico.jspx").forward(request, response);
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

        Servico ser= new Servico();
        ser.setNomeServico(request.getParameter("nome").toUpperCase());
        ser.setTipoServico(request.getParameter("tipoServico").toUpperCase());
        ser.setValorServico(Float.parseFloat(request.getParameter("valor")));
        ser.setPrazo((int)Integer.parseInt(request.getParameter("prazo")));
        ser.setId(7);
        ServicoDAO sDao= new ServicoDAO();
        Mensagem msg = null;
        
        try {
            sDao.cadastrarServico(ser);
            msg = new    Mensagem("Cadastrar Serviço", "Produto Cadastrado Com sucesso",
                        "ServicoCadastrarServlet");
        } catch (ClassNotFoundException ex) {
            msg = new Mensagem("Cadastrar Serviço", "Ocorreu um erro ao cadastrar o produto verique os campos e preencha corretamente",
                        "ServicoCadastrarServlet");
            Logger.getLogger(ServicoCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("Mensagem.jspx").forward(request, response);
        
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
