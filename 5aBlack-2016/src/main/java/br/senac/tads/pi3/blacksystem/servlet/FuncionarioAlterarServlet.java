/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.servlet;

import br.senac.tads.pi3.blacksystem.ablack.FuncionarioDAO;
import br.senac.tads.pi3.blacksystem.entity.Endereco;
import br.senac.tads.pi3.blacksystem.entity.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafael.lcunha
 */
@WebServlet(name = "FuncionarioAlterarServlet", urlPatterns = {"/FuncionarioAlterarServlet"})
public class FuncionarioAlterarServlet extends HttpServlet {

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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
        
       
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
        
        
        Endereco endereco = new Endereco();
        Funcionario funcionario = new Funcionario();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        
        endereco.setBairro("JARDIM ICARAI");
        endereco.setCep("04844150");
        endereco.setCidade("SÃO PAULO");
        endereco.setComplemento("CASA");
        endereco.setEstado("SP");
        endereco.setNumero(700);
        funcionario.setId(1);
        
        
        try {
            funcionarioDAO.alterarEnderecoFuncionarior(funcionario, endereco);
        } catch (SQLException | ClassNotFoundException   e) {
            System.out.println(e);
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
    }// </editor-fold>

}
