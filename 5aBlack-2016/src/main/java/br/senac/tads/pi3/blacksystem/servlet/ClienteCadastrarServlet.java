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
import br.senac.tads.pi3.blacksystem.entity.Erro;
import br.senac.tads.pi3.blacksystem.entity.Mensagem;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rafael
 */
@WebServlet(name = "ClienteCadastrarServlet", urlPatterns = {"/ClienteCadastrarServlet"})
public class ClienteCadastrarServlet extends HttpServlet {

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
        request.getRequestDispatcher("WEB-INF/cliente/Cadastrar.jspx").forward(request, response);
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
            throws ServletException {
        ClienteCadastroDAO cadCli = new ClienteCadastroDAO();
        EnderecoClienteDAO DAOenddCli = new EnderecoClienteDAO();
        Endereco endCli = new Endereco();
        Cliente cli = new Cliente();
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");

        cli.setCpf(request.getParameter("cpf"));
        cli.setNome(request.getParameter("nome").toUpperCase());
        cli.setSobrenome(request.getParameter("sobrenome").toUpperCase());
        cli.setTelefone(request.getParameter("telefone"));
        cli.setCelular(request.getParameter("celular"));
        cli.setSexo(request.getParameter("sexo").toUpperCase());
        cli.setEmail(request.getParameter("email"));
        String dtNascStr = request.getParameter("dt-Nascimento");
        
        // captura dos dados do endereço
        
        endCli.setEndereco(request.getParameter("rua"));
        endCli.setNumero((int) Integer.parseInt(request.getParameter("numero")));
        endCli.setCidade(request.getParameter("cidade"));
        endCli.setEstado(request.getParameter("estado"));
        endCli.setCep(request.getParameter("cep"));
        
        
        Date nasc= null;
        try {
            nasc = form.parse(dtNascStr);
        } catch (ParseException ex) {
            Logger.getLogger(ClienteCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       cli.setNasc(nasc);
       cli.setDtCadastro(new Date());
       

        
       Erro er = cli.validar(cli);
       boolean teste= er.isExistente();
        if (teste) {
            /*=============================================================
             Mensagem de Erro
             ===============================================================*/
            Mensagem msg = new Mensagem();
            msg.setTitulo("Cadastrar Cliente");
            msg.setTexto("Erro no cadastro, "+er.getMensagem());
            msg.setDestino("ClienteCadastrarServlet");
            request.setAttribute("msg", msg);
            try {
                request.getRequestDispatcher("Mensagem.jspx").forward(request, response);
            } catch (IOException ex) {
                Logger.getLogger(ClienteCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            try {
                cadCli.cadatrarPessoa(cli);
                 DAOenddCli.cadastrarEndereco(cli, endCli);
                /*=============================================================
                 Mensagem de sucesso
                 ===============================================================*/
                Mensagem msg = new Mensagem("Cadastrar Cliente", "Cliente cadastrado com sucesso!",
                        "ClienteCadastrarServlet");
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("Mensagem.jspx").forward(request, response);

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClienteCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException ex) {

            } catch (IOException ex) {
                Logger.getLogger(ClienteCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        
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
