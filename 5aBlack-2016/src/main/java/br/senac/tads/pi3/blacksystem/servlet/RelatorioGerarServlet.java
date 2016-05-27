/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.servlet;

import br.senac.tads.pi3.blacksystem.ablack.RelatorioDAO;
import br.senac.tads.pi3.blacksystem.entity.RelatorioFuncionario;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Isaque
 */
@WebServlet(name = "RelatorioGerarServlet", urlPatterns = {"/RelatorioGerarServlet"})
public class RelatorioGerarServlet extends HttpServlet {

    
    
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
        request.setAttribute("servicos", "mensagem");
        request.getRequestDispatcher("WEB-INF/relatorio/Gerar.jspx").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public Date converterData(String data){
        try {
            SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yyyy");
            Date dataConvertida = new java.sql.Date(dt.parse(data).getTime());
            System.err.println(dataConvertida);
            
            return dataConvertida;
        } catch (Exception e) {
            System.out.println("Erro de Conversão " + e.toString());
        }
        return null;
    }
    
    public ArrayList tipoDeRelatorio(String tipo, String dataInicio, String dataFim){
        RelatorioDAO rDAO = new RelatorioDAO();

        try {
            switch(tipo.toUpperCase()){
            case "FUNCIONARIO":
                return rDAO.relatorioVendaFuncionaros(dataInicio, dataFim);
            case "PEDIDO":
                return rDAO.relatorioPedidosMaisRealizados(dataInicio, dataFim);
            case "VENDA":
                return rDAO.relatorioDeFilial(dataInicio, dataFim);
            case "CLIENTE":
                return rDAO.relatorioDeCliente(dataInicio, dataFim);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RelatorioGerarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
            System.err.println("entrou na  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            
            String tipoRelatorio = request.getParameter("tipo-Relatorio");
            String dataInicio = request.getParameter("data-Inicial");
            String dataFim = request.getParameter("data-Final");
            log(tipoRelatorio);
            //log(dataInicio);
            
            ArrayList r = tipoDeRelatorio(tipoRelatorio, dataInicio, dataFim);
            switch(tipoRelatorio.toUpperCase()){
                case "FUNCIONARIO":
                    request.setAttribute("relatorioFuncionario", r);
                break;
                case "PEDIDO":
                    request.setAttribute("relatorioPedido", r);
                break;
                case "VENDA":
                    request.setAttribute("relatorioFilial", r);
                break;
                case "CLIENTE":
                    request.setAttribute("relatorioCliente", r);
                break;
            }
            
            request.getRequestDispatcher("WEB-INF/relatorio/Gerar.jspx").forward(request, response);
            
        
        
        
        
        
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
