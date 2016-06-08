/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.servlet;

import br.senac.tads.pi3.blacksystem.ablack.ProdutoDAO;
import br.senac.tads.pi3.blacksystem.ablack.MovimentoDAO;
import br.senac.tads.pi3.blacksystem.entity.MovimentoProduto;
import br.senac.tads.pi3.blacksystem.entity.Produto;
import br.senac.tads.pi3.blacksystem.entity.TipoProduto;
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
        
        Produto p = new Produto();
        System.err.println("sadasdasdasdasd");
        
        p.setNome(request.getParameter("nome").toUpperCase());
        p.setValidade(request.getParameter("validade"));
        p.setLote(request.getParameter("lote"));
        p.setQtdMin(Integer.parseInt(request.getParameter("qtdMinima")));
        p.setQtdMax(Integer.parseInt(request.getParameter("qtdMaxima")));
        p.setQtdAtual(Integer.parseInt(request.getParameter("qtdAtual")));
        p.getTipoDeProduto().setNome(request.getParameter("tipo"));
        p.setIdProduto(7);
        MovimentoProduto m = new MovimentoProduto();
        m.setDescricao("Produto cadastrado".toUpperCase());
        m.setIdFilial(1);
        m.setIdFuncionaro(2);
        
        try {
            ProdutoDAO pDAO = new ProdutoDAO();
            MovimentoDAO mDAO = new MovimentoDAO();
            pDAO.produtoCadastro(p);
            mDAO.produtoEntrada(m, p);
//            MovimentoDAO mAtulizar = new MovimentoDAO();
//            mAtulizar.produtoAtualizar(p);
//            mAtulizar.produtoSaida(m, p);
        } catch (Exception e) {
            
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
