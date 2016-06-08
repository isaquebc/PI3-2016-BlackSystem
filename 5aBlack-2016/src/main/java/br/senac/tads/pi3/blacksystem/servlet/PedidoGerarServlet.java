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
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        Servico s = new Servico();
        ArrayList<Peca> pecas = new ArrayList<>();
        Pedido p = new Pedido();
        Cliente cli = new Cliente();
        Funcionario funcionario = new Funcionario();
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        p.setDataEntrada(null);
        p.setStatus("aberto");
        p.setDataSaida(null);

//      Departamento dep= new Departamento();
        /*======================================================================
         Aqui ele gera um contador Cont, que serve para saber quantas linhas 
         existem na tabela e assim fazer o looping
         =======================================================================*/
        String dtped ="";
        Date ped = null;
        Date aux= null;
        int cont = Integer.parseInt(request.getParameter("cont"));
        for (int i = 1; i <= cont; i++) {
            Peca peca = new Peca();
            p.setTipoServico(request.getParameter("servico" + i).toUpperCase());
            peca.setTipoPeca(request.getParameter("tipoPeca" + i).toUpperCase());
            peca.setTipoTecido(request.getParameter("tecido" + i).toUpperCase());
            peca.setQdt(Integer.parseInt( request.getParameter("qtd" + i)));
            peca.setCor(request.getParameter("cor" + i).toUpperCase());
            pecas.add(peca);
            
             dtped = request.getParameter("dtRetirada" +i);
            
            try {
                
            aux = form.parse(dtped );
            if( ped==null){
                ped= form.parse(dtped);
            }
            
            if(aux.after(ped)){
            ped = aux;
            }
            else{
                ped= form.parse(dtped);
                
            }
        } catch (ParseException ex) {
            Logger.getLogger(ClienteCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        
        p.setDataSaida(ped);
        PedidoDAO pedidoDAO = new PedidoDAO();
        ServicoDAO servicoDao = new ServicoDAO();
        
        pedidoDAO.setPecas(pecas,p, s, cli);
        
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
