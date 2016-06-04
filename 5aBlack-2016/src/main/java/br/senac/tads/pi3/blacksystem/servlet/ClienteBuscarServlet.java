/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.servlet;

import br.senac.tads.pi3.blacksystem.ablack.ClienteCadastroDAO;
import br.senac.tads.pi3.blacksystem.entity.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
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
@WebServlet(name = "ClienteBuscarServlet", urlPatterns = {"/ClienteBuscarServlet"})
public class ClienteBuscarServlet extends HttpServlet {

    public List clientes(){
        List lista = new ArrayList<>();
        ClienteCadastroDAO cadCliente = new ClienteCadastroDAO();
        try {
            lista = cadCliente.listarClinte();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBuscarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return lista;   
}

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
        request.setAttribute("clientes", clientes());
        request.getRequestDispatcher("WEB-INF/cliente/Buscar.jspx").forward(request, response);
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
        
       String cpf = request.getParameter("cpf");
        
       ClienteCadastroDAO cliente = new ClienteCadastroDAO();
       

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
