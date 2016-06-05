/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.servlet;

import br.senac.tads.pi3.blacksystem.ablack.CadastroTratativaDAO;
import br.senac.tads.pi3.blacksystem.ablack.ChamadoDAO;
import br.senac.tads.pi3.blacksystem.entity.Chamado;
import br.senac.tads.pi3.blacksystem.entity.TratativaChamado;
import java.io.IOException;
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
@WebServlet(name = "ChamadoBuscarServlet", urlPatterns = {"/ChamadoBuscarServlet"})
public class ChamadoBuscarServlet extends HttpServlet {

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
        request.getAttribute("chamados");
        request.getRequestDispatcher("WEB-INF/chamado/Buscar.jspx").forward(request, response);
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
        int id = Integer.parseInt(request.getParameter("Id"));
        
        try {
            ChamadoDAO cDAO = new ChamadoDAO();
            Chamado c = cDAO.listaChamado(id);
            request.setAttribute("chamados", c);
            
//            TratativaChamado tratar = new TratativaChamado();
//            tratar.setDescricao("teste");
//            tratar.setIdChamado(id);
//            tratar.setIdFuncionario(2);
//            CadastroTratativaDAO tDAO = new CadastroTratativaDAO();
//            tDAO.cadastrarTratativaChamado(tratar);
            request.getRequestDispatcher("WEB-INF/chamado/Buscar.jspx").forward(request, response);
            
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
    }

}
