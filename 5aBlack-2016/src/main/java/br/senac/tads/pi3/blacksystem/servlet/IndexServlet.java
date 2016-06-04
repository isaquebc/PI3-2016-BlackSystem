/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.servlet;

import br.senac.tads.pi3.blacksystem.ablack.FuncionarioDAO;
import br.senac.tads.pi3.blacksystem.entity.Criptografia;
import br.senac.tads.pi3.blacksystem.entity.Mensagem;
import br.senac.tads.pi3.blacksystem.entity.Usuario;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Isaque
 */
@WebServlet(name = "IndexServlet", urlPatterns = {"/index.html"})
public class IndexServlet extends HttpServlet {

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
        request.setAttribute("servicos", "Mensagem");
        request.getRequestDispatcher("WEB-INF/index.jspx").forward(request, response);
        
        
        
        
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
       
        
        Map<String, Usuario>  usuario = new HashMap<>();
        Usuario usuarioBanco = new Usuario();
        Usuario usuarioLogado = new Usuario();
        Criptografia criptrografia = new Criptografia();
        FuncionarioDAO funcDAO = new FuncionarioDAO();
        usuarioLogado.setCpf(request.getParameter("cpf"));
        usuarioLogado.setHashSenha(request.getParameter("senha"));
        try {
            usuarioBanco = funcDAO.buscarFuncionario(usuarioLogado.getCpf());
            usuarioLogado.setSalt(usuarioBanco.getSalt());
            usuarioLogado.setHashSenha(criptrografia.gerarHashSenhaPBKDF2(usuarioLogado));
        } catch (Exception e) {
            System.out.println(e);
        }

        usuarioLogado = usuarioLogado.validar(usuarioBanco);
        
        if (usuarioLogado != null) {
            HttpSession sessaoUsuario = request.getSession(false);
            if (sessaoUsuario != null) {
                sessaoUsuario.invalidate();
            }
            sessaoUsuario = request.getSession(true);
            sessaoUsuario.setAttribute("usuarioLogado", usuarioBanco);
            response.sendRedirect(request.getContextPath() + "/HomeServlet");
            return;
        }
        Mensagem msg = new Mensagem();
        msg.setTitulo("Login Invalido");
        msg.setTexto("Acesso negado, verifique usuario ou senha e tente novamente.");
        msg.setDestino("index.html");
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("Mensagem.jspx").forward(request, response);        
        usuario.put(usuarioBanco.getCpf(), usuarioBanco);
        
        
        
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
