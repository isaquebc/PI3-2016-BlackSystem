package br.senac.tads.pi3.blacksystem.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.senac.tads.pi3.blacksystem.entity.Servico;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Rafael
 */
@WebServlet(name = "GerarPedidoServlet", urlPatterns = {"/GerarPedidoServlet"})
public class GerarPedidoServlet extends HttpServlet {

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
        Servico sr = new Servico();
        List lista = new ArrayList<>();
        HttpSession sessao = request.getSession();
        request.setAttribute("servicos", lista);
        if( !lista.isEmpty()){
           
            request.getRequestDispatcher("/pedido/Gerer.jspx").forward(request, response);
            
        }
        //fazer DAO do pedido
        //fazer dao de listar serviços
        // Delcarando uma seção para usa-la como refencia aos tipos de serviço a serem listados em todas as paginas
        sessao.setAttribute(null, lista);
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

        String tipoPeca = request.getParameter("tipo-Peca");
        String tipoTecido = request.getParameter("tipo-Tecido");
        String tipoLavagem = request.getParameter("tipo-Lavagem");
        String qtd = request.getParameter("qtd-Peca");
        String cor = request.getParameter("cor");
        int servico = Integer.parseInt(request.getParameter("tipo-Servico"));

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
