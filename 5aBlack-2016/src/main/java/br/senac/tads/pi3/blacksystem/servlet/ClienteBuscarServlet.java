/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.servlet;

import br.senac.tads.pi3.blacksystem.entity.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
        
        Cliente cliente = new Cliente();
        cliente.setCelular("00 90000-0000");
        cliente.setCep("89899-000");
        cliente.setCidade("bufunfa");
        cliente.setCpf("000.000.000-00");
        cliente.setEmail("xxxxxxxxxxx@mailzika.com");
        cliente.setEstado("Porto Rico");
        cliente.setNome("Mala");
        cliente.setNumero(333);
        cliente.setRua("Uma rua ai manoloko");
        cliente.setSobrenome("Aquele la mano");
        cliente.setTelefone("00 00000-0000");
        
        Cliente cliente2 = new Cliente();
        cliente2.setCelular("00 90000-0000");
        cliente2.setCep("89899-000");
        cliente2.setCidade("bufunfa");
        cliente2.setCpf("000.000.000-00");
        cliente2.setEstado("Porto Rico");
        cliente2.setNome("Mala");
        cliente2.setNumero(333);
        cliente2.setRua("Uma rua ai manoloko");
        cliente2.setSobrenome("Aquele la mano");
        cliente2.setTelefone("00 00000-0000");
        
        Cliente cliente4 = new Cliente();
        cliente4.setCelular("00 90000-0000");
        cliente4.setCep("89899-000");
        cliente4.setCidade("bufunfa");
        cliente4.setCpf("000.000.000-00");
        cliente4.setEmail("xxxxxxxxxxx@mailzika.com");
        cliente4.setEstado("Porto Rico");
        cliente4.setNome("Mala");
        cliente4.setNumero(333);
        cliente4.setRua("Uma rua ai manoloko");
        cliente4.setSobrenome("Aquele la mano");
        cliente4.setTelefone("00 00000-0000");
        
        lista.add(cliente);
        lista.add(cliente2);
        lista.add(cliente4);
        
        
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
        processRequest(request, response);
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
