/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.servlet;

import br.senac.tads.pi3.blacksystem.ablack.CadastroDAO;
import br.senac.tads.pi3.blacksystem.entity.Chamado;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
@WebServlet(name = "ChamadoAbrirServlet", urlPatterns = {"/ChamadoAbrirServlet"})
public class ChamadoAbrirServlet extends HttpServlet {

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
        request.setAttribute("servicos", "Mensagem");
        request.getRequestDispatcher("/chamado/Abrir.jspx").forward(request, response);
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
        
        CadastroDAO cadChamado = new CadastroDAO();
        
        
        
        Calendar ca = GregorianCalendar.getInstance();  
        Date data = ca.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data1 = sdf.format(data);
        java.sql.Date sqlData = null;  
        try {
            sqlData = (java.sql.Date)(java.util.Date)sdf.parse(data1);
        } catch (ParseException ex) {
            Logger.getLogger(ChamadoAbrirServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        Chamado chamado = new Chamado();
        chamado.setDataAbertura(null);
        chamado.setDescricao(request.getParameter("Desc"));
        chamado.setTipoSolicitacao(request.getParameter("categoria"));
        chamado.setStatus("Abt");
        chamado.setDataAbertura(sqlData);
        //chamado.setIdFuncionario(CPF DO FUNCIONARIO);
        try {
            cadChamado.cadastrarChamado(chamado);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChamadoAbrirServlet.class.getName()).log(Level.SEVERE, null, ex);
        }catch (NullPointerException ex){
            
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
