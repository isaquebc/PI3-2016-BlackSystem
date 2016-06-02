/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.servlet;

import br.senac.tads.pi3.blacksystem.ablack.CadastrarProdutoDAO;
import br.senac.tads.pi3.blacksystem.entity.MovimentoProduto;
import br.senac.tads.pi3.blacksystem.entity.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Isaque
 */
@WebServlet(name = "ProdutoCadastrarServlet", urlPatterns = {"/ProdutoCadastrarServlet"})
public class ProdutoCadastrarServlet extends HttpServlet {

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
        Produto p = new Produto();
        System.err.println("sadasdasdasdasd");
        p.setNome(request.getParameter("nome"));
        p.setValidade(request.getParameter("validade"));
//        p.setLote(Integer.parseInt((String)request.getParameter("lote")));
//        p.setQtdMin(Float.parseFloat((String)request.getParameter("qtdMinima")));
//        p.setQtdMax(Float.parseFloat((String)request.getParameter("qtdMaxima")));
//        p.setQtdAtual(Float.parseFloat((String)request.getParameter("qtdAtual")));
        
        MovimentoProduto m = new MovimentoProduto();
        m.setDescricao("Produto cadastrado");
        m.setIdFilial(1);
        m.setIdFuncionaro(2);
        m.setIdProduto(1);
        m.setQtd(100);
        
        try {
            CadastrarProdutoDAO pDAO = new CadastrarProdutoDAO();
            pDAO.cadastrarProduto(p);
            pDAO.entradaProduto(m);
        } catch (Exception e) {
            
        }

        request.getRequestDispatcher("WEB-INF/servicoProduto/CadastrarProduto.jspx").forward(request, response);
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
