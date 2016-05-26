/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.servlet;

import br.senac.tads.pi3.blacksystem.entity.Chamado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author isaque.bcosta1
 */
@WebServlet(name = "ChamadoListarServlet", urlPatterns = {"/ChamadoListarServlet"})
public class ChamadoListarServlet extends HttpServlet {

    
    public List chamados (){
        
        List lista = new ArrayList<Object>();
        
        Chamado chamado = new Chamado();
        Chamado chamado1 = new Chamado();
        Chamado chamado2 = new Chamado();
        
        String data = "Hoje parça"; 
        
        chamado.setIdChamado(123);
        chamado.setTipoSolicitacao("Erro Login");
        chamado.setDataAbertura(data);
        chamado.setStatus("Aberto");
        lista.add(chamado);
        
        chamado1.setIdChamado(342);
        chamado1.setTipoSolicitacao("Esqueci minha senha");
        chamado1.setDataAbertura(data);
        chamado1.setStatus("Aberto");
        lista.add(chamado1);
        
        chamado2.setIdChamado(456);
        chamado2.setTipoSolicitacao("#PeideiSai");
        chamado2.setDataAbertura(data);
        chamado2.setStatus("Em tratativa");
        lista.add(chamado2);
        
        
        
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
        request.setAttribute("chamados", chamados());
        request.getRequestDispatcher("WEB-INF/chamado/Lista.jspx").forward(request, response);
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
