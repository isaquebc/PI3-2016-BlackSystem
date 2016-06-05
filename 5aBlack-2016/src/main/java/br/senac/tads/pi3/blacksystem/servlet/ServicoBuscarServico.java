/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.servlet;

import br.senac.tads.pi3.blacksystem.ablack.ServicoDAO;
import br.senac.tads.pi3.blacksystem.entity.Servico;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Isaque
 */
@WebServlet(name = "ServicoAlterarServico", urlPatterns = {"/ServicoAlterarServico"})
public class ServicoBuscarServico extends HttpServlet {

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
        request.getRequestDispatcher("WEB-INF/servicoProduto/AlterarServico.jspx").forward(request, response);
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
        
        ServicoDAO servDAO = new ServicoDAO();
        Servico servico = new Servico();
        ArrayList<Servico> servicos = new ArrayList<>();
        servico.setNomeServico(((String)request.getParameter("nome-servico")).toUpperCase(Locale.US));
        servico.setTipoServico(request.getParameter("nome-servico").toUpperCase());
        
        
        try {
            servicos = servDAO.buscarServico(servico);
            request.setAttribute("servicos", servDAO.buscarServico(servico));
            request.getRequestDispatcher("WEB-INF/servicoProduto/AlterarServico.jspx").forward(request, response);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
