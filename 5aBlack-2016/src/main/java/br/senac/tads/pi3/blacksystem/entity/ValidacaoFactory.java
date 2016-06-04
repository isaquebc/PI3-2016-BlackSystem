/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.entity;

/**
 *
 * @author Isaque
 */
public class ValidacaoFactory {

    public ValidacaoFactory() {
        
    }    
    
    public Erro validarCliente(Cliente cliente){// <editor-fold defaultstate="collapsed" desc="Validação de Cliente.">

        
        String retorno= "";
        boolean estado=false;
        
        if(cliente.getNome().length()<= 2){
            estado=true;
            retorno+="Nome em branco! <br/> ";
        }
        
        if (cliente.getCpf().length()<= 2 ||  !cliente.isCpf()) {
            estado=true;
             retorno+="CPF invalido ou em branco! <br/> " ;
        }
        
        if (cliente.getSobrenome().length()<= 2) {
            estado=true;
            retorno+="CPF em branco!<br/> ";
        }
        
        if (cliente.getSexo()== null) {
            estado=true;
            retorno+="Sexo em branco!<br/> ";
        }
        
        if (cliente.getCelular().length()<= 2) {
            estado=true;
            retorno+="Celular em branco!<br/> ";
        }
        
        if (cliente.getEmail().length()<= 2) {
            estado=true;
            retorno+="E-mail em branco!<br/> ";
        }
        if (cliente.getDtCadastro() == null) {
            estado=true;
            retorno+="Data de nascimento em branco!<br/> ";
        }

        
        Erro msg = new Erro(retorno, estado);
        return msg;
    }// </editor-fold>
}
