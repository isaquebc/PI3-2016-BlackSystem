package br.senac.tads.pi3.blacksystem.servlet;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import br.senac.tads.pi3.blacksystem.entity.Servico;

import br.senac.tads.pi3.blacksystem.ablack.PedidoDAO;
import br.senac.tads.pi3.blacksystem.ablack.ServicoDAO;
import br.senac.tads.pi3.blacksystem.entity.*;
import java.io.IOException;
import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "PedidoGerarServlet", urlPatterns = {"/PedidoGerarServlet"})
public class PedidoGerarServlet extends HttpServlet {
//     public List Servico(){ 
//        Servico sr = new Servico();
//        List lista = new ArrayList<>();
//        Date data = new Date(12, 12, 12);
//        Servico servico = new Servico("Lavagem Simples", 20, data);
//        Servico servico2 = new Servico("Lavagem completa", 20, data);
//        Servico servico3 = new Servico("Lavagem Seca", 20, data);
//        
//        lista.add(servico);
//        lista.add(servico3);
//        lista.add(servico2);
//        return lista;
//    }

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
//        request.setAttribute("servicos", Servico());
        request.getRequestDispatcher("WEB-INF/pedido/Gerar.jspx").forward(request, response);
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

        Servico serv = new Servico();
        ArrayList<Peca> pecas = new ArrayList<>();
        Pedido ped = new Pedido();
        Cliente cli = new Cliente();
        cli.setId(1);
        Funcionario f = new Funcionario();
        f.setId(1);
//      Departamento dep= new Departamento();

        int cont = Integer.parseInt(request.getParameter("cont"));  
        for (int i=0;i<=cont;i ++) {
               Peca peca= new Peca();
            serv.setTipoServico(request.getParameter("servico" + cont));
            peca.setTipoPeca(request.getParameter("peca" + cont));
            peca.setTipoTecido(request.getParameter("tecido" + cont));
            peca.setQdt(request.getParameter("quantidade" + cont));
            ped.setDataSaida(request.getParameter("dtRetirada" + cont));
            pecas.add(peca);
        }
        PedidoDAO pedDAO = new PedidoDAO();
        ServicoDAO servDao = new ServicoDAO();
        try {
            
            pedDAO.cadastrarPedido(ped, pecas, cli, serv ,f);
            //servDao.cadastrarServico(serv);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoGerarServlet.class.getName()).log(Level.SEVERE, null, ex);
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
