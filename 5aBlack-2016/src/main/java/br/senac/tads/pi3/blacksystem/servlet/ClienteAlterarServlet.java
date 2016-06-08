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
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author miqueas.bsantos1
 */
@WebServlet(name = "ClienteAlterarServlet", urlPatterns = {"/ClienteAlterarServlet"})
public class ClienteAlterarServlet extends HttpServlet {

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
        ClienteCadastroDAO clienteDAO = new ClienteCadastroDAO();
        EnderecoClienteDAO enderecoDAO = new EnderecoClienteDAO();
        Endereco endereco = new Endereco();
        Cliente cliente = new Cliente();
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");

        cliente.setCpf(request.getParameter("cpf"));
        cliente.setNome(request.getParameter("nome").toUpperCase());
        cliente.setSobrenome(request.getParameter("sobrenome").toUpperCase());
        cliente.setTelefone(request.getParameter("telefone"));
        cliente.setCelular(request.getParameter("celular"));
        cliente.setSexo(request.getParameter("sexo").toUpperCase());
        cliente.setEmail(request.getParameter("email"));
        String dtNascStr = request.getParameter("dt-Nascimento");
        
        // captura dos dados do endereço
        
        endereco.setEndereco(request.getParameter("rua"));
        endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
        endereco.setCidade(request.getParameter("cidade"));
        endereco.setEstado(request.getParameter("estado"));
        endereco.setCep(request.getParameter("cep"));
        
        try {
            clienteDAO.alterarCliente(cliente);
            clienteDAO.alterarEnderecoCliente(cliente, endereco);
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
    }// </editor-fold>

}
